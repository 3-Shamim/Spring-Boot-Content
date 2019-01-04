package com.learningstuff.imagedemoinspring.Repository;

import com.learningstuff.imagedemoinspring.Model.Image;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface ImageRepository extends CrudRepository<Image, Integer>{
}
