/*
 * Created on 2024-10-16
 *
 * Copyright (c) 2024 Nadine von Frankenberg
 */

// NO NEED TO TOUCH THIS FILE

public class Owner {

    private String name;
    private Cat ownedCat;

    // Optional
    private static int numberOfOwners = 0;

    public Owner(String name) {
        this.name = name;
        numberOfOwners++;
    }

    public Owner(String name, Cat ownedCat) {
        this.name = name;
        this.ownedCat = ownedCat;
        numberOfOwners++;
    }

    // Getters & Setters
    public String getName() {
        return this.name;
    }

    public Cat getOwnedCat() {
        return this.ownedCat;
    }

    // Optional
    public static int getNumberOfOwners() {
        return numberOfOwners;
    }

    // Owner behavior
    public void adoptCat(Cat cat) {
        if (this.ownedCat == null && cat.isAdoptable()) {
            this.ownedCat = cat;
            cat.setOwner(this);
            System.out.println(name + " just adopted " + ownedCat.getName());
        } else if (cat.isAdoptable()) {
            System.out.println(name + " cannot adopt " + cat.getName() + ". " + name + " already owns a cat: "
                    + ownedCat.getName() + ".");
        } else {
            System.out.println(name + " cannot adopt " + cat.getName() + " because it is not adoptable. Its owner is "
                    + cat.getOwner().getName() + ".");
        }
    }
}
