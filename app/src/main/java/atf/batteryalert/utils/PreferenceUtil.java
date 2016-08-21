package atf.batteryalert.utils;

import android.content.Context;
import android.preference.PreferenceFragment;
import android.preference.PreferenceManager;
/**
 * Created by tom on 8/18/16.
 */
public class PreferenceUtil {
    public static int getLevel(Context context){
        return PreferenceManager.getDefaultSharedPreferences(context).getInt("batLvl", 70);
    }
    public static boolean isDim(Context context){
        return PreferenceManager.getDefaultSharedPreferences(context).getBoolean("isDim", false);
    }
    public static boolean getSettingsPerm(Context context){
        return PreferenceManager.getDefaultSharedPreferences(context).getBoolean("settings", true);
    }
    public static void setSettingsPerm(Context context, Boolean bool){
        PreferenceManager.getDefaultSharedPreferences(context).edit().putBoolean("settings", bool).apply();
    }
}
