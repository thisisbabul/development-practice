package com.iambabul.storedprocedure.service;

import com.iambabul.storedprocedure.Content;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ContentService {

    private final EntityManager entityManager;

    public List<Content> getContents() {
        return entityManager.createNamedStoredProcedureQuery("getContents").getResultList();
    }

    public List<Content> getContentById(Long contentId) {
        return entityManager.createNamedStoredProcedureQuery("getContentById").setParameter("contentId", contentId).getResultList();
    }
}
