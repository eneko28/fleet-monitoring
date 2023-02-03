package com.example.fleetmanagementdemo.machine;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class MachineService {

    private final MachineRepository machineRepository;

    @Autowired
    public MachineService(MachineRepository machineRepository){
        this.machineRepository = machineRepository;
    }

	public List<Machine> getMachines(){
		return machineRepository.findAll();
	}

    public Machine getMachineWithId(Long machineId) {
        Machine machine = machineRepository.findById(machineId)
            .orElseThrow(()->new IllegalStateException("machine with id " + machineId + " does not exists"));
        return machine;
    }   

    public void addNewMachine(Machine machine) {
        Optional<Machine> machineByLocation = machineRepository.findMachineByLocation(machine.getLocation());
        if(machineByLocation.isPresent()){
            throw new IllegalStateException("Location taken");
        }
        machineRepository.save(machine);
    }

    public void deleteMachine(Long machineId) {
        boolean exists = machineRepository.existsById(machineId);
        if(!exists){
            throw new IllegalStateException("machine with id " + machineId + " does not exists");
        } 
        machineRepository.deleteById(machineId);
    }

    @Transactional
    public void updateMachine(Long machineId, String location, String version) {
        Machine machine = machineRepository.findById(machineId)
            .orElseThrow(()->new IllegalStateException("machine with id " + machineId + " does not exists"));
        
        if(location != null && location.length() > 0 && !Objects.equals(machine.getLocation(), location)){
            Optional<Machine> optionalMachine = machineRepository.findMachineByLocation(location);
            if(optionalMachine.isPresent()){
                throw new IllegalStateException("Location taken");
            }
            machine.setLocation(location);
        }
        try{
            if(version != null && Integer.valueOf(version) > 0){
                machine.setVersion(Integer.valueOf(version));
            }
        }catch(Exception e){
            throw new IllegalStateException("Cannot parse version value: " + version);
        }
    }
}
