import java.awt.*;
import java.awt.geom.Rectangle2D;
import java.awt.image.*;
import java.io.FileOutputStream;

public class ImageSavingExamples extends Frame {
    private BufferedImage image;

    public ImageSavingExamples(){
        addWindowListener(new MyFinishWindow());
        image = new BufferedImage(200,300,BufferedImage.TYPE_INT_RGB);
        Graphics2D g2dImage = image.createGraphics();
        g2dImage.setPaint(Color.BLUE);
        g2dImage.draw(new Rectangle2D.Double(10,10,150,250));

        g2dImage.setPaint(Color.RED);
        g2dImage.drawString("Try Saving", 30, 230);

        try{
            FileOutputStream fos = new FileOutputStream("test.jpg");
            
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void paint(Graphics g){
        Graphics2D g2d = (Graphics2D) g;
        g2d.drawImage(image,50,50,null);
    }

    public static void main(String[] args) {
        ImageSavingExamples f = new ImageSavingExamples();
        f.setTitle("Saving New Image");
        f.setSize(600,600);
        f.setVisible(true);
        f.setLocationRelativeTo(null);
    }
}
