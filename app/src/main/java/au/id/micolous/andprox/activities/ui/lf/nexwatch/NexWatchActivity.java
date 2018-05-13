package au.id.micolous.andprox.activities.ui.lf.nexwatch;

import android.os.Bundle;

import au.id.micolous.andprox.R;
import au.id.micolous.andprox.activities.ui.ButtonListActivity;
import au.id.micolous.andprox.activities.ui.lf.io.IOCloneCommandActivity;
import au.id.micolous.andprox.activities.ui.lf.io.IODemodCommandActivity;
import au.id.micolous.andprox.activities.ui.lf.io.IOReadCommandActivity;

public class NexWatchActivity extends ButtonListActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nexwatch);

        setActivity(R.id.nexWatchDemod, NexWatchDemodCommandActivity.class);
        setActivity(R.id.nexWatchRead, NexWatchReadCommandActivity.class);
    }
}
