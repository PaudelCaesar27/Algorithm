package lesson12.primes;

public class IsPrime {
	//Precondition: n is a positive integer
	public static boolean isPrime(int n) {
		if(n== 1) return false;
		for(int i = 2; i * i <= n ; ++i) {
			if(n % i == 0) return false;
		}
		return true;
	}
	
	public static void main(String[] args) {
		for(int i = 2; i <= 500; ++i) {
			if(isPrime(i)) System.out.println(i + " is prime");
			else System.out.println(i + " is composite");
		}
	}
}
