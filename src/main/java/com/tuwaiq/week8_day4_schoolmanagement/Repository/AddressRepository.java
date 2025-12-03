package com.tuwaiq.week8_day4_schoolmanagement.Repository;

import com.tuwaiq.week8_day4_schoolmanagement.Model.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressRepository extends JpaRepository<Address,Integer> {

    Address findAddressById(Integer id);
}
