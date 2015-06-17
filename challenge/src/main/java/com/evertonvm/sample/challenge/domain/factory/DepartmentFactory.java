package com.evertonvm.sample.challenge.domain.factory;

import java.util.ArrayList;
import java.util.List;

import com.evertonvm.sample.challenge.domain.Department;
import com.evertonvm.sample.challenge.domain.Worker;

public class DepartmentFactory {

	public static Department createDepartment() {
		return new Department() {
			
			private List<Worker> workers;
			
			public List<Worker> getWorkers() {
				if (workers == null) {
					workers = new ArrayList<Worker>();
				}
				return workers;
			}
		};
	}

}
