public class Main {
    public static void main(String[] args){
        Game game = new Game();
        PaintArea paintArea = new PaintArea(game);
        Frame frame = new Frame(paintArea);
        frame.setVisible(true);
    }
}