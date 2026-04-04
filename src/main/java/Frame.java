import javax.swing.*;

public class Frame extends JFrame{
    private PaintArea paintArea;
    private String title = "BlackJack";
    private int width = 500, height = 500;

    public Frame(PaintArea paintArea){
        this.paintArea = paintArea;

        setTitle(title);
        setSize(width, height);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        add(paintArea);

        Timer timer = new Timer(20, (e -> paintArea.repaint()));
        timer.start();
    }

}
