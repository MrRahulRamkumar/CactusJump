package entities;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.util.Random;

import core.Game;
import util.ImageLoader;

public class Obstacles
{
    private int x = Game.WIDTH,obstacleRandomiser,moveSpeed = 8,flyx = Game.WIDTH,
    gap = 300;

    //images
    private static BufferedImage cactus = ImageLoader.loadImage("c.png");
    private static BufferedImage fly1 = ImageLoader.loadImage("fly1.png");
    private static BufferedImage fly2 = ImageLoader.loadImage("fly2.png");

    //Randomiser
    private static Random ran = new Random();

    //Collision
    private Rectangle singleCactusRect = new Rectangle();
    private Rectangle doubleCactusRect = new Rectangle();
    private Rectangle tripleCactusRect = new Rectangle();
    private Rectangle flyRect = new Rectangle();

    public boolean checkCollision()
    {
        if(obstacleRandomiser == 1)
        {
            if(Player.playerRect.intersects(singleCactusRect) == true)
            {
                return true;

            }

        }
        if(obstacleRandomiser == 2)
        {
            if(Player.playerRect.intersects(doubleCactusRect) == true)
            {
                return true;

            }

        }
        if(obstacleRandomiser == 3)
        {
            if(Player.playerRect.intersects(tripleCactusRect) == true)
            {
                return true;

            }

        }
        if(obstacleRandomiser == 4)
        {
            if(Player.playerRect.intersects(flyRect) == true)
            {
                return true;

            }

        }
        if(obstacleRandomiser == 5)
        {
            if(Player.playerRect.intersects(singleCactusRect) == true || Player.playerRect.intersects(doubleCactusRect) == true)
            {
                return true;

            }

        }
        if(obstacleRandomiser == 6)
        {
            if(Player.playerRect.intersects(singleCactusRect) == true || Player.playerRect.intersects(tripleCactusRect) == true)
            {
                return true;

            }
        }
        if(obstacleRandomiser == 7)
        {
            if(Player.playerRect.intersects(doubleCactusRect) == true || Player.playerRect.intersects(singleCactusRect) == true)
            {
                return true;

            }
        }
        if(obstacleRandomiser == 8)
        {
            if(Player.playerRect.intersects(doubleCactusRect) == true || Player.playerRect.intersects(tripleCactusRect) == true)
            {
                return true;

            }
        }
        if(obstacleRandomiser == 9)
        {
            if(Player.playerRect.intersects(tripleCactusRect) == true || Player.playerRect.intersects(singleCactusRect) == true)
            {
                return true;

            }
        }
        if(obstacleRandomiser == 10)
        {
            if(Player.playerRect.intersects(tripleCactusRect) == true || Player.playerRect.intersects(doubleCactusRect) == true)
            {
                return true;

            }
        }
        return false;

    }

    private void singleCactus(Graphics g,int gap)
    {
        g.drawImage(cactus,x+gap,350,null);

    }

    private void doubleCactus(Graphics g, int gap)
    {
        g.drawImage(cactus, x+gap,350,null);
        g.drawImage(cactus, x+40+gap,350,null);

    }

    private void tripleCactus(Graphics g,int gap)
    {
        g.drawImage(cactus, x+40+gap,350,null);
        g.drawImage(cactus, x+80+gap,350,null);
        g.drawImage(cactus, x+120+gap,350,null);

    }

    public void render(Graphics g,int whichFrame)
    {
        if(obstacleRandomiser == 1)//single cactus
        {
            singleCactus(g,gap);

        }
        if(obstacleRandomiser == 2)// double cacti 
        {
            doubleCactus(g,gap);

        }
        if(obstacleRandomiser == 3) //triple cactus
        {			
            tripleCactus(g,gap);

        }

        if(obstacleRandomiser == 4)//fly
        {
            if(whichFrame == 0)
            {
                g.drawImage(fly1,flyx,350,null);
            }
            if(whichFrame == 1)
            {
                g.drawImage(fly2,flyx,350,null);
            }
        }

        if(obstacleRandomiser == 5)
        {
            singleCactus(g,0);
            doubleCactus(g,gap);

        }
        if(obstacleRandomiser == 6)
        {									
            singleCactus(g,0);
            tripleCactus(g,gap);
        }
        if(obstacleRandomiser == 7)
        {
            doubleCactus(g,0);
            singleCactus(g,gap);

        }

        if(obstacleRandomiser == 8)
        {
            doubleCactus(g,0);
            tripleCactus(g,gap);

        }
        if(obstacleRandomiser == 9)
        {
            tripleCactus(g,0);
            singleCactus(g,gap);

        }
        if(obstacleRandomiser == 10)
        {
            tripleCactus(g,0);
            doubleCactus(g,gap);

        }

    }

    public void refresh()
    {
        if(x + 130 + gap >= 0 || flyx + 30 >= 0)
        {
            x = x - moveSpeed;
            flyx = flyx - 15;
        }
        else 
        {
            x = Game.WIDTH;
            flyx = Game.WIDTH;
            obstacleRandomiser = ran.nextInt(10)+1;

        }

        if(obstacleRandomiser >= 5 && obstacleRandomiser <=6)
        {
            gap = 300;
            singleCactusRect.setBounds(x+20,350+40,70,70);
            doubleCactusRect.setBounds(x+20+gap,350+40,70,70);
            tripleCactusRect.setBounds(x+50+gap,350+10,70,70);

        }
        else if(obstacleRandomiser >= 7 && obstacleRandomiser <=8)
        {
            gap = 300;
            doubleCactusRect.setBounds(x+20,350+40,70,70);
            singleCactusRect.setBounds(x+20+gap,350+40,70,70);
            tripleCactusRect.setBounds(x+50+gap,350+10,70,70);
        }
        else if(obstacleRandomiser >= 9 && obstacleRandomiser <=10)
        {
            gap = 300;
            doubleCactusRect.setBounds(x+20+gap,350+40,70,70);
            singleCactusRect.setBounds(x+20+gap,350+40,70,70);
            tripleCactusRect.setBounds(x+50,350+10,70,70);
        }
        else
        {
            gap = 0;
            singleCactusRect.setBounds(x+20,350+40,70,70);
            doubleCactusRect.setBounds(x+20,350+40,70,70);
            tripleCactusRect.setBounds(x+50,350+10,70,70);
        }

        flyRect.setBounds(flyx+20,350,72,36);

    }

}
