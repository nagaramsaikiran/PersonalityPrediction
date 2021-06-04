package com.capgemini.personality.entity;

import java.util.List;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="JobDetails")
public class JobDetails {
	@Id
	private long jobId;
	private String role;
	@ElementCollection
	private List<Skill> skills;
	private int experience;

	

	public long getJobId() {
		return jobId;
	}

	public void setJobId(long jobId) {
		this.jobId = jobId;
	}

	public JobDetails(long jobId, String role, List<Skill> skills, int experience) {
		super();
		this.jobId = jobId;
		this.role = role;
		this.skills = skills;
		this.experience = experience;
	}

	public String getName() {
		return role;
	}

	public void setName(String role) {
		this.role = role;
	}

	public List<Skill> getList() {
		return skills;
	}

	public void setList(List<Skill> skills) {
		this.skills = skills;
	}

	public int getExperience() {
		return experience;
	}

	public void setExperience(int experience) {
		this.experience = experience;
	}

}
