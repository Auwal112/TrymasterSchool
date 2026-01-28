package com.trymaster.session;

import android.content.Context;
import android.content.SharedPreferences;

public class SessionManager {

    SharedPreferences pref;
    SharedPreferences.Editor editor;
    Context context;

    private static final String PREF_NAME = "UserSession";

    private static final String IS_LOGIN = "isLoggedIn";
    private static final String USERNAME = "username";
    private static final String USER_ID  = "user_id";

    public SessionManager(Context context) {
        this.context = context;
        pref = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);
        editor = pref.edit();
    }

    // Save login session
    public void createLoginSession(int userId, String username) {
        editor.putBoolean(IS_LOGIN, true);
        editor.putInt(USER_ID, userId);
        editor.putString(USERNAME, username);
        editor.commit();
    }

    public boolean isLoggedIn() {
        return pref.getBoolean(IS_LOGIN, false);
    }

    public int getUserId() {
        return pref.getInt(USER_ID, -1);
    }

    public String getUsername() {
        return pref.getString(USERNAME, null);
    }

    public void logout() {
        editor.clear();
        editor.commit();
    }
}
