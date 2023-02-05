package com.example.fleetmanagementdemo.machine;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "api/v1/machine")
public class MachineController {

    private final MachineService machineService;

    @Autowired
    public MachineController(MachineService machineService){
        this.machineService = machineService;
    }

    @GetMapping()
    public List<Machine> getMachines(){
        return machineService.getMachines();
    }

    @GetMapping(path = "{machineId}")
    public Machine getMachineWithId(@PathVariable("machineId") Long machineId){
        return machineService.getMachineWithId(machineId);
    }

    @PostMapping()
    public void registerNewMachine(@RequestBody Machine machine){
        machineService.addNewMachine(machine);
    }

    @DeleteMapping(path = "{machineId}")
    public void deleteMachine(@PathVariable("machineId") Long machineId){
        machineService.deleteMachine(machineId);
    }

    @PutMapping(path = "{machineId}")
    public void updateMachine(
        @PathVariable("machineId") Long machineId,
        @RequestParam(required = false) String location,
        @RequestParam(required = false) String version ){
            machineService.updateMachine(machineId,location,version);
        }
}
