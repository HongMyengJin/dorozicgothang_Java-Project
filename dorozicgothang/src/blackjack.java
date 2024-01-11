import java.io.File;
import javax.sound.sampled.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


class MyPanel extends JPanel {
   private ImageIcon icon = new ImageIcon("cards/table.jpg");
   private Image img = icon.getImage(); 
   public void paintComponent(Graphics g) {
      super.paintComponent(g);
      g.drawImage(img, 0, 0, getWidth(), getHeight(), this);

   }
}


public class blackjack extends JFrame implements ActionListener{

   public String[] cardObj = new String[20]; // 카드 종류
   public int cardObjn = 0;
   public Player player1 = new Player("player");
   public Player player2 = new Player("player2");
   public Player player3 = new Player("player3");
   public Player dealer = new Player("dealer");
   
   private JButton jbtn5_1 = new JButton("5만");
   private JButton jbtn1_1 = new JButton("1만");
   private JButton jbtn5_2 = new JButton("5만");
   private JButton jbtn1_2 = new JButton("1만");
   private JButton jbtn5_3 = new JButton("5만");
   private JButton jbtn1_3 = new JButton("1만");           
   private JButton jbtnDeal = new JButton("Deal");
   private JButton jbtnAgain = new JButton("Again");
   
   
   
   private JLabel[] cardNumber_player1 = new JLabel[5];
   private JLabel[] cardNumber_player2 = new JLabel[5];
   private JLabel[] cardNumber_player3 = new JLabel[5];
   private JLabel[] cardNumber_dealer = new JLabel[5];

   

   
   private JLabel jlblBetMoney = new JLabel("0만");
   private JLabel jlblBetMoney_2 = new JLabel("0만");
   private JLabel jlblBetMoney_3 = new JLabel("0만");
   private JLabel jlblPlayerMoney = new JLabel("1000만");
   private JLabel jlblPlayerPts = new JLabel("");
   private JLabel jlblDealerPts = new JLabel("");
   private JLabel jlblStatus = new JLabel(" ");
       
   private Font fontstyle = new Font("Times",Font.BOLD,26);
   private Font fontstyle2 = new Font("Times",Font.BOLD,16);
   private Font fontstyle3 = new Font("Times",Font.BOLD,16);
   private Font fontstyle4 = new Font("Times",Font.BOLD,19);
   
   private int card_n = 0;
   private int nCardsDealer = 0;
   private int betMoney_1 = 0;
   private int betMoney_2 = 0;
   private int betMoney_3 = 0;
   private int playerMoney = 1000;//초기자본 1000달러
   private JLabel[] jlblCardsPlayer1 = new JLabel[7];
   private JLabel[] jlblCardsPlayer2 = new JLabel[7];
   private JLabel[] jlblCardsPlayer3 = new JLabel[7];
   private JLabel[] jlblCardsDealer = new JLabel[7];
   
   
   private JLabel Player1_Made = new JLabel("");
   private JLabel Player2_Made = new JLabel(" ");
   private JLabel Player3_Made = new JLabel("");
   private JLabel Dealer_Made = new JLabel(" ");
   
   private JLabel Player1_WL = new JLabel("");
   private JLabel Player2_WL = new JLabel(" ");
   private JLabel Player3_WL = new JLabel("");
   
   MyPanel tablePanel = new MyPanel();
   private Clip chipclip, flipclip, againclip, winclip,loseclip;
   
