package au.id.micolous.andprox.activities.ui.lf.awid;

import android.os.Bundle;

import au.id.micolous.andprox.R;
import au.id.micolous.andprox.activities.ui.ButtonListActivity;

public class AWIDActivity extends ButtonListActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_awid);

        setActivity(R.id.awidRead, AWIDReadCommandActivity.class);
        setActivity(R.id.awidDemod, AWIDDemodCommandActivity.class);
        setActivity(R.id.awidClone, AWIDCloneCommandActivity.class);
        setActivity(R.id.awidSim, AWIDSimCommandActivity.class);
    }
}
