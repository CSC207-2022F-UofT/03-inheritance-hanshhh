/*
 * This file defines an abstract class named Bag.
 * In this exercise, you will be writing a larger class according to
 * the TODOs we have left you. You may find the readings in chapter
 * 1. Introduction to Java helpful.
 */

public abstract class Bag {
    /*
     * TODO: Create the following private instance variables
     *       - a String named color
     *       - an int named numberOfContents
     *       - an int named capacity
     *       - an array of Strings named contents
     */
    private String color;
    private int numberOfContents;
    private int capacity;
    private String[] contents;




    /*
     * TODO: Create a constructor that takes two arguments:
     *       - a String representing the Bag's colour
     *       - an int representing the Bag's capacity
     *
     * The other attributes (private instance variables) should
     * be empty (e.g. numberOfContents is 0 and an empty String array for
     * its contents.)
     */

    /**
     * Creates a new Bag Object.
     * This constructor takes color and capacity as arguments.
     *
     * @param color the String variable of the Bag instance's color
     * @param capacity an integer variable representing the Bag instance's capacity.
     */
    Bag(String color, int capacity){
        this.color = color;
        this.capacity = capacity;
        this.numberOfContents = 0;
        this.contents = new String[5];
    }




    /*
     * TODO: Create a variety of 'getter' functions.
     *       These should be named:
     *           - getColor
     *           - getNumberOfContents
     *           - getCapacity
     */

    /**
     * return the Bag instance variable color.
     *
     * @return a string representing the color of the Bag instance.
     */
    public String getColor() {
        return this.color;
    }

    /**
     * return the Bag instance variable numberofcontents
     *
     * @return an integer that represents the current amounts of items inside the Bag instance.
     */
    public int getNumberOfContents() {
        return this.numberOfContents;
    }

    /**
     * return the Bag instance variable capacity
     *
     * @return an integer that represents the current carrying capacity of the Bag instance.
     */
    public int getCapacity() {
        return this.capacity;
    }
    /*
     * TODO: Create a setter function called setColor which sets the
     *       color of this bag to the given color.
     */

    /**
     * set the Bag instance variable color to the color specified as parameter below
     *
     * @param color a String that represents the color you want the Bag instance to be
     * @return
     */
    public void setColor(String color) {
        this.color = color;
    }
    /*
     * TODO: Create a method called addItem that takes in a String
     *       representing an item in the Bag.
     *       The item is added into the Bag if the number of items
     *       in the bag is < the capacity of the Bag.
     *       Remember to modify numberOfContents accordingly.
     *
     *       This method should return true if the item was added
     *       and false otherwise.
     */

    /**
     * Takes in a String representing an item in the Bag. The item will be added into the
     * Bag instance if the number of items in the bag is <  the capacity of the Bag and
     * update the capacity of the Bag accordingly.
     *
     * Return whether the item has been successfully added.
     *
     * @param item a String that represents the item to be added to the contents which is an array of strings
     * @return a boolean value that represents whether the item has successfully been added.
     */
    public boolean addItem(String item){
        if (this.numberOfContents < this.capacity){
            this.contents[numberOfContents] = item;
            this.numberOfContents += 1;
            if (this.capacity == this.numberOfContents) {
                this.increaseCapacity(5);
                String[] new_contents = new String[capacity];
                for (int i = 0; i < numberOfContents; i++) {
                    new_contents[i] = contents[i];
                }
                this.contents = new_contents;
            }
            return true;
        } else {
            this.increaseCapacity(1);
            return false;
        }


    }





    /**
     * TODO: Create a method called popItem that returns a String.
     *       The string should be the last item added to this Bag
     *       and the item should be removed from this Bag.
     *       Remember to modify numberOfContents accordingly.
     *
     * This method move the string item that's most recently added to this Bag instance, and the item will be removed
     * from the Bag.
     * If there are no items in this Bag, return null.
     *
     * @return a string which is the last item added to the bag instance.
     */

    public String popItem(){
        if (numberOfContents == 0){
            return null;
        }
        else {
            String item = contents[numberOfContents - 1];
            contents[numberOfContents - 1] = null;
            numberOfContents -= 1;
            return item;
        }
    }





    /**
     * Increase this bag's capacity by n.
     *
     * @param n the amount to increase this Bag's capacity by
     */
    public void increaseCapacity(int n) {
        // TODO: Implement this method.
        this.capacity = this.capacity + n;

    }

    /**
     * Return the details of this Bag.
     * This method requires you to have created the private
     * instance variables mentioned above.
     *
     * @return a string representation of this Bag instance.
     */
    @Override
    public String toString() {
        return this.color + " Bag (" + this.numberOfContents + " / " +
                this.capacity + ")";
    }

    /*
     * Below we have defined an abstract method.
     * This method takes no arguments and does not return anything.
     * It increases the capacity of this Bag.
     *
     * You will need to implement this method in
     * HandBag.java and CrossbodyBag.java.
     *
     * We recommend you look at HandBag.java first.
     */
    public abstract void enhance();
}