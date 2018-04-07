package states;

import java.awt.Graphics;
import core.Game;

public abstract class State 
{
	public abstract void render(Graphics g,Game game);
	public abstract void refresh(Game game);
}
