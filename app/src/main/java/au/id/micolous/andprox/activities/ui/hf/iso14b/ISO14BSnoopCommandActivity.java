package au.id.micolous.andprox.activities.ui.hf.iso14b;

import android.os.Bundle;

import au.id.micolous.andprox.R;
import au.id.micolous.andprox.SendCommandTask;
import au.id.micolous.andprox.activities.ui.CommandActivity;
import au.id.micolous.andprox.activities.ui.ConsoleFragment;

public class ISO14BSnoopCommandActivity extends CommandActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_iso14b_snoop);

        String cmd = "hf 14b snoop";

        ConsoleFragment.appendCommand(cmd);
        new SendCommandTask().execute(cmd);
    }
}
