package com.github.warren_bank.cli_feedback;

import android.app.Activity;
import android.content.Intent;
import android.media.RingtoneManager;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;

import java.util.Timer;
import java.util.TimerTask;

public class Play extends Activity {
    private static final String EXTRA_SOUND          = "sound";
    private static final String EXTRA_SOUND_TYPE     = "sound_type";
    private static final String EXTRA_SOUND_DURATION = "sound_duration";

    private enum SOUND_TYPE {
        RINGTONE     (RingtoneManager.TYPE_RINGTONE),
        NOTIFICATION (RingtoneManager.TYPE_NOTIFICATION),
        ALARM        (RingtoneManager.TYPE_ALARM);

        private final int sound_type;

        SOUND_TYPE(int sound_type) {
            this.sound_type = sound_type;
        }

        public int getInt() {
            return this.sound_type;
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Intent intent      = getIntent();
        int sound_type     = 0;
        int sound_duration = 0;

        if ((sound_type <= 0) && intent.hasExtra(EXTRA_SOUND)) {
            try {
                String     enum_key = intent.getStringExtra(EXTRA_SOUND).toUpperCase();
                SOUND_TYPE enum_val = SOUND_TYPE.valueOf(enum_key);

                if ((enum_val != null) && (enum_val.ordinal() >= 0)) {
                    sound_type = enum_val.getInt();
                }
            }
            catch(Exception e){}
        }

        if ((sound_type <= 0) && intent.hasExtra(EXTRA_SOUND_TYPE)) {
            try {
                sound_type = intent.getIntExtra(EXTRA_SOUND_TYPE, 0);
            }
            catch(Exception e){}
        }

        if (
          (sound_type > 0) && (
            (sound_type == RingtoneManager.TYPE_RINGTONE)     ||
            (sound_type == RingtoneManager.TYPE_NOTIFICATION) ||
            (sound_type == RingtoneManager.TYPE_ALARM)
          )
        ) {
            Uri notification;
            MediaPlayer player;
            boolean loop;

            sound_duration = intent.getIntExtra(EXTRA_SOUND_DURATION, 0);
            notification   = RingtoneManager.getDefaultUri(sound_type);
            player         = MediaPlayer.create(this, notification);
            loop           = ((sound_duration > 0) && (sound_duration > player.getDuration()));

            player.setLooping(loop);
            player.start();

            if (sound_duration > 0) {
                Timer timer = new Timer();
                timer.schedule(
                    new TimerTask() {
                        @Override
                        public void run() {
                            Play.this.runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
                                    player.stop();

                                    Play.this.finish();
                                }
                            });
                            timer.cancel();
                        }
                    },
                    sound_duration
                );
            }
            else {
                finish();
            }
            return;
        }

        finish();
    }
}
