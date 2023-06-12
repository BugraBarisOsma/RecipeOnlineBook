package org.example;

public class TagManager {

    private static TagManager tagManager = new TagManager();

    private TagManager() {

    }

    public static TagManager getTagManager() {
        return tagManager;
    }

    public String getTag(String tag) {
        String temp = "";
        if (tag.equalsIgnoreCase("1")) {
            temp = "Vegan";
        } else if (tag.equalsIgnoreCase("2")) {
            temp = "Spicy";
        } else if (tag.equalsIgnoreCase("3")) {
            temp = "Gluten-free";
        }

        return temp;
    }

}
