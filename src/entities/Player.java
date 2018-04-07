package entities;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

import core.Game;
import util.ImageLoader;

public class Player 
{
    public static int x = 30,y,moveSpeed = 5,jumpVel;
    public static boolean up,canJump,onGround;
    private final int DEFAULT_Y = 332;
    public int xVel,yVel,jump = 60;
    public static Rectangle playerRect = new Rectangle();

    //images
    private static BufferedImage p1_walk05 = ImageLoader.loadImage("p1_walk05.png");
    private static BufferedImage p1_walk06 = ImageLoader.loadImage("p1_walk06.png");
    private static BufferedImage p1_walk07 = ImageLoader.loadImage("p1_walk07.png");
    private static BufferedImage p1_walk08 = ImageLoader.loadImage("p1_walk08.png");
    private static BufferedImage p1_jump = ImageLoader.loadImage("p1_jump.png");
    private static BufferedImage p1_hurt = ImageLoader.loadImage("p1_hurt.png");
    private static BufferedImage over = ImageLoader.loadImage("giphy.png");

    //

    public Player()
    {
        y=DEFAULT_Y;
    }

    public void render(Graphics g,int whichFrame,boolean dead)
    {		
        playerRect.setBounds(x, y, 70,70);
        if(onGround == true && dead == false)
        {
            if(whichFrame == 0)
            {
                g.drawImage(p1_walk05, x, y,null);
            }
            if(whichFrame == 1)
            {
                g.drawImage(p1_walk06, x, y,null);
                
            }
            if(whichFrame == 2)
            {
                g.drawImage(p1_walk07, x, y,null);
            }
            if(whichFrame == 3)
            {
                g.drawImage(p1_walk08, x, y,null);
            }
            if(whichFrame == 4)
            {
                g.drawImage(p1_walk06, x, y,null);
            }
        }
        else if(onGround == false)
        {
            g.drawImage(p1_jump, x, y,null);
        }
        else if(dead == true)				
        {
            g.drawImage(p1_hurt,x,y,null);
            g.drawImage(over,90,100,null);

        }

    }
    public void refresh()
    {
        isSupported();

        if(Game.dead == false)
        {
            if(onGround == false)
            {
                applyGravity();
            }

            if(up && canJump == true)
            {
                yVel = yVel-jump;

            }
            y = y + yVel; 
        }
 
    }
    private void applyGravity()
    {
        if(yVel<5)
        {
            yVel = yVel+10;
        }
    }

    private void isSupported()
    {
        if(y == DEFAULT_Y)
        {
            yVel = 0;
            canJump = true;
            onGround = true;
        }
        else
        {
            canJump = false;
            onGround = false;
        }

    }

}

