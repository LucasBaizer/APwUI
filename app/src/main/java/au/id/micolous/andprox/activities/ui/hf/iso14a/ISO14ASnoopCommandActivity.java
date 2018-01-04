package au.id.micolous.andprox.activities.ui.hf.iso14a;

import android.os.Bundle;

import au.id.micolous.andprox.R;
import au.id.micolous.andprox.SendCommandTask;
import au.id.micolous.andprox.activities.ui.CommandActivity;
import au.id.micolous.andprox.activities.ui.ConsoleFragment;

public class ISO14ASnoopCommandActivity extends CommandActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_iso14a_snoop);

        findViewById(R.id.execute).setOnClickListener((e) -> {
            String cmd = "hf 14a snoop";
            if(isChecked(R.id.iso14aSnoopPar1)) {
                cmd += " c";
            }
            if(isChecked(R.id.iso14aSnoopPar2)) {
                cmd += " r";
            }
            ConsoleFragment.appendCommand(cmd);
            new SendCommandTask().execute(cmd);
        });
    }
}
