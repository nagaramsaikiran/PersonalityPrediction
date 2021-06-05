package com.capgemini.personality.service;

import java.util.HashMap;
import java.util.List;

import com.capgemini.personality.entity.Candidate;

public interface ICandidateService {
	public Candidate getCandidate(long id);
	
	public List<Candidate> getAllCandidates();

	public Candidate addCandidate(Candidate candidate);

	public Candidate updateCandidate(Candidate candidate);

	public Candidate deleteCandidate(long id);

}
