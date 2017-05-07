package Graphics;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by vassm on 2017. 05. 01..
 */
public class RailroadSwitchGraphics implements Drawable  {


    private ArrayList<BufferedImage> images;
    private int dir;
    private int x;
    private int y;

    public RailroadSwitchGraphics(String type, int x, int y){
        this.x = x;
        this.y = y;
        dir = 0;
        try {
            //image = ImageIO.read(new File("Resources/img_map/"+type));
            images = new ArrayList<>();
            images.add(ImageIO.read(new File("Resources/img_map/"+type)));
            String [] spec = type.split("_");
            if(spec[1].equals("2ag")){
                if(spec[2].equals("1")){
                    images.add(ImageIO.read(new File("Resources/img_map/"+spec[0]+"_"+spec[1]+"_"+"2"+"_"+spec[3])));
                }
                else{
                    images.add(ImageIO.read(new File("Resources/img_map/"+spec[0]+"_"+spec[1]+"_"+"1"+"_"+spec[3])));
                }
            }
            else if(spec[1].equals("3ag")){
                if(spec[2].equals("1")){
                    images.add(ImageIO.read(new File("Resources/img_map/"+spec[0]+"_"+spec[1]+"_"+"2"+"_"+spec[3])));
                    images.add(ImageIO.read(new File("Resources/img_map/"+spec[0]+"_"+spec[1]+"_"+"3"+"_"+spec[3])));
                }
                else if(spec[2].equals("2")){
                    images.add(ImageIO.read(new File("Resources/img_map/"+spec[0]+"_"+spec[1]+"_"+"1"+"_"+spec[3])));
                    images.add(ImageIO.read(new File("Resources/img_map/"+spec[0]+"_"+spec[1]+"_"+"3"+"_"+spec[3])));
                }
                else if(spec[2].equals("3")){
                    images.add(ImageIO.read(new File("Resources/img_map/"+spec[0]+"_"+spec[1]+"_"+"1"+"_"+spec[3])));
                    images.add(ImageIO.read(new File("Resources/img_map/"+spec[0]+"_"+spec[1]+"_"+"2"+"_"+spec[3])));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void setDirection(int direction){
        dir = direction;
    }

    @Override
    public void Draw(Graphics g) {
        g.drawImage(images.get(dir), x, y, null);
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