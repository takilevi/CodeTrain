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
public class RailroadCarGraphics implements Drawable  {

    private ArrayList<BufferedImage> images;
    private int color;
    private int x;
    private int y;

    public RailroadCarGraphics(String type, int x, int y){
        this.x = x;
        this.y = y;
        images = new ArrayList<>();
        try {
            if(type.contains("hcar")) {
                images.add(ImageIO.read(new File("Resources/img_map/" + type)));
                color = 0;
            }
            else{
                images.add(ImageIO.read(new File("Resources/img_map/" + "pcar_ures.png")));
                images.add(ImageIO.read(new File("Resources/img_map/" + "pcar_piros.png")));
                images.add(ImageIO.read(new File("Resources/img_map/" + "pcar_kek.png")));
                images.add(ImageIO.read(new File("Resources/img_map/" + "pcar_zold.png")));
                if(type.contains("piros")){
                    color = 1;
                }
                else if(type.contains("kek")){
                    color = 2;
                }
                else if(type.contains("zold")){
                    color  = 3;
                }
                else{
                    color = 0;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void setColor(int i){
        if(images.size()<i){
            color = i;
        }

    }

    @Override
    public void Draw(Graphics g) {
        g.drawImage(images.get(color), x, y, null);
    }

    @Override
    public int getX() {
        return x;
    }

    @Override
    public int getY() {
        return y;
    }

    public void RefreshPosition(Point p){
        System.out.print("kocsi új koord");
        x = p.x;
        y = p.y;
    }

}