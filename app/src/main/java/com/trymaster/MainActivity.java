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

public class MainActivity extends AppCompatActivity
{
	ImageView adsBanner;
	TextView adsDescription;
	RecyclerView courseRecyclerView;
	

	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		// TODO: Implement this method
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main_view);
		
		adsBanner=findViewById(R.id.adsbanner);
		
		
		courseRecyclerView = findViewById(R.id.course_rcv);

		// Get courses from database
		CourseOperation courses = new CourseOperation(this);
		List<Course> courseList=courses.getAllCourses();
		//courseList.add(courses.getCourse(1));

		CourseAdapter courseAdapter = new CourseAdapter(courseList);
		courseRecyclerView.setAdapter(courseAdapter);
		courseRecyclerView.setLayoutManager(new LinearLayoutManager(this));
	}
	
}
