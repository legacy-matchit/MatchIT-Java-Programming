package polygon;

import se.lth.cs.pt.window.SimpleWindow;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Iterator;
import java.util.Scanner;

public class ManyPolygons {

    public static void main(String[] args) {

        System.out.println("Input file name : ");
        Scanner s = new Scanner(System.in);
        String filename = s.nextLine();

//        String path = System.getProperty("user.dir");
//        System.out.println("Working Directory = " + path);

        /** file load **/
        Scanner scanner = null;

        try {
            scanner = new Scanner(new File( "src/" + filename));
        } catch (FileNotFoundException e) {
            System.out.println("Couldn't find " + filename + "file");
            System.exit(1);
        }

        SimpleWindow w = new SimpleWindow(600, 600, "Many polygons");


//        /** repeat scanner hasNext is true **/
//        while (scanner.hasNextLine()) {
//
//            System.out.println("-------------------------");
//
//            //load one line
//            Scanner row = new Scanner(scanner.nextLine());//한줄읽기
//
//            //create Polygon's instance
//            Polygon pol = new Polygon();//새로운 폴리건 인스턴스만들어서
//
//
//            //repeat row hasNextInt is true
//            while (row.hasNextInt()){
//                //add x,y as point instance in polygon
//                pol.addVertex(row.nextInt(),row.nextInt()); //정점을 폴리건에 포인트인스턴스를 넘겨서 배열에 담는다
//            }
//
//            pol.draw(w); // 그린다
//
//        }

        while (scanner.hasNextLine()){

            String line = scanner.nextLine();
            String[] ss = line.split(" ");
            Polygon pol = new Polygon();
            int x=0;
            int y=0;
            for(int i = 0; i < ss.length; i++){
                if(i % 2 == 0){
                    x =i;
                }else{
                    y =i;
                    pol.addVertex(Integer.parseInt(ss[x]), Integer.parseInt(ss[y]));
                }
            }
            pol.draw(w);
        }


    }
}
