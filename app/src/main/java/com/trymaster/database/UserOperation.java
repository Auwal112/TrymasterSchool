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
		values.put("username", user.getUsername());
		values.put("password", user.getPassword());
		values.put("email", user.getEmail());
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

}


	
	

