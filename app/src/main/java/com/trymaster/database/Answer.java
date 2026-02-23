package com.trymaster.database;

public class Answer
{
	int questionid;
	String option;
	String questionText;

	public Answer(int questionid, String option, String questionText)
	{
		this.questionid = questionid;
		this.option = option;
		this.questionText = questionText;
	}

	public void setQuestionid(int questionid)
	{
		this.questionid = questionid;
	}

	public int getQuestionid()
	{
		return questionid;
	}

	public void setOption(String option)
	{
		this.option = option;
	}

	public String getOption()
	{
		return option;
	}

	public void setQuestionText(String questionText)
	{
		this.questionText = questionText;
	}

	public String getQuestionText()
	{
		return questionText;
	}
}
