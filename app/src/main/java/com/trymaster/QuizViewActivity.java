package com.trymaster;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import com.trymaster.database.Question;
import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;
import android.widget.TextView;
import android.os.Handler;
import android.widget.Button;
import android.view.View.*;
import android.view.*;
import android.widget.RadioGroup;
import android.widget.RadioButton;
import android.widget.*;
import android.content.Context;
import java.util.Map;
import java.util.HashMap;
import com.trymaster.database.*;
import com.trymaster.session.SessionManager;
import com.trymaster.utils.*;
import org.json.*;
import android.util.*;
import android.content.*;

public class QuizViewActivity extends AppCompatActivity
{

	
	//Sqlite management class
	//QuizOperation quiz_op;
	//UserOperation user_op;
	
	SessionManager session;
	//list of question
	ArrayList<Question> questionList;
	//store questionid and answer selected by user
	Map<Integer,String> answer;
	
	Iterator<Question> it;
	//Store progress
	QuizProgressStore progresstore;
	
	//primitive datatype
	int nextQuestionIndex;
	int second,minute;
	
	
	//Ui widget
	TextView tv_time_sec,tv_time_min;
	Button prev_button,next_button;
	RadioGroup radioGroup;
	RadioButton op1,op2,op3,op4;
	TextView questionText,questionNumber;
	
	
	Context ctx;
	
//	Handler handler;
//	Runnable runnable;

	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
	
		
		super.onCreate(savedInstanceState);
		setContentView(R.layout.quiz_view);
		ctx=this;
		session = new SessionManager(this);
		//user_op=new UserOperation(this);
		//quiz_op=new QuizOperation(this);
		
		answer=new HashMap<>();
		
		
		//retrive quiz id from intent
		Intent i=getIntent();
		int quiz_id=i.getIntExtra("quiz_id",-1);
//		if(quiz_id<0) {
//			quiz_id=0;
//			Toast.makeText(this,"quiz id -1",100).show();
//		}else{
//			Toast.makeText(this,"quiz id>-1",100).show();
//		}
		String quiz_title=i.getStringExtra("quiz_title");
		Log.d("pos",quiz_title+"");
		//Toast.makeText(this,quiz_id+"",100).show();
		//fetch question on a given quiz id
		questionList=Quizdata.getQuizList().get(quiz_id).getQuestions();

		

	
		//Time
		second=60;	minute=40;
		
		
		// we start at question in index 0
		nextQuestionIndex=0;
		
		//quiz title
		
		
		
		//Initialize user interaction widget
		questionText=findViewById(R.id.tv_question_text);
		questionNumber=findViewById(R.id.tv_question_number);
		op1=findViewById(R.id.rb_option1);
		op2=findViewById(R.id.rb_option2);
		op3=findViewById(R.id.rb_option3);
		op4=findViewById(R.id.rb_option4);
		
		//time and second display textview
		tv_time_min=findViewById(R.id.tv_quiz_time_min);
		tv_time_sec=findViewById(R.id.tv_quiz_time_sec);
		//previus and next button
		prev_button=findViewById(R.id.btn_prev);
		next_button=findViewById(R.id.btn_next);
		
		
		//Context
		;
		//it=quiz.iterator();

