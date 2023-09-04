package com.example.authservice.repository;

import com.example.authservice.model.LanguageEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface LanguageRepository extends JpaRepository<LanguageEntity, Long> {
    Optional<LanguageEntity> findByMessageKeyAndLocale(String messageKey, String locale);
}
