import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.util.Scanner;

public class ReadImage {

        public static void main(String args[]) throws Exception {
            File newFile = new File("ImagesTestPGM/coins.pgm");
            FileReader file = new FileReader(newFile);
            BufferedReader br = new BufferedReader(file);
            String line;
            line = br.readLine();
            br.readLine();

//            while ( (line = br.readLine()) != null){
//                System.out.println(line);
//            }


            Scanner s = new Scanner(line);
            int width = s.nextInt();
            int height = s.nextInt();
            line = d.readLine();//third line contains maxVal
            s = new Scanner(line);
            int maxVal = s.nextInt();
            byte[][] im = new byte[height][width];
            for (int i = 0; i < 258; i++) {
                for (int j = 0; j < 258; j++) {
                    im[i][j] = -1;
                }
            }
            int count = 0;
            byte b;
            try {
                while (true) {
                    b = (byte) (d.readUnsignedByte());
                    if (b == '\n') { //do nothing if new line encountered
                    } else if (b == '#') {
                        d.readLine();
                    } else if (Character.isWhitespace(b)) { // do nothing if whitespace encountered
                    } else {
                        im[count / width][count % width] = b;
                        count++;
                    }
                }
            } catch (EOFException e) {
            }
            System.out.println("Height=" + height);
            System.out.println("Width=" + height);
            System.out.println("Required elemnts=" + (height * width));
            System.out.println("Obtained elemnets=" + count);


        }
    }

