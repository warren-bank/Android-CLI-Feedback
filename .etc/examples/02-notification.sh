#!/system/bin/sh

am start --user 0 -a android.intent.action.MAIN -n com.github.warren_bank.cli_feedback/.Show -e notification_title 'my notification title' -e notification 'my notification message'
