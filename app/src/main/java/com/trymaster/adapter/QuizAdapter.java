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
import com.trymaster.database.*;


public class QuizAdapter extends RecyclerView.Adapter<QuizAdapter.QuizViewHolder> {
    private List<Quiz> quiz;
	private OnQuizListener onQuizListener;

	public QuizAdapter(List<Quiz> quizes,OnQuizListener listener) {
		this.quiz = quizes;
		this.onQuizListener=listener;
	}

	@NonNull
	@Override
	public QuizViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
		View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.quiz_list_view, parent, false);
		return new QuizViewHolder(view,onQuizListener);
	}

	@Override
	public void onBindViewHolder(@NonNull QuizViewHolder holder, int position) {
		Quiz quizz = quiz.get(position);
		
		
		holder.quizTitle.setText(quizz.getTitle());
		holder.quizDescription.setText(quizz.getDescription());
		holder.quizSubject.setText(quizz.getCategory());
		//holder.no_of_question.setText(quizz.getTotalQuestions());

	}

	@Override
	public int getItemCount() {
		return quiz.size();
	}

	public class QuizViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
		public TextView quizTitle;
		public TextView quizDescription;
		public TextView quizSubject;
		public TextView no_of_question;
		public OnQuizListener onQuizlistener;

		public QuizViewHolder(@NonNull View itemView,OnQuizListener p) {
            super(itemView);
            quizTitle = itemView.findViewById(R.id.tvQuizTitle);
            quizDescription = itemView.findViewById(R.id.tvQuizDescription);
			quizSubject=itemView.findViewById(R.id.tvQuizCategory);
			no_of_question=itemView.findViewById(R.id.tvTotalQuestions);
			
			itemView.setOnClickListener(this);
			onQuizlistener=p;
		}

		@Override
        public void onClick(View v) {
            onQuizListener.onQuizClick(this.getAdapterPosition());
        }
	}

	public interface OnQuizListener{
        void onQuizClick(int position);
    }
}
