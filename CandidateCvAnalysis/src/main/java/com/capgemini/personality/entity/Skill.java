package com.capgemini.personality.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Skill {

	private String skillName;
	@Id
	private String skillId;

	public Skill() {
		super();
	}

	public Skill(String skillName, String skillId) {
		super();
		this.skillName = skillName;
		this.skillId = skillId;
	}

	public String getSkillId() {
		return skillId;
	}

	public void setSkillId(String skillId) {
		this.skillId = skillId;
	}


	public String getSkillName() {
		return skillName;
	}

	public void setSkillName(String skillName) {
		this.skillName = skillName;
	}

}
