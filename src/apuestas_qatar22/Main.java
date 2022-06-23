package apuestas_qatar22;

import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import java.util.Scanner;


public class Main {
    static Scanner teclado;
    
    public static void main(String[] args) {
        teclado = new Scanner(System.in);
        ArrayList<Equipo> lista_e = new ArrayList<>();
        ArrayList<Partido> lista_p = new ArrayList<>();
        ArrayList<Apuesta> lista_a=new ArrayList<>();
        
         /*
        ArrayList<String> jugadores_1 = new ArrayList<>();
        jugadores_1.add("hola");
        jugadores_1.add("chau");
        jugadores_1.add("dos");
        jugadores_1.add("no");
        
        ArrayList<String> jugadores_2 = new ArrayList<>();
        jugadores_1.add("hola");
        jugadores_1.add("chau");
        jugadores_1.add("dos");
        jugadores_1.add("no");
        

        Equipo equipo1 = new Equipo("nombre", (Integer)1, (Float)54f, jugadores_1, true, "B");
        Equipo equipo2 = new Equipo("nombre2", (Integer)4, (Float)59f, jugadores_2, true, "B");

        Equipo equipo3 = new Equipo("nombre3", (Integer)1, (Float)54f, jugadores_1, true, "B");
        Equipo equipo4 = new Equipo("nombre4", (Integer)4, (Float)59f, jugadores_2, true, "B");

        Equipo equipo5 = new Equipo("nombre5", (Integer)1, (Float)54f, jugadores_1, true, "A");
        Equipo equipo6 = new Equipo("nombre6", (Integer)4, (Float)59f, jugadores_2, true, "A");

        Equipo equipo7 = new Equipo("nombre7", (Integer)1, (Float)54f, jugadores_1, true, "A");
        Equipo equipo8 = new Equipo("nombre8", (Integer)4, (Float)59f, jugadores_2, true, "A");

        lista_e.add(equipo1);
        lista_e.add(equipo2);
        lista_e.add(equipo3);
        lista_e.add(equipo4);
        lista_e.add(equipo5);
        lista_e.add(equipo6);
        lista_e.add(equipo7);
        lista_e.add(equipo8);*/
        
        String fuente= JsonUtiles.leer("jasonmundial");
         JSONArray listaequipo;
         System.out.println(fuente);
       
      
		try {
			
			 listaequipo = new JSONArray(fuente);
			 
			for(int i=0;i<listaequipo.length();i++)
			{
				JSONObject tem = listaequipo.getJSONObject(i);
				
				String nombre= tem.getString("nombre");
				Integer ranking= tem.getInt("ranking_fifa");
				int calificacion= tem.getInt("calificacion");
				
			   ArrayList<String> players= new ArrayList<String>();
			  
			   for(int p=0;p<tem.getJSONArray("plantilla_jugadores").length();p++) {
				  players.add(tem.getJSONArray("plantilla_jugadores").getString(p));
				   	   
			   }
			   
			   String director_tecnico= tem.getString("director_tecnico");
			   Boolean como_clasifico= tem.getBoolean("como_clasifico");
			   String grupo = tem.getString("grupo");
			   
			   Equipo e= new Equipo(nombre, ranking, calificacion, players,director_tecnico,como_clasifico, grupo);
				lista_e.add(e);
	
				
			}
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	        String fuente2= JsonUtiles.leer("partidosgrupos");
	         JSONArray listapartidos;
	         System.out.println(fuente2);
	       
	      
			try {
				
				listapartidos = new JSONArray(fuente2);
				Equipo e1 = null;
				Equipo e2 = null;
				 
				for(int i=0;i<listapartidos.length();i++)
				{
					JSONObject tem = listapartidos.getJSONObject(i);
					
					String equipo1= tem.getString("local");
					String equipo2= tem.getString("visitante");
					Integer id= tem.getInt("partido_numero");
					
					
				   for(int d=0;d<lista_e.size();d++)
				   {
					   if(equipo1.equals(lista_e.get(d).getNombre())) {
						   e1=lista_e.get(d);
					   }
				   }
				   for(int d=0;d<lista_e.size();d++)
				   {
					   if(equipo2.equals(lista_e.get(d).getNombre())) {
						   e2=lista_e.get(d);
					   }
				   }
				   
				  
		Partido partido= new Partido(e1, e2);
		lista_p.add(partido);
					
				}
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		for(int i=0;i<lista_e.size();i++)
		{ 
			System.out.println(lista_e.get(i));
		}

        
        /* 
        for (Partido p : lista_p) {
            System.out.println(p.getEquipoA().getNombre());
            System.out.println(p.getEquipoB().getNombre());
        }
        */
	   System.out.println("--------------------------------------------------");
       System.out.println("FECHA 1");
       System.out.println("--------------------------------------------------");
       for(int i=0;i<16;i++)
		{ 
			System.out.println(lista_p.get(i));
		}
       System.out.println("--------------------------------------------------");
       System.out.println("FECHA 2");
       System.out.println("--------------------------------------------------");
       for(int i=16;i<32;i++)
		{ 
			System.out.println(lista_p.get(i));
		}
       System.out.println("--------------------------------------------------");
       System.out.println("FECHA 3");
       System.out.println("--------------------------------------------------");
       for(int i=32;i<48;i++)
		{ 
			System.out.println(lista_p.get(i));
		}
        App app = new App(lista_e, lista_p);
        
        
        for(int i=0;i<1;i++)
        {
        	Apuesta a1= realizar_apuesta(lista_p);
            lista_a.add(a1);
        }
       
        

        inicio_app(app, lista_p);
        for(int i=0;i<lista_e.size();i++)
        	
        {
        	System.out.println(lista_e.get(i).toString());
        }
        
        apuestas_terminadas(lista_a, lista_p);
        
        String letra="";
        Equipo ganador;
       
        ArrayList<String> letras= new ArrayList<String>();
        letras.add("A");
        letras.add("B");
        letras.add("C");
        letras.add("D");
        letras.add("E");
        letras.add("F");
        letras.add("G");
        letras.add("H");
        for(int i=0;i<letras.size();i++)
        {
        	 int posicion=1;
        	letra=letras.get(i);
        	ganador= ganador_del_grupo(lista_e,letra,posicion);
            System.out.println("Ganador del grupo "+ letras.get(i)  +" es: " + ganador.getNombre());
            posicion++;
            ganador= ganador_del_grupo(lista_e,letra,posicion);
             System.out.println("Segundo del grupo "+ letras.get(i)  + " es: " + ganador.getNombre());
        }
    
          
          ArrayList<Partido> lista_octavos = new ArrayList<>();
         
     	 
     	
     	 for(int i=0;i<letras.size();i++)
     	 {
     		 String letrauno=letras.get(i);
     		 i++;
         	 String letrados=letras.get(i);
         	 
     		Partido p=armado_partidos(lista_e, letrauno, letrados);
           	lista_octavos.add(p);
           	
           	
     	 }
     	 for(int i=letras.size()-1;i>=0;i--)
     	 {
             String letrauno=letras.get(i);
     		 i--;
         	 String letrados=letras.get(i);
         	 
     		Partido p=armado_partidos(lista_e, letrauno, letrados);
           	lista_octavos.add(p);
           	
           	
     	 }
     	 
     
    	 app.ver_partidos(lista_octavos);
    	 String equipito;
    	 System.out.println("Que equipo desea buscar? \n");
    	 teclado.nextLine();
    	 equipito = teclado.nextLine();
    	
    	 app.buscar_equipo(lista_e, equipito);
    	 
    	simular_partidos(lista_octavos);
      
      	
      
        /* 
        SimulacionPartido partido1 = new SimulacionPartido(equipo1, equipo2);
        partido1.calculoResultado();
        System.out.println("Equipo A: "+partido1.getGolesA() + " Equipo B: "+partido1.getGolesB());
        System.out.println(partido1.getId()); 
        System.out.println(partido1.getResultado()); 
        

        SimulacionPartido partido2 = new SimulacionPartido(equipo3, equipo4);
        partido2.calculoResultado();
        System.out.println("Equipo A: "+partido2.getGolesA() + " Equipo B: "+partido2.getGolesB());
        System.out.println(partido2.getId()); 
        System.out.println(partido2.getResultado()); 

        SimulacionPartido partido3 = new SimulacionPartido(equipo5, equipo6);
        partido3.calculoResultado();
        System.out.println("Equipo A: "+partido3.getGolesA() + " Equipo B: "+partido3.getGolesB());
        System.out.println(partido3.getId()); 
        System.out.println(partido3.getResultado()); 

        SimulacionPartido partido4 = new SimulacionPartido(equipo7, equipo8);
        partido4.calculoResultado();
        System.out.println("Equipo A: "+partido4.getGolesA() + " Equipo B: "+partido4.getGolesB());
        System.out.println(partido4.getId()); 
        System.out.println(partido4.getResultado()); 
        */
        

        // HashMap<Integer, Equipo> lista_equipos = new HashMap<>(); 

        // lista_equipos.put(equipo1.getRanking_fifa(), equipo1);
        
        
    }
    private static void equipito(String nextLine) {
		// TODO Auto-generated method stub
		
	}
	public static void menu_user(){
        System.out.println("[1] Ver partidos");
        System.out.println("[2] Realizar apuesta.");
        System.out.println("[3] Generar resultados.");
        System.out.println("[0] Salir.");
 
    }

    public static void inicio_app(App app, ArrayList<Partido> lista_p) {
        int key = -1;
        while (key!=0){
            System.out.println("[1] Login Usuario.");
            System.out.println("[0] Salir.");
            key = teclado.nextInt();
 
            switch(key) {
                case 1:
                    System.out.println("Ingrese nombre de usuario: ");
                    String u = teclado.next();

                    System.out.println("Ingrese contraseña de usuario: ");
                    String c = teclado.next();

                    boolean logueado = app.login_usuario(u, c);

                    if (logueado==false) {
                        System.out.println("Inicio de sesión fallido.");
                        
                    } else {
                        launch_app(app, lista_p);
                        
                    }
                    break;
            
                case 0:
                    break;
                }

    }
}

    public static void launch_app(App app,ArrayList<Partido>lista_p) {
        int key = -1;
        while (key!=0){
            menu_user();
            key = teclado.nextInt();
 
            switch(key) {
                case 1:
                    //ver los partidos de la fase de grupos
                    app.ver_partidos(lista_p);
                    //app.ver_partidos(app.grupos);
                    break;
                
                case 2:
                    //realizar apuesta

                    break;

                case 3:
                    // simular partidos
                  simular_partidos(lista_p);
                    
                    break;
                
                case 0:
                    //salir
                    break;
                }

    }


}

    public static Equipo ganador_del_grupo(ArrayList<Equipo> lista, String letra,int posicion)
    {
    	ArrayList<Equipo> clasificacion=new ArrayList<Equipo>();
    	
for(int i=0;i<lista.size();i++)
        	
        {
        	if(letra.equals(lista.get(i).getGrupo())&&(lista.get(i).getEstado()==true)){
        	  clasificacion.add(lista.get(i));
        	}
        }

      Equipo ganador=clasificacion.get(0);
    	for(int i=1;i<clasificacion.size();i++)
    	{
    		if(ganador.getPuntos()<=clasificacion.get(i).getPuntos())
    		{
    			ganador=clasificacion.get(i);
    		}
    	}
    	ganador.setComo_termino(posicion);
    	ganador.setEstado(false);
    	 return ganador;
    }
    public static Partido armado_partidos(ArrayList<Equipo> lista, String letra, String letrados) {
    	 Equipo primero = null;
     	 Equipo segundo = null;
    	for(int i=0;i<lista.size();i++)
    	{
    		if(lista.get(i).getComo_termino()==1&&lista.get(i).getGrupo().equals(letra)) {
    		primero=lista.get(i);
    		}
    	}
    	for(int i=0;i<lista.size();i++)
    	{
    		if(lista.get(i).getComo_termino()==2&&lista.get(i).getGrupo().equals(letrados)) {
    		segundo=lista.get(i);
    		}
    	}
    	Partido partidito= new Partido(primero, segundo);
    	return partidito;
    }
    public static void ver_partidos(ArrayList<Partido> arreglo) {
        int i = 1;    
        for (Partido partido : arreglo) {
            
            System.out.println("Partido "+i+ ": "+ partido.toString());
            i++;
        }


    }
    public static void simular_partidos(ArrayList<Partido> arreglo) {
        int i = 1;
        for (i=0;i<arreglo.size();i++) {    
            arreglo.get(i).setResultado();
            System.out.println("Partido"+i+": " + arreglo.get(i).toStringResultado());
           
        }
    }
    public static void simular_partidos_eliminatorias(ArrayList<Partido> arreglo) {
        int i = 1;
        for (i=0;i<arreglo.size();i++) {    
            arreglo.get(i).setResultado();
            System.out.println("Partido"+i+": " + arreglo.get(i).toStringResultado());
           
        }
    }
    public static Apuesta realizar_apuesta(ArrayList<Partido> lista) {
    	
    	System.out.println("A que partido desea apostar?");
    	int id_partido = teclado.nextInt();
    	System.out.println(lista.get(id_partido-1).toString());
    	System.out.println("Elegir apuesta: 0-local 1-visitante 2-empate \n ");
    	int que_aposto=teclado.nextInt();
    	System.out.println("Cuanto desea apostar?");
    	float monto=teclado.nextFloat();
    	
    	float ganancia=monto*2;
    	System.out.println("En caso de ganar la apuesta cobraria $ " +ganancia);
    	
    	Apuesta apuesta= new Apuesta(monto, que_aposto, id_partido);
    	return apuesta;
    	
    }
    public static void apuestas_terminadas(ArrayList<Apuesta> lista, ArrayList<Partido> lista_partido) {
    	
    	for(int i=0;i<lista.size();i++)
    	{
    		for(int d=0;d<lista_partido.size();d++)
    		{
 
    			if(lista.get(i).getId_partido()==lista_partido.get(d).getId()) {
    	
    				if(lista.get(i).getQue_aposto()==lista_partido.get(d).getResultado())
    				{
    					
    					System.out.println(lista_partido.get(d).toStringResultado());
    					System.out.println("Felicitaciones,apuesta ganada! \n");
    					lista.get(i).setEstado(true);
    					lista.get(i).setGanancia(lista.get(i).getMonto());;
    				}else {
    					System.out.println(lista_partido.get(d).toStringResultado());
    					System.out.println("Lo siento,apuesta perdida! \n");
    					lista.get(i).setEstado(false);
    					
    				}
    			}
    		}
    	}
    }
    
    }
  
   

