package culturemedia.exception;

public class VideoNotFoundException extends RuntimeException {
    public VideoNotFoundException() {
        super("There are no videos");
    }
    public VideoNotFoundException(String message) {
        super(message);
    }
}

