import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Guess extends JFrame {
    private JTextField t1, t2, t3;
    private JLabel j4;
    private JButton b1; 
    private ButtonListener bl1;
    private ButtonListener2 bl2;
    private ButtonListener3 bl3;

    private int rand = (int) (Math.random() * 100);
    private int count = 0, maxGuesses = 10;
    private boolean gameWon = false; 

    public Guess() {
        Container c = getContentPane();
        c.setLayout(null);
        c.setBackground(Color.WHITE);

        JLabel lblImage = new JLabel();
        lblImage.setBounds(0, 0, 100, 100);
        ImageIcon imageIcon = new ImageIcon("image.png");
        lblImage.setIcon(imageIcon);

        JLabel j = new JLabel("Guess my number game!");
        j.setForeground(Color.RED);
        j.setFont(new Font("tunga", Font.BOLD, 24));
        j.setSize(300, 40);
        j.setLocation(140, 30);

        JLabel j1 = new JLabel("Enter a number b/w 1-100");
        j1.setFont(new Font("tunga", Font.PLAIN, 17));
        j1.setSize(300, 50);
        j1.setLocation(180, 60);

        t1 = new JTextField(10);
        t1.setSize(50, 30);
        t1.setLocation(250, 110);

        j4 = new JLabel("Try and guess my number");
        j4.setFont(new Font("tunga", Font.PLAIN, 17));
        j4.setSize(350, 20);
        j4.setLocation(150, 150);

        t2 = new JTextField(10);
        t2.setSize(40, 20);
        t2.setLocation(10, 10);

        JLabel j5 = new JLabel("Best Score");
        j5.setFont(new Font("tunga", Font.PLAIN, 17));
        j5.setSize(270, 20);
        j5.setLocation(60, 10);

        t3 = new JTextField(10);
        t3.setSize(40, 20);
        t3.setLocation(160, 10);

        JLabel j6 = new JLabel("Guesses remaining");
        j6.setFont(new Font("tunga", Font.PLAIN, 17));
        j6.setSize(270, 20);
        j6.setLocation(210, 10);

        b1 = new JButton("Guess"); 
        b1.setSize(150, 40);
        b1.setLocation(200, 250);
        bl1 = new ButtonListener();
        b1.addActionListener(bl1);

        JButton b2 = new JButton("Give up!");
        b2.setSize(100, 30);
        b2.setLocation(100, 200);
        bl2 = new ButtonListener2();
        b2.addActionListener(bl2);

        JButton b3 = new JButton("Play Again");
        b3.setSize(120, 30);
        b3.setLocation(330, 200);
        bl3 = new ButtonListener3();
        b3.addActionListener(bl3);

        c.add(j5);
        c.add(j4);
        c.add(lblImage);
        c.add(j);
        c.add(j1);
        c.add(t1);
        c.add(t2);
        c.add(t3);
        c.add(b1);
        c.add(b2);
        c.add(b3);
        c.add(j6);

        t2.setEditable(false);
        t3.setEditable(false);

        setTitle("GUESS MY NUMBER");

        setSize(550, 350);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    private class ButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            if (count >= maxGuesses || gameWon) {
                j4.setText("You have reached the maximum number of guesses!");
                t1.setEditable(false);
                b1.setEnabled(false); 
                return;
            }

            int a = Integer.parseInt(t1.getText());
            count = count + 1;

            if (a < rand) {
                j4.setText(a + " is smaller, try again!!");
            } else if (a > rand) {
                j4.setText(a + " is larger, try again!!");
            } else {
                j4.setText("CORRECT, YOU WIN!!!!");

                if (count <= maxGuesses) {
                    t2.setText(String.valueOf(maxGuesses - count));
                }

                t1.setEditable(false);
                b1.setEnabled(false);
                gameWon = true;
            }

            t1.requestFocus();
            t1.selectAll();
            t3.setText(String.valueOf(maxGuesses - count));
        }
    }

    private class ButtonListener2 implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            j4.setText("The answer is " + rand + " !!");
            t1.setText("");
            t1.setEditable(false);
            b1.setEnabled(false); 
            gameWon = true;
        }
    }

    private class ButtonListener3 implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            rand = (int) (Math.random() * 100);
            t1.setText("");
            t3.setText(String.valueOf(maxGuesses));
            j4.setText("Try and guess my number");
            count = 0;
            t1.setEditable(true);
            t1.requestFocus();
            b1.setEnabled(true); 
            gameWon = false;
        }
    }

    public static void main(String[] args) {
        new Guess();
    }
}
