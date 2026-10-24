
import javax.swing.*;
import java.awt.*;

public class StudentForm {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Student Registration Portal");
        frame.setSize(550, 650);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);

        JPanel main = new JPanel();
        main.setBackground(new Color(235, 230, 255));
        main.setLayout(null);

        // Colorful Header
        JPanel header = new JPanel();
        header.setBackground(new Color(82, 55, 190));
        header.setBounds(0, 0, 550, 115);
        header.setLayout(new GridLayout(2, 1));

        JLabel title = new JLabel("STUDENT REGISTRATION", JLabel.CENTER);
        title.setFont(new Font("Arial", Font.BOLD, 24));
        title.setForeground(Color.WHITE);

        JLabel subtitle = new JLabel("Create Your Student Profile", JLabel.CENTER);
        subtitle.setFont(new Font("Arial", Font.PLAIN, 15));
        subtitle.setForeground(new Color(225, 220, 255));

        header.add(title);
        header.add(subtitle);
        main.add(header);

        // Form labels and fields
        Color textColor = new Color(55, 45, 100);

        JLabel nameLabel = new JLabel("Full Name");
        nameLabel.setBounds(55, 140, 150, 25);
        nameLabel.setForeground(textColor);
        main.add(nameLabel);

        JTextField name = new JTextField();
        name.setBounds(55, 168, 430, 35);
        main.add(name);

        JLabel idLabel = new JLabel("Student ID");
        idLabel.setBounds(55, 213, 150, 25);
        idLabel.setForeground(textColor);
        main.add(idLabel);

        JTextField id = new JTextField();
        id.setBounds(55, 241, 430, 35);
        main.add(id);

        JLabel deptLabel = new JLabel("Department");
        deptLabel.setBounds(55, 286, 150, 25);
        deptLabel.setForeground(textColor);
        main.add(deptLabel);

        String[] departments = {"CSE", "EEE", "ICE", "Civil", "BBA"};
        JComboBox<String> dept = new JComboBox<>(departments);
        dept.setBounds(55, 314, 430, 35);
        main.add(dept);

        JLabel genderLabel = new JLabel("Gender");
        genderLabel.setBounds(55, 359, 150, 25);
        genderLabel.setForeground(textColor);
        main.add(genderLabel);

        JRadioButton male = new JRadioButton("Male");
        JRadioButton female = new JRadioButton("Female");
        male.setBackground(main.getBackground());
        female.setBackground(main.getBackground());
        male.setBounds(55, 386, 100, 30);
        female.setBounds(160, 386, 120, 30);

        ButtonGroup group = new ButtonGroup();
        group.add(male);
        group.add(female);
        main.add(male);
        main.add(female);

        JLabel dobLabel = new JLabel("Date of Birth");
        dobLabel.setBounds(55, 425, 150, 25);
        dobLabel.setForeground(textColor);
        main.add(dobLabel);

        JTextField dob = new JTextField("DD/MM/YYYY");
        dob.setBounds(55, 453, 430, 35);
        main.add(dob);

        // Colorful buttons
        JButton register = new JButton("REGISTER");
        register.setBounds(55, 515, 205, 45);
        register.setBackground(new Color(20, 160, 115));
        register.setForeground(Color.WHITE);
        register.setFont(new Font("Arial", Font.BOLD, 14));
        register.setFocusPainted(false);
        main.add(register);

        JButton reset = new JButton("RESET");
        reset.setBounds(280, 515, 205, 45);
        reset.setBackground(new Color(235, 80, 105));
        reset.setForeground(Color.WHITE);
        reset.setFont(new Font("Arial", Font.BOLD, 14));
        reset.setFocusPainted(false);
        main.add(reset);

        register.addActionListener(e -> {
            String gender = "Not selected";
            if (male.isSelected()) gender = "Male";
            if (female.isSelected()) gender = "Female";

            if (name.getText().trim().isEmpty()
                    || id.getText().trim().isEmpty()) {
                JOptionPane.showMessageDialog(frame,
                    "Please enter your name and student ID!");
                return;
            }

            JOptionPane.showMessageDialog(frame,
                "Registration Successful! 🎉\n\n"
                + "Name: " + name.getText()
                + "\nStudent ID: " + id.getText()
                + "\nDepartment: " + dept.getSelectedItem()
                + "\nGender: " + gender
                + "\nDate of Birth: " + dob.getText(),
                "Student Profile",
                JOptionPane.INFORMATION_MESSAGE);
        });

        reset.addActionListener(e -> {
            name.setText("");
            id.setText("");
            dept.setSelectedIndex(0);
            group.clearSelection();
            dob.setText("");
        });

        frame.add(main);
        frame.setVisible(true);
    }
}
