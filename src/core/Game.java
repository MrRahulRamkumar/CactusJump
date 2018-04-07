package core;

import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.io.IOException;

import javax.swing.JFrame;

import util.HighScore;

import states.DeadState;
import states.GameState;
import states.State;
import entities.Background;
import entities.Obstacles;
import entities.Player;

@SuppressWarnings("serial")
public class Game extends Canvas implements Runnable {
    // class references

    public Player player;
    public HighScore highScore;
    public Obstacles obstacles;
    public Background background;
    public Animation playerAnimation;
    public Animation obstacleAnimation;
    public HudCounter hudCounter;
    public InputHandler ih;

    //states
    private State gameState = new GameState();
    private State deadState = new DeadState();
    private State currentState = new GameState();

    //window
    public static JFrame gameFrame;
    public final static int WIDTH = 660, HEIGHT = 560;
    public final Dimension gameDim = new Dimension(WIDTH, HEIGHT);
    public final static String gameTitle = "Game";

    //game
    public static boolean running = false, retry = false, dead = false;
    public Thread gameThread;

    private final int FPS = 60;
    private final double TIME_PER_REFRESH = 1000000000 / FPS; //cuz refresh onece evry 1/60th of sec
    public static double delta = 0;
    long now, before;

    //test
    public Game() {
        createWindow();
        init();
        start();
    }

    private void setState() {
        if (dead == true) {
            currentState = deadState;
        } else if (dead == false) {
            currentState = gameState;
        }
    }

    private void createWindow() {
        gameFrame = new JFrame(gameTitle);
        gameFrame.setVisible(true);
        gameFrame.setSize(gameDim);
        gameFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        gameFrame.setLocationRelativeTo(null);
        gameFrame.setLayout(new BorderLayout());
        gameFrame.setResizable(false);

        //Referring to canvas
        super.setMaximumSize(gameDim);
        super.setMinimumSize(gameDim);
        super.setPreferredSize(gameDim);

        gameFrame.add(this, BorderLayout.CENTER);
        gameFrame.pack();

    }

    public void init() {
        ih = new InputHandler(gameFrame);
        player = new Player();
        obstacles = new Obstacles();
        background = new Background();
        playerAnimation = new Animation();
        obstacleAnimation = new Animation();
        highScore = new HighScore("highScore.txt");
        try {
            hudCounter = new HudCounter(this);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void run() {
        before = System.nanoTime();

        while (running == true) {
            now = System.nanoTime();
            delta = delta + (now - before) / TIME_PER_REFRESH;
            before = now;

            if (delta >= 1) {
                refresh();
                render();
                delta--;

            }
        }
        stop();
    }

    public synchronized void start() {
        running = true;
        gameThread = new Thread(this);
        gameThread.start();

    }

    @SuppressWarnings("deprecation")
    public synchronized void stop() {
        running = false;
        gameThread.stop();
        System.exit(0);
    }

    public void render() 
    {
        BufferStrategy bs = super.getBufferStrategy();

        if (bs == null)
        {
            super.createBufferStrategy(2);
            return;
        }

        Graphics g = bs.getDrawGraphics();

        //clearing screen
        g.clearRect(0, 0, WIDTH, HEIGHT);

        //rendering
        currentState.render(g, this);

        bs.show();
        g.dispose();

    }

    public void refresh() {
        currentState.refresh(this);
        setState();
    }

}
