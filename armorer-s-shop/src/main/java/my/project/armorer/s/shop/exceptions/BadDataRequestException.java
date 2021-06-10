package my.project.armorer.s.shop.exceptions;

public class BadDataRequestException extends RuntimeException{
    public BadDataRequestException(String message) {
        super(message);
    }
}
