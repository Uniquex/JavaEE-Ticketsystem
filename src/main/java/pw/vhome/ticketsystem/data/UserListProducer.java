package pw.vhome.ticketsystem.data;

import pw.vhome.ticketsystem.model.User;
import pw.vhome.ticketsystem.model.User;
import pw.vhome.ticketsystem.services.UserService;
import pw.vhome.ticketsystem.services.UserService;
import pw.vhome.ticketsystem.util.Events;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.context.SessionScoped;
import javax.enterprise.event.Observes;
import javax.enterprise.inject.Produces;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;


@RequestScoped
public class UserListProducer
{
    private List<User> users;


    @Inject
    private UserService userService;

    @PostConstruct
    public void init() {
        users = userService.getAllUsers();
    }

    @Produces
    @Named
    public List<User> getUsers() {
        return users;
    }


    public void onUserAdded(@Observes @Events.Added User inquiry) {
        userService.addUser(inquiry);
        init();
    }

    public void onUserDeleted(@Observes @Events.Deleted User inquiry) {
        userService.deleteUser(inquiry);
        init();
    }

    public void onActionUpdated(@Observes @Events.Updated User inquiry) {
        userService.updateUser(inquiry);
        init();
    }
}
