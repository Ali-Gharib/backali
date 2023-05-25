package com.test.indata.repositories;

import com.test.indata.entities.ObjectModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ObjectRepository extends JpaRepository<ObjectModel, Long> {

}