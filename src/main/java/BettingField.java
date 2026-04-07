import java.awt.*;

public class BettingField{
    private int width, height, x, y;

    public BettingField(int x, int y){
        width = 150;
        height = 150;
        this.x = x;
        this.y = y;

    }

    public void draw(Graphics2D g2d){
        g2d.drawRoundRect(x,y,width,height,width/10,height/10);
    }
}
