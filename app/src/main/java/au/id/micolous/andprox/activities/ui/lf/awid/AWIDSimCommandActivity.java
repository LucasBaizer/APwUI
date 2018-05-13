package au.id.micolous.andprox.activities.ui.lf.awid;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;

import au.id.micolous.andprox.R;
import au.id.micolous.andprox.SendCommandTask;
import au.id.micolous.andprox.activities.ui.CommandActivity;
import au.id.micolous.andprox.activities.ui.ConsoleFragment;

public class AWIDSimCommandActivity extends CommandActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_awid_sim);

        setFieldText(R.id.awidSimPar1, AWIDConfiguration.facilityCode);
        setFieldText(R.id.awidSimPar2, AWIDConfiguration.cardNumber);

        findViewById(R.id.execute).setOnClickListener((e) -> {
            String facilityCode = getFieldText(R.id.awidSimPar1);
            String cardNumber = getFieldText(R.id.awidSimPar2);
            AWIDConfiguration.facilityCode = facilityCode;
            AWIDConfiguration.cardNumber = cardNumber;
            String cmd = "lf awid sim " + facilityCode + " " + cardNumber;
            ConsoleFragment.appendCommand(cmd);
            new SendCommandTask().execute(cmd);
        });
    }
}
