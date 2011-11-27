package Movimiento;

import javax.swing.JLabel;
import Auxiliares.Cuadrado;
import Entidades.Entidad;
import Entidades.Item;
import Entidades.Mario;
import Entidades.PiedraIrrompible;
import Gravedad.Gravedad;

//Esta clase hace saltar al jugador actualizandolo logica y graficamente.

public class Salto extends Thread {
	
	private Gravedad gravity;
	private Mario jugador;
	
	
	public Salto(Gravedad g,Mario m)
	{
		jugador=m;
		gravity=g;
	}
	
	public void run() {
		
		try {
			if(!jugador.getFinish()){
			//System.out.println(jugador.getBorde().getX1()+" "+jugador.getBorde().getY1());
			Cuadrado bordeMario = (Cuadrado) jugador.getBorde();
			boolean control = false;
			
			
			//Controla que no haya nada arriba
			
			for (Entidad aux : jugador.getObjetos()) {
			
				Cuadrado bordeEntidad = (Cuadrado) aux.getBorde();
				if (bordeMario.colisionaPorArriba(bordeEntidad)) {
					if (((PiedraIrrompible) aux).tieneItem()) {

						((PiedraIrrompible) aux).sacarItem();

					}
			
					control = true;
					break;

				}
				
			}

			Thread.sleep(50);
			if (!control) {
				gravity.suspend();
				jugador.setEstaSaltando(true);
				JLabel label = jugador.getLabel();
				for (int i = 0; i < 15 && !control; i++) {

					
					label.setLocation(label.getLocation().x,
							label.getLocation().y - 8);
					jugador.setEstaSaltando(true);

					jugador.setPosicion(jugador.getPosicion().getX(),
							jugador.getPosicion().getY() - 8);
					jugador.setBorde(jugador.getBorde().getX1(), jugador
							.getBorde().getY1() - 8);

				
					Thread.sleep(30);
					
					
					
					for (Entidad aux : jugador.getObjetos()) {
						Cuadrado bordeEntidad = (Cuadrado) aux.getBorde();
						bordeMario = (Cuadrado) jugador.getBorde();
						if (bordeMario.colisionaPorArriba(bordeEntidad)) {
							if (((PiedraIrrompible) aux).tieneItem()) {
								((PiedraIrrompible) aux).sacarItem();

							}
							control = true;
							break;
						}
						
					}
					
				
				}

				this.gravity.resume();
				
				
			}}

		} catch (Exception e) {
		}
	}
	}
	


