package com.evertonvm.sample.challenge.domain.factory;

import java.math.BigDecimal;

import com.evertonvm.sample.challenge.domain.Worker;

public class WorkerFactory {

	public static Worker createDeveloper() {
		return new Worker() {
			
			public String getRole() {
				return "Developer";
			}
			
			public BigDecimal getAllocationCost() {
				return new BigDecimal(1000);
			}
		};
	}
	
	public static Worker createQATester() {
		return new Worker() {
			
			public String getRole() {
				return "QA Tester";
			}
			
			public BigDecimal getAllocationCost() {
				return new BigDecimal(500);
			}
		};
	}

}
