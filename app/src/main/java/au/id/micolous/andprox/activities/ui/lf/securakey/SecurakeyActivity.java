package au.id.micolous.andprox.activities.ui.lf.securakey;

import android.os.Bundle;

import au.id.micolous.andprox.R;
import au.id.micolous.andprox.activities.ui.ButtonListActivity;

public class SecurakeyActivity extends ButtonListActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_securakey);

        setActivity(R.id.securakeyDemod, SecurakeyDemodCommandActivity.class);
        setActivity(R.id.securakeyRead, SecurakeyReadCommandActivity.class);
    }
}
