package atf.batteryalert;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.balysv.materialripple.MaterialRippleLayout;

import atf.batteryalert.services.BatteryListener;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //Ripple effects
        MaterialRippleLayout.on(findViewById(R.id.settings))
                .rippleColor(Color.WHITE)
                .create();

        MaterialRippleLayout.on(findViewById(R.id.start))
                .rippleColor(Color.WHITE)
                .create();

        MaterialRippleLayout.on(findViewById(R.id.stop))
                .rippleColor(Color.WHITE)
                .create();
    }

    public void settings(View v){
        startActivity(new Intent(this, SettingsActivity.class));
    }

    public void start(View v){
        startService(new Intent(getBaseContext(), BatteryListener.class));
        Snackbar.make(v, "Service started", Snackbar.LENGTH_SHORT);
    }

    public void stop(View v){
        stopService(new Intent(getBaseContext(), BatteryListener.class));
        Snackbar.make(v, "Service stopped", Snackbar.LENGTH_SHORT);
    }
}
