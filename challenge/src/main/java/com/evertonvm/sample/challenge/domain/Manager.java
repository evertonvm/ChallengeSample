package com.evertonvm.sample.challenge.domain;

import java.util.List;

public interface Manager extends Worker {

	List<Worker> getManagedWorkers();
	
}
