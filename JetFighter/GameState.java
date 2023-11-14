import java.awt.Graphics;
import java.util.Random;


public class GameState extends State
{
  private Player player1;
  private Player player2;

  private Random x;
  private Random y;

  private Asteroid[] temp;

  private HUD hud;

  public GameState(Game game)
  {
    super(game);
    player1 = new Player(game, 200, 415, 1);
    player2 = new Player(game, 400, 415, 2);

    x = new Random();
    y = new Random();
    int k = 0;
    int j = 0;

    temp = new Asteroid[55];
    for(int i = 0; i < temp.length; i++)
    {
      k = x.nextInt(620);
      j = y.nextInt(260);
      temp[i] = new Asteroid((float)k, (float)j, 10, 10, player1, player2);
    }

    hud = new HUD();
  }

  @Override
  public void tick()
  {
    player1.tick();
    player2.tick();
    for(int t = 0; t < temp.length; t++){ temp[t].tick(); }
    hud.tick();

  }

  @Override
  public void render(Graphics g)
  {
    player1.render(g);
    player2.render(g);
    for(int b = 0; b < temp.length; b++){ temp[b].render(g); }
    hud.render(g);
  }
}
