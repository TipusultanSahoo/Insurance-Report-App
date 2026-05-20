package com.insurance.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.insurance.entity.PlanMaster;

public interface PlanMasterRepo extends JpaRepository<PlanMaster , Integer> {

	@Query("select planName from PlanMaster")
	public List<String> getPlanNames();
}
