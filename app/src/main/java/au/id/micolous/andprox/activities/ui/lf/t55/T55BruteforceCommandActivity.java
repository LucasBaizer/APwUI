package au.id.micolous.andprox.activities.ui.lf.t55;

import android.os.Bundle;
import android.widget.CheckBox;
import android.widget.EditText;

import au.id.micolous.andprox.R;
import au.id.micolous.andprox.SendCommandTask;
import au.id.micolous.andprox.activities.ui.CommandActivity;
import au.id.micolous.andprox.activities.ui.ConsoleFragment;
import au.id.micolous.andprox.activities.ui.lf.awid.AWIDActivity;

public class T55BruteforceCommandActivity extends CommandActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_t55_bruteforce);

        CheckBox par1 = findViewById(R.id.par1Box);
        EditText file = findViewById(R.id.par1Text);
        EditText par2 = findViewById(R.id.par2);
        EditText par3 = findViewById(R.id.par3);

        par1.setOnCheckedChangeListener((x, checked) -> {
            file.setEnabled(checked);
            par2.setEnabled(!checked);
            par3.setEnabled(!checked);

            par2.setText("");
            par3.setText("");
            file.setText("");
        });

        findViewById(R.id.execute).setOnClickListener((e) -> {
            String p2 = getFieldText(R.id.par2);
            String p3 = getFieldText(R.id.par3);

            String cmd = "lf t55xx bruteforce";
            if(par1.isChecked()) {
                cmd += " i " + file.getText().toString();
            } else {
                cmd += " " + p2 + " " + p3;
            }

            ConsoleFragment.appendCommand(cmd);
            new SendCommandTask().execute(cmd);
        });
    }
}
