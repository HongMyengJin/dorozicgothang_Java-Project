public class Player {
   final static int MAX_CARDS = 40;
   public Card[] cards = new Card[MAX_CARDS];
   

   private int N = 0;
   private String name;
   private String Rank = "";
   private int[] Made = new int[3];
   private String Made_name = "";
   private int result;
   public Player(String name) {
      this.name = name;
   }
   public String outresult()
   {
	   return Made_name + Rank;
   }
   public int inHand() {
      return N; //�տ� �ִ� ī���� ����
   }
   public void addCard(Card c) {

      cards[N++] = c;
   }
   public void reset() {
      N=0;
      Rank = "";
      Made_name = "";
      result = 0;
      Made[0] = 0;
      Made[1] = 0;
      Made[2] = 0;
   }
   public int result_value()
   {
	   return result;
   }
  //10 8 2
   public void small(int n1, int n2, int n3){
   
	   if(n1 > n2)
	   {
		   if(n1 > n3)
		   {
			   Made[2] = n1;
			   if(n2 > n3)
			   {
				   Made[0] = n3;
				   Made[1] = n2;
			   }
			   else // n2 < n3
			   {
				   Made[0] = n2;
				   Made[1] = n3;
			   }
		   }
		   else //n1 < n3
		   {
			   Made[2] = n3;
			   
				   Made[0] = n2;
				   Made[1] = n1;

		   }
	   }
	   else // n1 < n2 
	   {
		   if(n2 > n3) 
		   {
			   Made[2] = n2;
			   if(n1 > n3)
			   {
				   Made[0] = n3;
				   Made[1] = n1;
			   }
			   else
			   {
				   Made[0] = n1;
				   Made[1] = n3;
			   }
			   
		   }
		   else // n2 < n3
		   {
			   Made[0] = n1;
			   Made[1] = n2;
			   Made[2] = n3;
		   }
	   }
	   
   }

   public void Made_name(int[] Made)
   {
	   
	   
	   if(Made[0] == 1 && Made[1] == 1 && Made[2] ==8)
	   {
		   Made_name =  "������(1 1 8) ";
	   }
	   else if(Made[0] == 1 && Made[1] == 2 && Made[2] ==7)
	   {
		   Made_name =  "�߸�ĥ(1 2 7) ";
	   }
	   else if(Made[0] == 1 && Made[1] == 3 && Made[2] ==6)
	   {
		   Made_name =  "������(1 3 6) ";
	   }
	   else if(Made[0] == 1 && Made[1] == 4 && Made[2] ==5)
	   {
		   Made_name =  "������(1 4 5) ";
	   }
	   else if(Made[0] == 1 && Made[1] == 9 && Made[2] ==10)
	   {
		   Made_name =  "�汸��(1 9 10) ";
	   }
	   else if(Made[0] == 2 && Made[1] == 2 && Made[2] ==6)
	   {
		   Made_name =  "�ϴ���(2 2 6) ";
	   }
	   else if(Made[0] == 2 && Made[1] == 3 && Made[2] ==5)
	   {
		   Made_name =  "�̻��(2 3 5) ";
	   }
	   else if(Made[0] == 2 && Made[1] == 8 && Made[2] ==10)
	   {
		   Made_name =  "������(2 8 10) ";
	   }
	   else if(Made[0] == 3 && Made[1] == 3 && Made[2] ==4)
	   {
		   Made_name =  "�ɽɻ�(3 3 4) ";
	   }
	   else if(Made[0] == 3 && Made[1] == 7 && Made[2] ==10)
	   {
		   Made_name =  "��ĥ��(3 7 10) ";
	   }
	   else if(Made[0] == 3 && Made[1] == 8 && Made[2] ==9)
	   {
		   Made_name =  "�����(3 8 9) ";
	   }
	   else if(Made[0] == 2 && Made[1] == 4 && Made[2] ==4)
	   {
		   Made_name =  "�����(4 4 2) ";
	   }
	   else if(Made[0] == 4 && Made[1] == 6 && Made[2] ==10)
	   {
		   Made_name =  "�����(4 6 10) ";
	   }
	   else if(Made[0] == 4 && Made[1] == 7 && Made[2] ==9)
	   {
		   Made_name =  "��ĥ��(4 7 9) ";
	   }
	   else if(Made[0] == 5 && Made[1] == 5 && Made[2] ==10)
	   {
		   Made_name =  "������(5 5 10) ";
	   }
	   else if(Made[0] == 5 && Made[1] == 6 && Made[2] ==9)
	   {
		   Made_name =  "������(5 6 9) ";
	   }
	   
	   else if(Made[0] == 5 && Made[1] == 7 && Made[2] ==8)
	   {
		   Made_name =  "������(5 7 8) ";
	   }
	   else if(Made[0] == 6 && Made[1] == 6 && Made[2] ==8)
	   {
		   Made_name =  "������(6 6 8) ";
	   }
	   else if(Made[0] == 6 && Made[1] == 7 && Made[2] ==7)
	   {
		   Made_name =  "öö��(7 7 6) ";
	   }
	   else if(Made[0] == 4 && Made[1] == 8 && Made[2] ==8)
	   {
		   Made_name =  "���Ž�(8 8 4) ";
	   }
	   else if(Made[0] == 2 && Made[1] == 9 && Made[2] ==9)
	   {
		   Made_name =  "������(9 9 2) ";
	   }
	   else
	   {
		   Made_name =  "����̵� ";
	   }

	   
   }
   public void value() { //���� ����ϴ� �޼ҵ�
	   if(N == 5)
	   {
	      result = 0; //����
	     
	       if((cards[0].getValue() + cards[1].getValue() + cards[2].getValue()) % 10 == 0)
		   {
	    	   if(result < Ranking(cards[3].getValue(), cards[4].getValue()))
	    	   {
	    		   small(cards[0].getValue() ,cards[1].getValue() ,cards[2].getValue());
	    		   Made_name(Made);
		    	   result = Ranking(cards[3].getValue(), cards[4].getValue());
		    	   Rank =  Ranking_S(cards[3].getValue(), cards[4].getValue());
	    	   
	    	   }
		   }
		   if((cards[0].getValue() + cards[1].getValue() + cards[3].getValue()) % 10 == 0)
		   {
			   if(result < Ranking(cards[2].getValue(), cards[4].getValue()))
	    	   {
				   small(cards[0].getValue() ,cards[1].getValue() ,cards[3].getValue());
				   Made_name(Made);
				   result = Ranking(cards[2].getValue(), cards[4].getValue());
				   Rank =  Ranking_S(cards[2].getValue(), cards[4].getValue());
	    	   }
		   }
		   if((cards[0].getValue() + cards[1].getValue() + cards[4].getValue()) % 10 == 0)
		   {
			   if(result < Ranking(cards[2].getValue(), cards[3].getValue()))
			   {
				   small(cards[0].getValue() ,cards[1].getValue() ,cards[4].getValue());
				   Made_name(Made);
				   result = Ranking(cards[2].getValue(), cards[3].getValue());
				   Rank =  Ranking_S(cards[2].getValue(), cards[3].getValue());
			   }
		   }
		   if((cards[0].getValue() + cards[2].getValue() + cards[3].getValue()) % 10 == 0)
		   {
			   if(result < Ranking(cards[1].getValue(), cards[4].getValue()))
			   {
				   small(cards[0].getValue() ,cards[2].getValue() ,cards[3].getValue());
				   Made_name(Made);
				   result = Ranking(cards[1].getValue(), cards[4].getValue());
				   Rank =  Ranking_S(cards[1].getValue(), cards[4].getValue());
			   }
		   }
		   if((cards[0].getValue() + cards[2].getValue() + cards[4].getValue()) % 10 == 0)
		   {
			   if(result < Ranking(cards[1].getValue(), cards[3].getValue()))
			   {
				   small(cards[0].getValue() ,cards[2].getValue() ,cards[4].getValue());
				   Made_name(Made);
				   result = Ranking(cards[1].getValue(), cards[3].getValue());
				   Rank =  Ranking_S(cards[1].getValue(), cards[3].getValue());
			   }
		   }
		   if((cards[0].getValue() + cards[3].getValue() + cards[4].getValue()) % 10 == 0)
		   {
			   if(result < Ranking(cards[1].getValue(), cards[2].getValue()))
			   {
				   small(cards[0].getValue() ,cards[3].getValue() ,cards[4].getValue());
				   Made_name(Made);
				   result = Ranking(cards[1].getValue(), cards[2].getValue());
				   Rank =  Ranking_S(cards[1].getValue(), cards[2].getValue());
			   }
		   }
		   if((cards[1].getValue() + cards[2].getValue() + cards[3].getValue()) % 10 == 0)
		   {
			   if(result < Ranking(cards[0].getValue(), cards[4].getValue()))
			   {
				   small(cards[1].getValue() ,cards[2].getValue() ,cards[3].getValue());
				   Made_name(Made);
				   result = Ranking(cards[0].getValue(), cards[4].getValue());
				   Rank =  Ranking_S(cards[0].getValue(), cards[4].getValue());
			   }
		   }
		   if((cards[1].getValue() + cards[2].getValue() + cards[4].getValue()) % 10 == 0)
		   {
			   if(result < Ranking(cards[0].getValue(), cards[3].getValue()))
			   {
				   small(cards[1].getValue() ,cards[2].getValue() ,cards[4].getValue());
				   Made_name(Made);
				   result = Ranking(cards[0].getValue(), cards[3].getValue());
				   Rank =  Ranking_S(cards[0].getValue(), cards[3].getValue());
			   }
		   }
		   if((cards[1].getValue() + cards[3].getValue() + cards[4].getValue()) % 10 == 0)
		   {
			   if(result < Ranking(cards[0].getValue(), cards[2].getValue()))
			   { 
				   small(cards[1].getValue() ,cards[3].getValue() ,cards[4].getValue());
				   Made_name(Made);
				   result = Ranking(cards[0].getValue(), cards[2].getValue());
				   Rank =  Ranking_S(cards[0].getValue(), cards[2].getValue());
			   }
		   }
		   if((cards[2].getValue() + cards[3].getValue() + cards[4].getValue()) % 10 == 0)
		   {
			   if(result < Ranking(cards[0].getValue(), cards[1].getValue()))
			   { 
				   small(cards[2].getValue() ,cards[3].getValue() ,cards[4].getValue());
				   Made_name(Made);
				   result = Ranking(cards[0].getValue(), cards[1].getValue());
				   Rank =  Ranking_S(cards[0].getValue(), cards[1].getValue());
			   }
		   }
		   if(result == 0)
		   {
			   Made_name = "����̵�";
		   }

	   }
	   

   }
   public int Ranking(int n1, int n2)
   {
	   if((n1 == 3 && n2 ==8) || (n2 == 3 && n1 ==8)) // 38���� -> 50��
	   {
		   return 50;
	   }
	   else if((n1 == 1 && n2 ==8) || (n2 == 8 && n1 ==1) || (n1 == 1 && n2 ==3) || (n2 == 3 && n1 ==1)) // 40��
	   {
		   return 40;
	   }
	   else if(n1 == n2)
	   {
		   for(int i = 1; i < 11; i++) // 30, 31, 32, 33, 34, 35, 36, 37, 38. 39
		   {
			   if(n1 == i)
			   {
			   return 29 + i;
			   }
		   } 
	   }
	   else if((n1 + n2) % 10 >= 1 && (n1 + n2) % 10 <= 9) // 20��
	   {
		   for(int i = 1; i < 10; i++) //11, 12, 13, 14, 15, 16, 17, 18, 19
		   {
			   if(((n1 + n2) % 10) == i)
			   {
				   return 10 + i;
			   }
		   } 
	   }
	   else if((n1 + n2) % 10 == 0) // 10��
	   {
		   return 10;
	   }

	   return 0;
   }
   
   public String Ranking_S(int n1, int n2)
   {
	   int n = Ranking(n1, n2);
	   if(n == 50)
	   {
		   return "38����";
	   }
	   else if (n == 40)
	   {
		   if(n1 == 1 || n1 ==8)
		   {
			   return "18����";
		   }
		   else
		   {
			   return "13����";
		   }
	   }
	   else if (n == 30)
	   {
		   return "�涯";
	   }
	   else if (n == 31)
	   {
		   return "�̶�";
	   }
	   else if (n == 32)
	   {
		   return "�ﶯ";
	   }
	   else if (n == 33)
	   {
		   return "�綯";
	   }
	   else if (n == 34)
	   {
		   return "����";
	   }
	   else if (n == 35)
	   {
		   return "����";
	   }
	   else if (n == 36)
	   {
		   return "ĥ��";
	   }
	   else if (n == 37)
	   {
		   return "�ȶ�";
	   }
	   else if (n == 38)
	   {
		   return "����";
	   }
	   else if (n == 39)
	   {
		   return "�嶯";
	   }
	   else if (n == 11)
	   {
		   return "1��";
	   }
	   else if (n == 12)
	   {
		   return "2��";
	   }
	   else if (n == 13)
	   {
		   return "3��";
	   }
	   else if (n == 14)
	   {
		   return "4��";
	   }
	   else if (n == 15)
	   {
		   return "5��";
	   }
	   else if (n == 16)
	   {
		   return "6��";
	   }
	   else if (n == 17)
	   {
		   return "7��";
	   }
	   else if (n == 18)
	   {
		   return "8��";
	   }
	   else if (n == 19)
	   {
		   return "9��";
	   }
	   else if (n == 10)
	   {
		   return "����";
	   }
	   return "";
	   
   }



}