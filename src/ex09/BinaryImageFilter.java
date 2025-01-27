package ex09;

public class BinaryImageFilter implements Processable{
  @Override
  public void process(GrayImage img) {
    int height = img.getHeight();
    int width = img.getWidth();
    
    for (int x = 0; x < width; x++) {
      for (int y=0; y < height; y++) {
        int gray = img.getGray(x, y);
        if (gray > 128) {
          img.setGray(x, y, 255);
        } else {
          img.setGray(x, y, 0);
        }
      }
    }
  }
}
