package com.capgemini.personality.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.personality.entity.Candidate;
import com.capgemini.personality.model.CandidateDTO;
import com.capgemini.personality.service.ICandidateService;
import com.capgemini.personality.utils.CandidateUtil;

@RestController
public class CandidateController {

	@Autowired
	private ICandidateService candidateService;

	@RequestMapping("/candidates")
	public List<CandidateDTO> getAllCandidates() {
		List<Candidate> candidateList = candidateService.getAllCandidates();
		return CandidateUtil.convertToCandidateDtoList(candidateList);
	}

	@RequestMapping("/candidates/{candidateId}")
	public CandidateDTO getCandidate(@PathVariable long id) {
		Candidate candidate = candidateService.getCandidate(id);
		return CandidateUtil.convertToCandidateDto(candidate);
	}

	@RequestMapping(method = RequestMethod.POST, value = "/candidates")
	public CandidateDTO addCandidate(@RequestBody Candidate candidate) {
		Candidate cand = candidateService.addCandidate(candidate);
		return CandidateUtil.convertToCandidateDto(cand);
	}
	
	@RequestMapping(method = RequestMethod.PUT, value = "/candidates")
	public CandidateDTO updateCandidate(@PathVariable long id,@RequestBody Candidate candidate) {
		Candidate cand = candidateService.updateCandidate(candidate);
		return CandidateUtil.convertToCandidateDto(cand);
	}
	
	@RequestMapping(method = RequestMethod.DELETE, value = "/candidates/{candidateId}")
	public CandidateDTO deleteCandidate(long id) {
		Candidate cand = candidateService.deleteCandidate(id);
		return CandidateUtil.convertToCandidateDto(cand);
	}
}
