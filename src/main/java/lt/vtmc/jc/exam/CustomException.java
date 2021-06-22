package lt.vtmc.jc.exam;

//class for custom expection to be thrown
public class CustomException extends Exception {
    public CustomException(String errorMessage) {
        super(errorMessage);
    }
}