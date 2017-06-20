package pw.vhome.ticketsystem.controller;

import pw.vhome.ticketsystem.data.InquiryListProducer;
import pw.vhome.ticketsystem.data.InquiryProducer;
import pw.vhome.ticketsystem.data.UserListProducer;
import pw.vhome.ticketsystem.data.UserProducer;
import pw.vhome.ticketsystem.model.Inquiry;
import pw.vhome.ticketsystem.model.User;
import pw.vhome.ticketsystem.util.Events;

import javax.enterprise.context.SessionScoped;
import javax.enterprise.event.Event;
import javax.enterprise.event.Observes;
import javax.faces.model.SelectItem;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;


/**
 * Created by vitz on 14.06.17.
 */

@SessionScoped
@Named
public class EditInquiryController implements Serializable {
    private static final long serialVersionUID = 2815989L;

    @Inject @Events.Added
    private Event<Inquiry> inquiryAddEvent;

    @Inject @Events.Updated
    private Event<Inquiry> inquiryUpdateEvent;

    @Inject
    private InquiryProducer inquiryProducer;

    @Inject
    private UserListProducer userListProducer;

    public String doSave(){
        if(inquiryProducer.isAddMode()){
            inquiryAddEvent.fire(inquiryProducer.getSelectedInquiry());
        } else {
            inquiryUpdateEvent.fire(inquiryProducer.getSelectedInquiry());
        }
        return Pages.LIST_INQUIRIES;
    }

    public SelectItem[] getKindValues() {
        SelectItem[] items = new SelectItem[Inquiry.Kind.values().length];
        int i = 0;
        for(Inquiry.Kind k: Inquiry.Kind.values()) {
            items[i++] = new SelectItem(k, k.name());
        }
        return items;
    }

    public SelectItem[] getPriorities() {
        SelectItem[] items = new SelectItem[Inquiry.Priority.values().length];
        int i = 0;
        for(Inquiry.Priority k: Inquiry.Priority.values()) {
            items[i++] = new SelectItem(k, k.name());
        }
        return items;
    }

    public SelectItem[] getUsers() {

        List<User> users = userListProducer.getUsers();

        SelectItem[] items = new SelectItem[users.size()];

        int i = 0;
        for(User u: users) {
            items[i++] = new SelectItem(u, u.getFirstName() + " " + u.getLastName() );
        }
        return items;
    }

    public String doCancel() {
        return Pages.LIST_INQUIRIES;
    }

}
