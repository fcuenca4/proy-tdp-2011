
public class Alumno {
	
	
	private String nombre;
	private String apellido;
	private int lu;
	
	public Alumno(String n,String a,int i){
		nombre=n;
		apellido=a;
		lu=i;
	}
	
	public String getNombres(){return nombre;}
	
	public String getApellido(){return apellido;}
	
	public int getLu(){return lu;}

	public String getApellidosNombres(){return(apellido+","+nombre);}
	
}
