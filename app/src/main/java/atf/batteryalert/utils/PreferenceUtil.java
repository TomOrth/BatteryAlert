package atf.batteryalert.utils;

import android.content.Context;
import android.preference.PreferenceManager;
/**
 * Created by tom on 8/18/16.
 */
public class PreferenceUtil {
    public int getLevel(Context context){
        return PreferenceManager.getDefaultSharedPreferences(context).getInt("batLvl", 70);
    }
    public boolean isDim(Context context){
        return PreferenceManager.getDefaultSharedPreferences(context).getBoolean("isDim", false);
    }
}
