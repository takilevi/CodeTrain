package Game;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.IOException;
import Graphics.View;

/**
 * Created by vassm on 2017. 05. 01..
 */
public class MouseEventHandler implements MouseListener {

    private View view;
    private Controller controller;

    public MouseEventHandler(View v, Controller c){
        view = v;
        controller = c;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        Point p = e.getPoint();
        controller.addCommand(view.getClicked(p));
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
