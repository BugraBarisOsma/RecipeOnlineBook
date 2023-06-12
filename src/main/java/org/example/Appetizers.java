package org.example;

import java.util.ArrayList;
import java.util.Arrays;

public class Appetizers implements Recipe,Cloneable {
    private String name;
    private String category;
    private String[] tags;
    private ArrayList<String> ingredients;
    private String instructions;
    private int servingSize;
    private int[] rating;


    public Appetizers(String name, String category, String[] tags, ArrayList<String> ingredients, String instructions, int servingSize, int[] rating) {
        this.name = name;
        this.category = category;
        this.tags = tags;
        this.ingredients = ingredients;
        this.instructions = instructions;
        this.servingSize = servingSize;
        this.rating = rating;

    }


    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String getCategory() {
        return category;
    }

    @Override
    public void setCategory(String category) {
        this.category = category;
    }

    @Override
    public String[] getTags() {
        return tags;
    }

    @Override
    public void setTags(String[] tags) {
        this.tags = tags;
    }

    @Override
    public ArrayList<String> getIngredients() {
        return ingredients;
    }

    @Override
    public void setIngredients(ArrayList<String> ingredients) {
        this.ingredients = ingredients;
    }

    @Override
    public String getInstructions() {
        return instructions;
    }

    @Override
    public void setInstructions(String instructions) {
        this.instructions = instructions;
    }

    @Override
    public int getServingSize() {
        return servingSize;
    }

    @Override
    public void setServingSize(int servingSize) {
        this.servingSize = servingSize;
    }

    @Override
    public int[] getRating() {
        return rating;
    }

    @Override
    public void setRating(int[] rating) {
        this.rating = rating;
    }
    @Override
    public Object copyObject() throws CloneNotSupportedException {
        return this.clone();
    }

    @Override
    public String toString() {
        return "Appetizers{" +
                "name='" + name + '\'' +
                ", category='" + category + '\'' +
                ", tags=" + Arrays.toString(tags) +
                ", ingredients=" + ingredients +
                ", instructions='" + instructions + '\'' +
                ", servingSize=" + servingSize +
                ", rating=" + Arrays.toString(rating) +
                '}';
    }
}
