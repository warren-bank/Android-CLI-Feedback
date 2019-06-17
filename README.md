#### [CLI Feedback](https://github.com/warren-bank/Android-CLI-Feedback)

Android app that can be started from the command line to either show a graphical message, or play an audio alert.

* the app reads configuration data from extra(s) included in its opening Intent
* depending on this data, the app will either:
  * _show_:
    * a Toast
    * a Notification
  * _play_:
    * the default sound for the chosen type of audio alert
* then, the app will finish

#### Examples:

* toast:
  ```bash
    am start                                        \
      --user 0                                      \
      -a android.intent.action.MAIN                 \
      -n com.github.warren_bank.cli_feedback/.Show  \
      -e toast 'my toast message'
  ```
* notification:
  ```bash
    am start                                        \
      --user 0                                      \
      -a android.intent.action.MAIN                 \
      -n com.github.warren_bank.cli_feedback/.Show  \
      -e notification_title 'my notification title' \
      -e notification 'my notification message'
  ```
  * line 1: 'my notification title'
  * line 2: 'my notification message'
* notification (title w/ no message):
  ```bash
    am start                                        \
      --user 0                                      \
      -a android.intent.action.MAIN                 \
      -n com.github.warren_bank.cli_feedback/.Show  \
      -e notification_title 'my notification title'
  ```
  * line 1: 'my notification title'
  * line 2: ''
* notification (message w/ default title):
  ```bash
    am start                                        \
      --user 0                                      \
      -a android.intent.action.MAIN                 \
      -n com.github.warren_bank.cli_feedback/.Show  \
      -e notification 'my notification message'
  ```
  * line 1: 'CLI Feedback:'
  * line 2: 'my notification message'
* sound (ringtone for 1x complete iteration):
  ```bash
    am start                                        \
      --user 0                                      \
      -a android.intent.action.MAIN                 \
      -n com.github.warren_bank.cli_feedback/.Play  \
      -e sound 'ringtone'                             # not case sensitive
  ```
* sound (ringtone for 1x complete iteration):
  ```bash
    am start                                        \
      --user 0                                      \
      -a android.intent.action.MAIN                 \
      -n com.github.warren_bank.cli_feedback/.Play  \
      --ei sound_type 1                               # RingtoneManager.TYPE_RINGTONE
  ```
* sound (notification for 1x complete iteration):
  ```bash
    am start                                        \
      --user 0                                      \
      -a android.intent.action.MAIN                 \
      -n com.github.warren_bank.cli_feedback/.Play  \
      -e sound 'notification'                         # not case sensitive
  ```
* sound (notification for 1x complete iteration):
  ```bash
    am start                                        \
      --user 0                                      \
      -a android.intent.action.MAIN                 \
      -n com.github.warren_bank.cli_feedback/.Play  \
      --ei sound_type 2                               # RingtoneManager.TYPE_NOTIFICATION
  ```
* sound (alarm for 1x complete iteration):
  ```bash
    am start                                        \
      --user 0                                      \
      -a android.intent.action.MAIN                 \
      -n com.github.warren_bank.cli_feedback/.Play  \
      -e sound 'alarm'                                # not case sensitive
  ```
* sound (alarm for 1x complete iteration):
  ```bash
    am start                                        \
      --user 0                                      \
      -a android.intent.action.MAIN                 \
      -n com.github.warren_bank.cli_feedback/.Play  \
      --ei sound_type 4                               # RingtoneManager.TYPE_ALARM
  ```
* sound (alarm for fixed duration @ 10 seconds):
  ```bash
    am start                                        \
      --user 0                                      \
      -a android.intent.action.MAIN                 \
      -n com.github.warren_bank.cli_feedback/.Play  \
      -e sound 'alarm'                              \ # not case sensitive
      --ei sound_duration 10000                       # unit: ms
  ```
* sound (alarm for fixed duration @ 10 seconds):
  ```bash
    am start                                        \
      --user 0                                      \
      -a android.intent.action.MAIN                 \
      -n com.github.warren_bank.cli_feedback/.Play  \
      --ei sound_type 4                             \ # RingtoneManager.TYPE_ALARM
      --ei sound_duration 10000                       # unit: ms
  ```

#### Notes:

* minimum supported version of Android:
  * Android 3.0 Honeycomb (API 11)

#### Legal:

* copyright: [Warren Bank](https://github.com/warren-bank)
* license: [GPL-2.0](https://www.gnu.org/licenses/old-licenses/gpl-2.0.txt)
