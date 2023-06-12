package org.example;

import java.util.ArrayList;
import java.util.Scanner;


public class Main {
    static Scanner input = new Scanner(System.in);
    static TagManager tagManager = TagManager.getTagManager();

    public static void main(String[] args) {

        ArrayList<Recipe> RecipeList = new ArrayList<Recipe>();

        int a = 0;
        String[] tags = {"tag1", "tag2", "tag3"};
        ArrayList<String> ingredients = new ArrayList<String>();
        ingredients.add("onion");
        ingredients.add("bellpaper");
        ingredients.add("tomato");
        String instructions = "cook onion tomato bellpepper";
        int[] rating = new int[2];
        rating[0] = 0;
        rating[1] = 0;
        Recipe recipe = RecipeFactory.getRecipe("menemen", "appetizers", tags, ingredients, instructions, 4, rating);
        RecipeList.add(recipe);
        A1:
        while (true) {
            System.out.println("----------Welcome to Recipe Management System----------");
            System.out.println("----------------------------------------------------");
            System.out.println("Choose a operation:");
            System.out.println(" 1 - ) Create a Recipe");
            System.out.println(" 2 - ) Modify a Recipe");
            System.out.println(" 3 - ) Rate a Recipe");
            System.out.println(" 4 - ) Search a Recipe");
            System.out.println(" 5 - ) Display all Recipes");


            a = input.nextInt();
            switch (a) {
                case 1:
                    RecipeList.add(createRecipe());
                    break;
                case 2:
                    modifyRecipe(RecipeList);
                    break;
                case 3:
                    System.out.println("Choose a recipe to rate");
                    for (Recipe p : RecipeList) {
                        showRecipe(p);
                    }
                    int chosen = input.nextInt();
                    rating(RecipeList.get(chosen - 1));
                    break;
                case 4:
                    System.out.println("Enter a word to search");
                    String searchTemp = input.next();
                    search(searchTemp, RecipeList);
                    break;
                case 5:
                    for ( Recipe m: RecipeList) {
                        showRecipe(m);
                    }
                    break;
            }
            System.out.println("Would you like to continue? (y/N)");
            String state = input.next();
            if (state.equalsIgnoreCase("y")) {
                continue A1;
            } else {
                break;
            }
        }
    }

    private static void modifyRecipe(ArrayList<Recipe> RecipeList) {

        int count = 1, select;
        for (Recipe i : RecipeList) {
            System.out.println("Which recipe would you like to modify?");
            System.out.println("------------------------------------------------");
            System.out.println(count + ". Recipe");
            showRecipe(i);
            count++;
        }
        System.out.println("Enter number of the recipe");

        try {
            ModifyIngredientCommand ingModifier = new ModifyIngredientCommand();
            ModifyInstructionCommand insModifier = new ModifyInstructionCommand();
            select = input.nextInt();
            ArrayList<String> tempIngredients = new ArrayList<String>();
            int counter = 0;
            for (String n:RecipeList.get(select-1).getIngredients()) {
               tempIngredients.add(RecipeList.get(select-1).getIngredients().get(counter));
               counter++;
            }
            Recipe recipeTemp = RecipeList.get(select - 1);
            Recipe recipeTemp2 = (Recipe) RecipeList.get(select-1).copyObject();
            String[] tags = new String[3];
            

            ingModifier.modify(recipeTemp);
            insModifier.modify(recipeTemp);
            System.out.println("Choose recipe tags (1-Vegan , 2-Spicy, 3-Gluten-free or press x to exit):");
            for (int i = 1; i < 4; i++) {
                System.out.println("Enter " + i + ". tag");
                String tagTemp = input.next();
                if (tagTemp.equalsIgnoreCase("x")) {
                    break;
                } else {
                    tags[i - 1] = tagManager.getTag(tagTemp);
                }

                System.out.println(tags[i - 1]);
            }

            recipeTemp.setTags(tags);

            System.out.println("Would you like to save changes");
            System.out.println(" 1 - ) Yes");
            System.out.println(" 2 - ) No");
            int decision = input.nextInt();
            if (decision == 2) {
                RecipeList.set(select - 1, recipeTemp2);
                RecipeList.get(select-1).setIngredients(tempIngredients);
            }

        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }

    }