   blackjack(){
      setupSound();
      JFrame gameFrame = new JFrame("dorijicgothang");
      gameFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      tablePanel.setLayout(null);
       jbtn5_1.setBounds(30,500,70,40);
       jbtn1_1.setBounds(110,500,70,40);
       jbtn5_2.setBounds(220,500,70,40);
       jbtn1_2.setBounds(300,500,70,40);
       jbtn5_3.setBounds(400,500,70,40);
       jbtn1_3.setBounds(480,500,70,40);
       jbtnDeal.setBounds(620,500,70,40);
       jbtnAgain.setBounds(700,500,70,40);
           
       for(int i = 0; i < 5; i++)
       {
    	   cardNumber_player1[i] =new JLabel(" ");
    	   cardNumber_player2[i] =new JLabel(" ");
    	   cardNumber_player3[i] =new JLabel(" ");
    	   cardNumber_dealer[i] =new JLabel(" ");
       }
       
       for(int i = 0; i < 5; i++)
       {
    	  
	       cardNumber_player1[i].setBounds(50 + i * 38, 300,100,50);
	       cardNumber_player1[i].setFont(fontstyle3);
	       cardNumber_player1[i].setForeground(Color.WHITE);
	       tablePanel.add(cardNumber_player1[i]);
       
	       cardNumber_player2[i].setBounds(240 + i * 38,300,100,50);
	       cardNumber_player2[i].setFont(fontstyle3);
	       cardNumber_player2[i].setForeground(Color.WHITE);
	       tablePanel.add(cardNumber_player2[i]);
	       
       
	       cardNumber_player3[i].setBounds(430 + i * 38,300,100,50);
	       cardNumber_player3[i].setFont(fontstyle3);
	       cardNumber_player3[i].setForeground(Color.WHITE);
	       tablePanel.add(cardNumber_player3[i]);
       
	       cardNumber_dealer[i].setBounds(290 + i * 38,100,100,50);
	       cardNumber_dealer[i].setFont(fontstyle3);
	       cardNumber_dealer[i].setForeground(Color.WHITE);
	       tablePanel.add(cardNumber_dealer[i]);
	       
	       
       }

       Player1_Made.setBounds(50,270,200,50);
       Player1_Made.setFont(fontstyle4);
       Player1_Made.setForeground(Color.BLUE);///////////////////////////////////////////////////
       tablePanel.add(Player1_Made);
       
       Player2_Made.setBounds(240,270,200,50);
       Player2_Made.setFont(fontstyle4);
       Player2_Made.setForeground(Color.BLUE);////////////////////////////////////////////////
       tablePanel.add(Player2_Made);
       
       Player3_Made.setBounds(430,270,200,50);
       Player3_Made.setFont(fontstyle4);
       Player3_Made.setForeground(Color.BLUE);//////////////////////////////////////////////
       tablePanel.add(Player3_Made);
       
       Dealer_Made.setBounds(280,80,200,50);
       Dealer_Made.setFont(fontstyle4);
       Dealer_Made.setForeground(Color.BLUE);
       tablePanel.add(Dealer_Made);
       
       Player1_WL.setBounds(50,240,200,50);
       Player1_WL.setFont(fontstyle);
       Player1_WL.setForeground(Color.RED);
       tablePanel.add( Player1_WL);
       
       Player2_WL.setBounds(240,240,200,50);
       Player2_WL.setFont(fontstyle);
       Player2_WL.setForeground(Color.RED);
       tablePanel.add( Player2_WL);
       
       Player3_WL.setBounds(430,240,200,50);
       Player3_WL.setFont(fontstyle);
       Player3_WL.setForeground(Color.RED);
       tablePanel.add( Player3_WL);
       
       
        jlblBetMoney.setBounds(90,450,100,50);
        jlblBetMoney.setFont(fontstyle);
        jlblBetMoney.setForeground(Color.ORANGE);
        tablePanel.add(jlblBetMoney);
        
        jlblBetMoney_2.setBounds(280,450,100,50);
        jlblBetMoney_2.setFont(fontstyle);
        jlblBetMoney_2.setForeground(Color.ORANGE);
        tablePanel.add(jlblBetMoney_2);
        
        jlblBetMoney_3.setBounds(470,450,100,50);
        jlblBetMoney_3.setFont(fontstyle);
        jlblBetMoney_3.setForeground(Color.ORANGE);
        tablePanel.add(jlblBetMoney_3);
        
        jlblPlayerMoney.setBounds(700,450,200,50);
        jlblPlayerMoney.setFont(fontstyle);
        jlblPlayerMoney.setForeground(Color.ORANGE);
        tablePanel.add(jlblPlayerMoney);
        

        
        jlblDealerPts.setBounds(300,100,100,50);
        jlblDealerPts.setFont(fontstyle2);
        jlblDealerPts.setForeground(Color.WHITE);
        tablePanel.add(jlblDealerPts);
        
        jlblStatus.setBounds(500,300,200,50);
        jlblStatus.setFont(fontstyle);
        jlblStatus.setForeground(Color.WHITE);
        tablePanel.add(jlblStatus);

       tablePanel.add(jbtn5_1);
       tablePanel.add(jbtn1_1);
       tablePanel.add(jbtn1_2);
       tablePanel.add(jbtn5_2);
       tablePanel.add(jbtn1_3);
       tablePanel.add(jbtn5_3);
       tablePanel.add(jbtnDeal);
       tablePanel.add(jbtnAgain);

       
       jbtn5_1.addActionListener(this);
       jbtn5_2.addActionListener(this);
       jbtn1_1.addActionListener(this);
       jbtn1_2.addActionListener(this);
       jbtn1_3.addActionListener(this);
       jbtn5_3.addActionListener(this);
       
       jbtnDeal.addActionListener(this);
       jbtnAgain.addActionListener(this);
       
       
       
       jbtn5_1.setEnabled(false);
       jbtn1_1.setEnabled(false);
       jbtn5_2.setEnabled(false);
       jbtn1_2.setEnabled(false);
       jbtn5_3.setEnabled(false);
       jbtn1_3.setEnabled(false);

       jbtnAgain.setEnabled(false);
           
      gameFrame.add(tablePanel);
      gameFrame.setSize(800,600);
      gameFrame.setVisible(true);
   }


