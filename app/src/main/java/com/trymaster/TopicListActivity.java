package com.trymaster;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import com.trymaster.adapter.TopicListAdapter;
import android.support.v7.widget.*;
import java.util.List;
import java.util.ArrayList;
import com.trymaster.database.Topic;

public class TopicListActivity extends AppCompatActivity
{
	RecyclerView topicRecyclerView;

	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		// TODO: Implement this method
		super.onCreate(savedInstanceState);
		setContentView(R.layout.topic_list);
		
		
		List<Topic> topicList=new ArrayList<>();
		for(int i=0;i<10;i++){
			Topic t1=new Topic();
			t1.setTitle("Intro to Python");
			t1.setGoal("understand what is python and why we learn python");
			topicList.add(t1);
		}
		
		
		
		
		topicRecyclerView = findViewById(R.id.topic_rcv);
		TopicListAdapter topicAdapter = new TopicListAdapter(topicList);
		topicRecyclerView.setAdapter(topicAdapter);
		topicRecyclerView.setLayoutManager(new LinearLayoutManager(this));
	}
	
	
	
	
	
}
