import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.awt.Color;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.awt.FileDialog;
import javax.swing.JFrame;

public class imageGen {
   public static void main(String args[])throws IOException {
	  FileDialog fd = new FileDialog(new JFrame());
	  fd.setVisible(true);
	  File[] f = fd.getFiles()
      
      File file= new File(fd.getFiles()[0].getAbsolutePath());
      FileWriter w = new FileWriter("C:\\new.txt");
      BufferedImage img = ImageIO.read(file);
      
      for (int y = 0; y < img.getHeight(); y++) {
         for (int x = 0; x < img.getWidth(); x++) {
        	 
            int pixel = img.getRGB(x,y);
            Color color = new Color(pixel, true);
            int red = color.getRed();
            int green = color.getGreen();
            int blue = color.getBlue();
            
            if(green - red > green) {
            	w.write("E ");
            } else if(blue - green > red) {
            	w.write("G ");
            } else if(red - green > blue) {
            	w.write("K ");
            } else if (red > green && red > blue) {
            	w.write("# ");
            } else if (green > red && green > blue) {
            	w.write("H ");
            } else {
            	w.write("- ");
            }
            
         }
         
         w.write("\n");
      }
      w.close();
      System.out.println("Success!");
   }
}
