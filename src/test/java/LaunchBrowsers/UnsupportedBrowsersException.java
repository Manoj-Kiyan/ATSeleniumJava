package LaunchBrowsers;

// Custom exception for unsupported browsers
public class UnsupportedBrowsersException extends RuntimeException {
    public UnsupportedBrowsersException(String message) {
        super("Unsupported browser: " + message);
    }
}

