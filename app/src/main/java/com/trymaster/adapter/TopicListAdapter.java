package com.trymaster.adapter;
import android.support.v7.widget.RecyclerView;
import java.util.List;
import com.trymaster.database.Topic;
import android.annotation.NonNull;
import android.view.View;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;
import com.trymaster.R;
import android.view.View.*;

public class TopicListAdapter extends RecyclerView.Adapter<TopicListAdapter.TopicViewHolder>
{
	private List<Topic> topic;
	private OnTopicListener onTopicListener;

	public TopicListAdapter(List<Topic> topic,OnTopicListener listener) {
		this.topic = topic;
		this.onTopicListener=listener;
	}

	@NonNull
	@Override
	public TopicViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
		View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.topic_list_item, parent, false);
		return new TopicViewHolder(view,onTopicListener);
	}

	@Override
	public void onBindViewHolder(@NonNull TopicViewHolder holder, int position) {
		Topic topic = this.topic.get(position);
		

		holder.number.setText(
			String.format("%02d", position + 1)
		);

		holder.title.setText(topic.getTitle());
		holder.goal.setText(topic.getGoal());

		// Show/hide resources
		if (topic.getVedioSource() == null ||
			topic.getVedioSource().isEmpty()) {

			holder.video.setVisibility(View.GONE);

		} else {
			holder.video.setVisibility(View.VISIBLE);
		}

		if (topic.getDocument_link() == null ||
			topic.getDocument_link().isEmpty()) {

			holder.document.setVisibility(View.GONE);

		} else {
			holder.document.setVisibility(View.VISIBLE);
		}

		if (topic.getQuiz_id() <= 0) {

			holder.quiz.setVisibility(View.GONE);

		} else {
			holder.quiz.setVisibility(View.VISIBLE);
		}
		
		
	}

	@Override
	public int getItemCount() {
		return this.topic.size();
	}

	public class TopicViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener
	{
		
		public TextView topicTitle,topicGoal,topicIndex;
		public TextView number,title,goal,video,document,quiz,status;

		public OnTopicListener ontopicL;
		
		public TopicViewHolder(@NonNull View itemView,OnTopicListener otl) {
            super(itemView);
			number = itemView.findViewById(R.id.topic_number);
			title = itemView.findViewById(R.id.topic_title);
			goal = itemView.findViewById(R.id.topic_goal);

			video = itemView.findViewById(R.id.topic_video);
			document = itemView.findViewById(R.id.topic_document);
			quiz = itemView.findViewById(R.id.topic_quiz);

			status = itemView.findViewById(R.id.topic_status);
			itemView.setOnClickListener(this);
			ontopicL=otl;

			}

		
		
		@Override
		public void onClick(View p1)
		{
			onTopicListener.onTopicClick(this.getAdapterPosition());

		}
		
		
	}
	
	public interface OnTopicListener{
        void onTopicClick(int position);
    }
}











	
	
