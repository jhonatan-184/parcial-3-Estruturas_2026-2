import java.util.Iterator;
import java.util.Queue;
import java.util.Random;
import java.util.Scanner;

public class metodos {
    public Queue<Objsolid> LLenarSolicitudes(Queue<Objsolid>cola, Scanner sc, metodos m ){
        
        boolean cont = true;
        while (cont) {
            Objsolid o = new Objsolid();
            System.out.println("Bienvenido que solucitud desea realizar");
            o.setNum_solici(ValidarTurno(cola));
            System.out.println("digite la ubicacion del lugar");
            o.setUbicación(sc.nextLine());
            System.out.println("cual es el problema que tiene");
            o.setProblema(sc.nextLine());
            System.out.println("cual tecnico desea que le brinde nuestros servicios");
            o.setTecnico(Tecnicos(sc));
            System.out.println("De 1 a 4 que tan urgente es la solicitud");
            o.setPrioridad(ValidarEntero(sc));
            o.setEstado(0);
            System.out.println(" ¿desea seguir agregando solicitudes? 1) si 0) no");
            int opt = sc.nextInt();
            if (opt == 0) {
                System.out.println("bye bye");
                cont = false;
            }
                cola.offer(o);
            

        }
        return cola;

    }
    public int ValidarEntero(Scanner sc) {
        while (!sc.hasNextInt()) {
            System.out.println("Por favor Ingrese un digito numerico");
            sc.next();
        }
        return sc.nextInt();
    }
    public int ValidarTurno(Queue<Objsolid>cola){
        int turno = 0;
         if (cola.isEmpty()) {
            turno = 1;
        } else {
            turno = cola.size() + 1;
        }
        return turno;
    }

    public int Tecnicos(Scanner sc){
        Random aleatorio = new Random();
        boolean dispo = aleatorio.nextBoolean();
        System.out.println("cual tecnico desea solicitar"+ dispo);
        System.out.println("1) Javier Maya" + dispo);
        System.out.println("2) Alexander Restrepo" + dispo);
        System.out.println("3) Santiago Navarro" + dispo);
        System.out.println("4) Romeo Santos" + dispo);

       return sc.nextInt();
    }
    public Queue<Objsolid> Atender(Queue<Objsolid> cola) {
        for (Objsolid o : cola) {
            if (o.getEstado() == 0) {
                System.out.println("La siguiente solicitud es la  " + o.getNum_solici());
                if (o.getTecnico() >= 1 && o.getTecnico() <= 4) {
                    o.setEstado(1);
                }
                
            }
        }
        return cola;
    }

    public Queue<Objsolid> MostrarSolicitudes(Queue<Objsolid>cola, int opt ){
        switch (opt) {
            case 1:
                for (Objsolid o : cola) {
                    System.out.println("La solicitud es la Numero " + o.getNum_solici());
                    System.out.println("En la ubicacion " + o.getUbicación());
                    System.out.println("Tiene el problema de " + o.getProblema());
                    System.out.println("Solicita al tecnico " + o.getTecnico());
                    System.out.println("tiene prioridad " + o.getPrioridad());
                }
                break;
        
            default:
                break;
        }
        return cola;
    }
    public Queue<Objsolid> EliminarSolicitud(Queue<Objsolid>cola ){
        if (!cola.isEmpty()){
            Iterator<Objsolid> it = cola.iterator();
            while (it.hasNext()) {
                Objsolid o = it.next();
                if (o.getEstado()== 1) {
                    it.remove();
                }
            }
        }

        return cola;
    }

}
