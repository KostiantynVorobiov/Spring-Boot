package springboot.demo.exeption;

public class FileReaderException extends RuntimeException {
    public FileReaderException(String message, Throwable exception) {
        super(message, exception);
    }
}
