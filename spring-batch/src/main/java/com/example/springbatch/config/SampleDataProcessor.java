package com.example.springbatch.config;

import com.example.springbatch.entity.SampleData;
import org.springframework.batch.item.ItemProcessor;

public class SampleDataProcessor implements ItemProcessor<String, SampleData> {

    @Override
    public SampleData process(String code) throws Exception {
        return SampleData.builder().code(code).build();
    }
}
