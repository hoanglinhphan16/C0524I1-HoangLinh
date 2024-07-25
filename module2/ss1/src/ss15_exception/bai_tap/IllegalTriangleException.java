package ss15_exception.bai_tap;

public class IllegalTriangleException extends RuntimeException{
    public IllegalTriangleException(){}
    public IllegalTriangleException(String message){
        super(message);
    }
}
