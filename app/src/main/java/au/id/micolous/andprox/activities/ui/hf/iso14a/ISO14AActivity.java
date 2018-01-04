package au.id.micolous.andprox.activities.ui.hf.iso14a;

import android.os.Bundle;

import au.id.micolous.andprox.R;
import au.id.micolous.andprox.activities.ui.ButtonListActivity;
import au.id.micolous.andprox.activities.ui.hf.iso.ISOListCommandActivity;
import au.id.micolous.andprox.activities.ui.hf.iso.ISOReaderCommandActivity;

public class ISO14AActivity extends ButtonListActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_iso14a);

        setActivity(R.id.iso14aList, ISOListCommandActivity.class);
        setActivity(R.id.iso14aReader, ISOReaderCommandActivity.class);
        setActivity(R.id.iso14aSim, ISO14ASimCommandActivity.class);
        setActivity(R.id.iso14aCuids, ISO14ACuidsCommandActivity.class);
        setActivity(R.id.iso14aSnoop, ISO14ASnoopCommandActivity.class);
        setActivity(R.id.iso14aRaw, ISO14ARawCommandActivity.class);
    }
}
