import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class MyWorld extends World
{

    public MyWorld()
    {    
        super(600, 400, 1); 
        
        Crocodile c = new Crocodile();
        addObject(c, 200, 300);
    }
}
