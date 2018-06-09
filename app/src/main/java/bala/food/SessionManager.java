package bala.food;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;

/**
 * Created by CDS123 on 26-04-2018.
 */

public class SessionManager {
    private Context mContext;
    public SessionManager(Context context) {
        mContext = context;
    }
    public String getSessionStringValue(String sessionName, String sessionKey) {
        SharedPreferences settings = getSession(sessionName);
        // Reading String value from SharedPreferences
        Log.w("Success", "String::: " + settings.getString(sessionKey, null));
        return settings.getString(sessionKey, "0");
    }
    public String getSessionrestaurant_id(String sessionName, String sessionKey) {
        SharedPreferences settings = getSession(sessionName);
        // Reading String value from SharedPreferences
        Log.w("Success", "String::: " + settings.getString(sessionKey, null));
        return settings.getString(sessionKey, null);
    }
    private SharedPreferences getSession(String sessionName) {
        int PRIVATE_MODE = 0;
        return mContext.getSharedPreferences(sessionName, PRIVATE_MODE);
    }

    public int getSessionIntValue(String sessionName, String sessionKey) {
        SharedPreferences settings = getSession(sessionName);
        // Reading integer value from SharedPreferences
        return settings.getInt(sessionKey, 0);
    }

    public float getSessionFloatValue(String sessionName, String sessionKey) {
        SharedPreferences settings = getSession(sessionName);
        // Reading integer value from SharedPreferences
        return settings.getFloat(sessionKey, 0);
    }

    public void storeSessionStringvalue(String sessionName, String key, String value) {

        SharedPreferences settings = getSession(sessionName);
        // Writing String data to SharedPreferences
        SharedPreferences.Editor editor = settings.edit();
        editor.putString(key, value);
        editor.apply();
    }
    public void storeSessionrestaurant_id(String sessionName, String key, String value) {
        SharedPreferences settings = getSession(sessionName);
        // Writing String data to SharedPreferences
        SharedPreferences.Editor editor = settings.edit();
        editor.putString(key, value);
        editor.apply();
    }

    public String storeRestarauntID(String sessionName, String key, String value) {
        SharedPreferences settings = getSession(sessionName);
        // Writing String data to SharedPreferences
        SharedPreferences.Editor editor = settings.edit();
        editor.putString(key, value);
        editor.apply();
        return sessionName;
    }
    public String getRestaurantID(String sessionName, String sessionKey) {
        SharedPreferences settings = getSession(sessionName);
        // Reading String value from SharedPreferences
        Log.w("Success", "String::: " + settings.getString(sessionKey, null));
        return settings.getString(sessionKey, null);
    }
    public void storeCategoryMenu(String sessionName, String key, String value) {
        SharedPreferences settings = getSession(sessionName);
        // Writing String data to SharedPreferences
        SharedPreferences.Editor editor = settings.edit();
        editor.putString(key, value);
        editor.apply();
    }
    public String getCategoryMenu(String sessionName, String sessionKey) {
        SharedPreferences settings = getSession(sessionName);
        // Reading String value from SharedPreferences
        Log.w("Success", "String::: " + settings.getString(sessionKey, null));
        return settings.getString(sessionKey, null);
    }

    public void storeSessionFloatvalue(String sessionName, String key, float value) {
        SharedPreferences settings = getSession(sessionName);
        // Writing String data to SharedPreferences
        SharedPreferences.Editor editor = settings.edit();
        editor.putFloat(key, value);
        editor.apply();
    }

    public void storeSessionIntvalue(String sessionName, String key, int value) {
        SharedPreferences settings = getSession(sessionName);
        // Writing integer data to SharedPreferences
        SharedPreferences.Editor editor = settings.edit();
        editor.putInt(key, value);
        editor.apply();
    }



    public void callLogout() {
        SharedPreferences settings = getSession("Login");
        SharedPreferences.Editor editor = settings.edit();
        editor.clear();
        editor.apply();
    }

}
