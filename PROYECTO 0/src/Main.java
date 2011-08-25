
public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		Information info=new Information(new Alumno("rodrigo","camparo",93376),new Alumno("francisco","cuenca",94294));
		System.out.println(info.getHolaMundo());
		System.out.println(info.getAlumno1().getApellidosNombres()+" :"+info.getAlumno1().getLu());
		System.out.println(info.getAlumno2().getApellidosNombres()+" :"+info.getAlumno2().getLu());
	}

}
