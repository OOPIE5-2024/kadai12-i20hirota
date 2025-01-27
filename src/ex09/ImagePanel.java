package ex09;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import javax.swing.JPanel;

public class ImagePanel extends JPanel {
  private BufferedImage image;
  
  ImagePanel() {
    super();
  }
  
  public void setImage(BufferedImage image) {
    this.image = image;
    this.setPreferredSize(new Dimension(this.image.getWidth(), this.image.getHeight()));
    repaint();
  }
  
  @Override
  protected void paintComponent(Graphics g) {
    super.paintComponent(g);
    
    if (image != null) {
      g.drawImage(image, 0, 0, null);
    }
  }
}
