import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class BettingField{
    private int width, height, x, y;
    private List<Button> buttons = new ArrayList<>();
    private String[] temp = {"⌃", "⌄", "bet"};
    private long amount = 0;

    public BettingField(int x, int y){
        width = 150;
        height = 150;
        this.x = x;
        this.y = y;

        for(int i = 0; i < temp.length;  i++){
            buttons.add(new Button(x+95, y+(30*i), temp[i], i, 50, 25));
        }

    }

    public void draw(Graphics2D g2d){
        g2d.drawRoundRect(x,y,width,height,width/10,height/10);

        for(int i = 0; i < buttons.size(); i++){
            buttons.get(i).draw(g2d);
        }

        g2d.drawString(String.valueOf(amount), x + width/2, y+height/2);


    }
}
