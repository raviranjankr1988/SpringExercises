package exercise.springcore;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;

public class DrawEvent extends ApplicationEvent {
    public DrawEvent(Object source) {
        super(source);
    }

    @Override
    public String toString() {
        return "Draw Event Occured";
    }
}
