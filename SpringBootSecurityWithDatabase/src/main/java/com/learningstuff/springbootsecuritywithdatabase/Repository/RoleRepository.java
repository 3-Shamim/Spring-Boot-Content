package com.learningstuff.springbootsecuritywithdatabase.Repository;

import com.learningstuff.springbootsecuritywithdatabase.Model.Role;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface RoleRepository extends CrudRepository<Role, Integer>{
}
