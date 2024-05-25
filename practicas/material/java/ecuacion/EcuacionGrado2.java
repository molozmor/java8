package modelo;


	public class EcuacionGrado2 {
	
		private double a;
		private double b;
		private double c;
		
		public EcuacionGrado2(){
			a = b = c = 0;
		}
		
		public EcuacionGrado2(double a, double b, double c){
			this.a = a;
			this.b = b;
			this.c = c;		
		}
		
		public double getSol1() throws RaizException {
			double x1;
			
			if ( Math.pow(b, 2.0) - (4 * a * c) < 0){
				throw new RaizException();
			}
			
			x1 = (-b + Math.sqrt( Math.pow(b, 2.0) - (4 * a * c))) / (2 * a);
			return(x1);
		}
		
		
		public double getSol2() throws RaizException {
			double x2;
			
			if ( Math.pow(b, 2.0) - (4 * a * c) < 0){
				throw new RaizException();
			}
			
			x2 = (-b - Math.sqrt( Math.pow(b, 2.0) - (4 * a * c))) / (2 * a);
			return(x2);
		}
	}