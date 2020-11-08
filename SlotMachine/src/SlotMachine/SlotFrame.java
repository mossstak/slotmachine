package SlotMachine;

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;

public class SlotFrame extends Thread implements ActionListener {

    private Symbol symbol;
    private Reel Reel;
    private static SlotFrame mainThread;
    int Credit = 0;

    private JButton btnAdd, btnBetOne, btnBetMax, btnSpin, btnReset, btnStatistic;
    private JPanel panel1, panel2, panel3, reel1, reel2, reel3;
    private JLabel label1, label2, label3, label4, label5, label6;
    private JLabel numberOfWin, numberOfLoss, numberOfMatch, betArea, creditArea, totalMoney, reelLeft, reelCenter, reelRight;

    String Amount = "10";

    int reelNo1 = 0, reelNo2 = 0, reelNo3 = 0, count = 0, spinned = 0, image1 = 1, image2 = 2, image3 = 0;
    int stopThread = 0, creditamountValue = 0, betAmount = 0;
    int matches = -1, winner = 0, loser = 0, imageValue = 0;
    int nowb = 0, nolb = 0;

    public static void main(String[] args) {
        mainThread = new SlotFrame();
    }

    public SlotFrame() {
        GUI();
        Reel = new Reel();
        symbol = new Symbol();
    }

