package gazi.university;

import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;

public class Music_Adder {

    public Music_Adder() throws UnsupportedAudioFileException, IOException, LineUnavailableException {

        File file = new File("C:\\Users\\nothi\\Desktop\\Music\\DOOM.wav");
        AudioInputStream audioStream = AudioSystem.getAudioInputStream(file);
        Clip clip = AudioSystem.getClip();
        clip.open(audioStream);
        clip.start();

    }

}
