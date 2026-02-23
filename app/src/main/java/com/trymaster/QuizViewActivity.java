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

public class QuizViewActivity extends AppCompatActivity
{

	QuizOperation quiz_op;
	int nextQuestionIndex;
	int second,minute;
	Iterator<Question> it;
	
	List<Question> questionList;
	Map<Integer,String> answer;
	
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
	
		
		
		
//		quiz.add(new Question(1,"who is president of Nigeria","Bola","bukhari","Atiku","Rabiu","Bola"));
//		quiz.add(new Question(2,"What Year of Independent","1998","1940","1906","1960","1960"));
//		quiz.add(new Question(3,"Which Year did bukhari become president","1998","2016","1906","1960","2016"));
//		quiz.add(new Question(4,"Which year are we now","2025","1940","1906","1960","2025"));
		// TODO: Implement this method
		super.onCreate(savedInstanceState);
		setContentView(R.layout.quiz_view);
		

		nextQuestionIndex=0;
		answer=new HashMap<>();

		quiz_op=new QuizOperation(this);
		questionList=quiz_op.getQuestionsByQuizId(1);
		
		questionText=findViewById(R.id.tv_question_text);
		questionNumber=findViewById(R.id.tv_question_number);
		op1=findViewById(R.id.rb_option1);
		op2=findViewById(R.id.rb_option2);
		op3=findViewById(R.id.rb_option3);
		op4=findViewById(R.id.rb_option4);
		
		second=60;
		minute=40;
		ctx=this;
		//it=quiz.iterator();

		//if(nextQuestionIndex<4) 	updateView(quiz.get(nextQuestionIndex));
		
		
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
					//radioGroup.clearCheck();
				}
			});
		
		
		
		tv_time_min=findViewById(R.id.tv_quiz_time_min);
		tv_time_sec=findViewById(R.id.tv_quiz_time_sec);
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
		
		
		prev_button=findViewById(R.id.btn_prev);
		next_button=findViewById(R.id.btn_next);
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
					radioGroup.clearCheck();
				}
				
	
			});
		//Get Next Question on View
		next_button.setOnClickListener(new OnClickListener() {
				@Override
				public void onClick(View p1) {
					String answer=(questionList.get(nextQuestionIndex).getAnswer());
					
					Toast.makeText(p1.getContext(),"The Answer is: "+answer,100).show();
					if (nextQuestionIndex < questionList.size() - 1) {
						nextQuestionIndex++;
						updateView(questionList.get(nextQuestionIndex));
					} else {
						finishQuiz();
						//Toast.makeText(ctx, "Finish", Toast.LENGTH_SHORT).show();
					}
					radioGroup.clearCheck();
				}
			});

	}
	public void updateView(Question q) {

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

		for (Question q : questionList) {
			if (answer.containsKey(q.getId())) {
				if (answer.get(q.getId()).equals(q.getAnswer())) {
					score++;
				}
			}
		}

		Toast.makeText(ctx,
					   "Quiz Finished\nScore: " + score + "/" + questionList.size(),
					   Toast.LENGTH_LONG).show();
	}

}
