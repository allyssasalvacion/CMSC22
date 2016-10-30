package minicalculator;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigDecimal;
import java.lang.Runnable;

/**
 * Created by Allyssa Albores on 29/10/2016.
 */
public class MiniCalculator extends JFrame {

    //----------------------------- setting the frame && panel && text area ---------------------------------

    JFrame frame = new JFrame("MINI CALCULATOR");
    JPanel pane = new JPanel(new BorderLayout(0, 0));
    JTextArea screen = new JTextArea(5, 30);

    //------------------------------------------- buttons --------------------------------------------------

    JButton clear = new JButton();
    JButton negative = new JButton();
    JButton percent = new JButton();
    JButton divide = new JButton();
    JButton multiply = new JButton();
    JButton subtract = new JButton();
    JButton add = new JButton();
    JButton equals = new JButton();
    JButton decimal = new JButton();
    JButton one = new JButton();
    JButton two = new JButton();
    JButton three = new JButton();
    JButton four = new JButton();
    JButton five = new JButton();
    JButton six = new JButton();
    JButton seven = new JButton();
    JButton eight = new JButton();
    JButton nine = new JButton();
    JButton zero = new JButton();
    JButton backspace = new JButton();

    //------------------------------------------ other variables --------------------------------------------

    double firstnum;
    double secondnum;
    BigDecimal total;
    double plusminus;
    String operations;
    String answer;

    //------------------------------------------ place components -------------------------------------------

    public MiniCalculator() {
        placeComponents();
    }

    //------------------------------------------ layout -----------------------------------------------------

    private void placeComponents() {
        pane.add(screen, BorderLayout.NORTH);
        screen.setBackground(Color.WHITE);
        screen.setForeground(Color.black);
        //screen.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
        screen.setEditable(false);
        Font v = new Font("Verdana", Font.PLAIN, 25);
        screen.setFont(v);
        screen.setLineWrap(true);
        screen.setWrapStyleWord(true);
        frame.setSize(300, 400);
        frame.setContentPane(pane);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panelButtons = new JPanel(new GridLayout(5,4,0,0));

        //------------------------------------------ row one ----------------------------------------------

        Font verdana = new Font("Verdana", Font.PLAIN, 20);
        clear.setText("AC");
        clear.setFont(verdana);
        clear.setFocusable(false);
        clear.setBackground(new Color(224, 224, 224));
        clear.setForeground(Color.BLACK);
        panelButtons.add(clear);
        clear.addActionListener(new clearButton());

        negative.setText("+/-");
        negative.setFont(verdana);
        negative.setFocusable(false);
        negative.setBackground(new Color(224, 224, 224));
        negative.setForeground(Color.BLACK);
        panelButtons.add(negative);
        negative.addActionListener(new negativeButton());

        percent.setText("%");
        percent.setFont(verdana);
        percent.setFocusable(false);
        percent.setBackground(new Color(224, 224, 224));
        percent.setForeground(Color.BLACK);
        panelButtons.add(percent);
        percent.addActionListener(new percentButton());

        divide.setText("÷");
        divide.setFont(verdana);
        divide.setFocusable(false);
        divide.setBackground(new Color(255, 153, 51));
        divide.setForeground(Color.WHITE);
        panelButtons.add(divide);
        divide.addActionListener(new divisionButton());

        //------------------------------------------ row two -----------------------------------------------

        seven.setText("7");
        seven.setFont(verdana);
        seven.setFocusable(false);
        seven.setBackground(new Color(224, 224, 224));
        seven.setForeground(Color.BLACK);
        panelButtons.add(seven);
        seven.addActionListener(new sevenButton());

        eight.setText("8");
        eight.setFont(verdana);
        eight.setFocusable(false);
        eight.setBackground(new Color(224, 224, 224));
        eight.setForeground(Color.BLACK);
        panelButtons.add(eight);
        eight.addActionListener(new eightButton());

        nine.setText("9");
        nine.setFont(verdana);
        nine.setFocusable(false);
        nine.setBackground(new Color(224, 224, 224));
        nine.setForeground(Color.BLACK);
        panelButtons.add(nine);
        nine.addActionListener(new nineButton());

        multiply.setText("x");
        multiply.setFont(verdana);
        multiply.setFocusable(false);
        multiply.setBackground(new Color(255, 153, 51));
        multiply.setForeground(Color.WHITE);
        panelButtons.add(multiply);
        multiply.addActionListener(new multiplyButton());

        //------------------------------------------ row three ------------------------------------------

        four.setText("4");
        four.setFont(verdana);
        four.setFocusable(false);
        four.setBackground(new Color(224, 224, 224));
        four.setForeground(Color.BLACK);
        panelButtons.add(four);
        four.addActionListener(new fourButton());

        five.setText("5");
        five.setFont(verdana);
        five.setFocusable(false);
        five.setBackground(new Color(224, 224, 224));
        five.setForeground(Color.BLACK);
        panelButtons.add(five);
        five.addActionListener(new fiveButton());

        six.setText("6");
        six.setFont(verdana);
        six.setFocusable(false);
        six.setBackground(new Color(224, 224, 224));
        six.setForeground(Color.BLACK);
        panelButtons.add(six);
       six.addActionListener(new sixButton());

        subtract.setText("-");
        subtract.setFont(verdana);
        subtract.setFocusable(false);
        subtract.setBackground(new Color(255, 153, 51));
        subtract.setForeground(Color.WHITE);
        panelButtons.add(subtract);
        subtract.addActionListener(new subtractButton());

        //------------------------------------------ row four -----------------------------------------------

        one.setText("1");
        one.setFont(verdana);
        one.setFocusable(false);
        one.setBackground(new Color(224, 224, 224));
        one.setForeground(Color.BLACK);
        panelButtons.add(one);
        one.addActionListener(new oneButton());

        two.setText("2");
        two.setFont(verdana);
        two.setFocusable(false);
        two.setBackground(new Color(224, 224, 224));
        two.setForeground(Color.BLACK);
        panelButtons.add(two);
        two.addActionListener(new twoButton());

        three.setText("3");
        three.setFont(verdana);
        three.setFocusable(false);
        three.setBackground(new Color(224, 224, 224));
        three.setForeground(Color.BLACK);
        panelButtons.add(three);
        three.addActionListener(new threeButton());

        add.setText("+");
        add.setFont(verdana);
        add.setFocusable(false);
        add.setBackground(new Color(255, 153, 51));
        panelButtons.add(add);
        add.setForeground(Color.WHITE);
        add.addActionListener(new addButton());

        //------------------------------------------ row five -----------------------------------------------

        zero.setText("0");
        zero.setFont(verdana);
        zero.setFocusable(false);
        zero.setBackground(new Color(224, 224, 224));
        zero.setForeground(Color.BLACK);
        panelButtons.add(zero);
        zero.addActionListener(new zeroButton());

        decimal.setText(".");
        decimal.setFont(verdana);
        decimal.setFocusable(false);
        decimal.setBackground(new Color(224, 224, 224));
        decimal.setForeground(Color.BLACK);
        panelButtons.add(decimal);
        decimal.addActionListener(new decimalButton());

        backspace.setText("<--");
        backspace.setFont(verdana);
        backspace.setFocusable(false);
        backspace.setBackground(new Color(224, 224, 224));
        backspace.setForeground(Color.BLACK);
        panelButtons.add(backspace);
        backspace.addActionListener(new backspaceButton());

        equals.setText("=");
        equals.setFont(verdana);
        equals.setFocusable(false);
        equals.setBackground(new Color(255, 153, 51));
        equals.setForeground(Color.WHITE);
        panelButtons.add(equals);
        equals.addActionListener(new equalsButton());

        pane.add(panelButtons, BorderLayout.CENTER);
        frame.setVisible(true);
    }