    private void GUI() {
        JFrame frame = new JFrame("SLOT MACHINE");
        frame.setSize(720, 480);
//                frame.setResizable(false);
        JPanel BGPanel = new JPanel();
        frame.getContentPane().add(BGPanel, BorderLayout.CENTER);
        BGPanel.setLayout(new BorderLayout(0, 0));

        JMenuBar menubar = new JMenuBar();
        frame.setJMenuBar(menubar);

        JMenu File = new JMenu("File");
        menubar.add(File);
        JMenuItem Exit = new JMenuItem("Exit");
        File.add(Exit);

        class Exitaction implements ActionListener {

            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        }
        Exit.addActionListener(new Exitaction());

        panel1 = new JPanel(new GridLayout(1, 2, 2, 0));
        panel1.setPreferredSize(new Dimension(100, 100));
        panel1.setBackground(Color.DARK_GRAY);
        BGPanel.add(panel1, BorderLayout.SOUTH);

        label1 = new JLabel("Number of Wins");
        numberOfWin = new JLabel("0");
        
        label2 = new JLabel("Number of Loss");
        numberOfLoss = new JLabel("0");

        label3 = new JLabel("Number of Match");
        numberOfMatch = new JLabel("0");

        label4 = new JLabel("Bet Area");
        betArea = new JLabel("0");
        betArea.setForeground(Color.WHITE);
        label4.setForeground(Color.WHITE);
        panel1.add(label4);
        panel1.add(betArea);

        label5 = new JLabel("Credit Area");
        creditArea = new JLabel("0");
        creditArea.setForeground(Color.WHITE);
        label5.setForeground(Color.WHITE);
        panel1.add(label5);
        panel1.add(creditArea);
        creditArea.setText("10");

        label6 = new JLabel("Amount");
        totalMoney = new JLabel("0");
        totalMoney.setText(Amount);

        panel1 = new JPanel();
        BGPanel.add(panel1, BorderLayout.CENTER);
        panel1.setPreferredSize(new Dimension(20, 20));
        panel1.setBackground(Color.WHITE);
        panel1.setLayout(new BorderLayout(0, 0));

        panel2 = new JPanel(new GridLayout(1, 2, 2, 0));
        panel1.add(panel2, BorderLayout.CENTER);
        panel2.setPreferredSize(new Dimension(200, 200));
        panel2.setBackground(Color.WHITE);

        btnAdd = new JButton("Add Coin");
        panel2.add(btnAdd);
        panel2.setBackground(Color.DARK_GRAY);
        btnAdd.addActionListener(this);

        btnBetOne = new JButton("Bet One");
        panel2.add(btnBetOne);
        btnBetOne.addActionListener(this);

        btnBetMax = new JButton("Bet Max");
        panel2.add(btnBetMax);
        btnBetMax.addActionListener(this);

        btnSpin = new JButton("Spin");
        panel2.add(btnSpin);
        btnSpin.addActionListener(this);

        btnReset = new JButton("Reset");
        panel2.add(btnReset);
        btnReset.addActionListener(this);

        btnStatistic = new JButton("Statistic Button");
        panel2.add(btnStatistic);
        btnStatistic.addActionListener(this);

        panel3 = new JPanel(new GridLayout(1, 2, 2, 0));
        panel3.setBackground(Color.DARK_GRAY);
        panel3.setPreferredSize(new Dimension(400, 200));
        panel1.add(panel3, BorderLayout.NORTH);

        reel1 = new JPanel(new GridLayout(1, 2, 2, 0));
        reel1.setBackground(Color.DARK_GRAY);
        panel3.add(reel1);
        reelLeft = new JLabel();
        reel1.add(reelLeft);

        reel1.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                mainThread.suspend();
                reelImageCompare();
                stopThread = 0;

            }

        });

        reel2 = new JPanel(new GridLayout(1, 2, 2, 0));
        reel2.setBackground(Color.DARK_GRAY);
        panel3.add(reel2);
        reelCenter = new JLabel();
        reel2.add(reelCenter);

        reel2.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                mainThread.suspend();
                reelImageCompare();
                stopThread = 0;

            }
        });

        reel3 = new JPanel(new GridLayout(1, 2, 2, 0));
        reel3.setBackground(Color.DARK_GRAY);
        panel3.add(reel3);
        reelRight = new JLabel();
        reel3.add(reelRight);

        reel3.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                mainThread.suspend();
                reelImageCompare();
                stopThread = 0;

            }
        });
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

    }

    public void run() {
        displayReel();
    }

    public void displayReel() {
        for (int i = 0;; i++) {
            Random number1 = new Random();
            Random number2 = new Random();
            Random number3 = new Random();
            reelNo1 = number1.nextInt(5 - 0 + 1) + 0;
            reelNo2 = number2.nextInt(5 - 0 + 1) + 0;
            reelNo3 = number3.nextInt(5 - 0 + 1) + 0;
            reelLeft.setIcon(new ImageIcon(Reel.spin(reelNo1)));
            reelCenter.setIcon(new ImageIcon(Reel.spin(reelNo2)));
            reelRight.setIcon(new ImageIcon(Reel.spin(reelNo3)));

            image1 = reelNo1;
            image2 = reelNo2;
            image3 = reelNo3;
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
            }
        }
    }

    public void reelImageCompare() {
        if (stopThread == 1) {

            if (symbol.compare(image1, image2, image3, count) == 2) {
                winner++;
                numberOfWin.setText(Integer.toString(winner));

                imageValue = Reel.reelImageValue(image2);
                int abc = imageValue;
                int bet = Integer.parseInt(betArea.getText());
                abc = abc * bet;
                count = 1;
                betArea.setText("0");
                JOptionPane.showMessageDialog(null, " Well Done " + "You Get: " + abc + " Credits ");
                int cA = Integer.parseInt(creditArea.getText());
                cA = cA + abc;
                creditArea.setText(Integer.toString(cA));
                nowb++;
            } if (symbol.compare(image1, image2, image3, count) == 3) {
                winner++;
                count = 1;
                numberOfWin.setText(Integer.toString(winner));

                imageValue = Reel.reelImageValue(image2);
                int abc1 = 3 * imageValue;
                int bet = Integer.parseInt(betArea.getText());
                abc1 = abc1 * bet;
                JOptionPane.showMessageDialog(null, " You Win " + "You Get: " + abc1 + " Credits ");
                betArea.setText("0");
                int cA = Integer.parseInt(creditArea.getText());
                cA = cA + abc1;
                creditArea.setText(Integer.toString(cA));
                nowb++;
            } if (symbol.compare(image1, image2, image3, count) == 2) {
                winner++;
                numberOfWin.setText(Integer.toString(winner));

                imageValue = Reel.reelImageValue(image1);
                int abc2 = imageValue;
                count = 1;
                int bet = Integer.parseInt(betArea.getText());
                abc2 = abc2 * bet;
                JOptionPane.showMessageDialog(null, " Yes! " + "You Get: " + abc2 + " Credits ");
                betArea.setText("0");
                int cA = Integer.parseInt(creditArea.getText());
                cA = cA + abc2;
                creditArea.setText(Integer.toString(cA));
                nowb++;
            } if (symbol.compare(image1, image2, image3, count) == 2) {
                winner++;
                numberOfWin.setText(Integer.toString(winner));

                imageValue = Reel.reelImageValue(image2);
                int abc3 = imageValue;
                count = 1;
                int bet = Integer.parseInt(betArea.getText());
                abc3 = abc3 * bet;
                JOptionPane.showMessageDialog(null, " You've Won " + "You Get: " + abc3 + " Credits ");
                betArea.setText("0");
                int cA = Integer.parseInt(creditArea.getText());
                cA = cA + abc3;
                creditArea.setText(Integer.toString(cA));
                nowb++;
            } if (image1 != image2 && image1 != image3 && image3 != image2) {
                loser++;
                numberOfLoss.setText(Integer.toString(loser));
                JOptionPane.showMessageDialog(null, " MEH, YOU LOSE, TRY AGAIN ");
                betArea.setText("0");
                nolb++;
            }
            count = 0;
            btnReset.setEnabled(true);
            btnStatistic.setEnabled(true);
            btnSpin.setEnabled(true);
        }
        
    }

    @Override
    public void actionPerformed(ActionEvent abc) {

        if (abc.getSource() == btnAdd) {
            Credit = Credit + 1;
            if (Credit == 5) {

                creditArea.setText("15");
//              Credit = 0;
            } else {
                creditamountValue = Integer.parseInt(creditArea.getText());
                creditamountValue = creditamountValue + 1;
                creditArea.setText(Integer.toString(creditamountValue));

                creditamountValue = 0;
            }
        }

        if (abc.getSource() == btnBetOne) {
            Credit = 0;
            int credAmount = Integer.parseInt(creditArea.getText());
            if (Integer.parseInt(creditArea.getText()) >= 3) {
                credAmount = credAmount - 1;
                betAmount = betAmount + 1;
                creditArea.setText(Integer.toString(credAmount));
                betArea.setText(Integer.toString(betAmount));
            } else {
                //When Credit is less than 3 Error Message Pop's up
                JOptionPane.showMessageDialog(null, "Not enough credits");
            }
        }

        if (abc.getSource() == btnBetMax) {
            Credit = 0;
            int credAmount = Integer.parseInt(creditArea.getText());
            //Bet Max can only be pressed once per game
            if (betAmount != 0) {
                JOptionPane.showMessageDialog(null, "Bet MAX can only be Pressed Once");
            } else if (Integer.parseInt(creditArea.getText()) >= 3) {
                credAmount = credAmount - 3;
                betAmount = betAmount + 3;
                creditArea.setText(Integer.toString(credAmount));
                betArea.setText(Integer.toString(betAmount));
                // When Credit is below 3, The game cannot be played
            } else {
                JOptionPane.showMessageDialog(null, "Not enough credits");
            }
        }

        if (abc.getSource() == btnStatistic) {
            Credit = 0;
            StatisticFrame window = new StatisticFrame(numberOfWin.getText(), numberOfLoss.getText(), nowb, nolb, numberOfMatch.getText(),
                    totalMoney.getText());
            window.setVisible(true);
        }

        if (abc.getSource() == btnReset) {
            //This resets the Credit to 15
            Credit = 15;
            int be = Integer.parseInt(betArea.getText());
            System.out.println(be);
            int credit = Integer.parseInt(creditArea.getText());
            credit = credit + be;
            System.out.println(credit);
            creditArea.setText(Integer.toString(Credit));
            betAmount = 0;
            betArea.setText(Integer.toString(0));
            btnBetMax.setEnabled(true);
        }

        if (abc.getSource() == btnSpin) {
            Credit = 0;
            int bet = Integer.parseInt(betArea.getText());
            if (bet > 0) {
                if (spinned == 0) {
                    mainThread.start();
                    spinned = 1;
                    numberOfMatch.setText(Integer.toString(++matches));
                }
                if (spinned > 0) {
                    mainThread.resume();
                    matches++;
                    numberOfMatch.setText(Integer.toString(matches));

                }

                stopThread = 1;
                //the BetAmount is reset to 0 when the reel is spunned.
                betAmount = 0;
                btnReset.setEnabled(false);
                btnStatistic.setEnabled(false);
                btnSpin.setEnabled(false);
            } else {
                //Game cannot be played, if the bet hasn't been put down.
                JOptionPane.showMessageDialog(null, "You can't play, if you don't bet");
            }
        }
    }

}
