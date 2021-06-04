package com.capgemini.personality.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Skill {
	@Id
	private String skillName;

	public Skill(String skillName) {
		super();
		this.skillName = skillName;
	}

	public Skill() {
		super();
	}

	public String getSkillName() {
		return skillName;
	}

	public void setSkillName(String skillName) {
		this.skillName = skillName;
	}

}
