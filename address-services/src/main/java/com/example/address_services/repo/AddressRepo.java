package com.example.address_services.repo;

import com.example.address_services.entity.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AddressRepo extends JpaRepository<Address, Integer> {

    @Query(
            nativeQuery = true,
            value
                    = "SELECT ea.id, ea.city, ea.state FROM microservice.address ea join microservice.employee e on e.id = ea.employee_id where ea.employee_id=:employeeId")
    Optional<Address> findAddressByEmployeeId(@Param("employeeId") int employeeId);
}