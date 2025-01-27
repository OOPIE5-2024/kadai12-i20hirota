package ex09;

public class NegativeImageFilter implements Processable{
  @Override
  public void process(GrayImage img) {
    int height = img.getHeight();
    int width = img.getWidth();
    
    for (int x = 0; x < width; x++) {
      for (int y=0; y < height; y++) {
        int gray = img.getGray(x, y);
        
        // 色を反転させて，set
        img.setGray(x, y, 255-gray);
      }
    }
  }
}
