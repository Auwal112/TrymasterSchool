package com.trymaster.database;

public class Badge
{
	private int id;
	private String title,
				description,
				icon,
				requirement,
	createAt;

	public Badge(int id, String title, String description, String icon, String requirement, String createAt)
	{
		this.id = id;
		this.title = title;
		this.description = description;
		this.icon = icon;
		this.requirement = requirement;
		this.createAt = createAt;
	}
	public Badge()
	{}

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

	public void setIcon(String icon)
	{
		this.icon = icon;
	}

	public String getIcon()
	{
		return icon;
	}

	public void setRequirement(String requirement)
	{
		this.requirement = requirement;
	}

	public String getRequirement()
	{
		return requirement;
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
