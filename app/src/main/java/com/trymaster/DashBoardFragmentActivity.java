package com.trymaster;
import android.support.v4.app.Fragment;
import android.content.Intent;
import android.view.View;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.os.Bundle;

public class DashBoardFragmentActivity extends Fragment
{
	
	Intent i;

	@Override
    public View onCreateView(LayoutInflater inflater, ViewGroup parent, Bundle savedInstanceState) {
		return inflater.inflate(R.layout.dashboard_fragment_view, parent, false);
    }

	// This event is triggered soon after onCreateView().
    // Any view setup should occur here.  E.g., view lookups and attaching view listeners.
    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {


		//Setting RecyclerView

	}
	
}
