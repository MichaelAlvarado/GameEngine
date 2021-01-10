package Resources;

import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedList;

public class SoundManager {

	//Audio
	private File audioFile;
	private AudioInputStream audioStream;
	private AudioFormat format;
	private DataLine.Info info;
	private HashMap<String,Clip> audioChannels;
	private boolean soundOn = true;

	public SoundManager(){
		audioChannels = new HashMap<String,Clip>();
	}

	private Clip loadAudio(String url) {
		try {
			//Read Audio File
			audioFile = new File("res/music/" + url + ".wav");
			audioStream = AudioSystem.getAudioInputStream(audioFile);
			format = audioStream.getFormat();
			info = new DataLine.Info(Clip.class, format);

			Clip audioClip = (Clip) AudioSystem.getLine(info);
			audioClip.open(audioStream);
			audioClip.loop(0);
			setVolumen(audioClip, (float) 30.0);
			
			return audioClip;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	

	/**
	 * Description - This method play once a given .wav sound
	 * Precondition - Placed the .wav file in res/music/
	 * @author - Michael J. Alvarado
	 * @date Apr 9, 2020
	 * @param str - This is the name of the Audiofile (It must be in res/music/). This file must be .wav and dont give + ".wav" just give the name.
	 */
	public void play(String str) {
		Clip clip = loadAudio(str);
		clip.start();
	}

	/**
	 * Description - This method let you add sounds to use later with methods startAudio, resumeAudio, stopAudio
	 * @author - Michael J. Alvarado
	 * @date Apr 10, 2020
	 * @param str - name of the .wav file in res/music/
	 */
	public void addAudio(String str) {
		audioChannels.put(str, loadAudio(str));
		stopAudio(str);
	}

	/**
	 * Description - This method resume the audio given. Could be use in tick or render to keep a loop audio.
	 * PreCondition - the audio has to be added first by using addAudio(str) method 
	 * @author - Michael J. Alvarado
	 * @date Apr 10, 2020
	 * @param str - name of the .wav file in res/music/. (Has to be added by using addAudio)
	 */
	public void resumeAudio(String clip) {
		if(soundOn == true) {
		Clip audioClip = audioChannels.get(clip);
		if(audioClip.getMicrosecondPosition() == audioClip.getMicrosecondLength()) {
			startAudio(clip);
		}
		audioClip.start();
		}
	}

	/**
	 * Description - restarts Audio and play.
	 * PreCondition - the audio has to be added first by using addAudio(str) method 
	 * @author - Michael J. Alvarado
	 * @date Apr 10, 2020
	 * @param str - name of the .wav file in res/music/. (Has to be added by using addAudio)
	 */
	public void startAudio(String clip) {
		if(soundOn == true) {
		Clip audioClip = audioChannels.get(clip);
		audioClip.setMicrosecondPosition(0);
		audioClip.start();
		}
	}

	/**
	 * Description - stops the audio
	 * PreCondition - the audio has to be added first by using addAudio(str) method 
	 * @author - Michael J. Alvarado
	 * @date Apr 10, 2020
	 * @param str - name of the .wav file in res/music/. (Has to be added by using addAudio)
	 */
	public void stopAudio(String clip) {
		audioChannels.get(clip).stop();
	}

	/**
	 * Description - returns the Clip with clip name
	 * PreCondition - the audio has to be added first by using addAudio(str) method 
	 * @author - Michael J. Alvarado
	 * @date Apr 10, 2020
	 * @param str - name of the .wav file in res/music/. (Has to be added by using addAudio) 
	 */
	public Clip getAudioClip(String clip) {
		return audioChannels.get(clip);
	}

	/**
	 * Description - Set volumen of the given clip
	 * PreCondition - if given a volumen greater that 46 it fails
	 * @author - Michael J. Alvarado
	 * @date Apr 10, 2020
	 * @param clip - Clip to set the volumen to
	 * @param volumen - 0 is no sound to 46.0 which is high volumen
	 */
	public void setVolumen(Clip clip, float volumen) {
		FloatControl gainControl = (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
		gainControl.setValue(volumen-40);
	}
	
	
	public boolean soundToggle() {
		if(soundOn == true) {
			return soundOn = false;
		} else
		return soundOn = true;
	}

}