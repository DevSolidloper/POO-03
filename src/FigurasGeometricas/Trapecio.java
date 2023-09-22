package FigurasGeometricas;

public class Trapecio {
	int basemayor;
    int basemenor;
    int altura;
    int lado1;
    int lado2;
    
    public Trapecio(int basemayor, int basemenor, int altura, int lado1, int lado2) {
        this.basemayor = basemayor;
        this.basemenor = basemenor;
        this.altura = altura;
        this.lado1 = lado1;
        this.lado2 = lado2;
    }
    double area() {
    	return(((basemayor+basemenor)/2)*altura);
    	
    }
    double perimetro() {
    	return(basemayor+basemenor+lado1+lado2);
 
    }
	

}
