package com.example.demo.Animal;

import java.util.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface HedgehogRepo extends JpaRepository<Hedgehog, Long> {
     @Query(value = "Select * from hedgehogs s where s.species like CONCAT('%',?1,'%')", nativeQuery = true)
     List<Hedgehog> getHedgehogsbyBreed(String breed);

     @Query(value = "Select * from hedgehogs s where s.species like CONCAT('%',?1,'%')", nativeQuery = true)
     List<Hedgehog> getHedgehogsbyAge(double age);

     @Query(value = "Select * from hedgehogs s where s.species like CONCAT('%',?1,'%')", nativeQuery = true)
     List<Hedgehog> getHedgehogsbyName(String name);
}