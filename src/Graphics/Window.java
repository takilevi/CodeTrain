package Graphics;

import Game.Application;
import Game.MouseEventHandler;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Random;


//todo: itt most nem teljesen vágom, hogy a game-t el kell tárolni, vagy azt hogy kezeli...
public class Window extends JFrame {

    private Container container;
    private JPanel panel;

    public Window(){

        setTitle("CodeTrain");
        setSize(640,480);
        setLocationRelativeTo(null);
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        container = getContentPane();


    }

    public void addPanel(JPanel p){
        p.setBackground(Color.green);
        add(p);
    }

    public JPanel getJPanel(){
        return panel;
    }

}