   private void setupSound() {
      String flipSound="sounds/cardFlip1.wav";
      try {
         AudioInputStream flipAudioInputStream =
               AudioSystem.getAudioInputStream(new File(flipSound));
         flipclip = AudioSystem.getClip();
         flipclip.open(flipAudioInputStream);
      }
      catch(Exception e) {
         System.out.println(e);
      }
      String chipSound="sounds/chip.wav";
      try {
         AudioInputStream chipAudioInputStream =
               AudioSystem.getAudioInputStream(new File(chipSound));
         chipclip = AudioSystem.getClip();
         chipclip.open(chipAudioInputStream);
      }
      catch(Exception e) {
         System.out.println(e);
      }

      String loseSound="sounds/wrong.wav";
      try {
         AudioInputStream loseAudioInputStream =
               AudioSystem.getAudioInputStream(new File(loseSound));
         loseclip = AudioSystem.getClip();
         loseclip.open(loseAudioInputStream);
      }
      catch(Exception e) {
         System.out.println(e);
      }

      String againSound="sounds/ding.wav";
      try {
         AudioInputStream againAudioInputStream =
               AudioSystem.getAudioInputStream(new File(againSound));
         againclip = AudioSystem.getClip();
         againclip.open(againAudioInputStream);
      }
      catch(Exception e) {
         System.out.println(e);
      }

      String winSound="sounds/win.wav";
      try {
         AudioInputStream winAudioInputStream =
               AudioSystem.getAudioInputStream(new File(winSound));
         winclip = AudioSystem.getClip();
         winclip.open(winAudioInputStream);
      }
      catch(Exception e) {
         System.out.println(e);
      }

   }
   private void hitPlayer(int n) {
	   
	  
      Card newCard = new Card();
      while(true)
      {
    	  int same = 0;
	      for(int i = 0; i < cardObjn; i++)
		   {
			   if(cardObj[i].equals(newCard.filename()))
			   {
				   same = 1;
			   }
		   }
	      if(same == 0)
	      {
	    	  cardObj[cardObjn] = newCard.filename();
	    	  cardObjn++;
	    	  break;
	      }
	      newCard = new Card();
      }
      
      player1.addCard(newCard);
      jlblCardsPlayer1[player1.inHand()-1] = 
            new JLabel(new ImageIcon("cards/"+newCard.filename()));
      jlblCardsPlayer1[player1.inHand()-1].setBounds(40+n*30,350, 80, 100);
      tablePanel.add(jlblCardsPlayer1[player1.inHand()-1]);
      
    
      Card newCard2 = new Card();
      while(true)
      {
    	  int same = 0;
	      for(int i = 0; i < cardObjn; i++)
		   {
			   if(cardObj[i].equals(newCard2.filename()))
			   {
				   same = 1;
			   }
		   }
	      if(same == 0)
	      {
	    	  cardObj[cardObjn] = newCard2.filename();
	    	  cardObjn++;
	    	  break;
	      }
	      newCard2 = new Card();
      }
      player2.addCard(newCard2);
      jlblCardsPlayer2[player2.inHand()-1] = 
            new JLabel(new ImageIcon("cards/"+newCard2.filename()));
      jlblCardsPlayer2[player2.inHand()-1].setBounds(230+n*30,350, 80, 100);
      tablePanel.add(jlblCardsPlayer2[player2.inHand()-1]);
      
      Card newCard3 = new Card();
      while(true)
      {
    	  int same = 0;
	      for(int i = 0; i < cardObjn; i++)
		   {
			   if(cardObj[i].equals(newCard3.filename()))
			   {
				   same = 1;
			   }
		   }
	      if(same == 0)
	      {
	    	  cardObj[cardObjn] = newCard3.filename();
	    	  cardObjn++;
	    	  break;
	      }
	      newCard3 = new Card();
      }
      player3.addCard(newCard3);
      jlblCardsPlayer3[player3.inHand()-1] = 
            new JLabel(new ImageIcon("cards/"+newCard3.filename()));
      jlblCardsPlayer3[player3.inHand()-1].setBounds(420+n*30,350, 80, 100);
      tablePanel.add(jlblCardsPlayer3[player3.inHand()-1]);
      
      tablePanel.updateUI();
      
      flipclip.stop();
      flipclip.setFramePosition(0);
      flipclip.start();
   }
   
