import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
public class menu {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Queue<Objsolid> cola = new LinkedList<>();
        metodos m = new metodos();
        boolean continuar = true;
        while (continuar) {
            System.out.println("Que solicitud desea");
            System.out.println("Que desea realizar");
            System.out.println("1) llenar solicitud ");
            System.out.println("2) Mostrar Solicitudes ");
            System.out.println("3) Atender solicitudes ");
            System.out.println("8) Salir ");
            int opt = m.ValidarEntero(sc);
            switch (opt) {
                case 1:
                    cola = m.LLenarSolicitudes(cola, sc, m);
                    break;
                    case 2:
                    m.MostrarSolicitudes(cola, opt);
                    break;
                case 3:
                    cola = m.Atender(cola);
                    break;
                case 8:
                    System.out.println("Hasta luego");
                    continuar = false;
                    break;

                default:
                    System.out.println("esta opcion no existe");
                    break;
            }
        }
    }
}

