package com.epam.teemo.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.NamedQueries;
import org.hibernate.annotations.NamedQuery;


@Entity
@Table(name = "demo_table")
@NamedQueries({
		@NamedQuery(
				name = "findConfidentialById",
				query = "from Confidential c where c.id = :id"
		)
})
public class Confidential implements Serializable
{
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name = "id")
	private String id;

	@Column(name = "name")
	private String name;

	@Column(name = "confidential")
	private String confidentialInfo;

	public String getId()
	{
		return id;
	}

	public void setId(String id)
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

	public String getConfidentialInfo()
	{
		return confidentialInfo;
	}

	public void setConfidentialInfo(String confidentialInfo)
	{
		this.confidentialInfo = confidentialInfo;
	}
}
