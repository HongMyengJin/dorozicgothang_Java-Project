
public class Card {
   private int value, x;
   public Card() {
      int temp;
      temp=(int)(Math.random()*40) + 1;//1,..40 // 40°³ ·£´ýÀ¸·Î
      if(temp % 4 == 0)
      {
    	  value = 4;
    	  x = temp/4;
      }
      else
      {
    	  value = temp % 4;
    	  x = temp/4 + 1;
      }
   }
   public int getValue() {

	   return x;
   }
   public String filename() {
      return x +"."+value+".jpg";
   }
   

}