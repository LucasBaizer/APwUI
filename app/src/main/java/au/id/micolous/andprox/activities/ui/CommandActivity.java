package au.id.micolous.andprox.activities.ui;

import android.support.v7.app.AppCompatActivity;
import android.widget.CheckBox;
import android.widget.CompoundButton;

public class CommandActivity extends AppCompatActivity {
    public boolean isChecked(int id) {
        return ((CompoundButton) findViewById(id)).isChecked();
    }
}
