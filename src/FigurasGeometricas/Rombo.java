package FigurasGeometricas;

public class Rombo {
	int Diagonalmayor;
	int Diagonalmenor;
	int Lado;
	
	public Rombo(int Diagonalmayor,int Diagonalmenor,int Lado) {
		this.Diagonalmayor=Diagonalmayor;
		this.Diagonalmenor=Diagonalmenor;
		this.Lado=Lado;
		
		
	}
	double area() {
		return((Diagonalmayor*Diagonalmenor)/2);
		
	}
	double perimetro() {
		return(4*Lado);
	}
	
	

}
