
public class Information {
	
	private Alumno alumno1;
	private Alumno alumno2;
	
	public Information(Alumno a1,Alumno a2){alumno1=a1;alumno2=a2;}
	
	public String getHolaMundo(){String cadena=new String("Hola Mundo");return cadena;}
	
	public String LUs(){String cadena=new String(alumno1.getLu()+" "+alumno2.getLu());
	                    return cadena;}
	
	public Alumno getAlumno1(){return alumno1;}
	
	public Alumno getAlumno2(){return alumno2;}

}
