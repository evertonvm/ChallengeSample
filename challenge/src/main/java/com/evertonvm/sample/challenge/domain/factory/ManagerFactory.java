package com.evertonvm.sample.challenge.domain.factory;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import com.evertonvm.sample.challenge.domain.Manager;
import com.evertonvm.sample.challenge.domain.Worker;

public class ManagerFactory {

	public static Manager createManager() {
		return new Manager() {
			
			private List<Worker> managedWorkers;
			
			public String getRole() {
				return "Manager";
			}
			
			public BigDecimal getAllocationCost() {
				return new BigDecimal(300);
			}
			
			public List<Worker> getManagedWorkers() {
				if (managedWorkers == null) {
					managedWorkers = new ArrayList<Worker>();
				}
				return managedWorkers;
			}
		};
	}
}
