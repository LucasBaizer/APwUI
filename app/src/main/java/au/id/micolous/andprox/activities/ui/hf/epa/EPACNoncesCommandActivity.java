package au.id.micolous.andprox.activities.ui.hf.epa;

import android.os.Bundle;

import au.id.micolous.andprox.R;
import au.id.micolous.andprox.SendCommandTask;
import au.id.micolous.andprox.activities.ui.CommandActivity;
import au.id.micolous.andprox.activities.ui.ConsoleFragment;

public class EPACNoncesCommandActivity extends CommandActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_epa_cnonces);

        findViewById(R.id.execute).setOnClickListener((e) -> {
            String cmd = "hf epa cnonces";
            cmd += " " + getFieldText(R.id.par1);
            cmd += " " + getFieldText(R.id.par2);
            cmd += " " + getFieldText(R.id.par3);

            ConsoleFragment.appendCommand(cmd);
            new SendCommandTask().execute(cmd);
        });
    }
}
