import java.util.ArrayList;
import java.util.Collections;

public class Image {

    public ArrayList<ArrayList<Integer>> matrix  ;
    public int width;
    public int height;

    public Image(){
        this.height = 300;
        this.width = 300;
        this.matrix = new ArrayList<ArrayList<Integer>>();
        for (int i =0;i<this.height;i++) {
            matrix.add(new ArrayList<Integer> (Collections.nCopies(this.width, 0)));
        }
    }

    public Image(int H, int W){
        this.height = H;
        this.width = W;
        this.matrix = new ArrayList<ArrayList<Integer>>();
        for (int i =0;i<this.height;i++) {
            matrix.add(new ArrayList<Integer> (Collections.nCopies(this.width, 0)));
        }
    }

    public Image(Image Im){
        this.height = Im.height;
        this.width = Im.width;
        this.matrix = new ArrayList<ArrayList<Integer>>();
        for (int i =0;i<this.height;i++) {
            matrix.add(new ArrayList<Integer> (Collections.nCopies(this.width, 0)));
        }
    }
}
