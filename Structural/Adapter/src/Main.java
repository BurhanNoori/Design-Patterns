/*
* An adapter pattern is used to allow two incompatible interfaces to work together.
* It acts as a bridge between the two interfaces, allowing them to communicate with each other.
* The recipie for an adapter pattern typically involves the following components:
* 1. Target Interface: This is the interface that the client expects to work with.
* 2. Adaptee: This is the existing interface that needs to be adapted to the target interface.
* 3. Adapter: This is the class that implements the target interface and contains an instance of the adaptee.
* The adapter translates the requests from the target interface to the adaptee interface.
* This way the client will not work with the target interface (as it is not compatible) instead it will call the adapter.
* Now the adapter has the same method which the client used to call for other adaptee implementations.
*
* */


public class Main {

    interface player {
        void play(String audioType, String fileName);
    }

    interface advancedPlayer {
        void playVlc(String fileName);
        void playMp4(String fileName);
    }

    class MediaPlayer implements player {
        public void play(String audioType, String fileName) {
            // Default implementation
            System.out.println("Playing " + audioType + " file: " + fileName);
        }
    }

    class AdvancedMediaPlayer implements advancedPlayer{
        public void playVlc(String fileName) {
            System.out.println("Playing vlc file: " + fileName);
        }

        public void playMp4(String fileName) {
            System.out.println("Playing mp4 file: " + fileName);
        }
    }


    class MediaAdapter implements player {
        advancedPlayer advancedMusicPlayer;

        public MediaAdapter(String audioType) {
            if(audioType.equalsIgnoreCase("vlc")) {
                advancedMusicPlayer = new AdvancedMediaPlayer();
            } else if(audioType.equalsIgnoreCase("mp4")) {
                advancedMusicPlayer = new AdvancedMediaPlayer();
            }
        }

        public void play(String audioType, String fileName) {
            if(audioType.equalsIgnoreCase("vlc")) {
                advancedMusicPlayer.playVlc(fileName);
            } else if(audioType.equalsIgnoreCase("mp4")) {
                advancedMusicPlayer.playMp4(fileName);
            }
        }
    }


    public static void main(String[] args) {
        Main main = new Main();
        MediaPlayer audioPlayer = main.new MediaPlayer();

        audioPlayer.play("mp3", "beyond the horizon.mp3");

        //mediaAdapter is providing support to play vlc and mp4 file formats
        player mediaAdapter = main.new MediaAdapter("vlc");
        mediaAdapter.play("vlc", "far far away.vlc");

        mediaAdapter = main.new MediaAdapter("mp4");
        mediaAdapter.play("mp4", "alone.mp4");
    }
}