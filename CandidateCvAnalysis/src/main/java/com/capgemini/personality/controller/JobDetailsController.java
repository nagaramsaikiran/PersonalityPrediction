package com.capgemini.personality.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.personality.entity.JobDetails;
import com.capgemini.personality.model.JobDetailsDTO;
import com.capgemini.personality.service.IJobDetailsService;

@RestController
public class JobDetailsController {


		@Autowired
		private IJobDetailsService jobDetailsService;

		@RequestMapping("/jobdetails")
		public List<JobDetailsDTO> getAllJobDetails() {
			return jobDetailsService.getAllJobDetails();
		}

		@RequestMapping("/jobdetails/{jobId}")
		public JobDetailsDTO getJobDetails(@PathVariable long id) {
			return jobDetailsService.getJobDetails(id);
			
		}

		@RequestMapping(method = RequestMethod.POST, value = "/jobdetails")
		public JobDetailsDTO addJobDetails(@RequestBody JobDetails jobDetails) {
			return jobDetailsService.addJobDetails(jobDetails);
		}
		
		@RequestMapping(method = RequestMethod.PUT, value = "/jobdetails")
		public JobDetailsDTO updateCandidate(@PathVariable long id,@RequestBody JobDetails jobDetails) {
			return jobDetailsService.updateJobDetails(id, jobDetails);
		}
		
		@RequestMapping(method = RequestMethod.DELETE, value = "/jobdetails/{jobId}")
		public JobDetailsDTO deleteCandidate(long id) {
			return jobDetailsService.deleteJobDetails(id);
		}

}
