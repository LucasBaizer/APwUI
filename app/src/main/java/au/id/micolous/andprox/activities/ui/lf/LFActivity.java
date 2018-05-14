package au.id.micolous.andprox.activities.ui.lf;

import android.os.Bundle;

import au.id.micolous.andprox.R;
import au.id.micolous.andprox.activities.ui.ButtonListActivity;
import au.id.micolous.andprox.activities.ui.UI;
import au.id.micolous.andprox.activities.ui.hf.iso14a.ISO14AActivity;
import au.id.micolous.andprox.activities.ui.hf.iso14b.ISO14BActivity;
import au.id.micolous.andprox.activities.ui.lf.awid.AWIDActivity;
import au.id.micolous.andprox.activities.ui.lf.io.IOActivity;
import au.id.micolous.andprox.activities.ui.lf.nexwatch.NexWatchActivity;
import au.id.micolous.andprox.activities.ui.lf.paradox.ParadoxActivity;
import au.id.micolous.andprox.activities.ui.lf.securakey.SecurakeyActivity;
import au.id.micolous.andprox.activities.ui.lf.t55.T55Activity;

public class LFActivity extends ButtonListActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lf);

        setActivity(R.id.lfButtonAwid, AWIDActivity.class, () -> {
            UI.setRFIDType("awid");
        });
        setActivity(R.id.lfButtonIo, IOActivity.class, () -> {
            UI.setRFIDType("io");
        });
        setActivity(R.id.lfButtonNexwatch, NexWatchActivity.class, () -> {
            UI.setRFIDType("nexwatch");
        });
        setActivity(R.id.lfButtonParadox, ParadoxActivity.class, () -> {
            UI.setRFIDType("paradox");
        });
        setActivity(R.id.lfButtonSecurakey, SecurakeyActivity.class, () -> {
            UI.setRFIDType("securakey");
        });
        setActivity(R.id.lfButtonT55xx, T55Activity.class, () -> {
            UI.setRFIDType("t55xx");
        });
    }
}
