public class Button{
    private int x, y, width, height;
    private String text;

    public Button(int x, int y, String text){
        this.x = x;
        this.y = y;
        this.text = text;
        width = 100;
        height = 50;
    }

    public boolean pressed(){
        return false;
    }

    public void pressedAction(){
        if(pressed()){



        }
    }

}
