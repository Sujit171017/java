
import javax.swing.*;
import java.awt.*;

public class SimpleCalculator extends JFrame {
    JTextField screen;
    JLabel history;
    double num;
    String op = "";
    boolean fresh = true;

    SimpleCalculator() {
        setTitle("My Calculator");
        setSize(330, 450);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel p = new JPanel(new BorderLayout(8, 8));
        p.setBackground(new Color(30, 34, 55));
        p.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));

        history = new JLabel(" ", JLabel.RIGHT);
        history.setForeground(Color.LIGHT_GRAY);

        screen = new JTextField("0");
        screen.setFont(new Font("Arial", Font.BOLD, 28));
        screen.setHorizontalAlignment(JTextField.RIGHT);
        screen.setEditable(false);

        JPanel top = new JPanel(new GridLayout(2, 1));
        top.setBackground(new Color(43, 48, 70));
        top.add(history);
        top.add(screen);
        p.add(top, BorderLayout.NORTH);

        String[] keys = {
            "C", "DEL", "%", "/",
            "7", "8", "9", "*",
            "4", "5", "6", "-",
            "1", "2", "3", "+",
            "+/-", "0", ".", "="
        };

        JPanel grid = new JPanel(new GridLayout(5, 4, 6, 6));
        grid.setBackground(new Color(30, 34, 55));

        for (String k : keys) {
            JButton b = new JButton(k);
            b.setFont(new Font("Arial", Font.BOLD, 17));
            b.setFocusPainted(false);
            b.setBackground("C DEL".contains(k) && k.length() > 1
                    || k.equals("C") ? new Color(225, 70, 90)
                    : "+-*/=".contains(k) && k.length() == 1
                    ? new Color(255, 155, 65)
                    : new Color(65, 75, 105));
            b.setForeground(Color.WHITE);
            b.addActionListener(e -> press(k));
            grid.add(b);
        }

        p.add(grid, BorderLayout.CENTER);
        add(p);
        setVisible(true);
    }

    void press(String k) {
        String s = screen.getText();
        try {
            if (k.matches("[0-9]")) {
                screen.setText(fresh || s.equals("0") ? k : s + k);
                fresh = false;
            } else if (k.equals(".")) {
                if (fresh) { screen.setText("0."); fresh = false; }
                else if (!s.contains(".")) screen.setText(s + ".");
            } else if (k.equals("C")) {
                screen.setText("0"); history.setText(" ");
                op = ""; fresh = true;
            } else if (k.equals("DEL")) {
                screen.setText(!fresh && s.length() > 1
                        ? s.substring(0, s.length() - 1) : "0");
            } else if (k.equals("%") || k.equals("+/-")) {
                double x = Double.parseDouble(s);
                screen.setText(fmt(k.equals("%") ? x / 100 : -x));
            } else if ("+-*/".contains(k) && k.length() == 1) {
                num = Double.parseDouble(s);
                op = k;
                history.setText(s + " " + k);
                fresh = true;
            } else if (k.equals("=") && !op.isEmpty() && !fresh) {
                double x = Double.parseDouble(s), r;
                switch (op) {
                    case "+": r = num + x; break;
                    case "-": r = num - x; break;
                    case "*": r = num * x; break;
                    default:
                        if (x == 0) {
                            screen.setText("Cannot divide by zero");
                            op = ""; fresh = true; return;
                        }
                        r = num / x;
                }
                history.setText(num + " " + op + " " + s + " =");
                screen.setText(fmt(r));
                op = ""; fresh = true;
            }
        } catch (Exception ex) {
            screen.setText("Error");
            op = ""; fresh = true;
        }
    }

    String fmt(double n) {
        return n == (long)n && Math.abs(n) < 1e15
                ? String.valueOf((long)n) : String.valueOf(n);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(SimpleCalculator::new);
    }
}
