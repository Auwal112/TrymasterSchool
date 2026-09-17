package com.trymaster.database;

public class Topic
{
	private int id,course_id,quiz_id;
	private String title,goal,vedioSource,document_link;

	public Topic(int id, int course_id, int quiz_id, String title, String goal, String vedioSource, String document_link)
	{
		this.id = id;
		this.course_id = course_id;
		this.quiz_id = quiz_id;
		this.title = title;
		this.goal = goal;
		this.vedioSource = vedioSource;
		this.document_link = document_link;
	}

	public Topic()
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

public void setQuiz_id(int quiz_id)
{
this.quiz_id = quiz_id;
}

public int getQuiz_id()
{
return quiz_id;
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
}

public void setVedioSource(String vedioSource)
{
this.vedioSource = vedioSource;
}

public String getVedioSource()
{
return vedioSource;
}

public void setDocument_link(String document_link)
{
this.document_link = document_link;
}

public String getDocument_link()
{
return document_link;
}
	
	
	}
