import java.io.DataInputStream;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.util.Scanner;

public class ReadImage {

        public ReadImage(File image) throws Exception {
            FileInputStream f = new FileInputStream(image);
            DataInputStream d = new DataInputStream(f);
            d.readLine();//first line contains P5
            String line = d.readLine();//second line contains height and width
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

