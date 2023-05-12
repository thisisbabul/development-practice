package com.babul.authservice.entity;

import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@MappedSuperclass
public class EntityBase {
    @Column(name = "created_at", columnDefinition = "TIMESTAMP")
    private LocalDateTime createdAt;
    private Long createdBy;
    @Column(name = "updated_on", columnDefinition = "TIMESTAMP")
    private LocalDateTime updatedOn;
    private Long updatedBy;
}
