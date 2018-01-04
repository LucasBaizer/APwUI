package au.id.micolous.andprox.activities.ui.hf.iso;

import android.os.Bundle;

import au.id.micolous.andprox.R;
import au.id.micolous.andprox.SendCommandTask;
import au.id.micolous.andprox.activities.ui.CommandActivity;
import au.id.micolous.andprox.activities.ui.ConsoleFragment;
import au.id.micolous.andprox.activities.ui.UI;

public class ISOListCommandActivity extends CommandActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_iso_list);

        findViewById(R.id.execute).setOnClickListener((e) -> {
            String cmd = "hf list " + UI.getRFIDType();
            if(isChecked(R.id.par1)) {
                cmd += " f";
            }
            if(isChecked(R.id.par1)) {
                cmd += " c";
            }
            ConsoleFragment.appendCommand(cmd);
            new SendCommandTask().execute(cmd);
        });
    }
}
