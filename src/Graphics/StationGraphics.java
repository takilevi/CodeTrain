package Graphics;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * Created by vassm on 2017. 05. 01..
 */
public class StationGraphics implements Drawable  {

    private BufferedImage image;
    private boolean passengers;
    private int x;
    private int y;

    public StationGraphics(String type, int x, int y){
        passengers = false;
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


        g.drawImage(image, x, y, null);

        if(passengers){
            g.setColor(Color.YELLOW);
            g.fillOval(x+25,y+15,10,10);
        }
    }

    @Override
    public int getX() {
        return x;
    }

    @Override
    public int getY() {
        return y;
    }

    public void setPassengers(boolean p){
        passengers = p;
    }

}