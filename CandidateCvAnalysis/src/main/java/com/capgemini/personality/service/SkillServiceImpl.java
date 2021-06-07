package com.capgemini.personality.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.personality.dao.SkillDao;
import com.capgemini.personality.entity.Skill;
import com.capgemini.personality.model.SkillDTO;
import com.capgemini.personality.utils.SkillUtil;
@Service
public class SkillServiceImpl implements ISkillService {
	@Autowired
	private SkillDao skillDao;

	@Override
	public SkillDTO getSkill(long id) {
		Skill skill = skillDao.get(id);
		return SkillUtil.convertToSkillDto(skill);
	}

	@Override
	public List<SkillDTO> getAllSkills() {
		List<Skill> skillList = skillDao.getAll();
		return SkillUtil.convertToSkillDtoList(skillList);
	}

	@Override
	public SkillDTO addSkill(Skill skill) {
		skillDao.save(skill);
		return SkillUtil.convertToSkillDto(skill);
	}

	@Override
	public SkillDTO updateSkill(Skill skill) {
		skillDao.update(skill);
		return SkillUtil.convertToSkillDto(skill);
	}

	@Override
	public SkillDTO deleteSkill(long id) {
		Skill skill = skillDao.get(id);
		skillDao.delete(skill);
		return SkillUtil.convertToSkillDto(skill);
	}

}
