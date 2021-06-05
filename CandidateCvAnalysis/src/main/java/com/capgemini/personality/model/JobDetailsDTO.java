package com.capgemini.personality.model;

import java.util.List;

import com.capgemini.personality.entity.Skill;

public class JobDetailsDTO {
	private long jobId;
	private String role;
	private List<Integer> skillIds;
	private int experience;

	public JobDetailsDTO() {
		super();
	}

	public JobDetailsDTO(long jobId, String role, List<Integer> skills, int experience) {
		super();
		this.jobId = jobId;
		this.role = role;
		this.skillIds = skills;
		this.experience = experience;
	}

	public long getJobId() {
		return jobId;
	}

	public void setJobId(long jobId) {
		this.jobId = jobId;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public List<Integer> getSkillIds() {
		return skillIds;
	}

	public void setSkillIds(List<Integer> skillIds) {
		this.skillIds = skillIds;
	}

	public int getExperience() {
		return experience;
	}

	public void setExperience(int experience) {
		this.experience = experience;
	}

}
