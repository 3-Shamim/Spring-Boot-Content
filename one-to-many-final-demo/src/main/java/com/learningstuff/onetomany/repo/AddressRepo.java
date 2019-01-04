package com.learningstuff.onetomany.repo;

import com.learningstuff.onetomany.model.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface AddressRepo extends JpaRepository<Address, Integer> {
}
