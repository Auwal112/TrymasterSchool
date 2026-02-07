package com.trymaster;
import com.trymaster.database.UserOperation;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;

import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import android.*;
import com.trymaster.database.*;

public class AddQuizActivity extends AppCompatActivity {

    private EditText etQuizTitle;
    private Spinner spCategory;
    private Button btnSelectCsv, btnSubmit;
    private TextView tvFileName;

    private static final int PICK_CSV = 100;
    private Uri csvUri;

    private QuizOperation quiz_operation;
    private SQLiteDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_quiz_view);

        etQuizTitle = findViewById(R.id.etQuizTitle);
        spCategory = findViewById(R.id.spCategory);
        btnSelectCsv = findViewById(R.id.btnSelectCsv);
        btnSubmit = findViewById(R.id.btnSubmit);
        tvFileName = findViewById(R.id.tvFileName);

        quiz_operation= new QuizOperation(this);


        setupSpinner();

        btnSelectCsv.setOnClickListener(new View.OnClickListener() {
				@Override
				public void onClick(View v) {
					selectCsvFile();
				}
			});

        btnSubmit.setOnClickListener(new View.OnClickListener() {
				@Override
				public void onClick(View v) {
					submitQuiz();
				}
			});
    }

    // ---------------- SPINNER ----------------

    private void setupSpinner() {
        String[] subjects = {
			"Mathematics",
			"English",
			"Physics",
			"Chemistry",
			"Islamic Studies",
			"Geography",
			"National Value",
			"History",
			"Computer"
        };

        ArrayAdapter<String> adapter = new ArrayAdapter<>(
			this,
			android.R.layout.simple_spinner_item,
			subjects
        );
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spCategory.setAdapter(adapter);
    }

    // ---------------- FILE PICKER ----------------

    private void selectCsvFile() {
        Intent intent = new Intent(Intent.ACTION_GET_CONTENT);
        intent.setType("text/*");
        startActivityForResult(Intent.createChooser(intent, "Select CSV file"), PICK_CSV);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == PICK_CSV && resultCode == RESULT_OK && data != null) {
            csvUri = data.getData();
            tvFileName.setText("CSV file selected");
        }
    }

    // ---------------- SUBMIT LOGIC ----------------

    private void submitQuiz() {
        String title = etQuizTitle.getText().toString().trim();
        String category = spCategory.getSelectedItem().toString();

        if (title.isEmpty()) {
            toast("Enter quiz title");
            return;
        }

        if (csvUri == null) {
            toast("Select CSV file");
            return;
        }

		//set topicid to zero meaning that quiz is standalone
        long quizId =quiz_operation.insertQuiz(title,category,-1,-1);
		

        if (quizId == -1) {
            toast("Failed to create quiz");
            return;
        }

        readCsvAndInsert(csvUri, quizId);

        toast("Quiz added successfully");
        finish();
    }

 
    

    // ---------------- CSV READER ----------------

	
    private void readCsvAndInsert(Uri uri, long quizId) {
        try {
            InputStream is = getContentResolver().openInputStream(uri);
            BufferedReader reader = new BufferedReader(new InputStreamReader(is));

            String line;
            boolean firstLine = true;

            while ((line = reader.readLine()) != null) {

                if (firstLine) {
                    firstLine = false;
                    continue;
                }

                String[] data = line.split(",");

                if (data.length < 6) continue;

                String questionText = data[0];
                String[] options = {
					data[1], data[2], data[3], data[4]
                };
                String correct = data[5].trim().toUpperCase();

				//insert question into database in relation with quiz
                long questionId = quiz_operation.insertQuestion((int) quizId,questionText,correct,1);
				

                for (int i = 0; i < 4; i++) {
					//insert option in relation with question
					quiz_operation.insertOption((int)questionId,options[i]);
                }
            }

            reader.close();

        } catch (Exception e) {
            e.printStackTrace();
            toast("Error reading CSV file");
        }
    }

    // ---------------- UTILITY ----------------

    private void toast(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }
}
