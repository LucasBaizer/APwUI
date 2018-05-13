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

public class T55ConfigCommandActivity extends CommandActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_t55_config);

        Spinner spinner1 = findViewById(R.id.par1Spinner);
        String[] items1 = new String[] { "8", "16", "32", "40", "50", "64", "100", "128" };
        ArrayAdapter<String> adapter1 = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, items1);
        spinner1.setAdapter(adapter1);

        Spinner spinner2 = findViewById(R.id.par2Spinner);
        String[] items2 = new String[] { "FSK", "FSK1", "FSK1a", "FSK2", "FSK2a", "ASK", "PSK1", "PSK2", "NRZ", "Biphase", "Biphase A" };
        ArrayAdapter<String> adapter2 = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, items2);
        spinner2.setAdapter(adapter2);

        CheckBox par1 = findViewById(R.id.par1Box);
        CheckBox par2 = findViewById(R.id.par2Box);
        CheckBox par4 = findViewById(R.id.par4Box);
        EditText offset = findViewById(R.id.par4Text);

        spinner1.setEnabled(false);
        spinner1.setClickable(false);
        spinner2.setEnabled(false);
        spinner2.setClickable(false);

        par1.setOnCheckedChangeListener((x, checked) -> {
            spinner1.setEnabled(checked);
            spinner1.setClickable(checked);
            spinner1.setSelection(0);
        });

        par2.setOnCheckedChangeListener((x, checked) -> {
            spinner2.setEnabled(checked);
            spinner2.setClickable(checked);
            spinner2.setSelection(0);
        });

        par4.setOnCheckedChangeListener((x, checked) -> {
            offset.setEnabled(checked);
            offset.setText("");
        });

        findViewById(R.id.execute).setOnClickListener((e) -> {
            String cmd = "lf t55xx config";
            if(par1.isChecked()) {
                cmd += " b " + spinner1.getSelectedItem();
            }
            if(par2.isChecked()) {
                String demod = spinner2.getSelectedItem().toString();
                if(demod.equals("Biphase")) {
                    demod = "BI";
                } else if(demod.equals("Biphase A")) {
                    demod = "BIa";
                }
                cmd += " d " + demod;
            }
            if(isChecked(R.id.par3)) {
                cmd += " i 1";
            }
            if(par4.isChecked()) {
                cmd += " o " + offset.getText().toString();
            }
            if(isChecked(R.id.par5)) {
                cmd += " Q5";
            }
            if(isChecked(R.id.par6)) {
                cmd += " ST";
            }

            ConsoleFragment.appendCommand(cmd);
            new SendCommandTask().execute(cmd);
        });
    }
}
