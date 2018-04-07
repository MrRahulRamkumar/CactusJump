package core;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.io.IOException;

public class HudCounter
{
	private long timer,before;
	private int numberToDisplay;
	public String currentScore;
	private Font font;
	public String hScore;

	public HudCounter(Game game) throws IOException
	{
		hScore = game.highScore.getScore();
		font = new Font("",Font.BOLD, 25);
	}
	public void refresh()
	{
		timer += System.currentTimeMillis() - before;
		before = System.currentTimeMillis();


		if(timer > 500)
		{
			numberToDisplay++;
			timer = 0;
		}
		currentScore = Integer.toString(numberToDisplay);

	}
	public void render(Graphics g)
	{
		Game.gameFrame.setTitle("Score: " + numberToDisplay );

		g.setColor(Color.PINK);
		g.setFont(font); 


		if(currentScore != null)
			g.drawString(currentScore,530,50);

		if(hScore != null)
			g.drawString("HI: " + hScore,490,25);
				
	}
	
}


