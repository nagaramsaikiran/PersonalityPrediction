package com.capgemini.personality.service;

import java.util.List;

import com.capgemini.personality.entity.JobDetails;
import com.capgemini.personality.model.JobDetailsDTO;

public interface IJobDetailsService {
	public List<JobDetailsDTO> getAllJobDetails();
	
	public JobDetailsDTO getJobDetails(long id);

	public JobDetailsDTO addJobDetails(JobDetails jobDetails);

	public JobDetailsDTO updateJobDetails(long id, JobDetails jobDetails);

	public JobDetailsDTO deleteJobDetails(long id);

}
