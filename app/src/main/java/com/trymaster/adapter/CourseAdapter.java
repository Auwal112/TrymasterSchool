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

	public CourseAdapter(List<Course> courses) {
		this.courses = courses;
	}

	@NonNull
	@Override
	public CourseViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
		View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.course_view_rcv, parent, false);
		return new CourseViewHolder(view);
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

	public class CourseViewHolder extends RecyclerView.ViewHolder {
		public TextView courseTitle;
		public TextView courseDescription;

		public CourseViewHolder(@NonNull View itemView) {
            super(itemView);
            courseTitle = itemView.findViewById(R.id.course_title);
            courseDescription = itemView.findViewById(R.id.course_description);
		}
	}
}
