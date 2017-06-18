package pw.vhome.ticketsystem.controller;

import pw.vhome.ticketsystem.data.InquiryProducer;
import pw.vhome.ticketsystem.model.Inquiry;

import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;

/**
 * Created by vitz on 14.06.17.
 */
@Named
@SessionScoped
public class ControllerTest implements Serializable{

    public static final long serialVersionUID = 98760123L;

    public String doIT(){
        return Pages.EDIT_INQUIRY;
    }
    @Inject
    private InquiryProducer inquiryProducer;

    public String doAddTicket(){
        inquiryProducer.prepareAddInquiry();
        return Pages.EDIT_INQUIRY;
    }

    public String doEditInquiry(Inquiry inquiry) {
        inquiryProducer.prepareEditInquiry(inquiry);
        return Pages.EDIT_INQUIRY;
    }
}
