import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Title Screen
 * 
 * @author Aiden
 * @version (May 25th, 2022)
 */
public class TitleScreen extends World
{
    Label titleLabel = new Label("Crocodile(Space to Start)", 60);
    /**
     * Constructor for objects of class TitleScreen.
     * 
     */
    public TitleScreen()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1); 

        addObject(titleLabel, getWidth()/2, 200);
        prepare();
    }

    /**
     * main world loop
     */

    public void act()
    {
        // Start game after users press space
        if(Greenfoot.isKeyDown("space"))
        {
            MyWorld gameWorld = new MyWorld();
            Greenfoot.setWorld(gameWorld);
        }
    }
    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */
    private void prepare()
    {
        Crocodile crocodile = new Crocodile();
        addObject(crocodile,513,97);
        crocodile.setLocation(450,27);
    }
}
