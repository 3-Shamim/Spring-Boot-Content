package com.learnigstuff.imagewithspringbootusingpath.repository;

import com.learnigstuff.imagewithspringbootusingpath.model.Image;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ImageRepository extends JpaRepository<Image, Long> {
    Image findImageByName(String fileName);
}
