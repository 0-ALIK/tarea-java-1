import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class SinAzucar 
{
    protected int vasos;
    protected float dinero;
    
    public SinAzucar() {
        vasos = 100;
        dinero = 0.0f;
    }

    public float getDinero() {
        return dinero;
    }

    public int getVasos() {
        return vasos;
    }

    public int getVasosGastados() {
        return 100 - vasos;
    }

    public float calcularPrecio(int vasosComprados) {

        if(vasosComprados > vasos)
            return -1;
        
        vasos -= vasosComprados;
        dinero += 0.45 * vasosComprados;
        return dinero;
    }
}

class ConAzucar extends SinAzucar 
{
    private int azucar;

    public ConAzucar() {
        super();
        azucar = 80;
    }

    public int getAzucar() {
        return azucar;
    }

    public int getAzucarGastada() {
        return 80 - azucar;
    }

    public float calcularPrecioAzucar(int vasosComprados, int numAzucar) {
        
        if(vasosComprados > numAzucar)
            return -1;
        if((vasosComprados * numAzucar) > azucar)
            return -2;
        
        vasos -= vasosComprados;
        azucar -= numAzucar;
        dinero += 0.5 * vasosComprados;
        return dinero;
    }
}

public class Practica
{
    public static void main(String[] args) throws IOException 
    {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        boolean active = true;

        ConAzucar venta = new ConAzucar();

        while(active)
        {
            System.out.print("\n\tMenú\n1. Vender limonada sin azucar\n2. Vender limonada con azucar\n3. Ver registro de inventario\n4. Salir\nIngrese la opción: ");

            switch(Integer.parseInt(br.readLine())) {

                case 1:
                    if(venta.getVasos() <= 0)
                        System.out.print("\nYa no te quedan mas vasos para vender\n");
                    else{
                        while(true) {

                            System.out.print("\nQuedan "+venta.getVasos()+" para vender");
                            System.out.print("\nIngrese el número de vasos que comprará el cliente: ");
                            if(venta.calcularPrecio( Integer.parseInt(br.readLine())) == -1){

                                System.out.print("\nNo hay vasos suficientes, ingrese una nueva cantidad");
                                continue;
                            }

                            break;
                        }
                    }

                break;

                case 2:
                break;

                case 3:
                break;

                case 4:
                    active = false;
                    System.out.print("\nAdios\n");
                break;

                default:
                    System.out.print("\nEsa opción no esta en el menú\n");
                break;
            }
        }

    }
}

