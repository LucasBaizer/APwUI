package au.id.micolous.andprox.activities.ui.lf.nexwatch;

import android.os.Bundle;

import au.id.micolous.andprox.R;
import au.id.micolous.andprox.SendCommandTask;
import au.id.micolous.andprox.activities.ui.CommandActivity;
import au.id.micolous.andprox.activities.ui.ConsoleFragment;

public class NexWatchDemodCommandActivity extends CommandActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nexwatch_demod);

        String cmd = "lf nexwatch demod";
        ConsoleFragment.appendCommand(cmd);
        new SendCommandTask().execute(cmd);
    }
}
