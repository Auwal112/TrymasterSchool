package com.trymaster;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import com.trymaster.database.Question;
import java.util.List;
import java.util.ArrayList;
import android.widget.TextView;
import android.os.Handler;
import android.widget.Button;
import android.view.View.*;
import android.view.*;

public class QuizViewActivity extends AppCompatActivity
{

	List<Question> quiz;
	TextView tv_time_sec,tv_time_min;
	Button prev_button,next_button;
	int second,minute;
	
//	Handler handler;
//	Runnable runnable;

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
		second=60;
		minute=40;

		prev_button=findViewById(R.id.btn_prev);
		next_button=findViewById(R.id.btn_next);
		//Reverse Previous question to View
		prev_button.setOnClickListener(new OnClickListener(){
				@Override
				public void onClick(View p1)
				{
					// TODO: Implement this method
				}
		});
		//Get Next Question on View
		next_button.setOnClickListener(new OnClickListener(){
				@Override
				public void onClick(View p1)
				{
					// TODO: Implement this method
				}
		});
		
		
		tv_time_min=findViewById(R.id.tv_quiz_time_min);
		tv_time_sec=findViewById(R.id.tv_quiz_time_sec);
		final Handler handler = new Handler();
		Runnable runnable = new Runnable() {
			@Override
			public void run() {
				// Update your view here
				if(minute == 0){
					//Toast.makeText(this.getContext(),"Time up",100).show();
					handler.removeCallbacks(this);
				}
				updateView();
				handler.postDelayed(this, 1000); // 1000ms = 1s
			}
		};
		handler.post(runnable);

	}
	
	public void  updateView(){
		//update quiz time text view
		if(second == 0){
			minute=minute-1;
			second=60;
		}
		
		second=second-1;
		String s=Integer.toString(second);
		tv_time_sec.setText(s);
		tv_time_min.setText(Integer.toString(minute));
		
	}

}
