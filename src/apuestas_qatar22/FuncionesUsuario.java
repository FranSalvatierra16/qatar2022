package apuestas_qatar22;

import apuestas_qatar22.excepciones.PasswordIncorrecta;
import apuestas_qatar22.excepciones.UsuarioIncorrecto;

public class FuncionesUsuario {
    private Usuario usuario;
    
    public FuncionesUsuario(Usuario usuario) {
        this.usuario = usuario;

    }

    public boolean validacion_datos_usuario(String user, String pass) throws UsuarioIncorrecto, PasswordIncorrecta {

        if (!user.equalsIgnoreCase(usuario.getUser())) {

            throw new UsuarioIncorrecto("Usuario incorrecto.");

        } else if (!pass.equals(usuario.getPassword())) {

            throw new PasswordIncorrecta("Contraseña incorrecta.");
        }   
        
        return true;
    }

    public boolean login (String user, String pass) {

        boolean rta = false;
        int caso = 0;
        int cont = 0;


        try {
            rta = validacion_datos_usuario(user, pass);
            
        } catch (UsuarioIncorrecto e) {
            System.out.println(e.getMessage()); 
            
        } catch (PasswordIncorrecta e) {
            System.out.println(e.getMessage());
        }
    
        return rta;
    }
    
}
