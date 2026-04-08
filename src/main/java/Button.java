import java.awt.*;
import java.awt.event.MouseEvent;

public class Button{
    private int x, y, width, height;
    private String text;
    private int id;

    public Button(int x, int y, String text, int id, int width, int height){
        this.x = x;
        this.y = y;
        this.text = text;
        this.id = id;
        this.width = width;
        this.height = height;
    }

    public boolean pressed(MouseEvent e){
        if(e.getX() > x && e.getX() < x+width && e.getY() > y && e.getY() < y+height){
            return true;
        }
        return false;
    }

    public void draw(Graphics2D g2d){
        g2d.drawRect(x,y,width,height);
        g2d.drawString(text, x+(width/2)-5 - text.length(), y+(height/2)+5);
    }

    public int getId(){
        return id;
    }
}
