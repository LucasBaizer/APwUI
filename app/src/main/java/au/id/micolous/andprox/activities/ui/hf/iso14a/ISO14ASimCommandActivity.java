package au.id.micolous.andprox.activities.ui.hf.iso14a;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;

import au.id.micolous.andprox.R;
import au.id.micolous.andprox.SendCommandTask;
import au.id.micolous.andprox.activities.ui.CommandActivity;
import au.id.micolous.andprox.activities.ui.ConsoleFragment;

public class ISO14ASimCommandActivity extends CommandActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_iso14a_sim);

        Spinner spinner = findViewById((R.id.iso14aSimPar1));

        String[] items = new String[] { "MIFARE Classic", "MIFARE Ultralight", "MIFARE Desfire", "ISO/IEC 14443-4", "MIFARE Tnp3xxx" };
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, items);
        spinner.setAdapter(adapter);

        findViewById(R.id.execute).setOnClickListener((e) -> {
            int idx = spinner.getSelectedItemPosition() + 1;
            String uid = ((EditText) findViewById(R.id.iso14aSimPar2)).getText().toString();
            String cmd = "hf 14a sim " + idx + " " + uid;
            ConsoleFragment.appendCommand(cmd);
            new SendCommandTask().execute(cmd);
        });
    }
}
