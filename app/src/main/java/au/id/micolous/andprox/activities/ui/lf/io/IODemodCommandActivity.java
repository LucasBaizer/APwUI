package au.id.micolous.andprox.activities.ui.lf.io;

import android.os.Bundle;

import au.id.micolous.andprox.R;
import au.id.micolous.andprox.SendCommandTask;
import au.id.micolous.andprox.activities.ui.CommandActivity;
import au.id.micolous.andprox.activities.ui.ConsoleFragment;

public class IODemodCommandActivity extends CommandActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_io_demod);

        String cmd = "lf io demod";
        ConsoleFragment.appendCommand(cmd);
        new SendCommandTask().execute(cmd);
    }
}
