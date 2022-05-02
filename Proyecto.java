import java.io.*;

class Jugador
{
    
}

class Game
{

}

public class Proyecto 
{

    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        boolean activo = true;

        while(activo)
        {
            System.out.print("\n\nMenú\n 1. Si desea jugar\n2. Si desea ver los puntajes\n3. Si desea salir\nOpcion: ");
            switch(Integer.parseInt(br.readLine()))
            {
                case 1:

                break;

                case 2:
                    
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

// Objetivos:Resolver problemas aplicando la propiedad de la herencia/polimorfismo. Comprender como la herencia fomenta la reutilización del software.Comprender los conceptos de clases base y clases derivadas.Aplicarlos efectos de los modos de acceso, constructores, sobrecarga, nombres de datos iguales y sobreescritura de métodos en la herencia. Enunciado:

/* Escribe un programa en java para simular un juego de dados. Las reglas de juego del juego de  dados  conocido  son:  cada  dado  tiene  6  lados,  estos  lados  contienen  1,  2,  3,  4,  5,  6 puntos, después de lanzar los dos dados, se calcula la suma de los puntos. El jugador con más puntos gana; el empate es el mismo si los puntos son los mismos.Se describe a continuación ciertas recomendaciones.Considere el uso de varias clasesSolo son dos jugadores Debe contar los puntos para cada uno y determinar el ganadorControlar turnos y la jugadaMostrar los puntos del ganador  Uso de una herramienta colaborativa */

/*
    Jugador
        atributos
            nombre
            puntosJuego
            puntosPartida
        métodos
            getNombre()
            getPuntos()
            getAcumulados()
    
    Juego
        atributos
        
            punto
        métodos
            lanzarDado()

*/