

import java.awt.image.BufferedImage;


public class Assets
{
  public static BufferedImage player;

  public static void init()
  {
    SpriteSheet sheet = new SpriteSheet(ImageLoader.loadImage("/res/textures/Player.gif"));
    player = sheet.crop(0, 0, 24, 26);
  }
}
