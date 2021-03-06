package com.learningstuff.completesingupandsingindemo.Repository;

import com.learningstuff.completesingupandsingindemo.Model.Users;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.Optional;

@Repository
@Transactional
public interface UserRepository extends CrudRepository<Users, Integer> {
    Optional<Users> findByName(String userName);
}
