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
        vasos -= vasosComprados;
        dinero += (0.45 * vasosComprados);
        return 0.45f * vasosComprados;
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
            
        vasos -= vasosComprados;
        azucar -= (numAzucar*vasosComprados);
        dinero += 0.5 * vasosComprados;
        return 0.5f * vasosComprados;
    }
}

public class Practica
{
    public static void main(String[] args) throws IOException 
    {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        boolean active = true;

        int cazucar, cvasos;

        ConAzucar venta = new ConAzucar();

        while(active)
        {
            System.out.print("\n\tMenú\n1. Vender limonada sin azucar\n2. Vender limonada con azucar\n3. Ver registro de inventario\n4. Salir\nIngrese la opción: ");

            switch(Integer.parseInt(br.readLine())) {

                //VENDER LIMONADA SIN AZUCAR
                case 1:
                    if(venta.getVasos() <= 0)
                        System.out.print("\nYa no te quedan mas vasos para vender\n");
                    else{
                        while(true) {

                            System.out.print("\nQuedan "+venta.getVasos()+" para vender");

                            System.out.print("\nIngrese el número de vasos que comprará el cliente: ");
                            cvasos = Integer.parseInt(br.readLine());

                            if(cvasos > venta.getVasos()){

                                System.out.print("\nNo hay vasos suficientes, ingrese una nueva cantidad");
                                continue;
                            }

                            System.out.print("\nEl precio por la compra del cliente es: "+venta.calcularPrecio(cvasos)+"$");

                            break;
                        }
                    }
                break;
                
                //VENDER LIMONADA CON AZUCAR
                case 2:
                    if(venta.getVasos() <= 0)
                        System.out.print("\nYa no te quedan mas vasos para vender\n");
                    else if(venta.getAzucar() <= 0)
                        System.out.print("\nYa no te quedan azucar para la limonadad con azucar\n");
                    else{
                        while(true) {

                            System.out.print("\nQuedan "+venta.getVasos()+" vasos y "+venta.getAzucar()+" cucharadas de azucar para vender");

                            System.out.print("\nIngrese el número de vasos que comprará el cliente: ");
                            cvasos = Integer.parseInt(br.readLine());
                            System.out.print("\nIngrese el cuantas cucharadas de azucar [1, 3] quiere el cliente: ");
                            cazucar = Integer.parseInt(br.readLine());
                            
                            if(cazucar > 3) {

                                System.out.print("\nEl máximo de cucharadas de azucar es 3, ingrese una nueva cantidad");
                                continue;
                            }
                            if(cvasos > venta.getVasos()){

                                System.out.print("\nNo hay vasos suficientes, ingrese una nueva cantidad");
                                continue;
                            }
                            if((cazucar*cvasos) > venta.getAzucar()){

                                System.out.print("\nNo hay azucar suficientes, ingrese una nueva cantidad");
                                continue;
                            }

                            System.out.print("\nEl precio por la compra del cliente es: "+venta.calcularPrecioAzucar(cvasos, cazucar)+"$");

                            break;
                        }
                    }
                break;

                //MOSTRAR DATOS DE VENTAS
                case 3:
                    System.out.print("\nDinero: "+venta.getDinero()+"$\nVasos: "+venta.getVasos()+"\nAzucar: "+venta.getAzucar()+"\nVasos usados: "+venta.getVasosGastados()+"\nAzucar gastada: "+venta.getAzucarGastada()+"\n");
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

