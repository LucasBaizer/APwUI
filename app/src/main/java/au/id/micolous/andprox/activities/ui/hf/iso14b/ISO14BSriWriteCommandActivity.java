package au.id.micolous.andprox.activities.ui.hf.iso14b;

import android.os.Bundle;
import android.widget.EditText;

import au.id.micolous.andprox.R;
import au.id.micolous.andprox.SendCommandTask;
import au.id.micolous.andprox.activities.ui.CommandActivity;
import au.id.micolous.andprox.activities.ui.ConsoleFragment;

public class ISO14BSriWriteCommandActivity extends CommandActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_iso14b_sriwrite);

        findViewById(R.id.execute).setOnClickListener((e) -> {
            String cmd = "hf 14b sriwrite";
            cmd += " " + (isChecked(R.id.par1) ? "2" : "1");
            cmd += " " + getFieldText(R.id.par2);
            cmd += " " + getFieldText(R.id.par3);

            ConsoleFragment.appendCommand(cmd);
            new SendCommandTask().execute(cmd);
        });
    }
}
