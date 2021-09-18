package com.iambabul.storedprocedure.controller;

import com.iambabul.storedprocedure.Content;
import com.iambabul.storedprocedure.service.ContentService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/api")
public class ContentController {

    private final ContentService contentService;

    @GetMapping("/contents")
    public ResponseEntity<List<Content>> getContents() {
        return ResponseEntity.ok().body(contentService.getContents());
    }

    @GetMapping("/content/{id}")
    public ResponseEntity<?> getContent(@PathVariable Long id) {
        return ResponseEntity.ok().body(contentService.getContentById(id).stream().findFirst());
    }
}
