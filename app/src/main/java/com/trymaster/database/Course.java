package com.trymaster.database;

public class Course
{
	private int id;
	private String title;
	private String description;
	private String goal;

	public Course(){}
	public Course(int ids,String title,String desc,String goal){
		this.id=ids;
		this.title=title;
		this.description=desc;
		this.goal=goal;
	}

	

	public void setId(int id)
	{
		this.id = id;
	}

	public int getId()
	{
		return id;
	}

	public void setTitle(String title)
	{
		this.title = title;
	}

	public String getTitle()
	{
		return title;
	}

	public void setDescription(String description)
	{
		this.description = description;
	}

	public String getDescription()
	{
		return description;
	}

	public void setGoal(String goal)
	{
		this.goal = goal;
	}

	public String getGoal()
	{
		return goal;
	}
	
}



	
	
