import java.io.*;

class Dado 
{
    
    private int numero;
    
    public Dado()
    {
        numero = 0;
    }
    
    public int lanzarDado()
    {
        numero = (int) Math.floor(Math.random()*(6-1+1)+1);
        System.out.print("Dado lanzado, el resultado fue "+numero);

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
    
    public void Partida(Jugador player1, Jugador player2, int n)
    {
        for (int i = 1; i <= n; i++) {
            
            System.out.print("Tirada Numero "+i);
            
            player1.setPuntosEnJuego(lanzarDado());

        }   
    }  
    
}

public class Proyecto 
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int opc = 0, cantidad;
        while(opc != 3)
        {
            System.out.print("Menú\n 1. Si desea jugar\n2. Si desea ver los puntajes 3. Si desea salir");
            opc = Integer.parseInt(br.readLine());
            switch(opc)
            {
                case 1:
                    System.out.print("Nombre del Jugador 1: ");
                    String Jugador1 = br.readLine();
                    Jugador jg1 = new Jugador(Jugador1);
                    System.out.print("Nombre del Jugador 2: ");
                    String Jugador2 = br.readLine();
                    Jugador jg2 = new Jugador(Jugador2);
                    System.out.print("Colocar las n jugadas");
                    cantidad = Integer.parseInt(br.readLine());
                break;
                case 2:
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