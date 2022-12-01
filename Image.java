import java.util.ArrayList;
import java.util.Collections;

import java.awt.FlowLayout;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

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

    /**
     * Renvoie une image en N&B selon le niveau du seuil
     * Les valeurs au-dessus sont en blancs, en dessous en noirs
     * @param value
     * @return
     */
    public Image seuil(int value){
        Image newImage = new Image(this);
        for (int i = 0; i<this.width; i++){
            for (int j = 0; j<this.height; j++){
                if (this.matrix.get(i).get(j)>value){
                    newImage.matrix.get(i).set(j,255);
                }
            }
        }
        return newImage;
    }

    /**
     * Renvoie une image résultat de la différence entre l'image et l'image en argument 
     * @param im
     * @return
     */
    public Image difference(Image im){
        Image newImage = new Image(this);
        int value;
        for (int i = 0; i<this.width; i++){
            for (int j = 0; j<this.height; j++){
                value = this.matrix.get(i).get(j)-im.matrix.get(i).get(j);
                newImage.matrix.get(i).set(j,value);
            }
        }
        return newImage;
    }

    /**
     * Fonction temporaire
     * Pour avoir une idée générale
     */
    public void affiche(){
        for (int i = 0; i<this.width; i++){
            System.out.println(this.matrix.get(i));
        }
    }
    

}
