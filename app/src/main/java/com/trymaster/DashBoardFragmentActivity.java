package com.trymaster;
import android.support.v4.app.Fragment;
import android.content.Intent;
import android.view.View;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.os.Bundle;
import android.support.v7.widget.*;
import com.trymaster.data.*;
import java.util.*;
import com.trymaster.database.*;
import com.trymaster.adapter.*;

public class DashBoardFragmentActivity extends Fragment implements CourseAdapter.OnCourseListener
{

	
	
	
	Intent i;
	CourseAdapter courseAdapter;
	RecyclerView courseRecycler;
	ArrayList<Course> courseList;

	@Override
    public View onCreateView(LayoutInflater inflater, ViewGroup parent, Bundle savedInstanceState) {
		return inflater.inflate(R.layout.dashboard_fragment_view, parent, false);
    }

	// This event is triggered soon after onCreateView().
    // Any view setup should occur here.  E.g., view lookups and attaching view listeners.
    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {


		//Setting RecyclerView
		courseRecycler = view.findViewById(R.id.course_recycler);

		courseList = CourseData.getCourses();

		courseAdapter = new CourseAdapter(courseList,this);

		courseRecycler.setLayoutManager(
			new LinearLayoutManager(
				view.getContext(),
				LinearLayoutManager.HORIZONTAL,
				false
			)
		);

		courseRecycler.setAdapter(courseAdapter);
		
		

	}
	
	
	
	
	@Override
	public void onCourseClick(int position)
	{
		i=new Intent(this.getContext(),TopicListActivity.class);
		startActivity(i);
		i=null;
	}
	
}
