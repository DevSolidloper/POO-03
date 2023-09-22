package FigurasGeometricas;
public class Circulo {
	int radio; 
	Circulo(int radio){
		this.radio=radio;
	}
	double calArea() {
		return Math.PI*Math.pow(radio, 2);
		
	}
	double perimetro() {
		return 2*Math.PI*radio;
	}

}
