package com.trymaster.utils;

import android.content.Context;
import android.content.SharedPreferences;

import org.json.JSONException;
import org.json.JSONObject;

public class QuizProgressStore {

    private static final String PREF_NAME = "quiz_progress";
    private static final String KEY_PROGRESS = "current_attempt";

    private SharedPreferences prefs;

    public QuizProgressStore(Context context) {
        prefs = context.getSharedPreferences(
			PREF_NAME,
			Context.MODE_PRIVATE
        );
    }

    // Save JSON
    public void save(JSONObject progress) {

        prefs.edit()
			.putString(KEY_PROGRESS, progress.toString())
			.apply();
    }

    // Load JSON
    public JSONObject load() {

        String json = prefs.getString(KEY_PROGRESS, null);

        if (json == null) {
            return null;
        }

        try {
            return new JSONObject(json);

        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
    }

    // Check whether progress exists
    public boolean exists() {
        return prefs.contains(KEY_PROGRESS);
    }

    // Delete progress
    public void clear() {
        prefs.edit()
			.remove(KEY_PROGRESS)
			.apply();
    }
}
