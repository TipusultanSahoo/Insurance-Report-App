package com.insurance.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.insurance.entity.PlanMaster;

public interface PlanMasterRepo extends JpaRepository<PlanMaster , Integer> {

}
