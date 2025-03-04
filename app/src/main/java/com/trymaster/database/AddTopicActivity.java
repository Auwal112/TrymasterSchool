package com.trymaster.database;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.appcompat.R;
import android.widget.*;
import android.view.View.*;
import android.view.*;

public class AddTopicActivity extends AppCompatActivity
{

	EditText topic_title,topic_objective,vedio_source;
	CheckBox is_publish;
	Button submit;
	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		// TODO: Implement this method
		super.onCreate(savedInstanceState);
		setContentView(R.layout.add_topic_view);
		
		
		topic_title=findViewById(R.id.title);
		topic_objective=findViewById(R.id.objective);
		vedio_source=findViewById(R.id.source);
		is_publish=findViewById(R.id.is_publish);
		submit=findViewById(R.id.submit);
		
		//submit form to database
		submit.setOnClickListener(new OnClickListener(){
			@Override
			public void onClick(View v){
				Toast.makeText(v.getContext(),"hello",100).show();
			}
		});//end of onclick listener
		
	}
	
}
