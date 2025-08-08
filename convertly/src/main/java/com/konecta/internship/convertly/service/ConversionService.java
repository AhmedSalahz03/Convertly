package com.konecta.internship.convertly.service;

import com.konecta.internship.convertly.model.ConversionRequest;
import com.konecta.internship.convertly.model.ConversionResponse;
import org.springframework.stereotype.Service;

@Service
public class ConversionService {
    public ConversionResponse convert(ConversionRequest request) {
        ConversionResponse response = new ConversionResponse();
        // Input validation
        if (request == null || request.getCategory() == null || request.getFromUnit() == null || request.getToUnit() == null) {
            response.setStatus("error: missing required fields");
            response.setOriginalInput(request);
            return response;
        }
        String category = request.getCategory().toLowerCase();
        String from = request.getFromUnit().toLowerCase();
        String to = request.getToUnit().toLowerCase();
        double value = request.getValue();
        if (category.equals("temperature")) {
            double result = 0;
            String formula = "";
            if (from.equals(to)) {
                result = value;
                formula = "No conversion needed.";
            } else if (from.equals("celsius") && to.equals("fahrenheit")) {
                result = (value * 9/5) + 32;
                formula = String.format("(%s°C × 9/5) + 32 = %s°F", value, result);
            } else if (from.equals("fahrenheit") && to.equals("celsius")) {
                result = (value - 32) * 5/9;
                formula = String.format("(%s°F - 32) × 5/9 = %s°C", value, result);
            } else if (from.equals("celsius") && to.equals("kelvin")) {
                result = value + 273.15;
                formula = String.format("%s°C + 273.15 = %sK", value, result);
            } else if (from.equals("kelvin") && to.equals("celsius")) {
                result = value - 273.15;
                formula = String.format("%sK - 273.15 = %s°C", value, result);
            } else if (from.equals("fahrenheit") && to.equals("kelvin")) {
                result = ((value - 32) * 5/9) + 273.15;
                formula = String.format("((%s°F - 32) × 5/9) + 273.15 = %sK", value, result);
            } else if (from.equals("kelvin") && to.equals("fahrenheit")) {
                result = ((value - 273.15) * 9/5) + 32;
                formula = String.format("((%sK - 273.15) × 9/5) + 32 = %s°F", value, result);
            } else {
                response.setStatus("error: invalid temperature units");
                response.setOriginalInput(request);
                return response;
            }
            response.setResult(result);
            response.setFormula(formula);
            response.setStatus("success");
            response.setOriginalInput(request);
            return response;
        } else if (category.equals("length")) {
            // Supported: meter, kilometer, mile, inch, foot
            double meters = 0;
            // Convert from source unit to meters
            switch (from) {
                case "meter": meters = value; break;
                case "kilometer": meters = value * 1000; break;
                case "mile": meters = value * 1609.34; break;
                case "inch": meters = value * 0.0254; break;
                case "foot": meters = value * 0.3048; break;
                default:
                    response.setStatus("error: invalid length units");
                    response.setOriginalInput(request);
                    return response;
            }
            double result = 0;
            String formula = "";
            // Convert meters to target unit
            switch (to) {
                case "meter": result = meters; formula = String.format("%s %s to meter = %s m", value, from, result); break;
                case "kilometer": result = meters / 1000; formula = String.format("%s %s to kilometer = %s km", value, from, result); break;
                case "mile": result = meters / 1609.34; formula = String.format("%s %s to mile = %s mi", value, from, result); break;
                case "inch": result = meters / 0.0254; formula = String.format("%s %s to inch = %s in", value, from, result); break;
                case "foot": result = meters / 0.3048; formula = String.format("%s %s to foot = %s ft", value, from, result); break;
                default:
                    response.setStatus("error: invalid length units");
                    response.setOriginalInput(request);
                    return response;
            }
            response.setResult(result);
            response.setFormula(formula);
            response.setStatus("success");
            response.setOriginalInput(request);
            return response;
        } else if (category.equals("weight")) {
            // Supported: gram, kilogram, pound, ounce
            double grams = 0;
            switch (from) {
                case "gram": grams = value; break;
                case "kilogram": grams = value * 1000; break;
                case "pound": grams = value * 453.592; break;
                case "ounce": grams = value * 28.3495; break;
                default:
                    response.setStatus("error: invalid weight units");
                    response.setOriginalInput(request);
                    return response;
            }
            double result = 0;
            String formula = "";
            switch (to) {
                case "gram": result = grams; formula = String.format("%s %s to gram = %s g", value, from, result); break;
                case "kilogram": result = grams / 1000; formula = String.format("%s %s to kilogram = %s kg", value, from, result); break;
                case "pound": result = grams / 453.592; formula = String.format("%s %s to pound = %s lb", value, from, result); break;
                case "ounce": result = grams / 28.3495; formula = String.format("%s %s to ounce = %s oz", value, from, result); break;
                default:
                    response.setStatus("error: invalid weight units");
                    response.setOriginalInput(request);
                    return response;
            }
            response.setResult(result);
            response.setFormula(formula);
            response.setStatus("success");
            response.setOriginalInput(request);
            return response;
        } else if (category.equals("time")) {
            // Supported: seconds, minutes, hours, days
            double seconds = 0;
            switch (from) {
                case "seconds": seconds = value; break;
                case "minutes": seconds = value * 60; break;
                case "hours": seconds = value * 3600; break;
                case "days": seconds = value * 86400; break;
                default:
                    response.setStatus("error: invalid time units");
                    response.setOriginalInput(request);
                    return response;
            }
            double result = 0;
            String formula = "";
            switch (to) {
                case "seconds": result = seconds; formula = String.format("%s %s to seconds = %s s", value, from, result); break;
                case "minutes": result = seconds / 60; formula = String.format("%s %s to minutes = %s min", value, from, result); break;
                case "hours": result = seconds / 3600; formula = String.format("%s %s to hours = %s h", value, from, result); break;
                case "days": result = seconds / 86400; formula = String.format("%s %s to days = %s d", value, from, result); break;
                default:
                    response.setStatus("error: invalid time units");
                    response.setOriginalInput(request);
                    return response;
            }
            response.setResult(result);
            response.setFormula(formula);
            response.setStatus("success");
            response.setOriginalInput(request);
            return response;
        } else {
            response.setStatus("error: unsupported category");
            response.setOriginalInput(request);
            return response;
        }
    }
}

