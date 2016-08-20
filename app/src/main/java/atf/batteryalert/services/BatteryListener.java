package atf.batteryalert.services;

import android.app.NotificationManager;
import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.BatteryManager;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.support.v4.app.NotificationCompat;

import atf.batteryalert.R;
import atf.batteryalert.utils.PreferenceUtil;

/**
 * Created by tom on 8/17/16.
 */
public class BatteryListener extends Service {
    BroadcastReceiver battery = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            //TODO: add notification code
            int level = intent.getIntExtra(BatteryManager.EXTRA_LEVEL, 0);
            if(level <= PreferenceUtil.getLevel(context)) {
                NotificationCompat.Builder notify = new NotificationCompat.Builder(context)
                        .setContentTitle("CHARGE PHONE")
                        .setContentText("Your phone has reached your desired limit. You should charge your phone now")
                        .setSmallIcon(R.mipmap.ic_launcher);

                // Sets an ID for the notification
                int mNotificationId = 001;
                // Gets an instance of the NotificationManager service
                NotificationManager mNotifyMgr =
                        (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
                // Builds the notification and issues it.
                mNotifyMgr.notify(mNotificationId, notify.build());
            }
        }
    };
    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId){
        return Service.START_STICKY;
    }

    @Override
    public void onCreate(){
        registerReceiver(battery, new IntentFilter(Intent.ACTION_BATTERY_CHANGED));
    }

    @Override
    public void onDestroy(){
        unregisterReceiver(battery);
    }

}
