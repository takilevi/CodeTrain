package Graphics;

import Game.Application;
import Game.MouseEventHandler;

import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

//todo: itt most nem teljesen vágom, hogy a game-t el kell tárolni, vagy azt hogy kezeli...
public class Window extends JFrame {

    public Window()
    {
        setTitle("CodeTrain");
        setSize(640,480);
        setLocationRelativeTo(null);
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        addMouseListener(new MouseEventHandler()); //todo: nem tudom hogy iratkozikfel a rá a controller...
    }

    public static void main(String[] args) {

        new Window().setVisible(true);
        Application.main();
    }

}


