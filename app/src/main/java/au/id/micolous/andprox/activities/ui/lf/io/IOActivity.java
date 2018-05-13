package au.id.micolous.andprox.activities.ui.lf.io;

import android.os.Bundle;

import au.id.micolous.andprox.R;
import au.id.micolous.andprox.activities.ui.ButtonListActivity;
import au.id.micolous.andprox.activities.ui.lf.awid.AWIDCloneCommandActivity;
import au.id.micolous.andprox.activities.ui.lf.awid.AWIDDemodCommandActivity;
import au.id.micolous.andprox.activities.ui.lf.awid.AWIDReadCommandActivity;
import au.id.micolous.andprox.activities.ui.lf.awid.AWIDSimCommandActivity;

public class IOActivity extends ButtonListActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_io);

        setActivity(R.id.ioDemod, IODemodCommandActivity.class);
        setActivity(R.id.ioRead, IOReadCommandActivity.class);
        setActivity(R.id.ioClone, IOCloneCommandActivity.class);
    }
}
