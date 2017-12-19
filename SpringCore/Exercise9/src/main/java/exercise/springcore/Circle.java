package exercise.springcore;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.Resource;

@Component //or Repository,service,controller
public class Circle implements Shape,ApplicationEventPublisherAware {

    private Point centre;
    private ApplicationEventPublisher aep;
    @Autowired
    private MessageSource messageSource;

    public Point getCentre() {
        return centre;
    }

    @Resource
    public void setCentre(Point centre) {
        this.centre = centre;
    }

    public void setMessageSource(MessageSource messageSource) {
        this.messageSource = messageSource;
    }

    public void draw() {
        //System.out.println("Drawing Circle");
        //System.out.println("Circle Centre point - (" + centre.getX() + "," + centre.getY() + ")");
        System.out.println(messageSource.getMessage("greeting",null,"Default",null));
        System.out.println(messageSource.getMessage("drcr",null,"Default",null));
        System.out.println(messageSource.getMessage("drpoints",new Object[] {centre.getX(),centre.getY()},"Default",null));
        DrawEvent drawEvent = new DrawEvent(this);
        aep.publishEvent(drawEvent);

    }

    @PostConstruct
    public void intializeCircle() {
        System.out.println("in intializeCircle");
    }

    @PreDestroy
    public void destroyCircle() {
        System.out.println("in destroyCircle");
    }

    public void setApplicationEventPublisher(ApplicationEventPublisher applicationEventPublisher) {
        this.aep=applicationEventPublisher;

    }
}
