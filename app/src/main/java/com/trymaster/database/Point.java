package com.trymaster.database;

public class Point
{
	private int id,
				user_id,
				course_id,
				point_earn;
					
	public Point(){}
	public void setId(int id)
	{
		this.id = id;
	}

	public int getId()
	{
		return id;
	}

	public void setUser_id(int user_id)
	{
		this.user_id = user_id;
	}

	public int getUserId()
	{
		return user_id;
	}

	public void setCourseId(int course_id)
	{
		this.course_id = course_id;
	}

	public int getCourseId()
	{
		return course_id;
	}

	public void setPointEarn(int point_earn)
	{
		this.point_earn = point_earn;
	}

	public int getPointEarn()
	{
		return point_earn;
	}
}
