package org.example;

import java.util.ArrayList;

public class RecipeFactory {
    public static Recipe getRecipe(String name, String category, String[] tags, ArrayList<String> ingredients, String instructions, int servingSize,int[] rating){

        Recipe recipe = null;
        if("dessert".equalsIgnoreCase(category)){
            recipe = new Desserts(name,category,tags,ingredients,instructions,servingSize, rating);
            System.out.println("New Dessert added");
        } else  if("main dish".equalsIgnoreCase(category)){
            recipe = new MainDish(name,category,tags,ingredients,instructions,servingSize, rating);

            System.out.println("New MainDish added");
        } else  if("appetizers".equalsIgnoreCase(category)){
            recipe = new Appetizers(name,category,tags,ingredients,instructions,servingSize,rating);
            System.out.println("New Appetizer added");
        } else {
            System.out.println("Please enter a valid category");
        }
       return recipe;
    }

}
