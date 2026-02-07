package com.trymaster;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.content.Intent;

import android.support.v7.app.AppCompatActivity;

import com.trymaster.session.SessionManager;
import com.trymaster.database.UserOperation;

public class DashBoardActivity extends AppCompatActivity {

    TextView tvWelcome, tvRank, tvQuizCount;
    Button btnStartQuiz, btnRecords, btnLogout;

    SessionManager session;
    UserOperation userOperation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dashboard_activity);

        session = new SessionManager(this);

        // If not logged in, go back to login
        if (!session.isLoggedIn()) {
            startActivity(new Intent(DashBoardActivity.this, LoginActivity.class));
            finish();
            return;
        }

        userOperation = new UserOperation(this);

        // Views
        tvWelcome   = findViewById(R.id.tv_welcome);
        tvRank      = findViewById(R.id.tv_rank);
        tvQuizCount = findViewById(R.id.tv_quiz_count);

        btnStartQuiz = findViewById(R.id.btn_start_quiz);
        btnRecords   = findViewById(R.id.btn_records);
        btnLogout    = findViewById(R.id.btn_logout);

        // Session data
        int studentId = session.getUserId();
        String username = session.getUsername();

        // Database data
        int overallRank = userOperation.getOverallRank(studentId);
        int quizCount   = userOperation.getQuizCount(studentId);

        // Display
        tvWelcome.setText("Welcome, " + username + " 👋");
        tvRank.setText("🏆 Rank Score: " + overallRank);
        tvQuizCount.setText("📘 Quizzes Completed: " + quizCount);

        // Buttons
        btnStartQuiz.setOnClickListener(new View.OnClickListener() {
				@Override
				public void onClick(View v) {
					startActivity(new Intent(DashBoardActivity.this, MainActivity.class));
				}
			});

        btnRecords.setOnClickListener(new View.OnClickListener() {
				@Override
				public void onClick(View v) {
					//startActivity(new Intent(DashboardActivity.this, RecordListActivity.class));
				}
			});

        btnLogout.setOnClickListener(new View.OnClickListener() {
				@Override
				public void onClick(View v) {
					session.logout();
					//startActivity(new Intent(DashboardActivity.this, LoginActivity.class));
					finish();
				}
			});
    }

	
}
