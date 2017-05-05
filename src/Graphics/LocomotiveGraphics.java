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
public class LocomotiveGraphics implements Drawable  {

    private BufferedImage image;
    private int x;
    private int y;

    public LocomotiveGraphics(int x, int y){
        this.x = x ;
        this.y = y ;
        try {
            image = ImageIO.read(new File("Resources/img_map/mozdony.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void Draw(Graphics g) {
        System.out.println("vonatotrajzoltam");
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
