package com.capgemini.personality.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.capgemini.personality.dao.CandidateDao;
import com.capgemini.personality.entity.Candidate;

public class CandidateServiceImpl implements ICandidateService {
	
	@Autowired
	private CandidateDao candidateDao;

	@Override
	public Candidate getCandidate(long id) {
		return candidateDao.get(id);
	}

	@Override
	public Candidate addCandidate(Candidate candidate) {
		 candidateDao.save(candidate);
		 return candidate;
	}

	@Override
	public Candidate updateCandidate(Candidate candidate) {
		candidateDao.update(candidate);
		return candidate;
	}

	@Override
	public Candidate deleteCandidate(long id) {
		Candidate candidate=candidateDao.get(id);
		candidateDao.delete(candidate);
		return candidate;
	}

	@Override
	public List<Candidate> getAllCandidates() {
		return candidateDao.getAll();
	}

}
