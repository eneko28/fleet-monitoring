package com.example.fleetmanagementdemo.machine;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface MachineRepository extends JpaRepository<Machine, Long> {
    
    @Query("SELECT m FROM Machine m where m.location = ?1")
    Optional<Machine> findMachineByLocation(String location);
}
