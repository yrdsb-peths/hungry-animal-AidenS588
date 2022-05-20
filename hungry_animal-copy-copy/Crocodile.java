import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Crocodile extends Actor
{
    /**
     * The Crocodile
     * Act - do whatever the Crocodile wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        setLocation(getX(), getY() + 1);
        // Allows crocodile to move, dependent on the key
        if (Greenfoot.isKeyDown("right"))
        {
            turn(4);
        }
        else if(Greenfoot.isKeyDown("left"))
        {
            turn(-4);
        }
        else if(Greenfoot.isKeyDown("up"))
        {
            move(4);
        }
        else if(Greenfoot.isKeyDown("down"))
        {
            move(-4);
        }
        eat();
    }
    public void eat()
    {
        // Remove fish if crocodile eats it
        if(isTouching(Fish.class))
        {
            removeTouching(Fish.class);
            MyWorld world = (MyWorld) getWorld();
            world.createFish();
            world.increaseScore();
        }
    }
}
