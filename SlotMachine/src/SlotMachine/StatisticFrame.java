/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SlotMachine;
import java.awt.event.*;
import java.io.*;
import java.text.SimpleDateFormat;
import java.time.*;
import java.time.format.*;
import java.util.Date;

import javax.swing.*;

public class StatisticFrame extends JFrame implements ActionListener {

	
	private static final long serialVersionUID = 1L;
	JLabel numberOfWin, numberOfLoss, totalWinBet, totalLossBet,totalNumberOfMatches, money;
	JButton writeData;
        Date date = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH-mm-ss");
	File statistic = new File(formatter.format(date) + ".txt");
	public StatisticFrame(String win, String loss, int wb, int lb, String matches, String money)
	{
		initialize(win, loss, wb, lb, matches, money);
	}

	private void initialize(String totalWin, String totalLoss, int winBet, int lossBet, String totalMatch, String totalMoney) {
		
		setBounds(100, 100, 600, 300);
		setLayout(null);
		setTitle("Game Statistics");
		
		writeData  = new JButton("Save to file");
		writeData.setBounds(250,150,250,40);
		writeData.addActionListener(this);
		
		numberOfWin = new JLabel();
		numberOfWin.setText("The total number of Wins: " +totalWin);
		numberOfWin.setBounds(10,20,250,40);
		add(numberOfWin);

		numberOfLoss = new JLabel("The total number of Losses: " + totalLoss);
		numberOfLoss.setBounds(10,70,250,40);
		add(numberOfLoss);

		totalWinBet = new JLabel("The total number of Spins: " + totalMatch);
		totalWinBet.setBounds(10,120,250,40);
		add(totalWinBet);

		totalLossBet = new JLabel("The average number of credits: " + (Integer.parseInt(totalMoney))/(Integer.parseInt(totalMoney)));
		totalLossBet.setBounds(10, 170, 250, 40);
		//add(totalLossBet);

		totalNumberOfMatches = new JLabel("Total Number Of Matches: " + totalMatch);
		totalNumberOfMatches.setBounds(10, 220,170,40);
		//add(totalNumberOfMatches);

		money = new JLabel("Money: $" + totalMoney);
		money.setBounds(10, 270, 150, 40);
		//add(money);
		
		add(writeData);
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource() == writeData)
		{
			LocalDate date = LocalDate.now();
			LocalTime time = LocalTime.now();
			
			try {				
					BufferedWriter bw = new BufferedWriter(new FileWriter(statistic));
					bw.write(numberOfLoss.getText()+"\n");
					bw.write(totalWinBet.getText()+"\n");
					bw.write(totalLossBet.getText()+"\n");
					bw.write(totalNumberOfMatches.getText()+"\n");
					bw.write(money.getText()+"\n");
					bw.write("Date: " +date+"\n");
					bw.write("Time: " +time+"\n");
					bw.close();
					JOptionPane.showMessageDialog(null,"Your file has been saved!");
					Thread.sleep(1000);
					setVisible(false);
				} catch (Exception ex) {}
			
		}
	}

}
