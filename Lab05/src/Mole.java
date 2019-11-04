import java.util.List;

public class Mole {

    private Graphics graphic = new Graphics(30,50,10);

    private List<Map> skys;

    public static void main(String[] args){

        //Graphics graphic = new Graphics(30,50,25); //Create Graphics's instance
        //graphic.square(); //draw square
        //graphic.block(10,14, Colors.SOIL);

        Mole mole = new Mole();
        mole.drawWorld();
        mole.drawSky(4,2);
        mole.drawSky(13,3);
        mole.drawSky(22,4);
        mole.drawGrass();
        mole.skys = mole.graphic.getSkyMap(); // get skys map info
        mole.dig();

    }

    public void drawWorld(){
        graphic.rectangle(0,0,30,50, Colors.SOIL);
    }

    public void drawSky(int x, int y){
        graphic.rectangle(x,y,3,1, Colors.SKY);
        graphic.rectangle(x-1,y+1,5,1, Colors.SKY);
        graphic.rectangle(x,y+2,3,1, Colors.SKY);
    }

    public void drawGrass(){
        graphic.rectangle(0,20,30,3, Colors.GRASS);
    }



    public void dig(){


        /** start position with draw Mole */
        int x = graphic.getWidth() / 2; /** half of window */
        int y = graphic.getHeight() / 2; /** half of window */
        graphic.block(x,y,Colors.MOLE); /** Draw a mole block at the coordinates before the mole moves */

        while (true){

            char key = graphic.waitForKey(); /** get key information */

            graphic.block(x,y,Colors.TUNNEL); /** Draw the tunnel block at the coordinates after the mole moves */

            if(key == 'w'){
                y--; // top 1 step
            }else if(key == 'a'){
                x--; // left 1 step
            }else if(key == 's'){
                y++; // bottom 1 step
            }else if(key == 'd'){
                x++; // right 1 step
            }

            //check mole location. If Mole out of window or under the sky map, Mole can not move
            if(isMoleUndertheCloud(x,y) || isMoleOutOfWindow(x,y)){
                if(key == 'w'){
                    y++;
                }else if(key == 'a'){
                    x++;
                }else if(key == 's'){
                    y--;
                }else if(key == 'd'){
                    x--;
                }
            }

            drawGrass(); /** Draw Grass For Eraser Tunnel Color  **/

            graphic.block(x,y,Colors.MOLE); /** Draw the mole block at the coordinates after the mole moves */
        }
    }

    public boolean isMoleOutOfWindow(int x, int y){

        if(x < 0 || x >= graphic.getWidth() ||
                y < 0 || y >= graphic.getHeight()){
            return true;
        }
        return false;
    }

    public boolean isMoleUndertheCloud(int x, int y){

        for (int i = 0; i < this.skys.size(); i++){

            Map map = skys.get(i);

            if(x == map.x && y == map.y) {
                return true;
            }
        }
        return false;
    }

}
