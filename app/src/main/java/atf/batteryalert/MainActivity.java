package atf.batteryalert;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.Settings;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import atf.batteryalert.services.BatteryListener;
import atf.batteryalert.utils.PreferenceUtil;

public class MainActivity extends AppCompatActivity {
    final int SETTINGS = 2020;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.M){
            PreferenceUtil.setSettingsPerm(getBaseContext(), Settings.System.canWrite(getBaseContext()));
            if(!Settings.System.canWrite(getBaseContext())){
                Intent intent = new Intent(Settings.ACTION_MANAGE_WRITE_SETTINGS);
                intent.setData(Uri.parse("package:" + this.getPackageName()));
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
            }

        }
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

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults){
        if(requestCode == SETTINGS){
            if(grantResults.length == 1 && grantResults[0] == PackageManager.PERMISSION_GRANTED){
                PreferenceUtil.setSettingsPerm(getBaseContext(), true);
            }
            else{
                PreferenceUtil.setSettingsPerm(getBaseContext(), false);
            }
            Toast.makeText(getBaseContext(), "This permission can be changed in the app settings", Toast.LENGTH_SHORT).show();
        }
    }
}
