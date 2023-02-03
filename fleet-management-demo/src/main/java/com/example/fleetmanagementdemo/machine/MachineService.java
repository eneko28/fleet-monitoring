package com.example.fleetmanagementdemo.machine;

import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class MachineService {

	public List<Machine> getMachines(){
		return List.of(
			new Machine(1L,1,"Zurich")
		);
	}
    
}
