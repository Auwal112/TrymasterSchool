package com.trymaster.adapter;
import android.annotation.*;
import android.support.v7.widget.*;
import android.view.*;
import android.widget.*;
import com.trymaster.*;
import com.trymaster.database.*;
import java.util.*;


public class CourseAdapter extends RecyclerView.Adapter<CourseAdapter.CourseViewHolder> {
    private ArrayList<Course> courses;
	private OnCourseListener onCourseListener;

	public CourseAdapter(ArrayList<Course> courses,OnCourseListener listener) {
		this.courses = courses;
		this.onCourseListener=listener;
	}

	@NonNull
	@Override
	public CourseViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
		View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.course_view_rcv, parent, false);
		return new CourseViewHolder(view,onCourseListener);
	}

	@Override
	public void onBindViewHolder(@NonNull CourseViewHolder holder, int position) {
		Course course = courses.get(position);
        holder.title.setText(course.getTitle());
        holder.description.setText(course.getDescription());

        // Temporary simulated progress
        int progress = 35;

        holder.progressBar.setProgress(progress);
        holder.progressText.setText(progress + "% complete");

        // Temporary simulated topic count
        holder.topics.setText("5 topics");
		//holder.courseTitle.setText(course.getTitle());
		//holder.courseDescription.setText(course.getDescription());
		
	}

	@Override
	public int getItemCount() {
		return courses.size();
	}

	public class CourseViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        TextView label;
        TextView title;
        TextView description;
        TextView progressText;
        TextView topics;
      //  TextView continueButton;
		
		ProgressBar progressBar;
		//public TextView courseTitle;
		//public TextView courseDescription;
		public OnCourseListener oncourselistener;

		public CourseViewHolder(@NonNull View itemView,OnCourseListener p) {
            super(itemView);
            //courseTitle = itemView.findViewById(R.id.course_title);
          //  courseDescription = itemView.findViewById(R.id.course_description);
			label = itemView.findViewById(R.id.course_label);
            title = itemView.findViewById(R.id.course_title);
            description = itemView.findViewById(R.id.course_description);

            progressText =
                itemView.findViewById(R.id.course_progress_text);

            topics =
                itemView.findViewById(R.id.course_topics);

            progressBar =
                itemView.findViewById(R.id.course_progress_bar);

          //  continueButton = itemView.findViewById(R.id.course_continue);
				
			itemView.setOnClickListener(this);
			oncourselistener=p;
		}
		
		@Override
        public void onClick(View v) {
            onCourseListener.onCourseClick(this.getAdapterPosition());
        }
	}
	
	public interface OnCourseListener{
        void onCourseClick(int position);
    }
}
