package com.capgemini.personality.service;

import com.capgemini.personality.entity.JobDetails;

public interface IJobDetailsService {
	public JobDetails getCandiadte(long id);

	public JobDetails addCandidate(JobDetails candidate);

	public JobDetails updateCandidate(long id, JobDetails candidate);

	public JobDetails deleteCandidate(long id);

}
