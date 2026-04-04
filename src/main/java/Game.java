import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Game{
    private int playerCardY = 300;
    private List<Card> cards = new ArrayList<>();
    private List<Card> player = new ArrayList<>();
    private int random;
    private boolean draw = true;
    private String[] symbols = {"A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K"};
    private String heart = "\u2665", diamond = "\u2666", spade = "\u2660", club = "\u2663";

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
        }
    }

    public void draw(Graphics2D g2d){
        for(int i = 0; i < player.size(); i++){
            player.get(i).draw(g2d, i*100 + 15, playerCardY);
        }
    }

    public Card drawCard(){
        random = (int) (Math.random()*cards.size());
        Card temp = cards.get(random);
        cards.remove(random);
        return temp;
    }
}
