package com.iambabul.redis.service;

import com.iambabul.redis.dto.PersonDTO;
import com.iambabul.redis.dto.RangeDTO;
import org.springframework.data.redis.core.ListOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class RedisListCache {
    private ListOperations<String, Object> listOps;

    public RedisListCache(final RedisTemplate<String, Object> redisTemplate) {
        this.listOps = redisTemplate.opsForList();
    }

    public void cachePersons(final String key, List<PersonDTO> persons) {
        persons.forEach(person -> {
            listOps.leftPush(key, person);
        });
    }

    public List<PersonDTO> getPersonsInRange(final String key, final RangeDTO range) {
        final List<Object> objects = listOps.range(key, range.getFrom(), range.getTo());
        if (CollectionUtils.isEmpty(objects)) {
            return Collections.emptyList();
        }

        return objects.stream()
                .map(x -> (PersonDTO) x)
                .collect(Collectors.toList());
    }

    public PersonDTO getLastElement(final String key) {
        final Object o = listOps.rightPop(key);

        if (Objects.isNull(o)) {
            return null;
        }

        return (PersonDTO) o;
    }

    public void trim(final String key, final RangeDTO range) {
        listOps.trim(key, range.getFrom(), range.getTo());
    }
}
