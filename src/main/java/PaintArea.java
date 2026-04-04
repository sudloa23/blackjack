import javax.swing.*;
import java.awt.*;

public class PaintArea extends JPanel {
    private Game game;

    public PaintArea(Game game){
        super();
        this.game = game;

        setFocusable(true);
    }

    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);

        Graphics2D g2d =(Graphics2D) g;
        game.draw(g2d);
    }
}
