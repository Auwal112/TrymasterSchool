package com.trymaster.adapter;
import android.support.v7.widget.RecyclerView;
import java.util.List;
import com.trymaster.database.Course;
import android.annotation.NonNull;
import android.view.View;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;
import com.trymaster.R;









public class CourseAdapter extends RecyclerView.Adapter<CourseAdapter.CourseViewHolder> {
    private List<Course> courses;
	private OnCourseListener onCourseListener;

	public CourseAdapter(List<Course> courses,OnCourseListener listener) {
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
		holder.courseTitle.setText(course.getTitle());
		holder.courseDescription.setText(course.getDescription());
		
	}

	@Override
	public int getItemCount() {
		return courses.size();
	}

	public class CourseViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
		public TextView courseTitle;
		public TextView courseDescription;
		public OnCourseListener oncourselistener;

		public CourseViewHolder(@NonNull View itemView,OnCourseListener p) {
            super(itemView);
            courseTitle = itemView.findViewById(R.id.course_title);
            courseDescription = itemView.findViewById(R.id.course_description);
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