   private void hitDealer(int n) {

	   Card newCard = new Card();
	   while(true)
	   {
	 	  int same = 0;
		      for(int i = 0; i < cardObjn; i++)
			   {
				   if(cardObj[i].equals(newCard.filename()))
				   {
					   same = 1;
				   }
			   }
		      if(same == 0)
		      {
		    	  cardObj[cardObjn] = newCard.filename();
		    	  cardObjn++;
		    	  break;
		      }
		      newCard = new Card();
	   }
	   dealer.addCard(newCard);
	   jlblCardsDealer[dealer.inHand()-1] = 
	         new JLabel(new ImageIcon("cards/"+ newCard.filename()));
	   jlblCardsDealer[dealer.inHand()-1].setBounds(260+n*30,150,80,100);
	   tablePanel.add(jlblCardsDealer[dealer.inHand()-1]);
	   //jlblPlayerPts.setText(""+dealer.value());
	   
   for(int i = 0; i < dealer.inHand(); i++)
   {
	   tablePanel.remove(jlblCardsDealer[i]); // redraw dealer's first card!
	   jlblCardsDealer[i] = new JLabel(new ImageIcon("cards/" + dealer.cards[i].filename()));
	   jlblCardsDealer[i].setBounds(260+i*30,150,80,100);
	   tablePanel.add(jlblCardsDealer[i]);
   }
   
 


   
   tablePanel.updateUI();
   
   } 
   
   private void hitDealerDown(int n) {
      Card newCard = new Card(); 
      dealer.addCard(newCard); 
      while(true)
      {
    	  int same = 0;
	      for(int i = 0; i < cardObjn; i++)
		   {
			   if(cardObj[i].equals(newCard.filename()))
			   {
				   same = 1;
			   }
		   }
	      if(same == 0)
	      {
	    	  cardObj[cardObjn] = newCard.filename();
	    	  cardObjn++;
	    	  break;
	      }
	      newCard = new Card();
      }
      jlblCardsDealer[dealer.inHand()-1] = new JLabel(new
      ImageIcon("cards/cardback.jpg"));
      jlblCardsDealer[dealer.inHand()-1].setBounds(260+n*30,150,80,100);
      tablePanel.add(jlblCardsDealer[dealer.inHand()-1]); 
      
      
      
      
      tablePanel.updateUI();
      
      
      
      }


      private void checkWinner() { 
         player1.value();
         player2.value();
         player3.value();
         dealer.value();
         Player1_Made.setText(player1.outresult());
         Player2_Made.setText(player2.outresult());
         Player3_Made.setText(player3.outresult());
         Dealer_Made.setText(dealer.outresult());
         
         int Win = 0;
         if(player1.result_value() == 0 || player1.result_value() <= dealer.result_value())
         {
             Player1_WL.setText("패");
             
         }
         else
         {
        	 Player1_WL.setText("승");
        	 playerMoney += betMoney_1 * 2;
        	 Win = 1;
        	 
         }
         if(player2.result_value() == 0 || player2.result_value() <= dealer.result_value())
         {
             Player2_WL.setText("패");
         }
         else
         {
        	 Player2_WL.setText("승");
        	 playerMoney += betMoney_2 * 2;
        	 Win = 1;
         }
         if(player3.result_value() == 0 || player3.result_value() <= dealer.result_value())
         {
             Player3_WL.setText("패");
         }
         else
         {
        	 Player3_WL.setText("승");
        	 playerMoney += betMoney_3 * 2;
        	 Win = 1;
         }      
         tablePanel.updateUI(); 
         
         if(Win == 1)
         {
        	   winclip.stop();
        	   winclip.setFramePosition(0); 
        	   winclip.start();
         }
         else
         {
           loseclip.stop();
       	   loseclip.setFramePosition(0); 
       	   loseclip.start();
         }
         }

