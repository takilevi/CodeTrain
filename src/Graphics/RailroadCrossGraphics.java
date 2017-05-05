package Graphics;

import Game.RailroadCross;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * Created by András on 2017.05.03..
 */
public class RailroadCrossGraphics implements Drawable {

    private BufferedImage image;
    private int x;
    private int y;

    public RailroadCrossGraphics(String type, int x, int y){
        this.x = x;
        this.y = y;
        try {
            image = ImageIO.read(new File("Resources/img_map/"+type));
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    @Override
    public void Draw(Graphics g) {
        g.drawImage(image, x, y, null);
    }

    @Override
    public int getX() {
        return x;
    }

    @Override
    public int getY() {
        return y;
    }


}
