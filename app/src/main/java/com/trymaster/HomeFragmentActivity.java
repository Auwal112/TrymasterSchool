package com.trymaster;

import android.support.v4.app.*;
import android.view.*;
import android.os.Bundle;
import android.support.v7.widget.*;

import java.util.*;
import android.widget.*;
import android.content.*;
import com.trymaster.adapter.QuizAdapter;
import android.view.View.*;
import com.trymaster.session.*;
import com.trymaster.database.*;
import org.json.*;
import com.trymaster.utils.*;

public class HomeFragmentActivity extends Fragment
{

	
	
	SessionManager session;
	QuizProgressStore progressStore;
	UserOperation userOperation;
	Intent i;
	TextView tv_username,continue_quiz_title;
	
	
	Button btn_continue_quiz;
	int quiz_id;
	String status,quiz_title;
	

	@Override
    public View onCreateView(LayoutInflater inflater, ViewGroup parent, Bundle savedInstanceState) {
       return inflater.inflate(R.layout.home_fragment_view, parent, false);
    }

	// This event is triggered soon after onCreateView().
    // Any view setup should occur here.  E.g., view lookups and attaching view listeners.
    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {


		session = new SessionManager(view.getContext());

        // If not logged in, go back to login
        if (!session.isLoggedIn()) {
            startActivity(new Intent(this.getContext(), LoginActivity.class));
            //finish();
            return;
        }
		userOperation = new UserOperation(view.getContext());
		// Session data
        int studentId = session.getUserId();
        String username = session.getUsername();

//        // Database data
//        int overallRank = userOperation.getOverallRank(studentId);
//        int quizCount   = userOperation.getQuizCount(studentId);
//		u
		tv_username=view.findViewById(R.id.tv_username);
		tv_username.setText(username);
		btn_continue_quiz=view.findViewById(R.id.btn_continue_quiz);
		continue_quiz_title=view.findViewById(R.id.tv_continue_quiz_title);
		
	
		
		
		
		/*  Fetch progress */
		progressStore=new QuizProgressStore(view.getContext());
		JSONObject progress = progressStore.load();
		if (progress != null) {
			try {
			    quiz_id = progress.getInt("quiz_id");
				quiz_title =progress.getString("quiz_title");
			   Toast.makeText(view.getContext(),quiz_title+"  Not exist",100).show();
				// Resume quiz
			} catch (JSONException e) {
				e.printStackTrace();
				Toast.makeText(view.getContext(),"Not exist",100).show();
			}
		}
		
		
		btn_continue_quiz.setOnClickListener(new OnClickListener(){
				@Override
				public void onClick(View v){
					i=new Intent(v.getContext(),QuizViewActivity.class);
					i.putExtra("quiz_id",quiz_id);
					i.putExtra("quiz_title",quiz_title);
					startActivity(i);
				}
			});
		continue_quiz_title.setText(quiz_title);
			
		
	}
	

}
