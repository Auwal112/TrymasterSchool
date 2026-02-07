package com.trymaster.database;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

public class QuizOperation {

    private SQLiteOpenHelper dbHelper;

    public QuizOperation(Context context) {
        dbHelper = new DatabaseHelper(context);
    }

    /* ===================== QUIZ CRUD ===================== */

    // CREATE quiz
    public long insertQuiz(String quiz_title,String category,int topicId, int noOfQuestion) {
        SQLiteDatabase db = dbHelper.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put("topic_id", topicId);
        values.put("no_of_question", noOfQuestion);
		values.put("title",quiz_title);
		values.put("category",category);

        long quizId = db.insert("quiz", null, values);
        db.close();
        return quizId;
    }

	// Get All Quiz
	public List<Quiz> getAllQuiz() {
    List<Quiz> quizList = new ArrayList<>();

    SQLiteDatabase db = dbHelper.getReadableDatabase();
    Cursor cursor = db.rawQuery("SELECT * FROM quiz", null);

    if (cursor != null && cursor.moveToFirst()) {
        do {
            long id = cursor.getLong(cursor.getColumnIndex("id"));
            String title = cursor.getString(cursor.getColumnIndex("title"));
            String description = ""; // default empty if your table doesn't have description
            int topicId = cursor.getInt(cursor.getColumnIndex("topic_id"));
            String category = cursor.getString(cursor.getColumnIndex("category"));
            int noOfQuestion = cursor.getInt(cursor.getColumnIndex("no_of_question"));

            // If your quiz table now has description column, uncomment this line:
            // description = cursor.getString(cursor.getColumnIndex("description"));

            Quiz quiz = new Quiz(id, title, description, category, noOfQuestion);
            quizList.add(quiz);
        } while (cursor.moveToNext());
        cursor.close();
    }

    db.close();
    return quizList;
}
    // READ quiz by id
    public Cursor getQuizById(int quizId) {
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        return db.rawQuery(
			"SELECT * FROM quiz WHERE id = ?",
			new String[]{String.valueOf(quizId)}
        );
    }

    // READ quizzes by topic
    public Cursor getQuizByTopic(int topicId) {
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        return db.rawQuery(
			"SELECT * FROM quiz WHERE topic_id = ?",
			new String[]{String.valueOf(topicId)}
        );
    }

    // UPDATE quiz
    public void updateQuiz(int quizId, int noOfQuestion) {
        SQLiteDatabase db = dbHelper.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put("no_of_question", noOfQuestion);

        db.update("quiz", values, "id = ?", new String[]{String.valueOf(quizId)});
        db.close();
    }

    // DELETE quiz
    public void deleteQuiz(int quizId) {
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        db.delete("quiz", "id = ?", new String[]{String.valueOf(quizId)});
        db.close();
    }

    /* ===================== QUESTION CRUD ===================== */

    // CREATE question
    public long insertQuestion(int quizId, String questionText,
                               String answer, int questionType) {

        SQLiteDatabase db = dbHelper.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put("quiz_id", quizId);
        values.put("question_text", questionText);
        values.put("answer", answer);
        values.put("question_type", questionType);

        long questionId = db.insert("question", null, values);
        db.close();
        return questionId;
    }

    // READ questions by quiz
    public Cursor getQuestionsByQuiz(int quizId) {
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        return db.rawQuery(
			"SELECT * FROM question WHERE quiz_id = ?",
			new String[]{String.valueOf(quizId)}
        );
    }

    // READ single question
    public Cursor getQuestionById(int questionId) {
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        return db.rawQuery(
			"SELECT * FROM question WHERE id = ?",
			new String[]{String.valueOf(questionId)}
        );
    }

    // UPDATE question
    public void updateQuestion(int questionId, String questionText,
                               String answer, int questionType) {

        SQLiteDatabase db = dbHelper.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put("question_text", questionText);
        values.put("answer", answer);
        values.put("question_type", questionType);

        db.update("question", values, "id = ?", new String[]{String.valueOf(questionId)});
        db.close();
    }

    // DELETE question
    public void deleteQuestion(int questionId) {
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        db.delete("question", "id = ?", new String[]{String.valueOf(questionId)});
        db.close();
    }

    /* ===================== OPTION CRUD ===================== */

    // CREATE option
    public void insertOption(int questionId, String optionText) {
        SQLiteDatabase db = dbHelper.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put("question_id", questionId);
        values.put("option_text", optionText);

        db.insert("option", null, values);
        db.close();
    }

    // READ options by question
    public Cursor getOptionsByQuestion(int questionId) {
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        return db.rawQuery(
			"SELECT * FROM option WHERE question_id = ?",
			new String[]{String.valueOf(questionId)}
        );
    }

    // UPDATE option
    public void updateOption(int optionId, String optionText) {
        SQLiteDatabase db = dbHelper.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put("option_text", optionText);

        db.update("option", values, "id = ?", new String[]{String.valueOf(optionId)});
        db.close();
    }

    // DELETE option
    public void deleteOption(int optionId) {
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        db.delete("option", "id = ?", new String[]{String.valueOf(optionId)});
        db.close();
    }

    // DELETE options of a question (useful)
    public void deleteOptionsByQuestion(int questionId) {
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        db.delete("option", "question_id = ?", new String[]{String.valueOf(questionId)});
        db.close();
    }
}
