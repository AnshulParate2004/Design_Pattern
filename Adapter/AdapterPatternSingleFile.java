// Save as AdapterPatternSingleFile.java
// Demonstrates both Object Adapter and Class Adapter in ONE Java file.

public class AdapterPatternSingleFile {
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

    /* =====================
     * 1) Target interface
     * ===================== */
    interface Target {
        void play(String fileName);
    }

    /* =====================
     * 2) Adaptee (incompatible API)
     *    Think of this as a closed-source or legacy lib you can't change.
     * ===================== */
    static class LegacyAudioLibrary {
        // Different method name and signature the client can't use directly
        public void playFile(String path) {
            System.out.println("[Legacy] Decoding & playing: " + path);
        }
    }

    /* =====================================
     * 3a) Object Adapter (composition)
     *     - Wraps an instance of the adaptee
     *     - Most flexible: can swap adaptee at runtime, combine multiple adaptees
     * ===================================== */
    static class ObjectAdapter implements Target {
        private final LegacyAudioLibrary legacy;

        public ObjectAdapter(LegacyAudioLibrary legacy) {
            this.legacy = legacy;
        }

        @Override
        public void play(String fileName) {
            // Translate Target call to Adaptee call
            String normalizedPath = normalize(fileName);
            legacy.playFile(normalizedPath);
        }

        private String normalize(String fileName) {
            // small example transform (could add path resolution, validation, etc.)
            return fileName.trim();
        }
    }

    /* =====================================
     * 3b) Class Adapter (inheritance)
     *     - Extends the adaptee AND implements the target
     *     - Less flexible (Java has single inheritance for classes), but concise
     * ===================================== */
    static class ClassAdapter extends LegacyAudioLibrary implements Target {
        @Override
        public void play(String fileName) {
            String normalizedPath = normalize(fileName);
            // Call inherited adaptee method directly
            playFile(normalizedPath);
        }

        private String normalize(String fileName) {
            return fileName.trim();
        }
    }
}
