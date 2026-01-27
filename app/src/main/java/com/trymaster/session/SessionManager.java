package com.trymaster.session;


import android.content.Context;
import android.content.SharedPreferences;

public class SessionManager {

    SharedPreferences pref;
    SharedPreferences.Editor editor;
    Context context;

    // Shared preference file name
    private static final String PREF_NAME = "UserSession";

    // Keys
    private static final String IS_LOGIN = "isLoggedIn";
    private static final String USERNAME = "username";

    public SessionManager(Context context) {
        this.context = context;
        pref = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);
        editor = pref.edit();
    }

    // create login session
    public void createLoginSession(String username) {
        editor.putBoolean(IS_LOGIN, true);
        editor.putString(USERNAME, username);
        editor.commit();
    }

    public boolean isLoggedIn() {
        return pref.getBoolean(IS_LOGIN, false);
    }

    public String getUsername() {
        return pref.getString(USERNAME, null);
    }

    public void logout() {
        editor.clear();
        editor.commit();
    }
}
