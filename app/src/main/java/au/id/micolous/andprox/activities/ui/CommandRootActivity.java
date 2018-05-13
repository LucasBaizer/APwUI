package au.id.micolous.andprox.activities.ui;

import android.os.Bundle;

import au.id.micolous.andprox.R;
import au.id.micolous.andprox.activities.ui.hf.HFActivity;
import au.id.micolous.andprox.activities.ui.lf.LFActivity;
import au.id.micolous.andprox.natives.Natives;

public class CommandRootActivity extends ButtonListActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cmd_root);

        setActivity(R.id.hfRootButton, HFActivity.class);
        setActivity(R.id.lfRootButton, LFActivity.class);
        setActivity(R.id.hwRootButton, HFActivity.class);

        Natives.registerPrintAndLogHandler((log) -> {
            runOnUiThread(() -> ConsoleFragment.append(log + "\n"));
        });
    }
}
