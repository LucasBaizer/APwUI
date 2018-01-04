package au.id.micolous.andprox.activities.ui.hf.iso14b;

import android.os.Bundle;

import au.id.micolous.andprox.R;
import au.id.micolous.andprox.activities.ui.ButtonListActivity;
import au.id.micolous.andprox.activities.ui.hf.iso.ISOListCommandActivity;
import au.id.micolous.andprox.activities.ui.hf.iso.ISOReaderCommandActivity;
import au.id.micolous.andprox.activities.ui.hf.iso14a.ISO14ASimCommandActivity;
import au.id.micolous.andprox.activities.ui.hf.iso14a.ISO14ASnoopCommandActivity;

public class ISO14BActivity extends ButtonListActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_iso14b);

        setActivity(R.id.iso14bList, ISOListCommandActivity.class);
        setActivity(R.id.iso14bReader, ISOReaderCommandActivity.class);
        setActivity(R.id.iso14bSim, ISO14ASimCommandActivity.class);
        setActivity(R.id.iso14bSnoop, ISO14ASnoopCommandActivity.class);
        setActivity(R.id.iso14bRaw, ISO14BRawCommandActivity.class);
    }
}
