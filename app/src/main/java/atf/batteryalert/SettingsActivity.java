package atf.batteryalert;

import android.content.Intent;
import android.os.Bundle;
import android.preference.PreferenceFragment;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;

public class SettingsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getFragmentManager().beginTransaction().replace(R.id.content, new SettingsFragment()).commit();
    }

    @Override
    public boolean onOptionsItemSelected (MenuItem item){
        switch(item.getItemId()){
            case android.R.id.home:
                startActivity(new Intent(getBaseContext(), MainActivity.class));
                Snackbar.make(item.getActionView(), "Settings have been saved", Snackbar.LENGTH_SHORT);

        }
        return true;
    }

    public static class SettingsFragment extends PreferenceFragment{
        @Override
        public void onCreate(final Bundle savedInstanceState){
           addPreferencesFromResource(R.xml.preference);
        }
    }

}
