package com.capgemini.personality.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.personality.dao.JobDetailsDao;
import com.capgemini.personality.entity.JobDetails;
import com.capgemini.personality.model.JobDetailsDTO;
import com.capgemini.personality.utils.JobDetailsUtil;

@Service
public class JobDetailsServiceImpl implements IJobDetailsService {

	@Autowired
	private JobDetailsDao jobDetailsDao;

	@Override
	public List<JobDetailsDTO> getAllJobDetails() {
		List<JobDetails> jobDetailsList = jobDetailsDao.getAll();
		return JobDetailsUtil.convertToJobDetailsDtoList(jobDetailsList);
	}

	@Override
	public JobDetailsDTO getJobDetails(long id) {
		JobDetails jobDetails = jobDetailsDao.get(id);
		return JobDetailsUtil.convertToJobDetailsDto(jobDetails);
	}

	@Override
	public JobDetailsDTO addJobDetails(JobDetails jobDetails) {
		jobDetailsDao.save(jobDetails);
		return JobDetailsUtil.convertToJobDetailsDto(jobDetails);
	}

	@Override
	public JobDetailsDTO updateJobDetails(long id, JobDetails jobDetails) {
		jobDetailsDao.update(jobDetails);
		return JobDetailsUtil.convertToJobDetailsDto(jobDetails);
	}

	@Override
	public JobDetailsDTO deleteJobDetails(long id) {
		JobDetails jobDetails=jobDetailsDao.get(id);
		jobDetailsDao.delete(jobDetails);
		return JobDetailsUtil.convertToJobDetailsDto(jobDetails);
	}

}
