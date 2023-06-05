package se.grouprich.projectmanagement.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

@Entity
public class Issue extends AbstractEntity
{
	@Column(name = "issue", columnDefinition = "TEXT", nullable = false)
	private String description;

	@ManyToOne
	@JoinColumn(nullable = false)
	private WorkItem workItem;

	protected Issue(){}

	public Issue(String description)
	{
		this.description = description;
	}

	public Long getId()
	{
		return id;
	}

	public String getDescription()
	{
		return description;
	}

	public WorkItem getWorkItem()
	{
		return workItem;
	}

	public Issue setDescription(String description)
	{
		this.description = description;
		return this;
	}

	public Issue setWorkItem(WorkItem workItem)
	{
		this.workItem = workItem;
		return this;
	}

	@Override
	public boolean equals(final Object other)
	{
		if (this == other)
		{
			return true;
		}

		if (other instanceof Issue)
		{
			Issue otherIssue = (Issue) other;
			return description.equals(otherIssue.description);
		}
		return false;
	}

	@Override
	public int hashCode()
	{
		int result = 1;
		result += description.hashCode() * 37;

		return result;
	}

	@Override
	public String toString()
	{
		return ToStringBuilder.reflectionToString(this, ToStringStyle.JSON_STYLE);
	}
}