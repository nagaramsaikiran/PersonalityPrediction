package com.capgemini.personality.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.capgemini.personality.entity.Skill;
import com.capgemini.personality.model.SkillDTO;
import com.capgemini.personality.service.ISkillService;
@Controller
public class SkillController {
	@Autowired
	private ISkillService skillService;

	@RequestMapping("/skills")
	public List<SkillDTO> getAllSkills() {
		return skillService.getAllSkills();
	}

	@RequestMapping("/skills/{skillId}")
	public SkillDTO getskill(@PathVariable long id) {
		return skillService.getSkill(id);
	}

	@RequestMapping(method = RequestMethod.POST, value = "/skills")
	public SkillDTO addskill(@RequestBody Skill skill) {
		return skillService.addSkill(skill);
	}

	@RequestMapping(method = RequestMethod.PUT, value = "/skills")
	public SkillDTO updateskill(@PathVariable long id, @RequestBody Skill skill) {
		return skillService.updateSkill(skill);
	}

	@RequestMapping(method = RequestMethod.DELETE, value = "/skills/{skillId}")
	public SkillDTO deleteskill(long id) {
		return skillService.deleteSkill(id);
	}

}
