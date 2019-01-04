package com.learningstuff.commanlinerunnerspringdemo.Repository;

import com.learningstuff.commanlinerunnerspringdemo.Model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface UserRepository  extends CrudRepository<User, Integer>{
}
