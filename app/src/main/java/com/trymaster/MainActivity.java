package com.trymaster;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.support.v7.widget.RecyclerView;
import java.util.List;
import java.util.ArrayList;
import android.support.v7.widget.LinearLayoutManager;
import com.trymaster.adapter.CourseAdapter;
import com.trymaster.database.CourseOperation;
import com.trymaster.database.Course;
import android.widget.*;
import android.content.Intent;
import android.view.View.*;
import android.view.View;
import com.trymaster.database.*;
import com.trymaster.session.*;

public class MainActivity extends AppCompatActivity implements CourseAdapter.OnCourseListener
{
	ImageView adsBanner;
	TextView adsDescription;
	RecyclerView courseRecyclerView;
	Intent intent;
	Button add_course_btn;

	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		// TODO: Implement this method
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main_view);
		
		adsBanner=findViewById(R.id.adsbanner);
		add_course_btn=findViewById(R.id.add_course);
		adsDescription=findViewById(R.id.adsdescription);
		SessionManager session = new SessionManager(MainActivity.this);
		String username=session.getUsername();
		adsDescription.setText(username);
		courseRecyclerView = findViewById(R.id.course_rcv);
//
//		//Populate the database with data
//		String[] course =this.getString(R.string.course).split("\n");
//		String[] topic =this.getString(R.string.topic).split("\n");
//		CourseOperation c=new CourseOperation(this);
//		TopicOperation top=new TopicOperation(this);
//
//		float id=c.createCourse(course[0],course[1]);
//		for(int i=0;i<topic.length;i++){
//			String[] t=topic[i].split(",");
//			top.createTopic(id,t[0],t[1],"http//:trymaster.com");
//
//		}
//		c=null;
//		top=null;
		
		// Get courses from database
		CourseOperation courses = new CourseOperation(this);
		List<Course> courseList=courses.getAllCourses();
	
		CourseAdapter courseAdapter = new CourseAdapter(courseList,this);
		courseRecyclerView.setAdapter(courseAdapter);
		courseRecyclerView.setLayoutManager(new LinearLayoutManager(this));
		
		add_course_btn.setOnClickListener(new OnClickListener(){
			@Override
			public void onClick(View v){
				intent=new Intent(v.getContext(),AddCourseActivity.class);
				startActivity(intent);
				
			}
		});
	
		}//end of Oncreate method
	//respond to click when recyler item is beign click
	@Override
	public void onCourseClick(int position)
	{
		// TODO: Implement this method
		intent=new Intent(this,TopicListActivity.class);
		startActivity(intent);
	}
	
	
	
	
}
