package com.trymaster.database;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.content.Context;
import java.util.List;
import java.util.ArrayList;
import android.database.Cursor;
import android.content.ContentValues;

public class UserOperation
{

	private SQLiteDatabase database;
	private SQLiteOpenHelper dbHelper;

	public UserOperation(Context context) {
		dbHelper = new DatabaseHelper(context);

	}
	
	public void insertUser(User user) {
		SQLiteDatabase db = dbHelper.getWritableDatabase();
		ContentValues values = new ContentValues();
		values.put("fullname",user.getFullName());
		values.put("username", user.getUsername());
		values.put("password", user.getPassword());
		values.put("email", user.getEmail());
		values.put("contact",user.getContact());
		db.insert("users", null, values);
		db.close();
	}
	
	public List<User> getAllUsers() {
		List<User> users = new ArrayList<>();
		SQLiteDatabase db = dbHelper.getWritableDatabase();
		Cursor cursor = db.rawQuery("SELECT * FROM users", null);
		if (cursor.moveToFirst()) {
			do {
				User user = new User();
				user.setId(cursor.getInt(0));
				user.setUsername(cursor.getString(1));
				user.setPassword(cursor.getString(2));
				user.setEmail(cursor.getString(3));
				users.add(user);
			} while (cursor.moveToNext());
		}
		cursor.close();
		db.close();
		return users;
	}
	
	public User getUserById(int id) {
		SQLiteDatabase db = dbHelper.getWritableDatabase();
		Cursor cursor = db.rawQuery("SELECT * FROM users WHERE id = ?", new String[] { String.valueOf(id) });
		User user = new User();
		if (cursor.moveToFirst()) {
			user.setId(cursor.getInt(0));
			user.setUsername(cursor.getString(1));
			user.setPassword(cursor.getString(2));
			user.setEmail(cursor.getString(3));
		}
		cursor.close();
		db.close();
		return user;
	}
	
	public void updateUser(User user) {
		SQLiteDatabase db = dbHelper.getWritableDatabase();
		ContentValues values = new ContentValues();
		values.put("username", user.getUsername());
		values.put("password", user.getPassword());
		values.put("email", user.getEmail());
		db.update("users", values, "id = ?", new String[] { String.valueOf(user.getId()) });
		db.close();
	}
	
	public void deleteUser(int id) {
		SQLiteDatabase db = dbHelper.getWritableDatabase();
		db.delete("users", "id = ?", new String[] { String.valueOf(id) });
		db.close();
	}
	public boolean login(String username, String password) {
		SQLiteDatabase db = dbHelper.getReadableDatabase();
		Cursor cursor = db.rawQuery(
			"SELECT * FROM users WHERE username = ? AND password = ?",
			new String[]{username, password}
		);
		boolean success = cursor.moveToFirst();
		cursor.close();
		db.close();
		return success;
	}
	
	public int getUserIdByUsername(String username) {

		SQLiteDatabase db = dbHelper.getReadableDatabase();

		Cursor cursor = db.rawQuery(
			"SELECT id FROM users WHERE username = ?",
			new String[]{username}
		);

		int userId = -1; // -1 means not found

		if (cursor.moveToFirst()) {
			userId = cursor.getInt(0);
		}

		cursor.close();
		db.close();

		return userId;
	}
	
	public boolean isUsernameExists(String username) {
		SQLiteDatabase db = dbHelper.getReadableDatabase();
		Cursor cursor = db.rawQuery(
			"SELECT id FROM users WHERE username = ?",
			new String[]{username}
		);
		boolean exists = cursor.moveToFirst();
		cursor.close();
		db.close();
		return exists;
	}
	
	
	//Those function manipulate record table for user
	// Calculte the total mark user got throught all quiz
	public int getOverallRank(int studentId) {
		SQLiteDatabase db = dbHelper.getReadableDatabase();

		Cursor cursor = db.rawQuery(
			"SELECT SUM(total_mark) FROM records WHERE user_id = ?",
			new String[]{String.valueOf(studentId)}
		);

		int rank = 0;
		if (cursor.moveToFirst() && !cursor.isNull(0)) {
			rank = cursor.getInt(0);
		}

		cursor.close();
		db.close();
		return rank;
	}
	//Count number of quiz completed by user
	public int getQuizCount(int studentId) {
		SQLiteDatabase db = dbHelper.getReadableDatabase();

		Cursor cursor = db.rawQuery(
			"SELECT COUNT(*) FROM records WHERE user_id = ?",
			new String[]{String.valueOf(studentId)}
		);

		int count = 0;
		if (cursor.moveToFirst()) {
			count = cursor.getInt(0);
		}

		cursor.close();
		db.close();
		return count;
	}
	
	//Has already did the quiz
	public boolean user_has_done(int quiz_id){
		SQLiteDatabase db = dbHelper.getReadableDatabase();
		Cursor cursor = db.rawQuery(
			"SELECT * FROM records WHERE quiz_id = ?",
			new String[]{String.valueOf(quiz_id)}
		);
		boolean exists = cursor.moveToFirst();
		cursor.close();
		db.close();
		return exists;
	}
	//insert user Record function
	public float insertRecord(int studentId, int quizId, int topicId, int totalPoint) {

		SQLiteDatabase db = dbHelper.getWritableDatabase();

		ContentValues values = new ContentValues();
		values.put("user_id", studentId);
		values.put("quiz_id", quizId);
		values.put("topic_id", topicId);
		values.put("total_mark", totalPoint);

		float id=db.insert("records", null, values);
		db.close();
		return id;
	}
}


	
	

