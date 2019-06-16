#### [CLI Feedback](https://github.com/warren-bank/Android-CLI-Feedback)

Android app that displays a graphical message from the command line.

* the app reads the message data from extra(s) included in its opening Intent
* depending on this data, the app will display either:
  * a Toast
  * a Notification
* once displayed, the app will finish

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

#### Notes:

* minimum supported version of Android:
  * Android 3.0 Honeycomb (API 11)

#### Legal:

* copyright: [Warren Bank](https://github.com/warren-bank)
* license: [GPL-2.0](https://www.gnu.org/licenses/old-licenses/gpl-2.0.txt)
