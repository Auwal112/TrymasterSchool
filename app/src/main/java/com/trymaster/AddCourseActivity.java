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
	TextView title,description;
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
		
		
		submit=findViewById(R.id.submitButton);
		
		submit.setText("hii");
		submit.setOnClickListener(new OnClickListener(){
			@Override
			public void onClick(View v){
				if(is_valid_input(title.getText().toString(),
								 description.getText().toString())){
					courseOpeation=new CourseOperation(v.getContext());
				   	float k=courseOpeation.createCourse(title.getText().toString(),
											   description.getText().toString());
					courseOpeation=null;
					Toast.makeText(v.getContext(),"id: "+k,100).show();
				 }else{
					 Toast.makeText(v.getContext(),"Error Occur",100).show();
				 }
			}
		});
		
	}//end of oncreate
	
	/*
	this method accept three argument
	title,description and source
	Return true if didnt violet the rule*/
	public boolean is_valid_input(String t,String d){
		boolean is_valid=true;
		
		if(t.length() < 3 ){
			is_valid=false;
		}
		if(d.length() < 10 ){
			is_valid=false;
		}
	
		
		return is_valid;
	}
	
}
