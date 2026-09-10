package com.trymaster;

import android.support.v4.app.*;
import android.view.*;
import android.os.*;
import android.support.v7.widget.*;

import java.util.*;
import android.widget.*;
import android.content.*;
import com.trymaster.adapter.QuizAdapter;

public class HomeFragmentActivity extends Fragment implements QuizAdapter.OnQuizListener
{

	
	
	
	Intent i;

	@Override
    public View onCreateView(LayoutInflater inflater, ViewGroup parent, Bundle savedInstanceState) {
       return inflater.inflate(R.layout.home_fragment_view, parent, false);
    }

	// This event is triggered soon after onCreateView().
    // Any view setup should occur here.  E.g., view lookups and attaching view listeners.
    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {


		//Setting RecyclerView
		
	}
	
	@Override
	public void onQuizClick(int position)
	{
		// TODO: Implement this method
	}
}
