import java.io.*;

class Dado 
{

    private int numero;
    
    public Dado()
    {
        numero = 0;
    }
    
    public int lanzarDado(Jugador a)
    {
        numero = (int) Math.floor(Math.random()*(6-1+1)+1);
        return numero;
    }
    
}   

class Jugador
{
    private String nombre;
    private int puntosEnJuego = 0;
    private int puntosAcumulados = 0;

    Jugador(String nombre)
    {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public int getPuntosAcumulados() {
        return puntosAcumulados;
    }
    
    public int getPuntosEnJuego() {
        return puntosAcumulados;
    }

    public void resetPuntos(){
        puntosEnJuego = 0;
    }

    public void setPuntosEnJuego(int puntosEnJuego) {
        this.puntosEnJuego += puntosEnJuego;
    }

    public void setPuntosAcumulados() {
        puntosAcumulados += puntosEnJuego;
    }

}

class Game extends Dado 
{

    public Game()
    {
        super();
    }  
    
    public String comprobarPartida(Jugador p1, Jugador p2) {

        String msg = "";

        if(p1.getPuntosEnJuego() > p2.getPuntosEnJuego())
            msg = "El jugador "+p1.getNombre()+" es el ganador con "+p1.getPuntosEnJuego()+" puntos";
        else if(p1.getPuntosEnJuego() < p2.getPuntosEnJuego())
            msg = "El jugador "+p2.getNombre()+" es el ganador con "+p2.getPuntosEnJuego()+" puntos"; 
        else
            msg = "ES UN EMPATE";

        p1.resetPuntos();
        p2.resetPuntos();

        return msg;
    }

    public String jugada(Jugador p1, Jugador p2) {

        p1.setPuntosEnJuego(lanzarDado(p1));
        p2.setPuntosEnJuego(lanzarDado(p2));

        return "";
    }
    
}

public class Proyecto 
{

    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int opc = 0, cantidad;

        Game juego = new Game();
        
        System.out.print("\nIntroducir los Nombres de los jugadores ");
        
        System.out.print("\nNombre del Jugador 1: ");
        Jugador jugador1 = new Jugador(br.readLine());
        
        System.out.print("\nNombre del Jugador 2: "); 
        Jugador jugador2 = new Jugador(br.readLine());
        
        cantidad = Integer.parseInt(br.readLine());


        
        while(opc != 3)
        {
            System.out.print("\n\nMenú\n 1. Si desea jugar\n2. Si desea ver los puntajes\n3. Si desea salir\nOpcion: ");
            opc = Integer.parseInt(br.readLine());

            switch(opc)
            {
                case 1:
                    System.out.print("Introduzca las tiradas que tendran");
                    cantidad = Integer.parseInt(br.readLine());

                    for (int i = 0; i < args.length; i++) {
                        
                    }

                break;

                case 2:
                    //s
                break;
                
                case 3:
                    System.out.print("Gracias por jugar");
                break;
                
                default:
                    System.out.print("Error: no coloco un numero proporcionado");
                break;
            }
        }
    }
}

// Objetivos:Resolver problemas aplicando la propiedad de la herencia/polimorfismo. Comprender como la herencia fomenta la reutilización del software.Comprender los conceptos de clases base y clases derivadas.Aplicarlos efectos de los modos de acceso, constructores, sobrecarga, nombres de datos iguales y sobreescritura de métodos en la herencia. Enunciado:

/* Escribe un programa en java para simular un juego de dados. Las reglas de juego del juego de  dados  conocido  son:  cada  dado  tiene  6  lados,  estos  lados  contienen  1,  2,  3,  4,  5,  6 puntos, después de lanzar los dos dados, se calcula la suma de los puntos. El jugador con más puntos gana; el empate es el mismo si los puntos son los mismos.Se describe a continuación ciertas recomendaciones.Considere el uso de varias clasesSolo son dos jugadores Debe contar los puntos para cada uno y determinar el ganadorControlar turnos y la jugadaMostrar los puntos del ganador  Uso de una herramienta colaborativa */

/*
    class Dado


    Class jugador - 2 instancias
        atributos
            nombre
            puntosEnJuego
            puuntoPorPartida
        metodos
            

    Class Juego
        metodos
        
    ==============================
    MUNU
    1. Jugar
    2. Puntajes de jugadores
    3. Salir
*/