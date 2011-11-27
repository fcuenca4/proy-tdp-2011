package Main;

import java.io.IOException;

import javax.sound.sampled.AudioFileFormat;
import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

public class Audio {
	
	protected String name;
	protected Clip sonido;
	protected AudioFileFormat aff;
	protected AudioInputStream ais;

	public Audio(String name) {
		this.name = name;
	}

	/**
	 * Pone en reproduccion el sonido.El parámetro indica la cantidad de repeticiones.
	 */
	public void reproducir(int count) {
		
		try {
			aff = AudioSystem.getAudioFileFormat(getClass().getResource(name));
			ais = AudioSystem.getAudioInputStream(getClass().getResource(name));
			AudioFormat af = aff.getFormat();
			DataLine.Info info = new DataLine.Info(Clip.class, ais.getFormat(), ((int) ais.getFrameLength() * af.getFrameSize()));
			sonido = (Clip) AudioSystem.getLine(info);
			sonido.open(ais);
			sonido.loop(count);// Clip.LOOP_CONTINUOUSLY
		} catch (IOException e1) {System.out.println("excecion 1");
		} catch (LineUnavailableException e2) {System.out.println("excepcion 2");

		} catch (UnsupportedAudioFileException e3) {System.out.println("excepcion 3");

		}
	}

	/**
	 * Detiene la reproduccion del audio.
	 */
	public void stop() {
		sonido.stop();
		sonido.close();
	}

	
	/**
	 * Retorna si el audio se esta reproduciendo.
	 */
	public boolean isRunning() {
		if (sonido != null)
			return sonido.isRunning();
		else
			return false;
	}

}

