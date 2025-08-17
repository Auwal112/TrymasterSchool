package com.trymaster;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.view.View.*;
import android.view.View;
import android.widget.Toast;
import android.content.Intent;

public class CourseContentActivity extends AppCompatActivity
{
	Button startQuizButton;
	Intent i;

	
	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		// TODO: Implement this method
		super.onCreate(savedInstanceState);
		setContentView(R.layout.course_content);
		
		startQuizButton=findViewById(R.id.start_button);
		//Add add onclick to start quiz button
		startQuizButton.setOnClickListener(new OnClickListener(){

				@Override
				public void onClick(View p1)
				{
					//Toast.makeText(p1.getContext(),"hii",100).show();
					i=new Intent(p1.getContext(),QuizViewActivity.class);
					startActivity(i);
				}
		});
		
		
		
	}

}
