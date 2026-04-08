import java.awt.*;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

public class BettingField{
    private int width, height, x, y;
    private List<Button> buttons = new ArrayList<>();
    private String[] temp = {"⌃", "⌄", "bet"};
    private long amount = 0;
    private int pressed;
    private long endAmount;
    private boolean ready = false;

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

    public void handleClick(MouseEvent e){
        for(int i = 0; i < buttons.size(); i++){
            if(buttons.get(i).pressed(e)){
                pressed = buttons.get(i).getId();
                return;
            }
        }

        switch(pressed){
            case 0:
                System.out.println("raise bet by 50");
                amount+=50;
                break;

            case 1:
                if(amount >= 50){
                    System.out.println("lower bet by 50");
                    amount-= 50;
                }else{
                    System.out.println("to low to lower");
                }
                break;

            case 2:
                endAmount = amount;
                ready = true;
                break;

            default:

                break;
        }
    }
}
