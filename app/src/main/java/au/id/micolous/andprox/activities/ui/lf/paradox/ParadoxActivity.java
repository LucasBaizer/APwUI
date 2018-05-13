package au.id.micolous.andprox.activities.ui.lf.paradox;

import android.os.Bundle;

import au.id.micolous.andprox.R;
import au.id.micolous.andprox.activities.ui.ButtonListActivity;

public class ParadoxActivity extends ButtonListActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_paradox);

        setActivity(R.id.paradoxDemod, ParadoxDemodCommandActivity.class);
        setActivity(R.id.paradoxRead, ParadoxReadCommandActivity.class);
    }
}
