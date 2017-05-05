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
public class TrackGraphics implements Drawable {

    private BufferedImage image;
    private int x;
    private int y;

    public TrackGraphics(String type, int x, int y){
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
    }

    public int getX(){
        return x;
    }
    public int getY(){
        return y;
    }


}