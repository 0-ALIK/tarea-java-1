/**
 * @author Flavio Sánchez (8-994-181)
 * @version 1.0 
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Edificio  
{
    protected boolean ascensor;

    public Edificio () {
        ascensor = true;
    }

    public boolean getAscensor () {
        return ascensor;
    }

    public String tieneAscensor () {
        return "SI tiene ascensor"; 
    }
}

class Restaurante extends Edificio 
{
    private int sillas;

    public Restaurante() {
        super();
    }

    @Override
    public boolean getAscensor() {
        return !ascensor;
    }

    public int getSillas() {
        return sillas;
    }

    @Override
    public String tieneAscensor() {
        if(getAscensor())
            return "\nSI cuenta con ascensor";
        
        return "\nNO cuenta con ascensor";
    }

    public double precioSillas () {
        return sillas * 0.75;
    }

    public void setSillas(int sillas) {
        this.sillas = sillas;
    }
}


class Hotel extends Edificio
{
    private int habitaciones;

    public Hotel() {
        super();
    }

    @Override
    public String tieneAscensor() {
        if(getAscensor())
            return "\nSI cuenta con ascensor";
        
        return "\nNO cuenta con ascensor";
    }

    public void setHabitaciones(int habitaciones) {
        this.habitaciones = habitaciones;
    }

    public double precioHabitacion () {
        return habitaciones * 200;
    }

    public int getHabitaciones() {
        return habitaciones;
    }
}

public class Parcial 
{
    public static void main(String[] args) throws IOException {
    
        BufferedReader br = new BufferedReader( new InputStreamReader(System.in) ); 
        boolean activo = true;
        double p;  

        Restaurante restaurante = new Restaurante();
        Hotel hotel = new Hotel();
        
        while (activo) {

            System.out.print("\n\tMenu\n1. Alquilar restaurante\n2. Alquilar hotel\n3. Salir\nIngresar Opción: ");

            switch (Integer.parseInt(br.readLine())) {

                case 1:
                    System.out.print("\n\tAlquilar Restaurante.\nLas sillas cuestan 0.75 cada una, Cauntas sillas quiere: ");
                    restaurante.setSillas(Integer.parseInt(br.readLine()));
                    
                    System.out.print(restaurante.tieneAscensor());
                
                    p = restaurante.precioSillas();
                    System.out.print("\nTotal a pagar: "+p+"\nTotal a pagar con impuesto: "+(p + (p*0.07))+"\n");
                break;
            
                case 2:
                    System.out.print("\n\tAlquilar Hotel.\nLas habitaciones cuestan 200, Cauntas habitaciones quiere: ");
                    hotel.setHabitaciones(Integer.parseInt(br.readLine()));

                    System.out.print(hotel.tieneAscensor());
                
                    p = hotel.precioHabitacion();
                    System.out.print("\nTotal a pagar: "+p+"\nTotal a pagar con impuesto: "+(p + (p*0.07))+"\n");
                break;

                case 3:
                    System.out.print("\nAdios\n");
                    activo = false;
                break;

                default:
                    System.out.print("\nOpción no existe\n");
                break;
            }

        }
    }
}

