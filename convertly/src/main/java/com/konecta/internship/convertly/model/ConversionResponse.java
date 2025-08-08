package com.konecta.internship.convertly.model;

public class ConversionResponse {
    private double result;
    private String formula;
    private String status;
    private ConversionRequest originalInput;

    // Getters and setters
    public double getResult() { return result; }
    public void setResult(double result) { this.result = result; }
    public String getFormula() { return formula; }
    public void setFormula(String formula) { this.formula = formula; }
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
    public ConversionRequest getOriginalInput() { return originalInput; }
    public void setOriginalInput(ConversionRequest originalInput) { this.originalInput = originalInput; }
}
