package com.blz.candidate.controller;
import java.util.List;

import javax.validation.Valid;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.JobParametersInvalidException;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.core.repository.JobExecutionAlreadyRunningException;
import org.springframework.batch.core.repository.JobInstanceAlreadyCompleteException;
import org.springframework.batch.core.repository.JobRestartException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.blz.candidate.DTO.CandidateDTO;
import com.blz.candidate.model.CandidateModel;
import com.blz.candidate.service.ICandidateService;
import com.blz.candidate.util.Response;

/**
 * Purpose: candidate controller to process candidate Data APIs.
 * @version: 4.15.1.RELEASE
 * @author: Pavan Kumar G V  
 */
@RestController
@RequestMapping("/candidate")
public class CandidateController {

	@Autowired
	ICandidateService candidateService;
//
//	@Autowired
//    private JobLauncher jobLauncher;
//    
//    @Autowired
//    private Job job;

//    @PostMapping("/importCandidates")
//    public void importCsvToDBJob() {
//        JobParameters jobParameters = new JobParametersBuilder()
//                .addLong("startAt", System.currentTimeMillis()).toJobParameters();
//        try {
//            jobLauncher.run(job, jobParameters);
//        } catch (JobExecutionAlreadyRunningException | JobRestartException | JobInstanceAlreadyCompleteException | JobParametersInvalidException e) {
//            e.printStackTrace();
//        }
//    }
    
	/**
	 * Purpose: To create Candidate
	 * @Param: candidateDTO,token and id
	 */
	@PostMapping("/addcandidate")
	public ResponseEntity<Response> addCandidate(/*@Valid*/@RequestBody CandidateDTO candidateDTO, @RequestHeader String token) {
		CandidateModel candidateModel = candidateService.addCandidate(candidateDTO,token);
		Response response = new Response("candidate inserted successfully", 200, candidateModel);
		return new ResponseEntity<>(response, HttpStatus.OK);	
	}

	/**
	 * Purpose: To update Candidate details by id
	 * @Param: candidateDTO,token and id
	 */
	@PutMapping("/updatecandidate/{id}")
	public ResponseEntity<Response> updateCandidate(/*@Valid*/@RequestBody CandidateDTO candidateDTO,@PathVariable Long id, @RequestHeader String token) {
		CandidateModel candidateModel = candidateService.updateCandidate(candidateDTO,id,token);
		Response response = new Response("candidate updated successfully", 200, candidateModel);
		return new ResponseEntity<>(response, HttpStatus.OK);
	}

	/**
	 * Purpose: To get Candidate details by id
	 * @Param: token
	 */
	@GetMapping("/getallcandidates")
	public ResponseEntity<Response> getAllCandidates( @RequestHeader String token) {
		List<CandidateModel> candidateModel = candidateService.getAllCandidates(token);
		Response response = new Response("getting all candidates successfully", 200, candidateModel);
		return new ResponseEntity<>(response, HttpStatus.OK);
	}

	/**
	 * Purpose: To delete Candidate details by id
	 * @Param: id and token
	 */
	@DeleteMapping("/deletecandidate/{id}")
	public ResponseEntity<Response> deleteCandidate(@PathVariable Long id, @RequestHeader String token) {
		CandidateModel candidateModel = candidateService.deleteCandidate(id,token);
		Response response = new Response("candidate deleted successfully", 200, candidateModel);
		return new ResponseEntity<>(response, HttpStatus.OK);
	}

	/**
	 * Purpose: To get candidate details by status
	 * @Param: status and token
	 */
	@GetMapping("/getbystatus/{status}")
	public ResponseEntity<Response> getCandidateByStatus(@PathVariable String status, @RequestHeader String token){
		List<CandidateModel> candidateModel = candidateService.getCandidateByStatus(status,token);
		Response response = new Response("getting candidate by status successfully", 200, candidateModel);
		return new ResponseEntity<>(response, HttpStatus.OK);
	}

	/**
	 * Purpose: To change candidate status by id
	 * @Param: id, status and token
	 */
	@PutMapping("/changestatus/{id}")
	public ResponseEntity<Response> ChangeStatus(@Valid@PathVariable Long id,@RequestParam String status, @RequestHeader String token) {
		CandidateModel candidateModel = candidateService.ChangeStatus(id,status,token);
		Response response = new Response("candidate status changed successfully", 200, candidateModel);
		return new ResponseEntity<>(response, HttpStatus.OK);
	}
	
	/**
	 * Purpose: To get count of status
	 * @Param: status and token
	 */
	@GetMapping("/getstatuscount")
	public ResponseEntity<Response> statusCount(@RequestParam String status, @RequestHeader String token) {
		long candidateModel = candidateService.statusCount(status, token);
		Response response = new Response("getting candidate status count successfully", 200, candidateModel);
		return new ResponseEntity<>(response, HttpStatus.OK);
	}
}
