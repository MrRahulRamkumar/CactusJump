package states;

import java.awt.Graphics;
import core.Game;

public class GameState extends State
{
    public void render(Graphics g,Game game)
    {

        Game.dead = game.obstacles.checkCollision();
        game.background.render(g);
        game.player.render(g,game.playerAnimation.getFrame(),false);//gets the frame to be rendered
        game.obstacles.render(g,game.obstacleAnimation.getFrame());
        game.hudCounter.render(g);
    }

    public void refresh(Game game)
    {
        game.background.refresh();
        game.obstacles.refresh();
        game.player.refresh();
        game.playerAnimation.refresh(5,45); //number of frames and time till a diff. 
        game.obstacleAnimation.refresh(2,200);//frame is rendered
        game.hudCounter.refresh();	
    }
}
