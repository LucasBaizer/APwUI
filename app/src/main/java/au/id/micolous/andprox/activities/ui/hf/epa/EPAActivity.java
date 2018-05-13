package au.id.micolous.andprox.activities.ui.hf.epa;

import android.os.Bundle;

import au.id.micolous.andprox.R;
import au.id.micolous.andprox.activities.ui.ButtonListActivity;
import au.id.micolous.andprox.activities.ui.hf.iso.ISOListCommandActivity;
import au.id.micolous.andprox.activities.ui.hf.iso14a.ISO14ACuidsCommandActivity;
import au.id.micolous.andprox.activities.ui.hf.iso14a.ISO14ARawCommandActivity;
import au.id.micolous.andprox.activities.ui.hf.iso14a.ISO14AReaderCommandActivity;
import au.id.micolous.andprox.activities.ui.hf.iso14a.ISO14ASimCommandActivity;
import au.id.micolous.andprox.activities.ui.hf.iso14a.ISO14ASnoopCommandActivity;

public class EPAActivity extends ButtonListActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_epa);

        setActivity(R.id.epaCnonces, EPACNoncesCommandActivity.class);
        setActivity(R.id.epaPreplay, EPAPReplayCommandActivity.class);
    }
}
