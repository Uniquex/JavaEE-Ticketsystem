package pw.vhome.ticketsystem.controller;

import pw.vhome.ticketsystem.data.InquiryProducer;
import pw.vhome.ticketsystem.data.UserProducer;
import pw.vhome.ticketsystem.model.Inquiry;
import pw.vhome.ticketsystem.model.User;
import pw.vhome.ticketsystem.util.Events;

import javax.enterprise.context.SessionScoped;
import javax.enterprise.event.Observes;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;

/**
 * Created by vitz on 14.06.17.
 */
@Named
@SessionScoped
public class ListInquiriesController implements Serializable{

    public static final long serialVersionUID = 98760987L;

    @Inject
    private InquiryProducer inquiryProducer;

    @Inject
    private UserProducer userProducer;

    public String doAddInquiry(){
        inquiryProducer.prepareAddInquiry();
        return Pages.EDIT_INQUIRY;
    }

    public String doEditInquiry(Inquiry inquiry) {
        inquiryProducer.prepareEditInquiry(inquiry);
        return Pages.EDIT_INQUIRY;
    }

    public String doEditUser(User user){
        userProducer.prepareEditUser(user);
        return Pages.EDIT_USER;
    }
}
