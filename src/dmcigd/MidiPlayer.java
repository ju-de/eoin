package dmcigd;

import java.applet.AudioClip;
import java.applet.Applet;
import java.net.MalformedURLException;
import java.net.URL;

public class MidiPlayer {
	static AudioClip currentMusic;
	
	static void endSong() {
		if(currentMusic != null) {
			currentMusic.stop();
		}
	}
	
	static void startSong(String fileName, URL codeBase) {
		currentMusic = loadSound(fileName, codeBase);
		if(currentMusic != null) {
			currentMusic.loop();
		}
	}
	
	static AudioClip loadSound(String fileName, URL codeBase) {
		
		AudioClip loadedSound = null;
		
		try {
			
			URL soundFileURL = new URL(codeBase, "../share/snd/" + fileName);
			loadedSound = Applet.newAudioClip(soundFileURL);
			
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		
		return loadedSound;
	}
}
