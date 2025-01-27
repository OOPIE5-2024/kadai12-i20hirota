package ex09;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.awt.event.ActionEvent;

public class Ex9 {
  private JFrame frame;
  private JTextField txtCatpng;
  private ImagePanel image;
  private JTextArea textArea;
  private GrayImage grayImg;

  /**
   * Launch the application.
   */
  public static void main(String[] args) {
    EventQueue.invokeLater(new Runnable() {
      public void run() {
        try {
          Ex9 window = new Ex9();
          window.frame.setVisible(true);
        } catch (Exception e) {
          e.printStackTrace();
        }
      }
    });
  }

  /**
   * Create the application.
   */
  public Ex9() {
    initialize();
  }

  /**
   * Initialize the contents of the frame.
   */
  private void initialize() {
    frame = new JFrame();
    frame.setBounds(100, 100, 450, 300);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    
    image = new ImagePanel();
    
    JScrollPane imgScrollPane = new JScrollPane();
    frame.getContentPane().add(imgScrollPane, BorderLayout.CENTER);
    imgScrollPane.setViewportView(image);
    
    JScrollPane textScrollPane = new JScrollPane();
    frame.getContentPane().add(textScrollPane, BorderLayout.SOUTH);
    
    textArea = new JTextArea();
    textScrollPane.setViewportView(textArea);
    
    JPanel panel = new JPanel();
    panel.setPreferredSize(new Dimension(120, 0));
    frame.getContentPane().add(panel, BorderLayout.WEST);
    panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
    
    JLabel lblNewLabel = new JLabel("File Name");
    panel.add(lblNewLabel);
    
    txtCatpng = new JTextField();
    txtCatpng.setText("cat.png");
    panel.add(txtCatpng);
    txtCatpng.setColumns(10);
    
    JButton btnNewButton = new JButton("Load");
    btnNewButton.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        String text = txtCatpng.getText();
        if (text != null) {
          BufferedImage img = null;
          try {
            img = ImageIO.read(new File(text));
            grayImg = new GrayImage(img);
            image.setImage(grayImg);
            imgScrollPane.setViewportView(image);
            if (img != null) {
              textArea.append("Load " + "\"" + text + "\"\n");
            } else {
              textArea.append("Unknown file format  \"" + text + "\"\n");
            }
          } catch (IOException e1) {
            textArea.append(e1.toString() + "\n");
          }
        }
      }
    });
    panel.add(btnNewButton);
    
    JButton btnBinary = new JButton("Binary");
    btnBinary.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        BinaryImageFilter binaryImageFilter = new BinaryImageFilter();
        grayImg.applyFilter(binaryImageFilter);
        image.setImage(grayImg);
      }
    });
    panel.add(btnBinary);
    
    JButton btnNegative = new JButton("Negative");
    btnNegative.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        NegativeImageFilter negativeImageFilter = new NegativeImageFilter();
        grayImg.applyFilter(negativeImageFilter);
        image.setImage(grayImg);
      }
    });
    panel.add(btnNegative);
  }
}
