package com.github.warren_bank.cli_feedback;

import android.app.Activity;
import android.app.Notification;
import android.app.NotificationManager;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.widget.Toast;

public class Show extends Activity {
    private static final String DEFAULT_NOTIFICATION_TITLE = "CLI Feedback:";

    private static final String EXTRA_TOAST_MESSAGE        = "toast";
    private static final String EXTRA_NOTIFICATION_TITLE   = "notification_title";
    private static final String EXTRA_NOTIFICATION_MESSAGE = "notification";
    private static final String NOTIFICATION_CHANNEL_ID    = "notification_channel_id";
    private static final int    NOTIFICATION_ID            = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Intent intent = getIntent();
        String title, message;

        if (intent.hasExtra(EXTRA_TOAST_MESSAGE)) {
            message = intent.getStringExtra(EXTRA_TOAST_MESSAGE);

            if (!message.isEmpty()) {
                Toast.makeText(Show.this, message, Toast.LENGTH_LONG).show();
                finish();
                return;
            }
        }

        if (intent.hasExtra(EXTRA_NOTIFICATION_TITLE) || intent.hasExtra(EXTRA_NOTIFICATION_MESSAGE)) {
            title   = intent.hasExtra(EXTRA_NOTIFICATION_TITLE)
                          ? intent.getStringExtra(EXTRA_NOTIFICATION_TITLE)
                          : DEFAULT_NOTIFICATION_TITLE;
            message = intent.getStringExtra(EXTRA_NOTIFICATION_MESSAGE);

            if (!title.isEmpty()) {
                Notification.Builder builder;
                Notification notification;
                NotificationManager mgr;

                if (Build.VERSION.SDK_INT >= 26) {
                    builder = new Notification.Builder(Show.this, NOTIFICATION_CHANNEL_ID);
                }
                else {
                    builder = new Notification.Builder(Show.this);
                }
                if ((message != null) && (!message.isEmpty())) {
                    builder.setContentText(message);
                }
                notification = builder
                    .setContentTitle(title)
                    .setSmallIcon(android.R.drawable.ic_dialog_info)
                    .setPriority(Notification.PRIORITY_MAX)
                    .setAutoCancel(true)
                    .build();
                mgr = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
                mgr.notify(NOTIFICATION_ID, notification);
                finish();
                return;
            }
        }

        finish();
    }
}
