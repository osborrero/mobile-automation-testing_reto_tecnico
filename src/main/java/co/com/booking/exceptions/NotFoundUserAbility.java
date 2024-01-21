package co.com.booking.exceptions;

public class NotFoundUserAbility extends RuntimeException {
    public NotFoundUserAbility(){
        super ("El actor no tiene esta habilidad");
    }

}
