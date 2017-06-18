package pw.vhome.ticketsystem.util;


import javax.enterprise.context.Dependent;
import javax.enterprise.inject.Produces;
import javax.enterprise.inject.spi.InjectionPoint;
import javax.faces.context.FacesContext;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.logging.Logger;

/**
 * Created by vitz on 24.05.17.
 */
@Dependent
public class Resources {

    @Produces
    @PersistenceContext
    private EntityManager em;


    @Produces
    public Logger produceLog() {
        return Logger.getLogger("MyLogger", "messages");
    }

    @Produces
    public FacesContext produceFacesContext() {
        return FacesContext.getCurrentInstance();
    }

    @Produces
    public Logger producesLog(InjectionPoint injectionPoint) {
        return Logger.getLogger(injectionPoint.getMember().getDeclaringClass().getName(), "messages");
    }
}