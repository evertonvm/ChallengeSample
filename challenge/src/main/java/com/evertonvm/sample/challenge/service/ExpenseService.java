package com.evertonvm.sample.challenge.service;

import java.math.BigDecimal;
import java.util.List;

import com.evertonvm.sample.challenge.domain.Department;
import com.evertonvm.sample.challenge.domain.Manager;
import com.evertonvm.sample.challenge.domain.Worker;

public class ExpenseService {

	public BigDecimal calculateManagerAllocationCost(Manager manager) {
		return calculateCost(manager.getManagedWorkers(), manager.getAllocationCost());
	}
	
	public BigDecimal calculateDepartmentAllocationCost(Department department) {
		return calculateCost(department.getWorkers(), new BigDecimal(0));
	}

	private BigDecimal calculateCost(List<Worker> workers, BigDecimal cost) {
		for (Worker worker : workers) {
			if (worker instanceof Manager) {
				cost = cost.add(calculateManagerAllocationCost((Manager)worker));
			} else {
				cost = cost.add(worker.getAllocationCost());
			}
		}
		return cost;
	}
}
