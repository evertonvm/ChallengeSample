package com.evertonvm.sample.challenge.service;

import static com.evertonvm.sample.challenge.domain.factory.DepartmentFactory.createDepartment;
import static com.evertonvm.sample.challenge.domain.factory.ManagerFactory.createManager;
import static com.evertonvm.sample.challenge.domain.factory.WorkerFactory.createDeveloper;
import static com.evertonvm.sample.challenge.domain.factory.WorkerFactory.createQATester;
import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;

import org.junit.Test;

import com.evertonvm.sample.challenge.domain.Department;
import com.evertonvm.sample.challenge.domain.Manager;
import com.evertonvm.sample.challenge.domain.Worker;


public class ExpenseServiceTest {
	
	private ExpenseService service = new ExpenseService();
	
	@Test
	public void it_should_calculate_manager_allocation_cost_as_2100() {
		//given
		Manager managerA = createManager();
		Manager managerB = createManager();
		Worker developer = createDeveloper();
		Worker tester = createQATester();
		
		managerB.getManagedWorkers().add(developer);
		managerB.getManagedWorkers().add(tester);
		managerA.getManagedWorkers().add(managerB);
		
		//when
		BigDecimal cost = service.calculateManagerAllocationCost(managerA);
		
		//then
		assertEquals(new BigDecimal(2100), cost);
	}
	
	@Test
	public void it_should_calculate_department_allocation_cost_as_2100() {
		//given
		Department department = createDepartment();
		Manager managerA = createManager();
		Manager managerB = createManager();
		Worker developer = createDeveloper();
		Worker tester = createQATester();
		
		managerB.getManagedWorkers().add(developer);
		managerB.getManagedWorkers().add(tester);
		managerA.getManagedWorkers().add(managerB);
		department.getWorkers().add(managerA);
		
		//when
		BigDecimal cost = service.calculateDepartmentAllocationCost(department);
		
		//then
		assertEquals(new BigDecimal(2100), cost);
	}
	
	@Test
	public void it_should_calculate_department_allocation_cost_as_6200() {
		//given
		Department department = createDepartment();
		
		Manager managerA = createManager();
		Manager managerB = createManager();
		
		department.getWorkers().add(managerA);
		department.getWorkers().add(managerB);
		
		Manager managerAA = createManager();
		Manager managerAAA = createManager();

		managerA.getManagedWorkers().add(managerAA);
		managerAA.getManagedWorkers().add(managerAAA);
		
		managerA.getManagedWorkers().add(createDeveloper());
		managerAA.getManagedWorkers().add(createDeveloper());
		managerAA.getManagedWorkers().add(createQATester());
		managerAAA.getManagedWorkers().add(createDeveloper());
		
		managerB.getManagedWorkers().add(createDeveloper());
		managerB.getManagedWorkers().add(createQATester());
		
		//when
		BigDecimal cost = service.calculateDepartmentAllocationCost(department);
		
		//then
		assertEquals(new BigDecimal(6200), cost);
	}
}
