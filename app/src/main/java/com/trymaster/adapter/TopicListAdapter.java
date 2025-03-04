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
		holder.topicTitle.setText(topic.getTitle());
		holder.topicGoal.setText(topic.getGoal());
		holder.topicIndex.setText(""+position);
		
		
	}

	@Override
	public int getItemCount() {
		return this.topic.size();
	}

	public class TopicViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener
	{

		
		
		public TextView topicTitle,topicGoal,topicIndex;

		public OnTopicListener ontopicL;
		public TopicViewHolder(@NonNull View itemView,OnTopicListener otl) {
            super(itemView);
            topicTitle = itemView.findViewById(R.id.topic_title);
            topicGoal = itemView.findViewById(R.id.topic_goal);
			topicIndex = itemView.findViewById(R.id.order);
		
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
