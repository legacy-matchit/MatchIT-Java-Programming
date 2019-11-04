import se.lth.cs.pt.window.SimpleWindow;
import java.awt.*;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class Graphics {

    /** Attributes of Graphics Class  **/
    private int width;
    private int height;
    private int blockSize;
    private SimpleWindow window;
    private  List<Map> skyMaps;

    /** Constructor for Graphics Class **/
    public Graphics(int w, int h, int bs){

        skyMaps = new ArrayList<>();
        width = w;
        height = h;
        blockSize = bs;
        window = new SimpleWindow(this.width * this.blockSize,this.height * this.blockSize,"Digging");
    }

    /**  Draw Square  **/
    public void square(){
        // SimpleWindow window = new SimpleWindow(300,500,"Digging");
        window.moveTo(10,10);
        window.lineTo(10,20);
        window.lineTo(20,20);
        window.lineTo(20,10);
        window.lineTo(10,10);
    }

    /**
     * * Create Block
     * @param x the coordinate of x
     * @param y the coordinate of y
     * @param col the color for changing line
     */
    public void block(int x, int y, Color col){ //draw one block

        window.setLineColor(col);

        int left = x * blockSize;
        int right = left + blockSize - 1;
        int top = y * blockSize;
        int bottom = top + blockSize - 1;
        for(int row = top; row <= bottom; row++){ //draw 10 lines to display as one block
            window.moveTo(left,row);
            window.lineTo(right,row);
        }
    }

    /** get key info **/
    public char waitForKey(){
        return window.waitForKey();
    }

    /**
     * Create blocks by width and height
     * @param x start position of coordinate
     * @param y start position of coordinate
     * @param width the block size
     * @param height the block size
     * @param col block color
     */
    public void rectangle(int x, int y, int width, int height, Color col){

        //Draw blocks by the width and height from the starting point x, y.
        for(int yy = y; yy < y + height; yy++){//y부터시작해서 y높이만큼

            for(int xx = x; xx < x + width; xx++){//x부터 시작해서 x넓이만큼

                //draw block
                block(xx,yy,col);

                //get the sky information
                collectSkyPositionInfo(xx,yy,col);
            }
        }
    }


    private void collectSkyPositionInfo(int x, int y, Color col){
        if(col == Colors.SKY){
            Map m = new Map();
            m.x = x;
            m.y = y;
            skyMaps.add(m);
        }
    }

    /**
     * get width
     * @return the width of the int type
     */
    public int getWidth(){
        return width;
    }
    /**
     * get height
     * @return the height of the int type
     */
    public int getHeight(){
        return height;
    }
    /**
     * get sky information
     * @return map in array
     */
    public List<Map> getSkyMap(){
        return skyMaps;
    }
}
