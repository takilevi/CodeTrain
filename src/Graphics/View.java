package Graphics;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by vassm on 2017. 05. 01..
 */
public class View {

    protected List<Drawable> drawables = new ArrayList<Drawable>();

    public void DrawAll()
    {
        for(int i = 0; i<drawables.size();i++)
        {
            drawables.get(i).Draw();
        }
    }
}
