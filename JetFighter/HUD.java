import java.awt.Graphics;
import java.awt.Color;
import java.awt.Font;


public class HUD
{
  protected static int score1;
  protected static int score2;

  public HUD()
  {
    score1 = 0;
    score2 = 0;
  }

  public void tick()
  {
    if(score1 == 7 || score2 == 7){ System.exit(1); }
  }

  public void render(Graphics g)
  {
    Font f = new Font("Serif", Font.PLAIN, 40);
    g.setColor(Color.WHITE);
    g.drawLine(300, 460, 300, 340);

    g.setFont(f);
    g.drawString("" + score1, 140, 30);
    g.drawString("" + score2, 457, 30);
  }
}
