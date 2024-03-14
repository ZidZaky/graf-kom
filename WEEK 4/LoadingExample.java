import java.awt.*;

public class LoadingExample extends Frame{
    private Image theImage;
    public LoadingExample(){
        addWindowListener(new MyFinishWindow());
        theImage = new javax.swing.ImageIcon("image1.jpg").getImage();
    }
     public void paint(Graphics g){
        Graphics2D g2d = (Graphics2D) g;
        g2d.drawImage(theImage,50,50,null);
     }
    
     public static void main(String[]args){
        LoadingExample f = new LoadingExample();
        f.setTitle("Image Loading");
        f.setSize(600,600);
        f.setVisible(true);
        f.setLocationRelativeTo(null);
    }
}