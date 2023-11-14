import java.awt.Graphics;
import java.awt.Color;
import java.awt.Rectangle;


public class Asteroid
{
  protected float x, y;
  protected float xVel;
  protected int width, height;
  protected Player player1, player2;

  public Asteroid(float x, float y, int width, int height, Player p1, Player p2)
  {
    this.x = x;
    this.y = y;
    xVel = 1.0f;
    this.width = width;
    this.height = height;
    player1 = p1;
    player2 = p2;
  }

  public Rectangle getBounds()
  {
    return new Rectangle((int)x, (int)y, width, height);
  }

  public void tick()
  {
    if(x >= 620){ x = 0; }
    x += xVel;
    collision();
  }

  public void render(Graphics g)
  {
    g.setColor(Color.WHITE);
    g.fillRect((int)x, (int)y, width, height);
  }

  public void collision()
  {
    if(getBounds().intersects(player1.getBounds()))
    {
      player1.setY(415);
    }

    if(getBounds().intersects(player2.getBounds()))
    {
      player2.setY(415);
    }
  }
}
