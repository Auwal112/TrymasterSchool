package com.trymaster.database;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.content.Context;
import android.content.ContentValues;
import android.database.Cursor;

public class PointOperation
{
	private SQLiteDatabase database;
	private SQLiteOpenHelper dbHelper;

	public PointOperation(Context context) {
		dbHelper = new DatabaseHelper(context);
		

	}

	//initialize the point with given user_id and course id
	public void InitializePoint(int user,int course) {
		SQLiteDatabase db = dbHelper.getWritableDatabase();
		ContentValues values = new ContentValues();
		values.put("user_id", user);
		values.put("course_id", course);
		values.put("point_earn", 0);
		db.insert("users", null, values);
		db.close();
	}
	

	//increment point
	public void incrementPoints(int userId, int courseId, int points) {
		SQLiteDatabase db = dbHelper.getWritableDatabase();
		ContentValues values = new ContentValues();
		values.put("point_earn", points);
		db.update("Points", values, "user_id = ? AND course_id = ?", new String[] { String.valueOf(userId), String.valueOf(courseId) });
		db.close();
	}
	//Total point
	public int getTotalPoints(int userId, int courseId) {
		SQLiteDatabase db = dbHelper.getWritableDatabase();
		Cursor cursor = db.rawQuery("SELECT SUM(point_earn) FROM Points WHERE user_id = ? AND course_id = ?", new String[] { String.valueOf(userId), String.valueOf(courseId) });
		int totalPoints = 0;
		if (cursor.moveToFirst()) {
			totalPoints = cursor.getInt(0);
		}
		cursor.close();
		db.close();
		return totalPoints;
	}
	


}


