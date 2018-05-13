package au.id.micolous.andprox.activities.ui.lf.t55;

import android.os.Bundle;

import au.id.micolous.andprox.R;
import au.id.micolous.andprox.activities.ui.ButtonListActivity;
import au.id.micolous.andprox.activities.ui.lf.awid.AWIDCloneCommandActivity;
import au.id.micolous.andprox.activities.ui.lf.awid.AWIDDemodCommandActivity;
import au.id.micolous.andprox.activities.ui.lf.awid.AWIDReadCommandActivity;
import au.id.micolous.andprox.activities.ui.lf.awid.AWIDSimCommandActivity;

public class T55Activity extends ButtonListActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_t55);

        setActivity(R.id.t55Bruteforce, T55BruteforceCommandActivity.class);
        setActivity(R.id.t55Config, T55ConfigCommandActivity.class);
        setActivity(R.id.t55Detect, T55DetectCommandActivity.class);
        setActivity(R.id.t55P1Detect, T55P1DetectCommandActivity.class);
        setActivity(R.id.t55Read, T55ReadCommandActivity.class);
        setActivity(R.id.t55Resetread, T55ResetreadCommandActivity.class);
        setActivity(R.id.t55Write, T55WriteCommandActivity.class);
        setActivity(R.id.t55Trace, T55TraceCommandActivity.class);
        setActivity(R.id.t55Info, T55InfoCommandActivity.class);
        setActivity(R.id.t55Special, T55SpecialCommandActivity.class);
        setActivity(R.id.t55Dump, T55DumpCommandActivity.class);
        setActivity(R.id.t55Wakeup, T55WakeupCommandActivity.class);
        setActivity(R.id.t55Wipe, T55WipeCommandActivity.class);
    }
}
