package Graphics;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * Created by badrian on 2017.05.07..
 */
public class DepotGraphics implements Drawable {

    private BufferedImage image;
    private int x;
    private int y;

    public DepotGraphics(String type, int x, int y){
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

    public int getX(){
        return x;
    }
    public int getY(){
        return y;
    }

}
