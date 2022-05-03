/*
* Jugador
    Atributos
        nombre
        puntosPartida
        puntosTotales
    Métodos
        getNombre()
        getPuntos()
        getPuntosTotales()

* Juego hereda de Jugador
    Atributos
        punto
    Métodos
        lanzarDado()
*/

import java.io.*;

class Jugador
{
    protected String jugador = "";
    protected int puntosPartidas = 0;
    protected int puntosTotales = 0;
    Jugador(String jugador)
    {
        this.jugador = jugador;
    }

    public String getJugador() {
        return jugador;
    }

    public int getPuntosPartidas() {
        return puntosPartidas;
    }

    public int getPuntosTotales() {
        return puntosTotales;
    }
}

class Juego extends Jugador
{
    private int punto;
    public Juego (String jugador) 
    {
        super(jugador);
        punto = 0;
    }

    public int getPunto() {
        return punto;
    }
    
    public int tirada()
    {
        punto = (int) (Math.random()*(6-1+1)+1);
        return punto;
    }

    public void sumarPuntos() {
        puntosPartidas  += punto;
    }

    public void reset () {
        puntosPartidas = 0;
    }

    public void acumular() {
        puntosTotales += puntosPartidas; 
    }
}

public class Proyecto 
{

    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        boolean activo = true;
        System.out.print("\nIngrese el nombre del jugador 1: ");
        Juego jugador1 = new Juego(br.readLine());

        int tiradas;

        System.out.print("\nIngrese el nombre del jugador 2: ");
        Juego jugador2 = new Juego(br.readLine()); 
        
        while(activo)
        {
            System.out.print("\n\nMenú\n 1. Si desea jugar\n2. Si desea ver los puntajes\n3. Si desea salir\nOpcion: ");
            switch(Integer.parseInt(br.readLine()))
            {
                case 1:
                    System.out.print("\nEl mejor de: ");
                    tiradas = Integer.parseInt(br.readLine());

                    for (int i = 1; i <= tiradas; i++) {
                        System.out.print("\nVuela numero"+i+"\nEl jugador "+jugador1.getJugador()+"ha lanzado el dado y saco"+jugador1.tirada()+"puntos"); 
                        System.out.print("\nEl jugador "+jugador2.getJugador()+"ha lanzado el dado y saco"+jugador2.tirada()+"puntos");

                        jugador1.sumarPuntos(); jugador2.sumarPuntos();

                        if(jugador1.getPunto() > jugador2.getPunto())
                            System.out.print("\nEl jugador "+jugador1.getJugador()+" Se lleva la primera vuelta con: "+jugador1.getPunto()+" puntos");
                        else
                            System.out.print("\nEl jugador "+jugador2.getJugador()+" Se lleva la primera vuelta con: "+jugador2.getPunto()+" puntos");

                        System.out.print("\nIngrese cualquier cosa para continuar con la siguiente vuelta: ");
                        br.readLine();
                    }

                    jugador1.acumular(); jugador2.acumular();
                    
                    if(jugador1.getPuntosPartidas() > jugador2.getPuntosPartidas())
                        System.out.print("\nEl jugador "+jugador1.getJugador()+" Ha ganado con "+jugador1.getPuntosPartidas()+" puntos");
                    else
                        System.out.print("\nEl jugador "+jugador2.getJugador()+" Ha ganado con "+jugador2.getPuntosPartidas()+" puntos");

                    jugador1.reset();
                    jugador2.reset();
                break;
                    


                case 2:
                    System.out.print("\nPuntos totales de "+jugador1.getJugador()+": "+jugador1.getPuntosTotales()+"\n");
                    System.out.print("\nPuntos totales de "+jugador2.getJugador()+": "+jugador2.getPuntosTotales()+"\n");
                break;
                
                case 3:
                    System.out.print("Gracias por jugar");
                    activo = false;
                break;
                
                default:
                    System.out.print("Error: no coloco un numero proporcionado");
                break;
            }
        }
    }
}