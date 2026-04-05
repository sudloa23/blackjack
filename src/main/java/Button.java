import java.awt.*;
import java.awt.event.MouseEvent;

public class Button{
    private int x, y, width, height;
    private String text;
    private int id;

    public Button(int x, int y, String text, int id){
        this.x = x;
        this.y = y;
        this.text = text;
        this.id = id;
        width = 100;
        height = 50;
    }

    public boolean pressed(MouseEvent e){
        if(e.getX() > x && e.getX() < x+width && e.getY() > y && e.getY() < y+height){
            return true;
        }
        return false;
    }

    public void draw(Graphics2D g2d){
        g2d.drawRect(x,y,width,height);
        g2d.drawString(text, x+35 - text.length(), y+30);
    }

    public int getId(){
        return id;
    }
}
