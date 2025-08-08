package com.konecta.internship.convertly.controller;

import org.springframework.web.bind.annotation.*;
import com.konecta.internship.convertly.model.ConversionRequest;
import com.konecta.internship.convertly.model.ConversionResponse;
import com.konecta.internship.convertly.service.ConversionService;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;

@RestController
@RequestMapping("/")
public class ConverterController {
    @Autowired
    private ConversionService conversionService;

    // POST /convert
    @PostMapping("convert")
    public ConversionResponse convert(@jakarta.validation.Valid @RequestBody ConversionRequest request) {
        return conversionService.convert(request);
    }

    // GET /categories
    @GetMapping("categories")
    public List<String> getCategories() {
            return List.of("temperature", "length", "weight", "time");
    }

    // GET /units?category=temperature
    @GetMapping("units")
    public List<String> getUnits(@RequestParam String category) {
            switch (category.toLowerCase()) {
                case "temperature":
                    return List.of("celsius", "fahrenheit", "kelvin");
                case "length":
                    return List.of("meter", "kilometer", "mile", "inch", "foot");
                case "weight":
                    return List.of("gram", "kilogram", "pound", "ounce");
                case "time":
                    return List.of("seconds", "minutes", "hours", "days");
                default:
                    return List.of();
            }
    }

    // GET /sample-payload
    @GetMapping("sample-payload")
    public ConversionRequest getSamplePayload() {
            ConversionRequest sample = new ConversionRequest();
            sample.setCategory("temperature");
            sample.setFromUnit("celsius");
            sample.setToUnit("fahrenheit");
            sample.setValue(25);
            return sample;
    }

    // GET /health
    @GetMapping("health")
    public String health() {
        return "{ \"status\": \"Unit Converter API is up and running\" }";
    }
}
