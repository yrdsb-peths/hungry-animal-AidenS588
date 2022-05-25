import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Crocodile extends Actor
{
    /**
     * The Crocodile
     * Act - do whatever the Crocodile wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    
    GreenfootSound crocSound = new GreenfootSound("aud_chomp.mp3");
    GreenfootImage[] idleRight = new GreenfootImage[6];
    GreenfootImage[] idleLeft = new GreenfootImage[6];
    
    // Direction
    String facing = "right";
    SimpleTimer animationTimer = new SimpleTimer();
    
    /**
     * Constructor - code runs once
     */
    public Crocodile()
    {
        for(int i = 0; i < idleRight.length; i++)
        {
            idleRight[i] = new GreenfootImage("images/CrocIdle/idle" + i + ".png");
            idleRight[i].scale(100, 50);
        }
        
        for(int i = 0; i < idleLeft.length; i++)
        {
            idleLeft[i] = new GreenfootImage("images/CrocIdle/idle" + i + ".png");
            idleLeft[i].mirrorHorizontally();
            idleLeft[i].scale(100, 50);
        }
        
        animationTimer.mark();
        
        setImage(idleRight[0]);
        
        
    }
    /*
     * Animate the Crocodile
     */
    int imageIndex = 0;
    public void animateCroc()
    {
        if(animationTimer.millisElapsed() < 50)
        {
            return;
        }
        animationTimer.mark();
        
        if(facing.equals("right"))
        {
            setImage(idleRight[imageIndex]);
            imageIndex = (imageIndex + 1) % idleRight.length;
        }
        else
        {
            setImage(idleLeft[imageIndex]);
            imageIndex = (imageIndex + 1) % idleLeft.length;
        }
    }
    
    
    public void act()
    {
        setLocation(getX(), getY());
        // Allows crocodile to move, dependent on the key
        if (Greenfoot.isKeyDown("right"))
        {
            move(4);
            facing = "right";
        }
        else if(Greenfoot.isKeyDown("left"))
        {
            move(-4);
            facing = "left";
        }
        eat();
        // animate croc
        animateCroc();
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
            crocSound.play();
        }
    }
}
