import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class MyWorld extends World
{
    public int score = 0;
    Label scoreLabel;
    
    public MyWorld()
    {    
        super(600, 400, 1, false); 
        // Create Crocodile
        Crocodile croc = new Crocodile();
        addObject(croc, 200, 300);
        
        //Create Label
        scoreLabel = new Label(0, 80);
        addObject(scoreLabel, 50, 50);
        
        //Create Fish
        createFish();
    }
    
    /**
     *  End game 
     */
    public void gameOver()
    {
        Label gameOverLabel = new Label("Game Over", 100);
        addObject(gameOverLabel, 300, 200);
    }
    
    /**
     * Increase score of fish eaten
     */
    public void increaseScore()
    {
        score++;
        scoreLabel.setValue(score);
    }
    
    
    /**
     * Create fish at random locations
     */
    public void createFish()
    {
        Fish fish = new Fish(); 
        int x = Greenfoot.getRandomNumber(600);
        int y = 0;
        addObject(fish, x, y);
    }
}
