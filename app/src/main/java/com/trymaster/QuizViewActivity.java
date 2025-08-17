package com.trymaster;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import com.trymaster.database.Question;
import java.util.List;
import java.util.ArrayList;

public class QuizViewActivity extends AppCompatActivity
{

	List<Question> quiz;

	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		
		quiz=new ArrayList<>();
		quiz.add(new Question(1,"who is president of Nigeria","Bola","bukhari","Atiku","Rabiu","Bola"));
		quiz.add(new Question(2,"What Year of Independent","1998","1940","1906","1960","1960"));
		quiz.add(new Question(3,"Which Year did bukhari become president","1998","2016","1906","1960","2016"));
		quiz.add(new Question(4,"Which year are we now","2025","1940","1906","1960","2025"));
		// TODO: Implement this method
		super.onCreate(savedInstanceState);
		setContentView(R.layout.quiz_view);

	}

}
