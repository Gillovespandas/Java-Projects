import java.util.*;

public class TriangleInequality {

	public static void main(String[] args) {

		int monteCarlo = 1000000;
		int count = 0;
		int temp =0;
		int stick1,stick2,fullstick,pickAstick= 0;
		int stick3 =0;
		
		for (int i = 0; i < monteCarlo; i++) {
			
		
		 fullstick = (int) (Math.random() * (1000));
		 //System.out.println(fullstick);
		stick1 = (int) (Math.random() * (fullstick))+1;
		//System.out.println(stick1);
		
		 stick2 = fullstick - stick1;
		 //System.out.println(stick2);
		
		
		
		 pickAstick = (int)(Math.random()*2)+1;
		
		if (pickAstick ==1) {
			temp = (int) (Math.random() * (stick1))+1;
			
			if(stick1 > temp) {
				stick3 = stick1 - temp;
				stick1 = temp;
			}else if(temp > stick1) {
				stick3 = temp- stick1;
				stick1 = temp;
			}
			
		}else if (pickAstick ==2) {
			temp = (int) (Math.random() * (stick2))+1;
			
			if(stick2 > temp) {
				stick3 = stick2 - temp;
				stick2 = temp;
			}else if(temp > stick2) {
				stick3 = temp- stick2;
				stick2 = temp;
			}
			
		}
	
		
		
		count = TriangleTest(stick1, stick2, stick3)+count;
		//System.out.println( );
		}
		System.out.println(count/(monteCarlo/100) + "%");
		System.out.println(count+"/"+monteCarlo);
		
	}

	public static int TriangleTest(int a, int b, int c) {

		int count = 0;
	
		if (a + b > c && b + c > a && a + c > b) {
			
			count = 1;
		}

		return count;

	}

}
