import se.lth.cs.pt.window.SimpleWindow;
public class SimpleWindowExample {
    public static void main(String[] args){

        SimpleWindow simpleWindow = new SimpleWindow(500,500,"Draw");
        while (true){
            //Wait mouse event
            simpleWindow.waitForMouseClick();
            //Draw line
            simpleWindow.lineTo(simpleWindow.getMouseX(),simpleWindow.getMouseY());

            simpleWindow.writeText("***");
        }
    }
}
