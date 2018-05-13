package au.id.micolous.andprox.activities.ui.lf.awid;

import android.os.Bundle;

import au.id.micolous.andprox.R;
import au.id.micolous.andprox.SendCommandTask;
import au.id.micolous.andprox.activities.ui.CommandActivity;
import au.id.micolous.andprox.activities.ui.ConsoleFragment;

public class AWIDCloneCommandActivity extends CommandActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_awid_clone);

        setFieldText(R.id.awidClonePar1, AWIDConfiguration.facilityCode);
        setFieldText(R.id.awidClonePar2, AWIDConfiguration.cardNumber);

        findViewById(R.id.execute).setOnClickListener((e) -> {
            String facilityCode = getFieldText(R.id.awidClonePar1);
            String cardNumber = getFieldText(R.id.awidClonePar2);
            AWIDConfiguration.facilityCode = facilityCode;
            AWIDConfiguration.cardNumber = cardNumber;
            String cmd = "lf awid clone " + facilityCode + " " + cardNumber;
            if(isChecked(R.id.awidClonePar3)) {
                cmd += " Q5";
            }
            ConsoleFragment.appendCommand(cmd);
            new SendCommandTask().execute(cmd);
        });
    }
}
