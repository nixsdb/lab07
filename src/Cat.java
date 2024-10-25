/*
 * Created on 2024-10-16 
 *
 * Copyright (c) 2024 Nadine von Frankenberg
 */

// NO NEED TO TOUCH THIS FILE

public class Cat {
    private String name;
    private int age;
    private String sound;
    private String funnyStory = "n/a";

    private Owner owner;
    private boolean isAdoptable = true; // default value

    // Constructors
    public Cat(String name, int age, String sound) {
        this.name = name;
        this.age = age;
        this.sound = sound;
    }

    public Cat(String name, int age, String sound, Owner owner) {
        this.name = name;
        this.age = age;
        this.sound = sound;

        if (owner != null) {
            this.owner = owner;
            this.isAdoptable = false;
        }
    }

    // Getters & Setters
    public String getName() {
        return this.name;
    }

    public int getAge() {
        return this.age;
    }

    public String getSound() {
        return this.sound;
    }

    public Owner getOwner() {
        return this.owner;
    }

    public String getFunnyStory() {
        return this.funnyStory;
    }

    public boolean isAdoptable() {
        return this.isAdoptable;
    }

    public void setFunnyStory(String funnyStory) {
        this.funnyStory = funnyStory;
    }

    public void setOwner(Owner owner) {
        if (this.isAdoptable) {
            this.owner = owner;
            this.isAdoptable = false;
        } else {
            System.out.println(this.name + " is not adoptable, its owner is " + this.owner.getName() + ".");
        }
    }

    // Behavior
    public void meow() {
        System.out.println(this.name + " says: " + this.sound + "!");
    }

    public void printFunnyStory() {
        System.out.println("Here is a funny story about " + this.name + ": \n" + this.funnyStory);

    }

    @Override
    public String toString() {
        return "Cat {name=" + name + ", age=" + age + ", owner="
                + owner.getName() + ", isAdoptable=" + isAdoptable + "}";
    }
}
