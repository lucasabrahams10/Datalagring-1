package se.grouprich.projectmanagement.model;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class AbstractEntity
{
	@Id
	@GeneratedValue
	Long id;
	
	public Long getId()
	{
		return id;
	}
}