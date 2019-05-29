package meaing0823.kotlin_learning

import android.util.Log

object Example4PrintLog {
    const val DEBUG = false

    const val HIGH = 1

    const val MEDIUM = 2

    const val LOW = 3

    fun function01() {
        if (DEBUG) {
            Log.d("TEST", "Some log")
        }
    }

    private inline fun printLog(level: Int = LOW, log: () -> String) {
        if (DEBUG) {
            // Do something depend on the level

            Log.d("TEST", log.invoke())
        }
    }

    fun function02() {
        printLog(HIGH) { "This is a high level log" }
    }
}