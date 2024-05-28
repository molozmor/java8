package bits;

public class Principal {

	public static void main(String[] args) {
		byte b1 = 0x0F; // 0000 1111   
		byte b2 = 0x3A; // 0011 1010
		                // 0000 1010  -> 0A
		
		int resul = b1 & b2;
		System.out.println("b1: " + b1 + " b2: " + b2);
		System.out.println("resul: " + resul);
		
		int resul2 = b1 | b2;
		System.out.println("resul2: " + resul2);
		
		// Operadores de rotación sobre bits:
		// 0000 1111 >> 2  = 0000 0011  div 2^2 = 4 
		// 0000 1111 << 3  = 0111 0000  mul 2^3 = 8
		
		b1 >>= 2; // b1 = b1 >> 2;
		System.out.println("b1: "+ b1);
		
		b1 = 0x0F;
		b1 <<= 3;
		System.out.println("b1: "+ b1);
	}

}
