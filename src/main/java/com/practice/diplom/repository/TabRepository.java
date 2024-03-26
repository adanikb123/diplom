package com.practice.diplom.repository;

import com.practice.diplom.entity.Tab;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TabRepository extends JpaRepository<Tab,Long> {
}
