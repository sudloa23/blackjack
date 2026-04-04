import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Game{
    private int playerCardX = 200, playerCardY = 200;
    private Deck deck = new Deck();
    private List<Card> cards = new ArrayList<>();
    private List<Card> player = new ArrayList<>();
    private int random;
    private boolean draw = true;

    public Game(){
        cards = deck.getCards();
        update();
    }

    public void update(){
        if(draw){
            drawCard();
            draw = false;
        }
    }

    public void draw(Graphics2D g2d){
        for(int i = 0; i < player.size(); i++){
            player.get(i).draw(g2d, playerCardX, playerCardY);
        }
    }

    public void drawCard(){
        random = (int) (Math.random()*cards.size());
        player.add(cards.get(random));
        cards.remove(random);
    }
}
