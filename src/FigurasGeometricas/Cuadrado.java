package FigurasGeometricas;

public class Cuadrado {
	int lado; //solo basta este, porque los lados son iguales.
	
	public Cuadrado(int lado) {
		this.lado=lado;
		
	}
	double area() {
		return lado*lado;
		
	}
	double perimetro() {
		return(4*lado);
		
	}
}
