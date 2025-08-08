
package com.konecta.internship.convertly.model;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Min;

public class ConversionRequest {
    @NotNull(message = "Category is required")
    private String category;

    @NotNull(message = "From unit is required")
    private String fromUnit;

    @NotNull(message = "To unit is required")
    private String toUnit;

    @Min(value = 0, message = "Value must be non-negative")
    private double value;

    // Getters and setters
    public String getCategory() { return category; }
    public void setCategory(String category) { this.category = category; }
    public String getFromUnit() { return fromUnit; }
    public void setFromUnit(String fromUnit) { this.fromUnit = fromUnit; }
    public String getToUnit() { return toUnit; }
    public void setToUnit(String toUnit) { this.toUnit = toUnit; }
    public double getValue() { return value; }
    public void setValue(double value) { this.value = value; }
}