   public void actionPerformed(ActionEvent e) {
    
      
      if (e.getSource()==jbtnDeal) {
    	 if(card_n == 0)
    	 {
	         hitPlayer(card_n); // 1개
	         
	         hitDealerDown(nCardsDealer);
	         card_n++;
	         nCardsDealer++;
	         
	         jbtn5_1.setEnabled(true);
	         jbtn1_1.setEnabled(true);
	         jbtn5_2.setEnabled(true);
	         jbtn1_2.setEnabled(true);
	         jbtn5_3.setEnabled(true);
	         jbtn1_3.setEnabled(true);

	         jbtnDeal.setEnabled(false);
	         jbtnAgain.setEnabled(false);
	         
	         
	         cardNumber_player1[card_n -1].setText(player1.cards[card_n- 1].getValue() + "");
	         cardNumber_player2[card_n- 1].setText(player2.cards[card_n- 1].getValue() + "");
	         cardNumber_player3[card_n- 1].setText(player3.cards[card_n- 1].getValue() + "");
	         
    	 }
    	 else
    	 {
    		 if(card_n == 4)
    		 {

    			 hitDealer(nCardsDealer);
    			 hitPlayer(card_n);
    	         //hitDealer(nCardsDealer);
    	         
    			 jbtn5_1.setEnabled(false);
    	         jbtn1_1.setEnabled(false);
    	         jbtn5_2.setEnabled(false);
    	         jbtn1_2.setEnabled(false);
    	         jbtn5_3.setEnabled(false);
    	         jbtn1_3.setEnabled(false);

    	         jbtnDeal.setEnabled(false);
    	         jbtnAgain.setEnabled(true);
    	         
    	         card_n++;
    	         nCardsDealer++;
    	         
    	         cardNumber_player1[card_n -1].setText(player1.cards[card_n- 1].getValue() + "");
    	         cardNumber_player2[card_n- 1].setText(player2.cards[card_n- 1].getValue() + "");
    	         cardNumber_player3[card_n- 1].setText(player3.cards[card_n- 1].getValue() + "");
    	         
    	         jlblBetMoney.setText(betMoney_1 + "만");
    	         for(int i = 0; i < nCardsDealer; i++)
    	         {
        	         cardNumber_dealer[i].setText(dealer.cards[i].getValue() + "");
    	         }
    	         
    	         checkWinner();


    	      
    		 }
    		 else
    		 {
	    		 for(int j = 0; j < 3; j++)
	    		 {
		    		 hitPlayer(card_n);
			         hitDealerDown(nCardsDealer);
			         nCardsDealer++;
			         card_n++;
			         
		    		 jbtn5_1.setEnabled(true);
		             jbtn1_1.setEnabled(true);
		             jbtn5_2.setEnabled(true);
		             jbtn1_2.setEnabled(true);
		             jbtn5_3.setEnabled(true);
		             jbtn1_3.setEnabled(true);

		             jbtnDeal.setEnabled(false);
		             jbtnAgain.setEnabled(false);
			         
			         cardNumber_player1[card_n -1].setText(player1.cards[card_n- 1].getValue() + "");
			         cardNumber_player2[card_n- 1].setText(player2.cards[card_n- 1].getValue() + "");
			         cardNumber_player3[card_n- 1].setText(player3.cards[card_n- 1].getValue() + "");
	    		 }
	    		 

    		 }
    	 }
         
      }
      if (e.getSource()==jbtn5_1) {
         betMoney_1 += 5;
         playerMoney -= 5;
         if (playerMoney < 0) {
            betMoney_1 -= 5;
            playerMoney +=5;
         }
         jlblPlayerMoney.setText(playerMoney + "만");
          jbtnDeal.setEnabled(true);
          
         chipclip.stop();
         chipclip.setFramePosition(0);
         chipclip.start();
      }
      if (e.getSource()==jbtn5_2) {
          betMoney_2 += 5;
          playerMoney -= 5;
          if (playerMoney < 0) {
             betMoney_2 -= 5;
             playerMoney +=5;
          }
          jlblPlayerMoney.setText(playerMoney + "만");
           jbtnDeal.setEnabled(true);
           
          chipclip.stop();
          chipclip.setFramePosition(0);
          chipclip.start();
       }
      if (e.getSource()==jbtn1_1) {
          betMoney_1 += 1;
          playerMoney -= 1;
          if (playerMoney < 0) {
             betMoney_1 -= 1;
             playerMoney +=1;
          }
          jlblPlayerMoney.setText(playerMoney + "만");
           jbtnDeal.setEnabled(true);
           
          chipclip.stop();
          chipclip.setFramePosition(0);
          chipclip.start();
       }
      if (e.getSource()==jbtn1_2) {
          betMoney_2 += 1;
          playerMoney -= 1;
          if (playerMoney < 0) {
             betMoney_2 -= 1;
             playerMoney +=1;
          }
          jlblPlayerMoney.setText(playerMoney + "만");
           jbtnDeal.setEnabled(true);
           
          chipclip.stop();
          chipclip.setFramePosition(0);
          chipclip.start();
       }
      
      if (e.getSource()==jbtn5_3) {
          betMoney_3 += 5;
          playerMoney -= 5;
          if (playerMoney < 0) {
             betMoney_3 -= 5;
             playerMoney +=5;
          }
          jlblPlayerMoney.setText(playerMoney + "만");
           jbtnDeal.setEnabled(true);
           
          chipclip.stop();
          chipclip.setFramePosition(0);
          chipclip.start();
       }
      if (e.getSource()==jbtn1_3) {
          betMoney_3 += 1;
          playerMoney -= 1;
          if (playerMoney < 0) {
             betMoney_3 -= 1;
             playerMoney +=1;
          }
          jlblPlayerMoney.setText(playerMoney + "만");
           jbtnDeal.setEnabled(true);
           
          chipclip.stop();
          chipclip.setFramePosition(0);
          chipclip.start();
       }
     
      jlblBetMoney.setText(betMoney_1 + "만");
      jlblBetMoney_2.setText(betMoney_2+ "만");
      jlblBetMoney_3.setText(betMoney_3+ "만");
      if (e.getSource()==jbtnAgain) {
    	  for(int j = 0; j < 3; j++)
    	  {
	         for (int i=0 ; i< card_n ; i++)
	         {
	          tablePanel.remove(jlblCardsPlayer1[i]);
	         tablePanel.remove(jlblCardsPlayer2[i]);
	         tablePanel.remove(jlblCardsPlayer3[i]);

	         }
    	  }
         for (int i=0 ; i < nCardsDealer ; i++)
            tablePanel.remove(jlblCardsDealer[i]);
         player1.reset();
         player2.reset();
         player3.reset();
         dealer.reset();
         jlblDealerPts.setText("");
         jlblPlayerPts.setText("");
         jlblStatus.setText("");    
         
         Player1_Made.setText("");
         Player2_Made.setText("");
         Player3_Made.setText("");
         Dealer_Made.setText("");
         
         Player1_WL.setText("");
         Player2_WL.setText("");
         Player3_WL.setText("");
         

         betMoney_1 = 0;
         betMoney_2 = 0;
         betMoney_3 = 0;
         



         
         jlblBetMoney.setText(betMoney_1 + "만");
         jlblBetMoney_2.setText(betMoney_2 + "만");
         jlblBetMoney_3.setText(betMoney_3 + "만");
         
         for(int i = 0; i < 5; i++)
         {
        	 cardNumber_player1[i].setText("");
        	 cardNumber_player2[i].setText("");
        	 cardNumber_player3[i].setText("");
        	 cardNumber_dealer[i].setText("");
         }
         card_n = 0;
         cardObjn = 0;
         nCardsDealer = 0;
         jbtn5_1.setEnabled(true); 
         jbtn1_1.setEnabled(true);
         jbtn5_2.setEnabled(true); 
         jbtn1_2.setEnabled(true);
         jbtn5_3.setEnabled(true); 
         jbtn1_3.setEnabled(true);
         jbtnDeal.setEnabled(false);
         jbtnAgain.setEnabled(false);
         againclip.stop();
         againclip.setFramePosition(0);
         againclip.start();
         
         jlblPlayerMoney.setText(playerMoney + "만");
         
         tablePanel.updateUI();
       
      }
   }
   public static void main(String[] args) {
      new blackjack();
   }
}
