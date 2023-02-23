package com.services.productcatalog.repository;

import com.services.productcatalog.model.Brand;
import com.services.productcatalog.model.Item;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ItemRepository extends JpaRepository<Item, Long> {
}