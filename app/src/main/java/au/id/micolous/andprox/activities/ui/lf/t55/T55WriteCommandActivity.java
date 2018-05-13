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

public class T55WriteCommandActivity extends CommandActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_t55_write);

        Spinner spinner = findViewById(R.id.par1Spinner);
        String[] items1 = new String[] { "0", "1", "2", "3", "4", "5", "6", "7" };
        ArrayAdapter<String> adapter1 = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, items1);
        spinner.setAdapter(adapter1);

        CheckBox par1 = findViewById(R.id.par1Box);
        CheckBox par2 = findViewById(R.id.par2Box);
        CheckBox par3 = findViewById(R.id.par3Box);

        EditText data = findViewById(R.id.par2Text);
        EditText password = findViewById(R.id.par3Text);

        spinner.setEnabled(false);
        spinner.setClickable(false);

        par1.setOnCheckedChangeListener((x, checked) -> {
            spinner.setEnabled(checked);
            spinner.setClickable(checked);
            spinner.setSelection(0);
        });

        par3.setOnCheckedChangeListener((x, checked) -> {
            data.setEnabled(checked);
            data.setText("");
        });

        par3.setOnCheckedChangeListener((x, checked) -> {
            password.setEnabled(checked);
            password.setText("");
        });

        findViewById(R.id.execute).setOnClickListener((e) -> {
            String cmd = "lf t55xx write";
            if(par1.isChecked()) {
                cmd += " b " + spinner.getSelectedItem();
            }
            if(par2.isChecked()) {
                cmd += " d " + data.getText().toString();
            }
            if(par3.isChecked()) {
                cmd += " p " + password.getText().toString();
            }
            if(isChecked(R.id.par4)) {
                cmd += " 1";
            }
            if(isChecked(R.id.par5)) {
                cmd += " t";
            }

            ConsoleFragment.appendCommand(cmd);
            new SendCommandTask().execute(cmd);
        });
    }
}
