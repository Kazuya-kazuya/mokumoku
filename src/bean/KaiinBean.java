package bean;


import java.sql.Date;

import domain.Sex;

public class KaiinBean
{
	private int id;
	private String name;
	private Date date;
	private Sex sex;


	public KaiinBean(){}


	public int getId()
	{
		return id;
	}
	public void setId(int id)
	{
		this.id = id;
	}
	public String getName()
	{
		return name;
	}
	public void setName(String name)
	{
		this.name = name;
	}
	public Date getDate()
	{
		return date;
	}
	public void setDate(Date date)
	{
		this.date = date;
	}

	public Sex getSex()
	{
		return sex;
	}

	public void setSex(Sex sex)
	{
		this.sex = sex;
	}


	public String toString()
	{
		return "KaiinBean [id=" + id + ", name=" + name + ", date=" + date + ", sex=" + sex + "]";
	}
}

