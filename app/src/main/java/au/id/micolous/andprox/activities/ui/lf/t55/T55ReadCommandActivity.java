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

public class T55ReadCommandActivity extends CommandActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_t55_read);

        Spinner spinner = findViewById(R.id.par1Spinner);
        String[] items1 = new String[] { "0", "1", "2", "3", "4", "5", "6", "7" };
        ArrayAdapter<String> adapter1 = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, items1);
        spinner.setAdapter(adapter1);

        CheckBox par1 = findViewById(R.id.par1Box);
        CheckBox par2 = findViewById(R.id.par2Box);

        EditText password = findViewById(R.id.par2Text);

        spinner.setEnabled(false);
        spinner.setClickable(false);

        par1.setOnCheckedChangeListener((x, checked) -> {
            spinner.setEnabled(checked);
            spinner.setSelection(0);
        });

        par2.setOnCheckedChangeListener((x, checked) -> {
            password.setEnabled(checked);
            password.setText("");
        });

        findViewById(R.id.execute).setOnClickListener((e) -> {
            String cmd = "lf t55xx read";
            if(par1.isChecked()) {
                cmd += " b " + spinner.getSelectedItem();
            }
            if(par2.isChecked()) {
                cmd += " p " + password.getText().toString();
            }
            if(isChecked(R.id.par3)) {
                cmd += " o";
            }
            if(isChecked(R.id.par4)) {
                cmd += " 1";
            }

            ConsoleFragment.appendCommand(cmd);
            new SendCommandTask().execute(cmd);
        });
    }
}
