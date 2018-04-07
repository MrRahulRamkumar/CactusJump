package core;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;

import entities.Player;

public class InputHandler implements KeyListener
{

	public InputHandler(JFrame frame)
	{
		frame.addKeyListener(this);
	}

	@SuppressWarnings("static-access")
	@Override
	public void keyPressed(KeyEvent e)
	{ 
		int keyCode = e.getKeyCode();

		//jump
		if(keyCode == e.VK_SPACE)
		{
			Player.up = true;
		}
		
		//retry
		if(keyCode == e.VK_ENTER && Game.dead == true)
		{
			Game.retry = true;
			
		}
			
	}
	//jump
	@SuppressWarnings("static-access")
	@Override
	public void keyReleased(KeyEvent e)
	{
		int keyCode = e.getKeyCode();

		if(keyCode == e.VK_SPACE)
		{
			Player.up = false;
		}
	}

	@Override
	public void keyTyped(KeyEvent e)
	{


	}
	
}



