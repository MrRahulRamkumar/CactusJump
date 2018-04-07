package entities;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.Random;

import core.Game;
import util.ImageLoader;

public class Background
{

    //images
    private BufferedImage background = ImageLoader.loadImage("b.png");
    private BufferedImage cloud = ImageLoader.loadImage("singleCloud.png");

    //cloud related (width = 80, height = 64)
    public static int moveSpeed = 1,x1 = 30,x2 = x1+350,y1 = 30,y2 = 40; 

    //Randomiser
    private static Random ran = new Random();

    public void render(Graphics g)
    { 
        g.drawImage(background, 0, 0,Game.WIDTH,Game.HEIGHT, null);

        g.drawImage(cloud, x1, y1,80,70, null);
        g.drawImage(cloud, x2, y2,80,70, null);

    }
    public void refresh()
    {
        if(x1 + 80 >= 0)
        {
            x1 = x1 - moveSpeed;
        }
        else
        {
            x1 = Game.WIDTH;
            y1 = ran.nextInt(50)+100;			
        }

        if(x2 + 80 >= 0)
        {
            x2 = x2 - moveSpeed;
        }
        else
        {
            x2 = Game.WIDTH;
            y2 = ran.nextInt(50) + 100;
        }
    }
}

