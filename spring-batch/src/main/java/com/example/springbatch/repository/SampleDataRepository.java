package com.example.springbatch.repository;

import com.example.springbatch.entity.SampleData;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SampleDataRepository extends JpaRepository<SampleData, String> {
}
