package com.trymaster.database;

public class Question
{
	int id;
	String text;
	String op1,op2,op3,op4;
	String answer;

	public Question(int id, String text, String op1, String op2, String op3, String op4, String answer)
	{
		this.id = id;
		this.text = text;
		this.op1 = op1;
		this.op2 = op2;
		this.op3 = op3;
		this.op4 = op4;
		this.answer = answer;
	}


	public void setId(int id)
	{
		this.id = id;
	}

	public int getId()
	{
		return id;
	}

	public void setText(String text)
	{
		this.text = text;
	}

	public String getText()
	{
		return text;
	}}
