package Graphics;

import Game.Controller;
import Game.MouseEventHandler;
import Game.RailroadModel;
import Game.StaticElement;
import com.sun.media.jfxmediaimpl.platform.java.JavaPlatform;
import sun.java2d.d3d.D3DRenderQueue;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static java.lang.Math.abs;

/**
 * Created by vassm on 2017. 05. 01..
 */
public class View {

    protected List<Drawable> drawables = new ArrayList<Drawable>();

    private RailroadModel model;
    private Window window;
    private JPanel panel;
    MouseEventHandler listener;

    public View(RailroadModel m, Window w, Controller c) {
        window = w;
        model = m;
        Map<String, StaticElement> mapElements = model.getElementsInModel();

        for (String key: mapElements.keySet()) {
            addDrawable(mapElements.get(key).getGraphics());
        }

        panel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                if(drawables != null){
                    for(int i = 0; i< drawables.size(); i++){
                        drawables.get(i).Draw(g);
                    }
                }
            }
        };
        MouseEventHandler listener = new MouseEventHandler(this, c);
        panel.addMouseListener(listener);
        window.addPanel(panel);
        DrawAll();
    }

    public void addDrawable(Drawable item){
        drawables.add(item);

        //Ha valamit hozzáadtunk, rajzoljuk,
        DrawAll();
    }

    public void DrawAll() {
        panel.revalidate();
        panel.repaint();
    }


    public JPanel getPanel(){
      return panel;

    }

    public Drawable getClicked(Point p){

        Drawable bestMatch = null;
        int best = 25;
        for(int i= 0; i <drawables.size(); i++){
           double distance = Math.sqrt((drawables.get(i).getX()+10-p.x)*(drawables.get(i).getX()+10-p.x) +
                   (drawables.get(i).getY()+10-p.y)*(drawables.get(i).getY()+10-p.y));

            if(distance < best) {
                bestMatch = drawables.get(i);
                best = (int )Math.round(distance);
            }

        }
        return bestMatch;
    }



}
