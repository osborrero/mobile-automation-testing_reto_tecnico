package co.com.booking.interactions;

import net.serenitybdd.markers.IsHidden;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Tasks;

public class Pause implements Interaction, IsHidden {
    private final int seconds;

    public Pause(int seconds) {
        this.seconds = seconds;
    }

    public static Pause withDuration(int seconds) {
        return Tasks.instrumented(Pause.class, seconds);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        try {
            Thread.sleep(seconds * 1_000L);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