    //-------------------------------------- ActionListener -------------------------------------------

    //------------------------------------------ clear ------------------------------------------------

    private class clearButton implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            screen.setText(null);
        }
    }

    //------------------------------------- negative/positive ------------------------------------------

    private class negativeButton implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            plusminus = (Double.parseDouble(String.valueOf(screen.getText())));
            plusminus = plusminus * (-1);
            screen.setText(String.valueOf(plusminus));
        }
    }

    //------------------------------------------ backspace ------------------------------------------------

    private class backspaceButton implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String backspace;

            if(screen.getText().length() > 0) {
                StringBuilder str = new StringBuilder(screen.getText());
                str.deleteCharAt(screen.getText().length() - 1);
                backspace = str.toString();
                screen.setText(backspace);
            }
        }
    }

    //------------------------------------------ decimal --------------------------------------------------

    private class decimalButton implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            screen.setText(screen.getText()+ ".");
        }
    }

    //------------------------------------------ numbers --------------------------------------------------

    private class zeroButton implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            screen.setText(screen.getText()+ "0");
        }
    }

    private class oneButton implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            screen.setText(screen.getText()+ "1");
        }
    }

    private class twoButton implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            screen.setText(screen.getText()+ "2");
        }
    }

    private class threeButton implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            screen.setText(screen.getText()+ "3");
        }
    }

    private class fourButton implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            screen.setText(screen.getText()+ "4");
        }
    }

    private class fiveButton implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            screen.setText(screen.getText()+ "5");
        }
    }

    private class sixButton implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            screen.setText(screen.getText()+ "6");
        }
    }

    private class sevenButton implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            screen.setText(screen.getText()+ "7");
        }
    }

    private class eightButton implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            screen.setText(screen.getText()+ "8");
        }
    }

    private class nineButton implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            screen.setText(screen.getText()+ "9");
        }
    }

    //-------------------------------------- operations ----------------------------------------------

    private class addButton implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            firstnum = (Double.parseDouble(screen.getText()));
            screen.setText("");
            operations = "+";
        }
    }

    private class subtractButton implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            firstnum = (Double.parseDouble(screen.getText()));
            screen.setText("");
            operations = "-";
        }
    }

    private class multiplyButton implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            firstnum = (Double.parseDouble(screen.getText()));
            screen.setText("");
            operations = "*";
        }
    }

    private class divisionButton implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            firstnum = (Double.parseDouble(screen.getText()));
            screen.setText("");
            operations = "/";
        }
    }

    private class percentButton implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            firstnum = (Double.parseDouble(screen.getText()));
            screen.setText("");
            operations = "%";
        }
    }

    //------------------------------------------ equals --------------------------------------------------

    private class equalsButton implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            secondnum = Double.parseDouble(screen.getText());

            if (operations == "+") {
                total = BigDecimal.valueOf(firstnum + secondnum);
                answer = String.format("%.2f", total);
                screen.setText(answer);
            } else if (operations == "-") {
                total = BigDecimal.valueOf(firstnum - secondnum);
                answer = String.format("%.2f", total);
                screen.setText(answer);
            } else if (operations == "*") {
                total = BigDecimal.valueOf(firstnum * secondnum);
                answer = String.format("%.2f", total);
                screen.setText(answer);
            } else if (operations == "/") {
                total = BigDecimal.valueOf(firstnum / secondnum);
                answer = String.format("%.2f", total);
                screen.setText(answer);
            } else if (operations == "%") {
                total = BigDecimal.valueOf(firstnum % secondnum);
                answer = String.format("%.2f", total);
                screen.setText(answer);
            }
        }
    }

    //------------------------------------------ main --------------------------------------------------

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    MiniCalculator window = new MiniCalculator();
                    window.frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

}
