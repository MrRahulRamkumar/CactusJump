package core;

public class Animation 
{
	private long timer,before;
	private int whichFrame;
	
	public void refresh(int numberOfFrames,int speed)
	{
		timer += System.currentTimeMillis() - before;
		before = System.currentTimeMillis();


		if(timer > speed)
		{
			whichFrame++;
			timer = 0;

		}
		if(whichFrame == numberOfFrames)
		{
			whichFrame = 0;
			timer = 0;
		}
	}
	
	public int getFrame()
	{
		return whichFrame;
	}

}

