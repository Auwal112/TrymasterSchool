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
import com.trymaster.adapter.*;


public class MainActivity extends AppCompatActivity implements QuizAdapter.OnQuizListener
{
	List<Quiz> quizList;
	UserOperation user_op;
	
	ImageView adsBanner;
	TextView adsDescription;
	RecyclerView quizRecyclerView;
	Intent intent;
	Button add_quiz_btn;

	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		// TODO: Implement this method
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main_view);
		
		adsBanner=findViewById(R.id.adsbanner);
		add_quiz_btn=findViewById(R.id.add_course);
		adsDescription=findViewById(R.id.adsdescription);
		
		SessionManager session = new SessionManager(MainActivity.this);
		String username=session.getUsername();
		adsDescription.setText(username);
		quizRecyclerView = findViewById(R.id.course_rcv);
		
		
		// Get courses from database
		QuizOperation quizop = new QuizOperation(this);
		quizList=quizop.getAllQuiz();
	
		QuizAdapter courseAdapter = new QuizAdapter(quizList,this);
		quizRecyclerView.setAdapter(courseAdapter);
		quizRecyclerView.setLayoutManager(new LinearLayoutManager(this));
		
		add_quiz_btn.setOnClickListener(new OnClickListener(){
			@Override
			public void onClick(View v){
				intent=new Intent(v.getContext(),AddQuizActivity.class);
				startActivity(intent);
				
			}
		});
	
		}//end of Oncreate method
	//respond to click when recyler item is beign click
	@Override
	public void onQuizClick(int position)
	{
		// TODO: Implement this method
		int q=(int) quizList.get(position).getId();
		user_op=new UserOperation(this);
		if(user_op.user_has_done(q)){
			Toast.makeText(this,"You have alredy done this quiz",100).show();
		}else{
			intent=new Intent(this,QuizViewActivity.class);
			startActivity(intent);
		}
		
	}
	
	
	
	
}
