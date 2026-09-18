package com.example.methods_of_jpa;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import jakarta.transaction.Transactional;

public interface ProductRepository extends JpaRepository<Product, Integer> {
  Optional<Product> findByProductName(String name);

  List<Product> findAllByProductPriceBetween(double startPrice, double endPrice);

  List<Product> findAllByProductPriceGreaterThanEqual(double price, Sort sort);

  Optional<Product> findByProductNameAndProductBrand(String name, String brand  );

  // //JPQL -> Java Persistence Query Language
  // @Query ("SELECT P FROM Product P WHERE p.productName =?1 AND p.productbrand=?2")  //positioanal parameter
  // Optional<Product> getProduct( String name, String brand);

//  @Query ("SELECT P FROM Product P WHERE p.productName =:name AND p.productbrand=:brand")  // named parameter
//   Optional<Product> getProduct( String name, String brand);

// @Query (nativeQuery = true,
//    value = "SELECT * FROM product WHERE product_name=? AND product_brand=? ")
//    Optional<Product> getProduct(String name , String brand );

  // @Query (nativeQuery = true,
  //  value = "SELECT * FROM product WHERE product_name=?1 AND product_brand=?2 ")
  //  Optional<Product> getProduct(String name , String brand ); 
  
  @Query (nativeQuery = true,
   value = "SELECT * FROM product WHERE product_name=:name AND product_brand=:brand ")
   Optional<Product> getProduct(String name , String brand );

   @Modifying 
   @Transactional   //  while using any DML query or performing multiple DB operations
   @Query (nativeQuery = true,
          value = "UPDATE  product SET product_price=:price WHERE product_id=:id" )
          int updatePrice(int id,double price );
  
}