

import javax.swing.JFrame;
import java.awt.Dimension;
import java.awt.Canvas;


public class Display
{
  private JFrame frame;
  private Canvas canvas;

  private String title;
  private int width, height;

  public Display(String t, int w, int h)
  {
    title = t;
    width = w;
    height = h;

    createDisplay();
  }

  private void createDisplay()
  {
    // The window will be a JFrame
    frame = new JFrame(title);

    // Set the size
    frame.setPreferredSize(new Dimension(width, height));
    frame.setMaximumSize(new Dimension(width, height));
    frame.setMinimumSize(new Dimension(width, height));

    // Make sure program stops on the closing of the JFrame
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    // Make sure frame cannot be resized
    frame.setResizable(false);

    // Frame starts in the center of the screen
    frame.setLocationRelativeTo(null);

    // Make sure it can be seen
    frame.setVisible(true);

    canvas = new Canvas();
    canvas.setPreferredSize(new Dimension(width, height));
    canvas.setMaximumSize(new Dimension(width, height));
    canvas.setMinimumSize(new Dimension(width, height));
    canvas.setFocusable(false);

    frame.add(canvas);
    frame.pack();
  }

  public Canvas getCanvas(){ return canvas; }
  public JFrame getFrame(){ return frame; }
}
