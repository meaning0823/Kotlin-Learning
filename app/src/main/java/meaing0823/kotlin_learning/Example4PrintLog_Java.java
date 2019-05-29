package meaing0823.kotlin_learning;

import android.util.Log;

public class Example4PrintLog_Java {
    private final boolean DEBUG = false;

    public void function01() {
        if (DEBUG) {
            Log.d("TEST", "Some log");
        }
    }
}
