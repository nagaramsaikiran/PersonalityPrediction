package com.capgemini.personality.model;

import javax.persistence.Id;

public class SkillDTO {
	private String skillName;
	private long skillId;
	public SkillDTO() {
		super();
	}
	public SkillDTO(String skillName, long skillId) {
		super();
		this.skillName = skillName;
		this.skillId = skillId;
	}
	public String getSkillName() {
		return skillName;
	}
	public void setSkillName(String skillName) {
		this.skillName = skillName;
	}
	public long getSkillId() {
		return skillId;
	}
	public void setSkillId(long skillId) {
		this.skillId = skillId;
	}

}
