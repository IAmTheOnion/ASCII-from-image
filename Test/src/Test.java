import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.awt.Color;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.util.Scanner;

public class Test {
   public static void main(String args[])throws IOException {
      Scanner s = new Scanner(System.in);
      System.out.println("Paste file path: ");
      String name = s.next();
      
      File file= new File(name);
      FileWriter w = new FileWriter("C:\\new.txt");
      BufferedImage img = ImageIO.read(file);
      
      for (int y = 0; y < img.getHeight(); y++) {
         for (int x = 0; x < img.getWidth(); x++) {
        	 
            int pixel = img.getRGB(x,y);
            Color color = new Color(pixel, true);
            int red = color.getRed();
            int green = color.getGreen();
            int blue = color.getBlue();
            
            if (red > green && red > blue) {
            	w.write("# ");
            } else if (green > red && green > blue) {
            	w.write("* ");
            } else {
            	w.write("= ");
            }
            
         }
         
         w.write("\n");
      }
      w.close();
      System.out.println("Success!");
   }
}