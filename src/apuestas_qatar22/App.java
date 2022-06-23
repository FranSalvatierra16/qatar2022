package apuestas_qatar22;

import java.util.ArrayList;
import java.util.Scanner;

public class App {
	
	static Scanner teclado = new Scanner(System.in);

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
    public void buscar_equipo(ArrayList<Equipo> lista,String equipo)
    {
    	
    		Boolean respuesta=false;
    		for(int i=0;i<lista.size();i++)

    			if(lista.get(i).getNombre().equals(equipo))
    				{
    		try {
    			respuesta= validacion_estado(lista, i);
    			
    		} catch (ErrorEquipoeliminado e) {
    			// TODO Auto-generated catch block
    			System.out.println(e.getMessage());
    	}
    				}
    	}
    	public Boolean validacion_estado(ArrayList<Equipo> lista,int cont)throws ErrorEquipoeliminado{
    		if(lista.get(cont).getEstado()==true)
    		{
    			throw new ErrorEquipoeliminado("El equipo "+ lista.get(cont).getNombre()+" ha quedado eliminado");
    		}
    		return true;
    	}
    	
    
    	
    
}
