package au.id.micolous.andprox.activities.ui.hf.iso14b;

import android.os.Bundle;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Switch;

import au.id.micolous.andprox.R;
import au.id.micolous.andprox.SendCommandTask;
import au.id.micolous.andprox.activities.ui.CommandActivity;
import au.id.micolous.andprox.activities.ui.ConsoleFragment;

public class ISO14BRawCommandActivity extends CommandActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_iso14b_raw);

        findViewById(R.id.execute).setOnClickListener((e) -> {
            String cmd = "hf 14b raw";

            if(isChecked(R.id.par1)) {
                cmd += " -r";
            }
            if(isChecked(R.id.par2)) {
                cmd += " -c";
            }
            if(isChecked(R.id.par3)) {
                cmd += " -p";
            }
            if(isChecked(R.id.par4)) {
                cmd += " -s";
            }
            if(isChecked(R.id.par5)) {
                cmd += " -ss";
            }
            cmd += " " + ((EditText) findViewById(R.id.par6)).getText().toString();

            ConsoleFragment.appendCommand(cmd);
            new SendCommandTask().execute(cmd);
        });
    }
}
