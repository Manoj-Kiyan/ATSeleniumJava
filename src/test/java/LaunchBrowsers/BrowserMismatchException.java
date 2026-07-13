package LaunchBrowsers;

// Custom exception for OS/browser mismatch
public class BrowserMismatchException extends RuntimeException {
    public BrowserMismatchException(String message) {
        super("Browser mismatch: " + message);
    }
}
