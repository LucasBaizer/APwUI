package au.id.micolous.andprox.activities.ui.lf.io;

import android.os.Bundle;

import au.id.micolous.andprox.R;
import au.id.micolous.andprox.SendCommandTask;
import au.id.micolous.andprox.activities.ui.CommandActivity;
import au.id.micolous.andprox.activities.ui.ConsoleFragment;
import au.id.micolous.andprox.activities.ui.lf.awid.AWIDConfiguration;

public class IOCloneCommandActivity extends CommandActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_io_clone);

        findViewById(R.id.execute).setOnClickListener((e) -> {
            String cmd = "lf io clone " + getFieldText(R.id.par1);
            ConsoleFragment.appendCommand(cmd);
            new SendCommandTask().execute(cmd);
        });
    }
}
