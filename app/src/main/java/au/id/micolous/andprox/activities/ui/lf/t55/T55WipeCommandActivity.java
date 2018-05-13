package au.id.micolous.andprox.activities.ui.lf.t55;

import android.os.Bundle;

import au.id.micolous.andprox.R;
import au.id.micolous.andprox.SendCommandTask;
import au.id.micolous.andprox.activities.ui.CommandActivity;
import au.id.micolous.andprox.activities.ui.ConsoleFragment;

public class T55WipeCommandActivity extends CommandActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_t55_wipe);

        findViewById(R.id.execute).setOnClickListener((e) -> {
            String cmd = "lf t55xx wipe";
            if(isChecked(R.id.par1)) {
                cmd += " Q5";
            }

            ConsoleFragment.appendCommand(cmd);
            new SendCommandTask().execute(cmd);
        });
    }
}
