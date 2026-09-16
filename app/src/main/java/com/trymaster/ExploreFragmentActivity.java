package com.trymaster;
import android.support.v4.app.Fragment;
import android.content.Intent;
import android.view.View;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import java.util.List;
import com.trymaster.database.Quiz;
import com.trymaster.database.QuizOperation;
import com.trymaster.adapter.*;
import android.support.v7.widget.*;
import android.util.*;
import android.widget.*;
import android.text.*;
import java.util.*;

public class ExploreFragmentActivity extends Fragment implements QuizAdapter.OnQuizListener
{
	
	Intent i;
	RecyclerView quizRecyclerView;
	ArrayList<Quiz> quizList;
	EditText searchQuiz;

	@Override
    public View onCreateView(LayoutInflater inflater, ViewGroup parent, Bundle savedInstanceState) {
		return inflater.inflate(R.layout.explore_fragment_view, parent, false);
    }

	// This event is triggered soon after onCreateView().
    // Any view setup should occur here.  E.g., view lookups and attaching view listeners.
    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {


		//Setting RecyclerView
		quizRecyclerView = view.findViewById(R.id.quiz_rcv);

		quizRecyclerView.setLayoutManager(
			new LinearLayoutManager(view.getContext())
		);

		QuizOperation quizop = new QuizOperation(view.getContext());

		quizList = quizop.getAllQuiz();

		Log.d("EXPLORE", "Quiz count = " + quizList.size());

		QuizAdapter quizAdapter =
			new QuizAdapter(quizList,this);

		quizRecyclerView.setAdapter(quizAdapter);
		
		
		

		searchQuiz = view.findViewById(R.id.et_search_quiz);

		quizRecyclerView = view.findViewById(R.id.quiz_rcv);

		quizRecyclerView.setLayoutManager(
			new LinearLayoutManager(view.getContext())
		);

		QuizOperation quizop2= new QuizOperation(view.getContext());

		//quizList = quizop2.getAllQuiz();

		final QuizAdapter quizAdapter2 = new QuizAdapter(quizList, this);

		quizRecyclerView.setAdapter(quizAdapter2);

		searchQuiz.addTextChangedListener(new TextWatcher() {

				@Override
				public void beforeTextChanged(
					CharSequence s,
					int start,
					int count,
					int after) {
				}

				@Override
				public void onTextChanged(
					CharSequence s,
					int start,
					int before,
					int count) {

					quizAdapter2.filter(s.toString());
				}

				@Override
				public void afterTextChanged(Editable s) {
				}
			});
		
		
	}
	
	
	//respond to click when recyler item is beign click
	@Override
	public void onQuizClick(int position)
	{
		i=new Intent(this.getContext(),QuizViewActivity.class);
		startActivity(i);
		
		
		// TODO: Implement this method
//		int q=(int) quizList.get(position).getId();
//		user_op=new UserOperation(this);
//		if(user_op.user_has_done(q)){
//			Toast.makeText(this,"You have alredy done this quiz",100).show();
//		}else{
//			);
//		}
		
	}
	
	
}
