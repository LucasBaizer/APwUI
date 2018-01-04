package au.id.micolous.andprox.activities.ui;

import android.app.TaskStackBuilder;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;

public class ButtonListActivity extends AppCompatActivity {
    public void setActivity(int id, Class<?> activity) {
        setActivity(id, activity, null);
    }

    public void setActivity(int id, Class<?> activity, Runnable also) {
        findViewById(id).setOnClickListener((e) -> {
            if(also != null) {
                also.run();
            }

            TaskStackBuilder.create(this).addNextIntentWithParentStack(new Intent(this, activity)).startActivities();
        });
    }
}
