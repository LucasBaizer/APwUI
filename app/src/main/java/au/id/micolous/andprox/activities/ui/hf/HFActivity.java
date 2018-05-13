package au.id.micolous.andprox.activities.ui.hf;

import android.os.Bundle;
import au.id.micolous.andprox.R;
import au.id.micolous.andprox.activities.ui.ButtonListActivity;
import au.id.micolous.andprox.activities.ui.UI;
import au.id.micolous.andprox.activities.ui.hf.epa.EPAActivity;
import au.id.micolous.andprox.activities.ui.hf.iso14a.ISO14AActivity;
import au.id.micolous.andprox.activities.ui.hf.iso14b.ISO14BActivity;

public class HFActivity extends ButtonListActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hf);

        setActivity(R.id.hfButton14a, ISO14AActivity.class, () -> {
            UI.setRFIDType("14a");
        });
        setActivity(R.id.hfButton14b, ISO14BActivity.class, () -> {
            UI.setRFIDType("14b");
        });
        setActivity(R.id.hfButtonEpa, EPAActivity.class, () -> {
            UI.setRFIDType("epa");
        });
    }
}
