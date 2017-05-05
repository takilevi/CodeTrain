package Graphics;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * Created by vassm on 2017. 05. 01..
 */
public class StationGraphics implements Drawable  {

    private BufferedImage image;
    private int x;
    private int y;

    public StationGraphics(String type, int x, int y){
        this.x = x;
        this.y = y;
        try {
            image = ImageIO.read(new File("Resources/img_map/"+type));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //Todo itt ha a kört kikomentezitek látszik hogy hova kell kattintani
    @Override
    public void Draw(Graphics g) {
        //g.drawOval(x, y, 50, 50);
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