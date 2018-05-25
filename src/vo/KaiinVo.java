package vo;

import java.sql.Date;

import domain.Sex;

public class KaiinVo
{
	private int id;
	private String name;
	private Date date;
	private Sex sex;


	public KaiinVo(int id, String name, Sex sex) {
		super();
		this.id = id;
		this.name = name;
		this.date = new Date(new java.util.Date().getTime());
		this.sex = sex;
	}

	public KaiinVo(int id, String name, Date date, Sex sex) {
		super();
		this.id = id;
		this.name = name;
		this.date = date;
		this.sex = sex;
	}


	public int getId()
	{
		return id;
	}
	public void setId(int id)
	{
		this.id = id;
	}
	public String getName() {
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

	public domain.Sex getSex()
	{
		return sex;
	}

	public void setSex(Sex sex)
	{
		this.sex = sex;
	}


	public String toString()
	{
		return "KaiinVo [id=" + id + ", name=" + name + ", date=" + date + ", sex=" + sex + "]";
	}



}