		//if(nextQuestionIndex<4) 	updateView(quiz.get(nextQuestionIndex));
		
		
		//Store quiz info in sharepreference incase of terminating app
		// so you can continue next time
		progresstore=new  QuizProgressStore(this);
		final JSONObject progress = new JSONObject();
		try {

			//progress.put("attempt_id", 1);
			progress.put("quiz_id", quiz_id);
			progress.put("quiz_title", quiz_title);
			progress.put("status", "in_progress");
			progresstore.save(progress);

		}catch(JSONException e){
			e.printStackTrace();
		}
		
		
		
		
		
		
		
		
		
		
		//Reverse Previous question to View
		prev_button.setOnClickListener(new View.OnClickListener() {
				@Override
				public void onClick(View v) {

					if (nextQuestionIndex > 0) {
						nextQuestionIndex--;
						updateView(questionList.get(nextQuestionIndex));
					} else {
						Toast.makeText(ctx, "First Question", Toast.LENGTH_SHORT).show();
					}
					//radioGroup.clearCheck();
				}
				
	
			});
		//Get Next Question on View
		next_button.setOnClickListener(new OnClickListener() {
				@Override
				public void onClick(View p1) {
					//String user_answer=answer.get("")
					//save question and user answer in memory
					
					if (nextQuestionIndex < questionList.size() - 1) {
						nextQuestionIndex++;
						updateView(questionList.get(nextQuestionIndex));
					} else {
						finishQuiz();
						progresstore.clear();
						//Toast.makeText(ctx, "Finish", Toast.LENGTH_SHORT).show();
					}
					//radioGroup.clearCheck();
				}
			});
			
			
			
			
			
		//Run thread to update time and second
		final Handler handler = new Handler();
		Runnable runnable = new Runnable() {
			@Override
			public void run() {

				if (minute == 0 && second == 0) {
					handler.removeCallbacks(this);
					Toast.makeText(ctx, "Time Up!", Toast.LENGTH_LONG).show();
					finishQuiz();
					return;
				}


				time_tick();
				handler.postDelayed(this, 1000);
			}
		};
		handler.post(runnable);
			
		//All Option group
		radioGroup = (RadioGroup) findViewById(R.id.rg_options);
		radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {

				@Override
				public void onCheckedChanged(RadioGroup group, int checkedId) {

					// VERY IMPORTANT: prevent crash
					if (checkedId == -1) return;

					RadioButton radioButton = (RadioButton) group.findViewById(checkedId);
					if (radioButton == null) return;

					String selectedText = radioButton.getText().toString();

					//Toast.makeText(ctx, selectedText, Toast.LENGTH_SHORT).show();

					Question q = questionList.get(nextQuestionIndex);

					// put() handles both insert and update
					answer.put(q.getId(), selectedText);
					//Toast.makeText(ctx,""+answer.size(),100).show();
					//radioGroup.clearCheck();
				}
			});
		
		updateView(questionList.get(nextQuestionIndex));

	}
	public void updateView(Question q) {

		radioGroup.clearCheck();
		questionText.setText(q.getText());
		questionNumber.setText("Question " + (nextQuestionIndex + 1));

		op1.setText(q.getOp1());
		op2.setText(q.getOp2());
		op3.setText(q.getOp3());
		op4.setText(q.getOp4());

		

		// Restore selected answer if exists
		if (answer.containsKey(q.getId())) {
			String selected = answer.get(q.getId());

			if (op1.getText().toString().equals(selected)) {
				op1.setChecked(true);
			} else if (op2.getText().toString().equals(selected)) {
				op2.setChecked(true);
			} else if (op3.getText().toString().equals(selected)) {
				op3.setChecked(true);
			} else if (op4.getText().toString().equals(selected)) {
				op4.setChecked(true);
			}
		}
	}
	
	public void time_tick() {

		if (second == 0) {
			minute--;
			second = 59;
		} else {
			second--;
		}

		tv_time_min.setText(String.valueOf(minute));
		tv_time_sec.setText(String.valueOf(second));
	}
	
	public void finishQuiz() {

		int score = 0;
		
		// Session data
		int stud_id = session.getUserId();

		for (Question q : questionList) {
			//if answer contain questionid and answer is correct
			if (answer.containsKey(q.getId()) && answer.get(q.getId()).equals(q.getAnswer()) )	score++;
		}
		
		//if(score>=6){
			//float done=user_op.insertRecord(stud_id,1,0,score);
		//}else{
		//	Toast.makeText(ctx,"Try again boy",100).show();
		//}
		Toast.makeText(ctx,
					   "Quiz Finished\nScore: " + score + "/" + questionList.size(),
					   Toast.LENGTH_LONG).show();
	}

}
