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
import android.support.design.widget.*;
import android.view.MenuItem;
import android.support.annotation.NonNull;
import android.support.v4.app.FragmentTransaction;


public class MainActivity extends AppCompatActivity implements QuizAdapter.OnQuizListener
{

	@Override
	public void onQuizClick(int position)
	{
		// TODO: Implement this method
	}
	
//	
//	UserOperation user_op;
//	
//	ImageView adsBanner;
//	TextView adsDescription;

//	Intent intent;
//	Button add_quiz_btn;
//	
	
	FragmentTransaction ft;
	FrameLayout fragment;
	
	private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
	= new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.nav_home:
					ft = getSupportFragmentManager().beginTransaction(); 
					ft.replace(R.id.fragmentFrame, new HomeFragmentActivity());
					ft.commit();
                    return true;
                case R.id.nav_explore:
					ft = getSupportFragmentManager().beginTransaction(); 
					ft.replace(R.id.fragmentFrame, new ExploreFragmentActivity());
					ft.commit();
					return true;
				

				case R.id.nav_dashboard:
					ft = getSupportFragmentManager().beginTransaction(); 
					ft.replace(R.id.fragmentFrame, new DashBoardFragmentActivity());
					ft.commit();
                    return true;
            }
            return false;
        }
    };

	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		// TODO: Implement this method
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main_view);
		
//		adsBanner=findViewById(R.id.adsbanner);
//		//add_quiz_btn=findViewById(R.id.add_quiz);
//		//adsDescription=findViewById(R.id.adsdescription);
//		
//		SessionManager session = new SessionManager(MainActivity.this);
//		String username=session.getUsername();
		//adsDescription.setText(username);
//		
//		
//		o

//	
//		
//		
//		/*add_quiz_btn.setOnClickListener(new OnClickListener(){
//			@Override
//			public void onClick(View v){
//				intent=new Intent(v.getContext(),AddQuizActivity.class);
//				startActivity(intent);
//				
//			}
//		});
		
	
		

		
		ft = getSupportFragmentManager().beginTransaction(); 
		ft.replace(R.id.fragmentFrame, new HomeFragmentActivity());
		ft.commit();
		BottomNavigationView navigation = findViewById(R.id.navigation);
		navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
		
	
		}//end of Oncreate method
	
	
	
	
	
}
