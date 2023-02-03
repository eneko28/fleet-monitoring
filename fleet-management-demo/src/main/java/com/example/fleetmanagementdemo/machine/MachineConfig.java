package com.example.fleetmanagementdemo.machine;

import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MachineConfig {

    @Bean
    CommandLineRunner commandLineRunner(MachineRepository machineRepository){
        return args ->{
			Machine zurich = new Machine(1,"Zurich");
            Machine thalwil = new Machine(1,"Thalwil");
            machineRepository.saveAll(List.of(zurich,thalwil));
        };
    }
    
}
