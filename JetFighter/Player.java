import java.awt.Graphics;
import java.awt.Rectangle;


public class Player
{
  public static final float DEFAULT_SPEED = 3.0f;
  public static final int DEFAULT_CREATURE_WIDTH = 24;
  public static final int DEFAULT_CREATURE_HEIGHT = 26;

  protected float x, y;
  protected float xVel, yVel;
  protected int width, height;
  protected float speed;

  private Game game;
  private int id;

  public Player(Game game, float x, float y, int id)
  {
    this.x = x;
    this.y = y;
    this.game = game;
    width = DEFAULT_CREATURE_WIDTH;
    height = DEFAULT_CREATURE_HEIGHT;
    this.id = id;
    speed = DEFAULT_SPEED;
    xVel = 0;
    yVel = 0;
  }

  public Rectangle getBounds()
  {
    return new Rectangle((int)x, (int)y, width, height);
  }

  public void tick()
  {
    getInput();
    move();
    if(y >= 415){ y = 415; }
    if(y < 0)
    {
      y = 415;
      if(id == 1){ HUD.score1++; }
      if(id == 2){ HUD.score2++; }
    }
  }

  public void render(Graphics g)
  {
    g.drawImage(Assets.player, (int)x, (int)y, width, height, null);
  }

  private void getInput()
  {
    xVel = 0;
    yVel = 0;
    if(id == 1)
    {
      if(game.getKeyInput().w){ yVel = -speed; }
      if(game.getKeyInput().s){ yVel = speed; }
    }

    if(id == 2)
    {
      if(game.getKeyInput().up){ yVel = -speed; }
      if(game.getKeyInput().down){ yVel = speed; }
    }
  }

  public void move()
  {
    x += xVel;
    y += yVel;
  }

  // GETTERS/SETTERS
  public float getX(){ return x; }
  public float getY(){ return y; }
  public float getXVel(){ return xVel; }
  public float getYVel(){ return yVel; }
  public float getSpeed(){ return speed; }
  public int getWidth(){ return width; }
  public int getHeight(){ return height; }

  public void setX(float x){ this.x = x; }
  public void setY(float y){ this.y = y; }
  public void setXVel(float xVel){ this.xVel = xVel; }
  public void setYVel(float yVel){ this.yVel = yVel; }
  public void setSpeed(float speed){ this.speed = speed; }
  public void setWidth(int width){ this.width = width; }
  public void setHeight(int height){ this.height = height; }
}
