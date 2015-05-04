public class Lab7 {

	public static void main(String[] args) {
		
		long p = 24852977;
		long g = 2744;
		long gxmodp = 8414508;
		long a1 = 15268076;
		long a2 = 743675;
		
		long x = 0;
		long temp = 0;
		long counter = 0;
		
		//first we calculate x
		
		do{
			
			counter++;
			temp = modPow(g,counter,p);
			
			if(temp == gxmodp) {
				x = counter;
			}
			
			} while(x==0);
		
		long pow = p-1-x;
		long sum1 = modPow(a1,pow,p);
		long sum2 = modMult(sum1,a2,p);
		
		System.out.println(sum2);
			
		

	}

	public static long modPow(long number, long power, long modulus) {

		if (power == 0)
			return 1;
		else if (power % 2 == 0) {
			long halfpower = modPow(number, power / 2, modulus);
			return modMult(halfpower, halfpower, modulus);
		} else {
			long halfpower = modPow(number, power / 2, modulus);
			long firstbit = modMult(halfpower, halfpower, modulus);
			return modMult(firstbit, number, modulus);
		}
	}

	public static long modMult(long first, long second, long modulus) {
		if (second == 0)
			return 0;
		else if (second % 2 == 0) {
			long half = modMult(first, second / 2, modulus);
			return (half + half) % modulus;
		} else {
			long half = modMult(first, second / 2, modulus);
			return (half + half + first) % modulus;
		}
	}
}
