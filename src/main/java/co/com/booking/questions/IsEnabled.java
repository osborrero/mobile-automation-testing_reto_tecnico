package co.com.booking.questions;

import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.annotations.Subject;
import net.serenitybdd.screenplay.targets.Target;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isEnabled;

@Subject("the #target is enabled - ")
public class IsEnabled implements Question<Boolean> {

    private Target target;

    public IsEnabled(Target target) {
        this.target = target;
    }

    public static IsEnabled theTarget(Target target) {
        return Instrumented.instanceOf(IsEnabled.class).withProperties(target);
    }

    @Override
    public Boolean answeredBy(Actor actor) {
        actor.attemptsTo(
                WaitUntil.the(target, isEnabled())
                        .forNoMoreThan(10)
                        .seconds()
        );
        return target.resolveFor(actor).isCurrentlyEnabled();
    }

}
