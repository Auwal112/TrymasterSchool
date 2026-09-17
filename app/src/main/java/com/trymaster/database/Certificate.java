package com.trymaster.database;

public class Certificate
{
	private int id,course_id;
	private String title,description,certImage,createAt;

	public Certificate(int id, int course_id, String title, String description, String certImage, String createAt)
	{
		this.id = id;
		this.course_id = course_id;
		this.title = title;
		this.description = description;
		this.certImage = certImage;
		this.createAt = createAt;
	}
	public Certificate()
	{}

	public void setId(int id)
	{
		this.id = id;
	}

	public int getId()
	{
		return id;
	}

	public void setCourse_id(int course_id)
	{
		this.course_id = course_id;
	}

	public int getCourse_id()
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

	public void setDescription(String description)
	{
		this.description = description;
	}

	public String getDescription()
	{
		return description;
	}

	public void setCertImage(String certImage)
	{
		this.certImage = certImage;
	}

	public String getCertImage()
	{
		return certImage;
	}

	public void setCreateAt(String createAt)
	{
		this.createAt = createAt;
	}

	public String getCreateAt()
	{
		return createAt;
	}
	
	
}
