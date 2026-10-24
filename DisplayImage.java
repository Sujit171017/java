import javax.swing.*;

class DisplayImage {
    public static void main(String[] args) {
        JFrame f = new JFrame("Image");
        f.add(new JLabel(new ImageIcon("tiger.jpg")));
        f.setSize(1000, 500);
        f.setVisible(true);
    }
}