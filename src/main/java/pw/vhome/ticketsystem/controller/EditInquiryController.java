package pw.vhome.ticketsystem.controller;

import pw.vhome.ticketsystem.data.InquiryListProducer;
import pw.vhome.ticketsystem.data.InquiryProducer;
import pw.vhome.ticketsystem.model.Inquiry;
import pw.vhome.ticketsystem.model.User;
import pw.vhome.ticketsystem.util.Events;

import javax.enterprise.context.SessionScoped;
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
    private Event<Inquiry> campaignAddEvent;

    @Inject
    private InquiryListProducer inquiryListProducer;

    @Inject
    private InquiryProducer inquiryProducer;

    public String doSave(){
        if(inquiryProducer.isAddMode()) {
            inquiryListProducer.getInquiries().add(inquiryProducer.getSelectedInquiry());
        }
        return Pages.LIST_INQUIRIES;
    }

    public String doCancel() {
        return Pages.LIST_INQUIRIES;
    }

}
