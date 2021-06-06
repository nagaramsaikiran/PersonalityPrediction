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

@RestController
public class CandidateController {

	@Autowired
	private ICandidateService candidateService;

	@RequestMapping("/candidates")
	public List<CandidateDTO> getAllCandidates() {
		return candidateService.getAllCandidates();
	}

	@RequestMapping("/candidates/{candidateId}")
	public CandidateDTO getCandidate(@PathVariable long id) {
		return candidateService.getCandidate(id);
	}

	@RequestMapping(method = RequestMethod.POST, value = "/candidates")
	public CandidateDTO addCandidate(@RequestBody Candidate candidate) {
		return candidateService.addCandidate(candidate);
	}

	@RequestMapping(method = RequestMethod.PUT, value = "/candidates")
	public CandidateDTO updateCandidate(@PathVariable long id, @RequestBody Candidate candidate) {
		return candidateService.updateCandidate(candidate);
	}

	@RequestMapping(method = RequestMethod.DELETE, value = "/candidates/{candidateId}")
	public CandidateDTO deleteCandidate(long id) {
		return candidateService.deleteCandidate(id);
	}
}
