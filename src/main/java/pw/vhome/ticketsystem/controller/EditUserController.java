package pw.vhome.ticketsystem.controller;

import pw.vhome.ticketsystem.data.UserListProducer;
import pw.vhome.ticketsystem.data.UserProducer;
import pw.vhome.ticketsystem.data.UserProducer;
import pw.vhome.ticketsystem.model.User;
import pw.vhome.ticketsystem.model.User;
import pw.vhome.ticketsystem.util.Events;

import javax.enterprise.context.SessionScoped;
import javax.enterprise.event.Event;
import javax.faces.model.SelectItem;
import javax.inject.Inject;
import javax.inject.Named;
import javax.jws.soap.SOAPBinding;
import java.io.Serializable;


/**
 * Created by vitz on 14.06.17.
 */

@SessionScoped
@Named
public class EditUserController implements Serializable {
    private static final long serialVersionUID = 2815989L;

    @Inject @Events.Added
    private Event<User> userAddEvent;

    @Inject @Events.Updated
    private Event<User> userUpdateEvent;

    @Inject
    private UserProducer userProducer;

    public String doSave(){
        if(userProducer.isAddMode()){
            userAddEvent.fire(userProducer.getSelectedUser());
        } else {
            userUpdateEvent.fire(userProducer.getSelectedUser());
        }
        return Pages.LIST_INQUIRIES;
    }

    public SelectItem[] getLevels() {
        SelectItem[] items = new SelectItem[User.Level.values().length];
        int i = 0;
        for(User.Level k: User.Level.values()) {
            items[i++] = new SelectItem(k, k.name());
        }
        return items;
    }


    public String doCancel() {
        return Pages.LIST_INQUIRIES;
    }

}
