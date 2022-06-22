package apuestas_qatar22;

import java.util.ArrayList;

public class App {

    ArrayList<Equipo>lista_equipos;
    ArrayList<Partido>grupos;
    ArrayList<Partido>octavos_final;
    ArrayList<Partido>cuartos_final;
    ArrayList<Partido>semis_final;
    ArrayList<Partido>final_mundial;

    public App(ArrayList<Equipo>lista_equipos, ArrayList<Partido>grupos) {
        lista_equipos = new ArrayList<>();
        grupos = new ArrayList<>();
        octavos_final = new ArrayList<>();
        cuartos_final = new ArrayList<>();
        semis_final = new ArrayList<>();
        final_mundial = new ArrayList<>();
    }

    public boolean login_usuario(String nombre_usuario, String contraseña) {

        Usuario usuario = new Usuario("valentin", "holahola", "email@gmai.com", "4359999");
        FuncionesUsuario funciones = new FuncionesUsuario(usuario);

        boolean respuesta = funciones.login(nombre_usuario, contraseña);

        return respuesta;
        
    } 

    public void ver_partidos(ArrayList<Partido> arreglo) {
        int i = 1;    
        for (Partido partido : arreglo) {
            
            System.out.println("Partido "+i+ ": "+ partido.toString());
            i++;
        }


    }

    public void simular_partidos(ArrayList<Partido> arreglo) {
        int i = 1;
        for (i=0;i<arreglo.size();i++) {    
            arreglo.get(i).setResultado();
            System.out.println("Partido"+i+": " + arreglo.get(i).toStringResultado());
           
        }
    }
    
}
