package com.learningstuff.card_view_with_springboot.Repository;

import com.learningstuff.card_view_with_springboot.Model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public interface ProductRepository extends JpaRepository<Product, Integer> {

    @Modifying
    @Query(value = "select p from Product p where p.productName like:name")
    List<Product> findByNameLike(@Param(value = "name") String name);

}
