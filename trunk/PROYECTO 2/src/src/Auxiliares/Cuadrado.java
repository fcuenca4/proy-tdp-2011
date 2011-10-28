package Auxiliares;

import Entidades.Mario;


/**
 * Implementa un Cuadrado utilizando la clase Borde
 * 
 * 
 * */
public class Cuadrado extends Borde{
	
		
		
		
		//Constructor
	public Cuadrado(int x,int y)
	{
		this.x1=x;
		this.y1=y;
		this.x2=x+32;
		this.y2=y+32;

		
	}
	
	
	//Setters
	public void setPosicion(int x,int y)
	{
		this.x1=x;
		this.x2=x+32;
		this.y1=y;
		this.y2=y+32;
	}
	
	
	//Getters
	
	
	public int getX1()
	{
		return x1;
	}
	
	public int getX2()
	{
		return x2;
	}
	
	public int getY1()
	{
		return y1;
	}
	
	public int getY2()
	{
		return y2;
	}
	
	
	
	
	/**	
	 * 
	 * @return True, si existe una colision entre los cuadrados, unicamente por derecha
	 * 		   False, si no existe colision por derecha
	 * @param Cuadrado c	
	 */
	public boolean colisionaPorDerecha(Cuadrado c)
	{
		int y1=c.getY1();
		int y2=c.getY2();
		int x1=c.getX1();
		int x2=c.getX2();
		if(  (x1==this.x2) && (y1==this.y1) && (y2==this.y2)) {return true;}   //PARA EL CASO EN QUE MARIO ESTE EXACTAMENTE AL LADO DEL OBJETO
		if(  (this.x2==x1) && (this.y1>y1) && (this.y1<y2) && (this.y2>y2) ) {return true;}     //PARA EL CASO EN QUE MARIO ESTE EXACTAMENTE AL LADO DEL OBJETO PERO UN POQUITO MAS ABAJO
		if(  (this.x2==x1) && (this.y1<y1) && (this.y2<y2) && (this.y2>y1) ) {return true;}     //PARA EL CASO EN QUE MARIO ESTE EXACTAMENTE AL LADO DEL OBJETO PERO UN POQUITO MAS ARRIBA
	    
		
		return false;
	}
	
	/**	
	 * @return True, si existe una colision entre los cuadrados, unicamente por Abajo
	 * 		   False, si no existe colision por Abajo
	 * @param Borde c	
	 */
	public boolean colisionaPorAbajo(Cuadrado c)
	{
		int y1=c.getY1();
		int y2=c.getY2();
		int x1=c.getX1();
		int x2=c.getX2();
		if( (this.x1==x1) && (this.x2==x2) && (this.y2==y1) ) {return true;}  //PARA EL CASO EN QUE MARIO ESTE EXACTAMENTE ARRIBA DEL OBJETO
		if( (this.y2==y1) && (this.x1<x1) && (this.x2>x1) && (this.x2<x2) ) {return true;}  //PARA EL CASO EN QUE MARIO ESTE EXACTAMENTE ARRIBA DEL OBJETO PERO UN POQUITO CORRIDO A LA IZQUIERDA
		if( (this.y2==y1) && (this.x2>x2) && (this.x1>x1) && (this.x1<x2) ) {return true;}  //PARA EL CASO EN QUE MARIO ESTE EXACTAMENTE ARRIBA DEL OBJETO PERO UN POQUITO CORRIDO A LA DERECHA
		 
		return false;
	}
	
	/**	
	 * @return True, si existe una colision entre los cuadrados, unicamente por Izquierda
	 * 		   False, si no existe colision por izquierda
	 * @param Borde c	
	 */
	public boolean colisionaPorIzquierda(Cuadrado c)
	{
		int y1=c.getY1();
		int y2=c.getY2();
		int x1=c.getX1();
		int x2=c.getX2();
		if( (this.x1==x2) && (this.y1==y1) && (this.y2==y2) ) {return true;}  //PARA EL CASO EN QUE MARIO ESTE EXACTAMENTE A LA IZQUIERDA DEL OBJETO
		if( (this.x1==x2) && (this.y1<y1) && (this.y2>y1) && (this.y2<y2) ) {return true;} //PARA EL CASO EN QUE MARIO ESTE EXACTAMENTE A LA IZQUIERDA DEL OBJETO PERO UN POQUITO MAS ARRIBA
		if( (this.x1==x2) && (this.y2>y2) && (this.y1>y1) && (this.y1<y2) ) {return true;} //PARA EL CASO EN QUE MARIO ESTE EXACTAMENTE A LA IZQUIERDA DEL OBJETO PERO UN POQUITO MAS ABAJO
		
		return false;
		
	}
		
	/**	
	 * @return True, si existe una colision entre los cuadrados, unicamente por Arriba
	 * 		   False, si no existe colision por Arriba
	 * @param Borde c	
	 */
	public boolean colisionaPorArriba(Cuadrado c)
	{
		int y1=c.getY1();
		int y2=c.getY2();
		int x1=c.getX1();
		int x2=c.getX2();
		if( (this.y1==y2) && (this.x1==x1)) {return true;}   //PARA EL CASO EN QUE MARIO ESTE EXACTAMENTE ABAJO DEL OBJETO
		if( (this.y1==y2) && (this.x2>x2) && (this.x1>x1) && (this.x1<x2)){return true;}  //PARA EL CASO EN QUE MARIO ESTE EXACTAMENTE ABAJO DEL OBJETO PERO UN POQUITO A LA DERECHA
		if( (this.y1==y2) && (this.x1<x1) && (this.x2>x1) && (this.x2<x2)){return true;} //PARA EL CASO EN QUE MARIO ESTE EXACTAMENTE ABAJO DEL OBJETO PERO UN POQUITO A LA IZQUIERDA
		return false;
		
	}
	

}
