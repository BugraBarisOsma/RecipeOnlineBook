package org.example;

import java.util.ArrayList;

public interface Recipe {
    String getName();

    void setName(String name);

    String getCategory();

    void setCategory(String category);

    String[] getTags();

    void setTags(String[] tags);

    ArrayList<String> getIngredients();

    void setIngredients(ArrayList<String> ingredients);

    String getInstructions();

    void setInstructions(String instructions);

    int getServingSize();
    void setServingSize(int servingSize);

    int[] getRating();

    void setRating(int[] rating);

    Object copyObject() throws CloneNotSupportedException;
}
