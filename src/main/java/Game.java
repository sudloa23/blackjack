import java.awt.*;
import java.awt.geom.AffineTransform;
import java.util.ArrayList;
import java.util.List;

public class Game{
    private int playerCardY = 300;
    private List<Card> cards = new ArrayList<>();
    private List<Card> player = new ArrayList<>();
    private List<Card> bot = new ArrayList<>();
    private int random;
    private boolean draw = true;
    private String[] symbols = {"A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K"};
    private String heart = "\u2665", diamond = "\u2666", spade = "\u2660", club = "\u2663";
    private int width = 80, height = 140, arcSize = 14;
    private String filledBox = "\u25A3", emptyBox = "\u25A2";
    private int boxSize = 10;

    public Game(){
        for(int i = 0; i < symbols.length; i++){
            cards.add(new Card(heart, symbols[i]));
            cards.add(new Card(diamond, symbols[i]));
            cards.add(new Card(spade, symbols[i]));
            cards.add(new Card(club, symbols[i]));
        }
        init();
    }

    public void init(){
        for(int i = 0; i < 2; i++){
            player.add(drawCard());
            bot.add(drawCard());
        }
    }

    public void draw(Graphics2D g2d){
        for(int i = 0; i < player.size(); i++){
            player.get(i).draw(g2d, i*100 + 15, playerCardY);
        }

        drawBack(g2d,210, 100);
    }

    public Card drawCard(){
        random = (int) (Math.random()*cards.size());
        Card temp = cards.get(random);
        cards.remove(random);
        return temp;
    }

    public void drawBack(Graphics2D g2d, int x, int y){
        Font DEFAULT = g2d.getFont();
        Color color = new Color(61, 68, 104);
        AffineTransform original = g2d.getTransform();
        g2d.drawRoundRect(x,y,width,height,arcSize,arcSize);
        g2d.setColor(color);
        g2d.fillRoundRect(x, y, width, height, arcSize, arcSize);
        g2d.setColor(new Color(193, 196, 218));
        g2d.setFont(new Font("Serif", Font.BOLD, boxSize));


        for(int i = 0; i < 140/boxSize; i++){
            for(int j = 0; j < 80/boxSize; j++){
                if((i + j)%2 == 0){
                    g2d.drawString(filledBox, x + (j*boxSize) + 1, y + ( i*boxSize) + boxSize-1);
                }else {
                    g2d.drawString(emptyBox, x + (j*boxSize) + 1, y + ( i*boxSize) + boxSize-1);
                }
            }
        }

    }
}
