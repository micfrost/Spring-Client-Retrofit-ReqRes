package dev.micfro.retrofitca;

public class User {
    private Integer id;
    private String name;
    private Integer year;
    private String color;
    private String pantone_value;

    // Getters and Setters
    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public Integer getYear() { return year; }
    public void setYear(Integer year) { this.year = year; }
    public String getColor() { return color; }
    public void setColor(String color) { this.color = color; }
    public String getPantoneValue() { return pantone_value; }
    public void setPantoneValue(String pantone_value) { this.pantone_value = pantone_value; }
}
