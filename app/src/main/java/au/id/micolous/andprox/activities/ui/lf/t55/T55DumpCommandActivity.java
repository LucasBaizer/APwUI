package au.id.micolous.andprox.activities.ui.lf.t55;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Spinner;

import au.id.micolous.andprox.R;
import au.id.micolous.andprox.SendCommandTask;
import au.id.micolous.andprox.activities.ui.CommandActivity;
import au.id.micolous.andprox.activities.ui.ConsoleFragment;

public class T55DumpCommandActivity extends CommandActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_t55_dump);

        CheckBox par1 = findViewById(R.id.par1Box);
        EditText password = findViewById(R.id.par1Text);

        par1.setOnCheckedChangeListener((x, checked) -> {
            password.setEnabled(checked);
            password.setText("");
        });

        findViewById(R.id.execute).setOnClickListener((e) -> {
            String cmd = "lf t55xx dump";
            if(par1.isChecked()) {
                cmd += " " + password.getText().toString();
            }
            if(isChecked(R.id.par2)) {
                cmd += " o";
            }

            ConsoleFragment.appendCommand(cmd);
            new SendCommandTask().execute(cmd);
        });
    }
}
