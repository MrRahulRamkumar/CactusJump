package states;

import java.awt.Graphics;
import core.Game;

public class DeadState extends State
{
    public void render(Graphics g, Game game) 
    {
        game.background.render(g);
        game.player.render(g,game.playerAnimation.getFrame(),true);
        game.obstacles.render(g,game.obstacleAnimation.getFrame());
        game.hudCounter.render(g);
    }

    public void refresh(Game game)
    {
        game.player.refresh();
        if(Game.retry == true)
        {
            game.highScore.updateScore(game.hudCounter.currentScore,game.hudCounter.hScore);
            Game.dead = false;
            Game.retry = false;
            game.init();

        }
    }
}
