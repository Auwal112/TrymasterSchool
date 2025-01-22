package com.trymaster.database;

public class Topic
{
	private int id,course_id;
	private String title,goal;


	public void setId(int id)
	{
		this.id = id;
	}

	public int getId()
	{
		return id;
	}

	public void setCourseId(int course_id)
	{
		this.course_id = course_id;
	}

	public int getCourseId()
	{
		return course_id;
	}

	public void setTitle(String title)
	{
		this.title = title;
	}

	public String getTitle()
	{
		return title;
	}

	public void setGoal(String goal)
	{
		this.goal = goal;
	}

	public String getGoal()
	{
		return goal;
	}}
