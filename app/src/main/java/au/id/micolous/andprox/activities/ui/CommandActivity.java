package au.id.micolous.andprox.activities.ui;

import android.support.v7.app.AppCompatActivity;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;

public class CommandActivity extends AppCompatActivity {
    public boolean isChecked(int id) {
        return ((CompoundButton) findViewById(id)).isChecked();
    }

    public String getFieldText(int id) { return ((TextView) findViewById(id)).getText().toString(); };

    public void setFieldText(int id, String value) {
        ((TextView) findViewById(id)).setText(value);
    }

    public String clean(String value) {
        return value.replace(" ", "");
    }
}
