package org.lessons.java.demo.repository;

import org.lessons.java.demo.model.Sale;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SaleRepository extends JpaRepository<Sale, Integer> {

}
