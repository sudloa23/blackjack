import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.geom.AffineTransform;
import java.util.ArrayList;
import java.util.List;

public class Game{
    private final int playerCardY = 300, dealerCardY = 15;
    private List<Card> cards = new ArrayList<>();
    private List<Card> player = new ArrayList<>();
    private List<Card> dealer = new ArrayList<>();
    private int random;
    private String[] symbols = {"A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K"};
    private String heart = "\u2665", diamond = "\u2666", spade = "\u2660", club = "\u2663";
    private int width = 80, height = 140, arcSize = 14;
    private String filledBox = "\u25A3", emptyBox = "\u25A2";
    private int boxSize = 10;
    private List<Button> buttons = new ArrayList<>();
    private String[] btnText = {"hit", "stay", "double", "split"};
    private int playerPoints = 0, dealerPoints = 0;
    private String turn = "p1";
    private boolean playerStay = false, dealerStay = false;
    private String winner;
    private int bet = 0;
    private long money = 5000;

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
            playerPoints += player.get(i).getValue();
            dealer.add(drawCard());
            dealerPoints += dealer.get(i).getValue();
        }

        System.out.println("player Points: " + playerPoints);
        System.out.println("dealer Points: " + dealerPoints);

        for(int i = 1; i <= 4; i++){
            buttons.add(new Button(650, ((i-1)*55) +10, btnText[i-1], i));
        }
    }

    public void draw(Graphics2D g2d){
        for(int i = 0; i < player.size(); i++){
            player.get(i).draw(g2d, i*100 + 15, playerCardY);
        }

        for(int i = 0; i < dealer.size(); i++){
            dealer.get(i).draw(g2d, i*100 + 15, dealerCardY);
        }

        for(int i = 0; i < buttons.size(); i++){
            buttons.get(i).draw(g2d);
        }

        //drawBack(g2d,0, 0);
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

    public void handleMouseClick(MouseEvent e){
        int btnPressed = 0;

        for(int i = 0; i < buttons.size(); i++){
            if(buttons.get(i).pressed(e)){
                btnPressed = buttons.get(i).getId();
            }
        }
        if (!playerStay) {
        switch(btnPressed) {
                case 1:
                    if (playerPoints <= 21) {
                        System.out.println("hit!");
                        int random = (int) (Math.random() * cards.size());
                        player.add(cards.get(random));
                        playerPoints += cards.get(random).getValue();
                        cards.remove(random);
                        System.out.println("player Points updated to: " + playerPoints);
                        if(!dealerStay) turn = "d";

                        dealerPlay();
                    } else {
                        System.out.println("player already over 21");
                    }
                    break;

                case 2:
                    System.out.println("stay!");

                    turn = "d";
                    playerStay = true;
                    dealerPlay();
                    break;

                case 3:
                    System.out.println("double!");

                    turn = "d";
                    dealerPlay();
                    break;

                case 4:
                    System.out.println("split!");
                    //implent later

                    break;

                default:
                    System.out.println("invalid btnId parsed");
                    break;
            }
        }else{
            System.out.println("you cannot make a move anymore");
        }
    }

    public void dealerPlay(){
        if(turn == "d"){
            if(dealerPoints <= 16){
                dealerHit();
            }else{
                dealerStay();
            }
        }
    }

    public void dealerHit(){
        int random = (int) (Math.random()*cards.size());
        dealer.add(cards.get(random));
        dealerPoints += cards.get(random).getValue();
        cards.remove(random);
        System.out.println("dealer hit!");
        if(!playerStay) turn = "p1";

    }

    public void dealerStay(){
        System.out.println("dealer stay!");
    }

    public void checkWin(){
        if(playerStay && dealerStay){
            if(dealerPoints > 21 && playerPoints <= 21){
                winner = "player";
            }else if(dealerPoints <= 21 && playerPoints <= 21 && playerPoints > dealerPoints){
                winner = "player";
            }else if(dealerPoints <= 21 && playerPoints <= 21 && playerPoints < dealerPoints){
                winner = "dealer";
            }else if(dealerPoints == playerPoints || dealerPoints > 21 && playerPoints > 21){
                winner = "draw";
            }
        }


    }

    public void result(){
        if(winner != null){
            if(winner.equals("player")){
                System.out.println("player wins " + bet*2 + "€");
                money += bet*2;
            }else if(winner.equals("dealer")){
                System.out.println("dealer wins");
            }else if(winner.equals("draw")){
                System.out.println("draw");
                money += bet;
            }
        }
    }
}
