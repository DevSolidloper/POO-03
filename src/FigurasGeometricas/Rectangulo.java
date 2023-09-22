package FigurasGeometricas;

public class Rectangulo {
	int base;
	int altura;
	Rectangulo(int base, int altura){
		this.base=base;
		this.altura=altura;
	}
	double area() {
		return base*altura;
		
	}
	double perimetro() {
		return(2*base)+(2*altura);
	}
}
