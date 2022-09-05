package com.blz.candidate.repository;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.blz.candidate.model.CandidateModel;


@Repository
public interface CandidateRepository extends JpaRepository<CandidateModel, Long>{
		List<CandidateModel> getCandidateByStatus(String status);
}
