package au.id.micolous.andprox.activities.ui.hf.iso14a;

import android.os.Bundle;

import au.id.micolous.andprox.R;
import au.id.micolous.andprox.SendCommandTask;
import au.id.micolous.andprox.activities.ui.CommandActivity;
import au.id.micolous.andprox.activities.ui.ConsoleFragment;
import au.id.micolous.andprox.activities.ui.UI;

public class ISO14AReaderCommandActivity extends CommandActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_iso14a_reader);

        findViewById(R.id.execute).setOnClickListener((e) -> {
            String cmd = "hf 14a reader";
            if(isChecked(R.id.par1)) {
                cmd += " -k";
            }
            if(isChecked(R.id.par2)) {
                cmd += " -x";
            }
            if(isChecked(R.id.par3)) {
                cmd += " -3";
            }
            ConsoleFragment.appendCommand(cmd);
            new SendCommandTask().execute(cmd);
        });
    }
}
