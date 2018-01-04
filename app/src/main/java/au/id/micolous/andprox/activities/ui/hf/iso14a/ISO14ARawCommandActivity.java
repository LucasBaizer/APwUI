package au.id.micolous.andprox.activities.ui.hf.iso14a;

import android.os.Bundle;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Switch;

import au.id.micolous.andprox.R;
import au.id.micolous.andprox.SendCommandTask;
import au.id.micolous.andprox.activities.ui.CommandActivity;
import au.id.micolous.andprox.activities.ui.ConsoleFragment;

public class ISO14ARawCommandActivity extends CommandActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_iso14a_raw);

        CheckBox par4Box = findViewById(R.id.par4Box);
        Switch par4Switch = findViewById(R.id.par4Switch);

        CheckBox par7Box = findViewById(R.id.par7Box);
        EditText par7Text = findViewById(R.id.par7Text);

        CheckBox par8Box = findViewById(R.id.par8Box);
        EditText par8Text = findViewById(R.id.par8Text);

        par4Box.setOnCheckedChangeListener((x, checked) -> {
            par4Switch.setEnabled(checked);

            if(!checked) {
                par4Switch.setChecked(false);
            }
        });
        par7Box.setOnCheckedChangeListener((x, checked) -> {
            par7Text.setEnabled(checked);

            if(!checked) {
                par7Text.setText("");
            }
        });
        par8Box.setOnCheckedChangeListener((x, checked) -> {
            par8Text.setEnabled(checked);

            if(!checked) {
                par8Text.setText("");
            }
        });

        findViewById(R.id.execute).setOnClickListener((e) -> {
            String cmd = "hf 14a raw";

            if(isChecked(R.id.par1)) {
                cmd += " -r";
            }
            if(isChecked(R.id.par2)) {
                cmd += " -c";
            }
            if(isChecked(R.id.par3)) {
                cmd += " -p";
            }
            if(isChecked(R.id.par4Box)) {
                if(isChecked(R.id.par4Switch)) {
                    cmd += " -s";
                } else {
                    cmd += " -a";
                }
            }
            if(isChecked(R.id.par5)) {
                cmd += " -T";
            }
            if(isChecked(R.id.par6)) {
                cmd += " -3";
            }
            if(isChecked(R.id.par7Box)) {
                cmd += " -b " + par7Text.getText().toString();
            }
            if(isChecked(R.id.par8Box)) {
                cmd += " -t " + par8Text.getText().toString();
            }
            cmd += " " + ((EditText) findViewById(R.id.par9)).getText().toString();

            ConsoleFragment.appendCommand(cmd);
            new SendCommandTask().execute(cmd);
        });
    }
}
