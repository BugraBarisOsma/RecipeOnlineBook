package org.example;

import java.util.Scanner;

public class ModifyInstructionCommand implements Modify{

    @Override
    public void modify(Recipe recipe) {
        Scanner input = new Scanner(System.in);
        String temp = recipe.getInstructions();
        System.out.println("This is current instructions:");
        System.out.println("-------------------------------");
        System.out.println(temp);
        System.out.println("-------------------------------");
        System.out.println("Please enter new instructions:");
        temp = input.nextLine();
        recipe.setInstructions(temp);

    }
}
