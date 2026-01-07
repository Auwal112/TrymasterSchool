package com.trymaster;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import com.trymaster.adapter.TopicListAdapter;
import android.support.v7.widget.*;
import java.util.List;
import java.util.ArrayList;
import com.trymaster.database.Topic;
import android.content.Intent;
import android.widget.*;
import com.trymaster.database.*;

public class TopicListActivity extends AppCompatActivity implements TopicListAdapter.OnTopicListener
{

	
	Intent intent;
	RecyclerView topicRecyclerView;
	TopicOperation topics;

	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		// TODO: Implement this method
		super.onCreate(savedInstanceState);
		setContentView(R.layout.topic_list);
		
		topics=new TopicOperation(this);
		
		List<Topic> topicList=topics.getAllTopic();
		for(int i=0;i<10;i++){
			Topic t1=new Topic();
			t1.setTitle("Intro to Python");
			t1.setGoal("understand what is python and why we learn python");
			topicList.add(t1);
		}
		
		
		
		
		topicRecyclerView = findViewById(R.id.topic_rcv);
		TopicListAdapter topicAdapter = new TopicListAdapter(topicList,this);
		topicRecyclerView.setAdapter(topicAdapter);
		topicRecyclerView.setLayoutManager(new LinearLayoutManager(this));
	}
	
	
	@Override
	public void onTopicClick(int position)
	{
		// TODO: Implement this method
		Toast.makeText(this,"topic",100).show();
		intent=new Intent(this,CourseContentActivity.class);
		startActivity(intent);
	}
	
	
}
