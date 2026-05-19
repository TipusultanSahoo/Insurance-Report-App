package com.insurance.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "plan_master")
@Data
public class PlanMaster {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long planId;

    private String planName;

    
    
	public Long getPlanId() {
		return planId;
	}

	public void setPlanId(Long planId) {
		this.planId = planId;
	}

	public String getPlanName() {
		return planName;
	}

	public void setPlanName(String planName) {
		this.planName = planName;
	}
    
    
}