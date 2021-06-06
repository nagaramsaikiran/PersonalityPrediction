package com.capgemini.personality.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.personality.dao.CandidateDao;
import com.capgemini.personality.entity.Candidate;
import com.capgemini.personality.model.CandidateDTO;
import com.capgemini.personality.utils.CandidateUtil;

@Service
public class CandidateServiceImpl implements ICandidateService {
	
	@Autowired
	private CandidateDao candidateDao;

	@Override
	public CandidateDTO getCandidate(long id) {
		Candidate candidate= candidateDao.get(id);
		return CandidateUtil.convertToCandidateDto(candidate);
	}

	@Override
	public CandidateDTO addCandidate(Candidate candidate) {
		 candidateDao.save(candidate);
		 return CandidateUtil.convertToCandidateDto(candidate);
	}

	@Override
	public CandidateDTO updateCandidate(Candidate candidate) {
		candidateDao.update(candidate);
		return CandidateUtil.convertToCandidateDto(candidate);
	}

	@Override
	public CandidateDTO deleteCandidate(long id) {
		Candidate candidate=candidateDao.get(id);
		candidateDao.delete(candidate);
		return  CandidateUtil.convertToCandidateDto(candidate);
	}

	@Override
	public List<CandidateDTO> getAllCandidates() {
		List<Candidate> candidateList=candidateDao.getAll();
		return CandidateUtil.convertToCandidateDtoList(candidateList);
	}

}
