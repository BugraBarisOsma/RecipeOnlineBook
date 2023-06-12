package org.example;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class ModifyIngredientCommand implements Modify {

    @Override
    public void modify(Recipe recipe) {
        Scanner input = new Scanner(System.in);
        ArrayList<String> temp = recipe.getIngredients();
        System.out.println("These are current ingredients");
        System.out.println("-----------------------------");
        Iterator<String> iterator = temp.iterator();
        while (iterator.hasNext()) {
            String i = iterator.next();
            System.out.println(" - " + i);
            iterator.remove();
        }

        for (int i = 0; i < 3; i++) {

            temp.add(i, null);
        }
        int count = 1;
        ArrayList<String> newIngredients = new ArrayList<>();
        for (String i : temp) {
            System.out.println("Enter " + count + ". ingredient");
            newIngredients.add(input.nextLine());
            count++;
        }
        for (int i = 0; i < temp.size(); i++) {
            temp.set(i, newIngredients.get(i));
        }


        recipe.setIngredients(temp);


    }
}
