package com.trymaster.database;
import android.content.Context;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteDatabase;

public class DatabaseHelper extends SQLiteOpenHelper
{
	private static final String DATABASE_NAME = "trymaster.db";
	private static final int DATABASE_VERSION = 1;

	public SQLiteDatabase db;
	
	public DatabaseHelper(Context context) {
		super(context, DATABASE_NAME, null, DATABASE_VERSION);
	}
	public SQLiteDatabase getDb(){
		
		return db;
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		//Relatede User Table
		//user info table
		db.execSQL("CREATE TABLE user (id INTEGER PRIMARY KEY, username TEXT, email TEXT, password TEXT)");
		//user Courses Table
		//courses being enrolled
		db.execSQL("CREATE TABLE course_enroll (id INTEGER PRIMARY KEY, user_id INTEGER, course_id INTEGER, progress INTEGER, completed BOOLEAN)");
		//point earn by user
		db.execSQL("CREATE TABLE point (id INTEGER PRIMARY KEY, user_id INTEGER, course_id INTEGER, point_earn INTEGER)");
		//User Badges
		db.execSQL("CREATE TABLE badge (id INTEGER PRIMARY KEY, badge_name TEXT, description TEXT, badge_image TEXT)");
		
		// Create Course table
		db.execSQL("CREATE TABLE courses (id INTEGER PRIMARY KEY, title TEXT, description TEXT)");
		//Create Topic table
		db.execSQL("CREATE TABLE topic (id INTEGER PRIMARY KEY,course_id INTEGER, title TEXT,objective TEXT, video_url TEXT)");
		//Create Quiz Table
		db.execSQL("CREATE TABLE quiz (id INTEGER PRIMARY KEY,topic_id INTEGER)");
		//Create Question Table
		db.execSQL("CREATE TABLE question (id INTEGER PRIMARY KEY,quiz_id INTEGER,question_text TEXT,answer TEXT,question_type INTEGER)");
		//Create Option Table
		db.execSQL("CREATE TABLE option (id INTEGER PRIMARY KEY,question_id INTEGER,option_text TEXT)");
		
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		// Upgrade logic
	}
}
