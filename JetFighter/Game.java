import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;


public class Game implements Runnable
{
  private Display display;
  private Thread thread;
  private boolean running = false;

  private State gameState;

  private KeyInput keyInput;

  public int width, height;
  public String title;

  public Game(String title, int width, int height)
  {
    this.width = width;
    this.height = height;
    this.title = title;
    keyInput = new KeyInput();
  }

  public void init()
  {
    display = new Display(title, width, height);
    display.getFrame().addKeyListener(keyInput);
    Assets.init();


    gameState = new GameState(this);
    State.setState(gameState);
  }

  private void tick()
  {
    keyInput.tick();
    if(State.getState() == gameState)
    {
      State.getState().tick();
    }
  }

  private void render()
  {
    BufferStrategy bs = display.getCanvas().getBufferStrategy();
    if(bs == null)
    {
      display.getCanvas().createBufferStrategy(3);
      return;
    }

    Graphics g = bs.getDrawGraphics();
    g.setColor(Color.BLACK);
    g.fillRect(0, 0, width, height);

    if(State.getState() == gameState)
    {
      State.getState().render(g);
    }

    g.dispose();
    bs.show();
  }

@SuppressWarnings("unused")
public void run()
  {
    init();
    long lastTime = System.nanoTime();
    double fps = 60.0;
    double nanoSeconds = 1000000000 / fps;
    double delta = 0;
    long timer = 0;
    int frames = 0;
    while(running == true)
    {
      long now = System.nanoTime();
      delta += (now - lastTime)/nanoSeconds;
      timer += now - lastTime;
      lastTime = now;
      if(delta >= 1)
      {
        tick();
        render();
        frames++;
        delta--;
      }

      if(timer >= 1000000000)
      {
        //System.out.println("Frames: " + frames);
        frames = 0;
        timer = 0;
      }
    }
    stop();
  }

  public KeyInput getKeyInput(){ return keyInput; }

  public synchronized void start()
  {
    thread = new Thread(this);
    thread.start();
    running = true;
  }

  public synchronized void stop()
  {
    try{
      thread.join();
    }
    catch(Exception e){
      e.printStackTrace();
    }
    running = false;
  }

  public static void main(String[] args)
  {
    Game game = new Game("JetFighter", 640, 480);
    game.start();
  }
}
