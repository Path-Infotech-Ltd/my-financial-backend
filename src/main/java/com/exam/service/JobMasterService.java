package com.exam.service;

import com.exam.dto.JobRequest;
import com.exam.dto.JobResponse;
import com.exam.model.JobMaster;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface JobMasterService {

	public List<JobMaster> getAllJobs();

	public void deleteJob(Long jobId);

	public JobMaster getJobById(Long jobId);

	public JobMaster getJobByName(String jobName);

	public List<JobMaster> sortByJobName(String direction);

	List<JobMaster> findByJobNameOrStatus(String jobStatus, String jobName);

	JobResponse addNewJob(JobRequest jobRequest);
}
