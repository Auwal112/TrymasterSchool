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

public class QuizViewActivity extends AppCompatActivity
{

	int nextQuestionIndex;
	int second,minute;
	Iterator<Question> it;
	
	List<Question> quiz;
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
	
		nextQuestionIndex=0;
		answer=new HashMap<>();
		quiz=new ArrayList<>();
		quiz.add(new Question(1,"who is president of Nigeria","Bola","bukhari","Atiku","Rabiu","Bola"));
		quiz.add(new Question(2,"What Year of Independent","1998","1940","1906","1960","1960"));
		quiz.add(new Question(3,"Which Year did bukhari become president","1998","2016","1906","1960","2016"));
		quiz.add(new Question(4,"Which year are we now","2025","1940","1906","1960","2025"));
		// TODO: Implement this method
		super.onCreate(savedInstanceState);
		setContentView(R.layout.quiz_view);
		
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

		if(nextQuestionIndex<4) 	updateView(quiz.get(nextQuestionIndex));
		
		
		//All Option group
		radioGroup = findViewById(R.id.rg_options);
		radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
				@Override
				public void onCheckedChanged(RadioGroup group, int checkedId) {
					RadioButton radioButton = group.findViewById(checkedId);
					String selectedText = radioButton.getText().toString();
					// Do something with the selected text
					Toast.makeText(ctx,selectedText,100).show();
					Question q=quiz.get(nextQuestionIndex);
					if(answer.containsKey(q.getId())){
						answer.replace(q.getId(),selectedText);
					}else{
						answer.put(q.getId(),selectedText);
					}
				}
			});
		
		
		
		tv_time_min=findViewById(R.id.tv_quiz_time_min);
		tv_time_sec=findViewById(R.id.tv_quiz_time_sec);
		final Handler handler = new Handler();
		Runnable runnable = new Runnable() {
			@Override
			public void run() {
				// Update your view here
				if(minute == 0){
					//Toast.makeText(this.getContext(),"Time up",100).show();
					handler.removeCallbacks(this);
				}
				time_tick();
				handler.postDelayed(this, 1000); // 1000ms = 1s
			}
		};
		handler.post(runnable);
		
		
		prev_button=findViewById(R.id.btn_prev);
		next_button=findViewById(R.id.btn_next);
		//Reverse Previous question to View
		prev_button.setOnClickListener(new OnClickListener(){
				@Override
				public void onClick(View p1)
				{
					// TODO: Implement this method
				}
			});
		//Get Next Question on View
		next_button.setOnClickListener(new OnClickListener() {
				@Override
				public void onClick(View p1) {
					if (nextQuestionIndex < quiz.size() - 1) {
						nextQuestionIndex++;
						updateView(quiz.get(nextQuestionIndex));
					} else {
						Toast.makeText(ctx, "Finish", Toast.LENGTH_SHORT).show();
					}
				}
			});

	}
	public void updateView(Question q){
		questionText.setText(q.getText());
		op1.setText(q.getOp1());
		op2.setText(q.getOp2());
		op3.setText(q.getOp3());
		op4.setText(q.getOp4());
	}
	
	public void  time_tick(){
		//update quiz time text view
		if(second == 0){
			minute=minute-1;
			second=60;
		}
		
		second=second-1;
		String s=Integer.toString(second);
		tv_time_sec.setText(s);
		tv_time_min.setText(Integer.toString(minute));
		
	}

}
