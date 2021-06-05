package com.capgemini.personality.utils;

import java.util.ArrayList;
import java.util.List;

import com.capgemini.personality.entity.Candidate;
import com.capgemini.personality.model.CandidateDTO;

public class CandidateUtil {
	public static List<CandidateDTO> convertToCandidateDtoList(List<Candidate> list) {
		List<CandidateDTO> dtolist = new ArrayList<>();
		for (Candidate candidate : list)
			dtolist.add(convertToCandidateDto(candidate));
		return dtolist;
	}

	public static Candidate convertToCandidate(CandidateDTO candidatedto) {
		Candidate candidate = new Candidate();
		candidate.setName(candidatedto.getName());
		candidate.setCandidateId(candidatedto.getCandidateId());
		candidate.setSkillIds(candidatedto.getSkillIds());
		candidate.setExperience(candidatedto.getExperience());
		return candidate;
	}

	public static CandidateDTO convertToCandidateDto(Candidate candidate) {
		CandidateDTO candidateDTO = new CandidateDTO();
		candidateDTO.setName(candidate.getName());
		candidateDTO.setCandidateId(candidate.getCandidateId());
		candidateDTO.setSkillIds(candidate.getSkillIds());
		candidateDTO.setExperience(candidate.getExperience());
		return candidateDTO;
	}

}
