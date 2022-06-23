package apuestas_qatar22;

public class ErrorEquipoeliminado extends Exception {
	
	 public ErrorEquipoeliminado(String mensaje) {
		// TODO Auto-generated constructor stub	{
		super(mensaje);
	}
  public String getMessage() {
	  
	  
	return "ERROR "+super.getMessage();
	  
  }

}
