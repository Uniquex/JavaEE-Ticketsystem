package pw.vhome.ticketsystem.data;

import pw.vhome.ticketsystem.model.User;


import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import javax.ws.rs.Produces;

/**
 * Created by vitz on 09.06.17.
 */
@SessionScoped
@Named
public class UserProducer implements java.io.Serializable {
    private static final long serialVersionUID = 1828660647917534556L;

    private enum Mode{
        EDIT, ADD
    }

    private User user;
    private Mode mode;


    public void setSelectedUser(User user) {
        this.user = user;
    }

    @Produces
    @Named
    public boolean isAddMode() {
        return mode == Mode.ADD;
    }

    public void prepareAddUser(){
        this.user = new User();
        this.mode = Mode.ADD;
    }

    public void prepareEditUser(User user) {
        this.user = user;
        this.mode = Mode.EDIT;
    }

    @Produces
    @Named
    public User getSelectedUser(){
        return user;
    }



}
