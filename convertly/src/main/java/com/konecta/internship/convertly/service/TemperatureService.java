package com.konecta.internship.convertly.service;

import org.springframework.stereotype.Service;

@Service
public class TemperatureService {
    public double convert(String from, String to, double value) {
        from = from.toLowerCase();
        to = to.toLowerCase();
        if (from.equals(to)) {
            return value;
        }
        switch (from) {
            case "celsius":
                if (to.equals("fahrenheit")) {
                    return (value * 9/5) + 32;
                } else if (to.equals("kelvin")) {
                    return value + 273.15;
                }
                break;
            case "fahrenheit":
                if (to.equals("celsius")) {
                    return (value - 32) * 5/9;
                } else if (to.equals("kelvin")) {
                    return ((value - 32) * 5/9) + 273.15;
                }
                break;
            case "kelvin":
                if (to.equals("celsius")) {
                    return value - 273.15;
                } else if (to.equals("fahrenheit")) {
                    return ((value - 273.15) * 9/5) + 32;
                }
                break;
        }
        throw new IllegalArgumentException("Invalid temperature units");
    }

    public String getFormula(String from, String to, double value, double result) {
        from = from.toLowerCase();
        to = to.toLowerCase();
        if (from.equals(to)) {
            return "No conversion needed.";
        }
        if (from.equals("celsius") && to.equals("fahrenheit")) {
            return String.format("(%s°C × 9/5) + 32 = %s°F", value, result);
        } else if (from.equals("fahrenheit") && to.equals("celsius")) {
            return String.format("(%s°F - 32) × 5/9 = %s°C", value, result);
        } else if (from.equals("celsius") && to.equals("kelvin")) {
            return String.format("%s°C + 273.15 = %sK", value, result);
        } else if (from.equals("kelvin") && to.equals("celsius")) {
            return String.format("%sK - 273.15 = %s°C", value, result);
        } else if (from.equals("fahrenheit") && to.equals("kelvin")) {
            return String.format("((%s°F - 32) × 5/9) + 273.15 = %sK", value, result);
        } else if (from.equals("kelvin") && to.equals("fahrenheit")) {
            return String.format("((%sK - 273.15) × 9/5) + 32 = %s°F", value, result);
        }
        return "Invalid temperature units.";
    }
}
