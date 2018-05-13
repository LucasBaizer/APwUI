package au.id.micolous.andprox.activities.ui.lf.t55;

import android.os.Bundle;
import android.widget.CheckBox;
import android.widget.EditText;

import au.id.micolous.andprox.R;
import au.id.micolous.andprox.SendCommandTask;
import au.id.micolous.andprox.activities.ui.CommandActivity;
import au.id.micolous.andprox.activities.ui.ConsoleFragment;

public class T55InfoCommandActivity extends CommandActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_t55_info);

        findViewById(R.id.execute).setOnClickListener((e) -> {
            String cmd = "lf t55xx info";
            if(isChecked(R.id.par1)) {
                cmd += " 1";
            }

            ConsoleFragment.appendCommand(cmd);
            new SendCommandTask().execute(cmd);
        });
    }
}
