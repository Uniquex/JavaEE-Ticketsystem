package pw.vhome.ticketsystem.controller;

import pw.vhome.ticketsystem.data.InquiryListProducer;
import pw.vhome.ticketsystem.data.InquiryProducer;
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


/**
 * Created by vitz on 14.06.17.
 */

@SessionScoped
@Named
public class EditInquiryController implements Serializable {
    private static final long serialVersionUID = 2815989L;

    @Inject @Events.Added
    private Event<Inquiry> inquiryAddEvent;

    @Inject
    private InquiryProducer inquiryProducer;

    public String doSave(){
        if(inquiryProducer.isAddMode()){
            inquiryAddEvent.fire(inquiryProducer.getSelectedInquiry());
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

    public SelectItem[] getKindPriorities() {
        SelectItem[] items = new SelectItem[Inquiry.Priority.values().length];
        int i = 0;
        for(Inquiry.Priority k: Inquiry.Priority.values()) {
            items[i++] = new SelectItem(k, k.name());
        }
        return items;
    }

    public String doCancel() {
        return Pages.LIST_INQUIRIES;
    }

}
