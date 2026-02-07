package com.trymaster.database;
import android.content.Context;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.appcompat.*;

public class DatabaseHelper extends SQLiteOpenHelper
{
	private static final String DATABASE_NAME = "trymaster.db";
	private static final int DATABASE_VERSION = 4;

	public SQLiteDatabase db;
	Context ctx;
	public DatabaseHelper(Context context) {
		super(context, DATABASE_NAME, null, DATABASE_VERSION);
		ctx=context;
	}
	public SQLiteDatabase getDb(){
		
		return db;
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		//Relatede User Table
		//user/student info table
		db.execSQL("CREATE TABLE users (id INTEGER PRIMARY KEY,fullname TEXT, username TEXT, email TEXT,contact TEXT, password TEXT)");
		//user Topic
		db.execSQL("CREATE TABLE topic (id INTEGER PRIMARY KEY,course_id INTEGER, title TEXT,objective TEXT,video_url TEXT)");
		//Create Quiz Table
		db.execSQL("CREATE TABLE quiz (id INTEGER PRIMARY KEY,topic_id INTEGER,title TEXT,category TEXT,no_of_question INTEGER)");
		//Create Question Table
		db.execSQL("CREATE TABLE question (id INTEGER PRIMARY KEY,quiz_id INTEGER,question_text TEXT,answer TEXT,question_type INTEGER)");
		//Create Option Table
		db.execSQL("CREATE TABLE option (id INTEGER PRIMARY KEY,question_id INTEGER,option_text TEXT)");
		//Create Record Table
		db.execSQL("CREATE TABLE records (id INTEGER PRIMARY KEY,user_id INTEGER,topic_id INTEGER,quiz_id INTEGER,total_mark INTEGER)");
		
		
		
		/* 		###############################
				those below Table is for feature use
				#########£##£#####################*/
			
		//courses being enrolled

		db.execSQL("CREATE TABLE course_enroll (id INTEGER PRIMARY KEY, user_id INTEGER, course_id INTEGER, progress INTEGER, completed BOOLEAN)");
		//point earn by user
		db.execSQL("CREATE TABLE point (id INTEGER PRIMARY KEY, user_id INTEGER, course_id INTEGER, point_earn INTEGER)");
		//User Badges
		db.execSQL("CREATE TABLE badge (id INTEGER PRIMARY KEY, badge_name TEXT, description TEXT, badge_image TEXT)");

		// Create Course table
		db.execSQL("CREATE TABLE courses (id INTEGER PRIMARY KEY, title TEXT, description TEXT,is_complete BOOLEAN )");
		//Create Topic table
	
		
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		// Upgrade logic
	}
}
