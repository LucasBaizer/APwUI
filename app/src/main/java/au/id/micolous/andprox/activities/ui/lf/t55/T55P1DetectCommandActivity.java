package au.id.micolous.andprox.activities.ui.lf.t55;

import android.os.Bundle;
import android.widget.CheckBox;
import android.widget.EditText;

import au.id.micolous.andprox.R;
import au.id.micolous.andprox.SendCommandTask;
import au.id.micolous.andprox.activities.ui.CommandActivity;
import au.id.micolous.andprox.activities.ui.ConsoleFragment;

public class T55P1DetectCommandActivity extends CommandActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_t55_p1detect);

        CheckBox par2 = findViewById(R.id.par2Box);
        EditText pw = findViewById(R.id.par2Text);

        par2.setOnCheckedChangeListener((x, checked) -> {
            pw.setEnabled(checked);
            pw.setText("");
        });

        findViewById(R.id.execute).setOnClickListener((e) -> {
            String cmd = "lf t55xx p1detect";
            if(isChecked(R.id.par1)) {
                cmd += " 1";
            }
            if(par2.isChecked()) {
                cmd += " p " + pw.getText().toString();
            }

            ConsoleFragment.appendCommand(cmd);
            new SendCommandTask().execute(cmd);
        });
    }
}
