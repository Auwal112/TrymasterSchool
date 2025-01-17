package com.trymaster;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Button;
import android.view.View.*;
import android.view.View;
import com.trymaster.database.*;
import android.widget.*;


public class AddCourseActivity extends AppCompatActivity
{

	//Three input here
	TextView title,description,vedioSrc;
	Button submit;
	
	CourseOperation courseOpeation;
	
	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		// TODO: Implement this method
		super.onCreate(savedInstanceState);
		setContentView(R.layout.add_course_view);
		
		title=findViewById(R.id.title);
		description=findViewById(R.id.description);
		vedioSrc=findViewById(R.id.vedioSrc);
		
		submit=findViewById(R.id.submitButton);
		
		
		submit.setOnClickListener(new OnClickListener(){
			@Override
			public void onClick(View v){
				if(is_valid_input(title.getText().toString(),
								 description.getText().toString(),
								 vedioSrc.getText().toString())){
					courseOpeation=new CourseOperation(v.getContext());
				   	float k=courseOpeation.createCourse(title.getText().toString(),
											   description.getText().toString(),
											   vedioSrc.getText().toString());
					courseOpeation=null;
					Toast.makeText(v.getContext(),"id: "+k,100).show();
				 }else{
					 Toast.makeText(v.getContext(),"Error Occur",100).show();
				 }
			}
		});
	}
	
	/*
	this method accept three argument
	title,description and source
	Return true if didnt violet the rule*/
	public boolean is_valid_input(String t,String d,String s){
		boolean is_valid=true;
		
		if(t.length() < 3 && t.startsWith("[0-9]")){
			is_valid=false;
		}
		if(d.length() < 10 && d.startsWith("[0-9]")){
			is_valid=false;
		}
		if(s.length()<3){
			is_valid=false;
		}
		
		return is_valid;
	}
	
}
