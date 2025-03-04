package com.trymaster.database;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.content.ContentValues;
import android.database.Cursor;
import java.util.List;
import java.util.ArrayList;
import java.sql.*;

public class TopicOperation
{

	private SQLiteDatabase database;
	private SQLiteOpenHelper dbHelper;

	public TopicOperation(Context context) {
		dbHelper = new DatabaseHelper(context);

	}


	public long createTopic(float id,String title,String desc,String vedioSrc) {
		database = dbHelper.getWritableDatabase();
		ContentValues values = new ContentValues();
		values.put("course_id",id);
		values.put("title", title);
		values.put("objective", desc);
		values.put("video_url", vedioSrc);

		long k=database.insert("topic", null, values);
		return k;
	}

	public Topic getTopic(int id) {
		database = dbHelper.getReadableDatabase();
		Cursor cursor = database.query("topic", new String[] {"id", "title", "description", "video_url"}, "id = ?", new String[] {String.valueOf(id)}, null, null, null);
		if (cursor != null) {
			cursor.moveToFirst();
			Topic topic = new Topic();
			topic.setId(cursor.getInt(0));
			topic.setTitle(cursor.getString(1));
			topic.setGoal(cursor.getString(2));
			topic.setVedioSource(cursor.getString(3));
			return topic;
		}
		return null;
	}

	public int updateTopic(int id,String title,String goal,String url) {
		database = dbHelper.getWritableDatabase();
		ContentValues values = new ContentValues();
		values.put("title",title);
		values.put("objective",goal);
		values.put("video_url", url);
		return database.update("topic", values, "id = ?", new String[] {String.valueOf(id)});
	}

	public void deleteTopic(int id) {
		database = dbHelper.getWritableDatabase();
		database.delete("topic", "id = ?", new String[] {String.valueOf(id)});
	}

	public List<Topic> getAllTopic() {
		List<Topic> topicList = new ArrayList<>();

		database = dbHelper.getReadableDatabase();
		Cursor cursor = database.rawQuery("SELECT * FROM topic", null);

		if (cursor.moveToFirst()) {
			do {
				Topic topic = new Topic();
				topic.setId(cursor.getInt(0));
				topic.setTitle(cursor.getString(1));
				topic.setGoal((cursor.getString(2)));
				//course.setVideoUrl(cursor.getString(3));
				topicList.add(topic);
			} while (cursor.moveToNext());
		}

		cursor.close();
		database.close();

		return topicList;
	}
}
