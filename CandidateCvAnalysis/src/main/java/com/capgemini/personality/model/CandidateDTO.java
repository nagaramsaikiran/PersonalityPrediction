package com.capgemini.personality.model;

import java.util.ArrayList;
import java.util.List;

import com.capgemini.personality.entity.Skill;

public class CandidateDTO {

	private String name;
	private long candidateId;
	private List<Integer> skillIds;
	private int experience;

	public CandidateDTO() {
		super();
	}

	public CandidateDTO(String name, int candidateId, ArrayList<Integer> skills, int experience) {
		super();
		this.name = name;
		this.candidateId = candidateId;
		this.skillIds = skills;
		this.experience = experience;
	}

	public long getCandidateId() {
		return candidateId;
	}

	public void setCandidateId(long candidateId) {
		this.candidateId = candidateId;
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
