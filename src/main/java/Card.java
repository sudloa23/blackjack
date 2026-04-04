import java.awt.*;
import java.awt.geom.AffineTransform;

public class Card {
    private String suit;
    private String symbol;
    private int value;
    private int width = 80, height = 140, arcSize = 12;
    private Color color;

    public Card(String suit, String symbol){
        this.suit = suit;
        this.symbol = symbol;
        if(suit.equals("\u2665") || suit.equals("\u2666")){
            color = Color.RED;
        }else{
            color = Color.BLACK;
        }

        switch(symbol){
            case "A":
                value = 1;
                int aceValue = 11;
                break;

            case "1":
                value = 1;
                break;

            case "2":
                value = 2;
                break;

            case "3":
                value = 3;
                break;

            case "4":
                value = 4;
                break;

            case "5":
                value = 5;
                break;

            case "6":
                value = 6;
                break;

            case "7":
                value = 7;
                break;

            case "8":
                value = 8;
                break;

            case "9":
                value = 9;
                break;

            case "10":
                value = 10;
                break;

            case "J":
                value = 10;
                break;

            case "Q":
                value = 10;
                break;

            case "K":
                value = 10;
                break;

            default:
                System.out.println("invalid symbol");
                break;
        }
    }

    public void draw(Graphics2D g2d, int x, int y){
                Font DEFAULT = g2d.getFont();
                AffineTransform original = g2d.getTransform();
                g2d.drawRoundRect(x, y, width, height, arcSize, arcSize);

                //symbol - middle
                g2d.setColor(color);
                g2d.setFont(new Font("Serif", Font.BOLD, 50));
                g2d.drawString(suit, x+22, y+84);

                //symbol - top left
                g2d.setFont(new Font("Serif", Font.BOLD, 12));
                g2d.drawString(suit, x+4, y+24);

                //symbol - bottom right
                g2d.translate(x+76, y+116);
                g2d.rotate(Math.PI);
                g2d.drawString(suit, 0, 0);
                g2d.setFont(DEFAULT);
                g2d.drawString(symbol, 0, -12);
                g2d.setTransform(original);

                g2d.drawString(symbol, x+4, y+12);
                g2d.setColor(Color.BLACK);
    }

}
