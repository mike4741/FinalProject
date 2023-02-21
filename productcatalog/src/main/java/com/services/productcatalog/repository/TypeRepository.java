package com.services.productcatalog.repository;

import com.services.productcatalog.dto.TypeDto;
import com.services.productcatalog.model.Type;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TypeRepository extends JpaRepository<Type ,Long> {
    TypeDto findAllById(long typeId);
}
