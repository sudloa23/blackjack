import java.util.ArrayList;
import java.util.List;

public class Deck{
    private List<Card> cards = new ArrayList<>();
    private String[] symbols = {"A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K"};
    private String heart = "\u2665", diamond = "\u2666", spade = "\u2660", club = "\u2663";

    public Deck(){
        for(int i = 0; i < symbols.length; i++){
            cards.add(new Card(heart, symbols[i]));
            cards.add(new Card(diamond, symbols[i]));
            cards.add(new Card(spade, symbols[i]));
            cards.add(new Card(club, symbols[i]));
        }
    }

    public List<Card> getCards(){
        return cards;
    }

}
