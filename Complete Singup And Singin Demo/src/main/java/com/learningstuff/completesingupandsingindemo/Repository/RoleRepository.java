package com.learningstuff.completesingupandsingindemo.Repository;

import com.learningstuff.completesingupandsingindemo.Model.Role;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface RoleRepository extends CrudRepository<Role, Integer> {
}
