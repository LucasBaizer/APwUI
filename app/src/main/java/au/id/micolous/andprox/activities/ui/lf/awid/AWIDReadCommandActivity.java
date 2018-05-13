package au.id.micolous.andprox.activities.ui.lf.awid;

import android.os.Bundle;

import au.id.micolous.andprox.R;
import au.id.micolous.andprox.SendCommandTask;
import au.id.micolous.andprox.activities.ui.CommandActivity;
import au.id.micolous.andprox.activities.ui.ConsoleFragment;

public class AWIDReadCommandActivity extends CommandActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_awid_read);

        findViewById(R.id.execute).setOnClickListener((e) -> {
            String cmd = "lf awid read";
            if(isChecked(R.id.awidReadPar1)) {
                cmd += " 1";
            }
            ConsoleFragment.appendCommand(cmd);
            new SendCommandTask().execute(cmd);
        });
    }
}
