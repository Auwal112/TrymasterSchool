package com.trymaster.database;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.content.ContentValues;
import android.database.Cursor;

public class CourseOperation
{
	
	private SQLiteDatabase database;
	private SQLiteOpenHelper dbHelper;

	public CourseOperation(Context context) {
		dbHelper = new DatabaseHelper(context);
		database = dbHelper.getWritableDatabase();
	}
	
	public long createCourse(Course course) {
		ContentValues values = new ContentValues();
		values.put("title", course.getTitle());
		values.put("description", course.getDescription());
		values.put("video_url", course.getVideoUrl());
		return database.insert("courses", null, values);
	}

	public Course getCourse(int id) {
		Cursor cursor = database.query("courses", new String[] {"id", "title", "description", "video_url"}, "id = ?", new String[] {String.valueOf(id)}, null, null, null);
		if (cursor != null) {
			cursor.moveToFirst();
			Course course = new Course();
			course.setId(cursor.getInt(0));
			course.setTitle(cursor.getString(1));
			course.setDescription(cursor.getString(2));
			course.setVideoUrl(cursor.getString(3));
			return course;
		}
		return null;
	}

	public int updateCourse(Course course) {
		ContentValues values = new ContentValues();
		values.put("title", course.getTitle());
		values.put("description", course.getDescription());
		values.put("video_url", course.getVideoUrl());
		return database.update("courses", values, "id = ?", new String[] {String.valueOf(course.getId())});
	}

	public void deleteCourse(int id) {
		database.delete("courses", "id = ?", new String[] {String.valueOf(id)});
	}
}
