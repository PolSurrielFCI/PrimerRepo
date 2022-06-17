public class Triangulo extends Figura {
    float base;
    float altura;
    float hipotenusa;
    @Override
    public float calcularArea(){
        return base * altura * hipotenusa;
    }
    Triangulo(float base, float altura, float hipotenusa){
        this.base=base;
        this.altura=altura;
        this.hipotenusa=hipotenusa;
    }
};


