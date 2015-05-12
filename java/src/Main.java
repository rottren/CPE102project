import processing.core.PApplet;
import processing.core.PImage;

import java.util.ArrayList;
import java.util.List;

import java.util.List;
import java.util.ArrayList;
import processing.core.*;

public class Main extends PApplet
{
    private List<PImage> imgs;
    private int current_image;
    private long next_time;

    private final int BGND_COLOR = color(550, 230, 245);
    private static final int ANIMATION_TIME = 100;
    private Grid[][] world = new Grid[15][20];
    private final static int HEIGHT = 20;
    private final static int WIDTH = 15;
    private PImage grass = loadImage("C:\\Users\\Luke\\cpe102\\experiment\\CPE102project\\images\\grass.bmp");
    private PImage rock = loadImage("C:\\Users\\Luke\\cpe102\\experiment\\CPE102project\\images\\rock.bmp"); // Need to make images relative so Nick and Luke can use them

    public enum Grid
    {
        BACKGROUND, OBSTACLE
    }

    public void tiles()
    {
        for (int h=0; h < world.length; h++)
        {
            for (int w=0; w < world[h].length; w++)
            {
                if (((h%8==1) && (w%3==0 || w%3==2 || h==1)) && !(h==1 && w==17))
                {
                    world[h][w] = Grid.OBSTACLE;
                }
                else
                {
                    world[h][w] = Grid.BACKGROUND;
                }
            }
        }
    }


    public void setup()
    {
        size(640, 480);
        background(BGND_COLOR);
        System.out.println(world.length);
        imgs = new ArrayList<PImage>();

        current_image = 0;
        next_time = System.currentTimeMillis() + ANIMATION_TIME;
        tiles();
        System.out.println(world.length);
        System.out.println(world[0].length);

    }

    public void keyPressed() {

    }


    private void next_image()
    {
        current_image = (current_image + 1) % imgs.size();
    }

    private void add_ents()
    {
        for (int h=0; h < world.length; h++)
        {
            for (int w=0; w < world[h].length; w++)
            {
                if (world[h][w] == Grid.OBSTACLE)
                {
                    image(rock, w*32, h*32);
                }
                else
                {
                    image(grass, w*32, h*32);
                }
            }
        }
    }

    public void draw()
    {
        add_ents();
        // A simplified action scheduling handler
        long time = System.currentTimeMillis();
        if (time >= next_time)
        {
            next_image();
            next_time = time + ANIMATION_TIME;
        }
    }

    public static void main(String[] args)
    {
        PApplet.main("Main");
    }
}
