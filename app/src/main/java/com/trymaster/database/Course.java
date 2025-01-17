package com.trymaster.database;
import java.security.*;

public class Course
{
	private int id;
	private String title;
	private String description;
	private String videoUrl;

	public Course(){}
	public Course(int ids,String title,String desc,String url){
		this.id=ids;
		this.title=title;
		this.description=desc;
		this.videoUrl=url;
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

	public void setVideoUrl(String videoUrl)
	{
		this.videoUrl = videoUrl;
	}

	public String getVideoUrl()
	{
		return videoUrl;
	}
	
}



	
	
