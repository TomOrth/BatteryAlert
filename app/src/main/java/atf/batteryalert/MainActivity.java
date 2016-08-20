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
import android.widget.Toast;

import com.balysv.materialripple.MaterialRippleLayout;

import atf.batteryalert.services.BatteryListener;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
    }

    public void settings(View v){
        startActivity(new Intent(this, SettingsActivity.class));
    }

    public void start(View v){
        startService(new Intent(getBaseContext(), BatteryListener.class));
        Toast.makeText(getBaseContext(), "Service started", Toast.LENGTH_SHORT).show();
    }

    public void stop(View v){
        stopService(new Intent(getBaseContext(), BatteryListener.class));
        Toast.makeText(getBaseContext(), "Service stopped", Toast.LENGTH_SHORT).show();
    }
}
