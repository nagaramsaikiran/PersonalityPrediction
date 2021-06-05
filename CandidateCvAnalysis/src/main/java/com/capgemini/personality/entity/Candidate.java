package com.capgemini.personality.entity;

import java.util.List;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "CandidateDetails")
public class Candidate {
	private String name;
	@Id
	private long candidateId;
	private List<Integer> skillIds;
	private int experience;

	public Candidate() {
		super();
	}

	public long getCandidateId() {
		return candidateId;
	}

	public void setCandidateId(long candidateId) {
		this.candidateId = candidateId;
	}

	public Candidate(String name, int candidateId, List<Integer> skills, int experience) {
		super();
		this.name = name;
		this.candidateId = candidateId;
		this.skillIds = skills;
		this.experience = experience;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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
