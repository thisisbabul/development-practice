package com.iambabul.redis.controller;

import com.iambabul.redis.dto.PersonDTO;
import com.iambabul.redis.dto.RangeDTO;
import com.iambabul.redis.service.RedisListCache;
import com.iambabul.redis.service.RedisValueCache;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/person")
public class PersonController {
    private final RedisValueCache valueCache;
    private final RedisListCache listCache;

    @PostMapping
    public void cachePerson(@RequestBody final PersonDTO personDTO) {
        valueCache.cache(personDTO.getId(), personDTO);
    }

    @GetMapping("/{id}")
    public PersonDTO getPerson(@PathVariable final String id) {
        return (PersonDTO) valueCache.getCachedValue(id);
    }

    @DeleteMapping("/{id}")
    public void deletePerson(@PathVariable final String id) {
        valueCache.deleteCachedValue(id);
    }

    @PostMapping("/list/{key}")
    public void cachePersons(@PathVariable final String key, @RequestBody final List<PersonDTO> persons) {
        listCache.cachePersons(key, persons);
    }

    @GetMapping("/list/{key}")
    public List<PersonDTO> getPersonsInRange(@PathVariable final String key, @RequestBody final RangeDTO range) {
        return listCache.getPersonsInRange(key, range);
    }

    @GetMapping("/list/last/{key}")
    public PersonDTO getLastElement(@PathVariable final String key) {
        return listCache.getLastElement(key);
    }

    @DeleteMapping("/list/{key}")
    public void trim(@PathVariable final String key, @RequestBody final RangeDTO range) {
        listCache.trim(key, range);
    }
}