    public static Recipe createRecipe() {
        try {
            String tags[] = new String[3];
            ArrayList<String> ingredients = new ArrayList<String>();
            System.out.println("Enter recipe name:");
            String temp = input.nextLine();
            String name = input.nextLine();
            System.out.println("Enter a category:(Main dish, Dessert,Appetizer write down one of them)");
            String category = input.nextLine();
            System.out.println("Choose recipe tags (1-Vegan , 2-Spicy, 3-Gluten-free or press x to exit integer only):");
            for (int i = 1; i < 4; i++) {
                System.out.println("Enter " + i + ". tag");
                String tagTemp = input.next();
                if (tagTemp.equalsIgnoreCase("x")) {
                    break;
                } else {
                    tags[i - 1] = tagManager.getTag(tagTemp);
                }

                System.out.println(tags[i - 1]);
            }



            int count = 1;
            System.out.println("Enter ingredients:");
            System.out.println("When you are done adding ingredients , press x to exit");
            while (true) {
                System.out.println("Enter " + count + ". ingredient");
                String temp2 = input.next();
                if (temp2.equalsIgnoreCase("x")) {
                    break;
                }
                ingredients.add(temp2);
                count++;

            }
            for (int i = 0; i < ingredients.size(); i++) {
                System.out.println(ingredients.get(i));
            }


            System.out.println("Enter instructions");
            String temp2 = input.nextLine();
            String instructions = input.nextLine();
            System.out.println("Enter serving size");
            int servingSize = input.nextInt();
            System.out.println("Enter rating");
            int rate = input.nextInt();
            int[] rating = {rate, 1};

            Recipe recipe = RecipeFactory.getRecipe(name, category, tags, ingredients, instructions, servingSize, rating);
            return recipe;

        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }

    public static void search(String searchTemp, ArrayList<Recipe> RecipeList) {
        boolean state = false;
        for (Recipe i : RecipeList) {
            if (i.getName().equalsIgnoreCase(searchTemp)) {
                showRecipe(i);
                state = true;
                break;
            } else if (i.getInstructions().equalsIgnoreCase(searchTemp)) {
                showRecipe(i);
                state = true;
                break;
            } else if (i.getCategory().equalsIgnoreCase(searchTemp)) {
                showRecipe(i);
                state = true;
                break;
            }
            for (String j : i.getTags()) {
                if(j == null){
                    break;
                }
                if (j.equalsIgnoreCase(searchTemp)) {
                    showRecipe(i);
                    state = true;
                    break;

                }
            }
            for (String k : i.getIngredients()) {
                if (k.contains(searchTemp)) {
                    showRecipe(i);
                    state = true;
                    break;
                }
            }

        }
        if (state == false) {
            System.out.println("No recipe has been found");
        }

    }

    public static void rating(Recipe recipe) {

        int[] tempArray = recipe.getRating();
        System.out.println("Enter rating (1-5)");
        int rate = input.nextInt();
        tempArray[1]++;
        System.out.println(tempArray[1]);
        tempArray[0] = (tempArray[0] + rate) / tempArray[1];
        System.out.println(tempArray[0]);
        recipe.setRating(tempArray);

    }

    public static void showRecipe(Recipe recipe) {
        System.out.println("------------------------------------------------");
        System.out.println("Name : " + recipe.getName());
        System.out.println("Category : " + recipe.getCategory());
        System.out.println("Ingredients : ");
        for (String j : recipe.getIngredients()) {
            System.out.println(" - " + j);

        }
        System.out.println("Instructions : " + recipe.getInstructions());
        System.out.println("Serving Size : " + recipe.getServingSize());
        System.out.println("Tags : ");
        for (String k : recipe.getTags()) {
            System.out.print("[ " + k + " ]\t\n");
        }
        System.out.println("Rating : ");
        int[] rating = recipe.getRating();
        System.out.println(rating[0] + " stars");
    }
}



