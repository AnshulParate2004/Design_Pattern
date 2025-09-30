package Adapter;


public public class Adapter{
    public static void main(String[] args) {
        System.out.println("--- Object Adapter demo ---");
        Target player1 = new ObjectAdapter(new LegacyAudioLibrary());
        player1.play("song.mp3");
        player1.play("podcast.wav");

        System.out.println();
        System.out.println("--- Class Adapter demo ---");
        Target player2 = new ClassAdapter();
        player2.play("lecture.aac");
        player2.play("mix.flac");
    }
    interface Target{
        void play(String fileName);
    }
    static class LegacyAudioLibrary{
               public void playFile(String path) {
            System.out.println("[Legacy] Decoding & playing: " + path);
        }
    }

 

}

