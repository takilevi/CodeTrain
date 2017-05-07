package Graphics;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by vassm on 2017. 05. 01..
 */
public class TunnelEntranceGraphics implements Drawable  {

    private ArrayList<BufferedImage> images;
    private int active;
    private int x;
    private int y;

    public TunnelEntranceGraphics(String type, int x, int y){
        this.x = x;
        this.y = y;
        active = 0;
        images = new ArrayList<>();
        try {

            images.add(ImageIO.read(new File("Resources/img_map/"+type)));
            if(type.contains("f")){
                images.add(ImageIO.read(new File("Resources/img_map/"+"tunnel_f_inact")));
            }
            else{
                images.add(ImageIO.read(new File("Resources/img_map/"+"tunnel_v_inact")));
            }


        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void Draw(Graphics g) {
        g.drawImage(images.get(active), x, y, null);
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