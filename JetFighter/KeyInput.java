import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;


public class KeyInput implements KeyListener
{
  private boolean[] keys;
  protected boolean up, down, w, s;

  public KeyInput()
  {
    keys = new boolean[4];
    for(int i = 0; i < 4; i++){ keys[i] = false; }
  }

  public void tick()
  {
    up = keys[0];
    down = keys[1];
    w = keys[2];
    s = keys[3];
  }

  @Override
  public void keyPressed(KeyEvent e)
  {
    if(e.getKeyCode() == KeyEvent.VK_UP){ keys[0] = true; }
    if(e.getKeyCode() == KeyEvent.VK_DOWN){ keys[1] = true; }
    if(e.getKeyCode() == KeyEvent.VK_W){ keys[2] = true; }
    if(e.getKeyCode() == KeyEvent.VK_S){ keys[3] = true; }
  }

  @Override
  public void keyReleased(KeyEvent e)
  {
    if(e.getKeyCode() == KeyEvent.VK_UP){ keys[0] = false; }
    if(e.getKeyCode() == KeyEvent.VK_DOWN){ keys[1] = false; }
    if(e.getKeyCode() == KeyEvent.VK_W){ keys[2] = false; }
    if(e.getKeyCode() == KeyEvent.VK_S){ keys[3] = false; }
  }

  @Override
  public void keyTyped(KeyEvent e){;}
}
