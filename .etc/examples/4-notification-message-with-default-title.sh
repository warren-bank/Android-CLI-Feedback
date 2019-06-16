#!/system/bin/sh

am start -a android.intent.action.MAIN -n com.github.warren_bank.cli_feedback/.Show -e notification 'my notification message'
