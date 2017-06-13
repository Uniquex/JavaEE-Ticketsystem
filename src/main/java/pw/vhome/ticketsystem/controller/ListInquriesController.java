package pw.vhome.ticketsystem.controller;

import pw.vhome.ticketsystem.data.InquiryProducer;
import pw.vhome.ticketsystem.model.Inquiry;

import javax.inject.Inject;
import java.io.Serializable;

/**
 * Created by vitz on 09.06.17.
 */
public class ListInquriesController implements Serializable{

    @Inject
    private InquiryProducer inquiryProducer;

    public String doAddTicket(){
        inquiryProducer.prepareAddInquiry();
        return Pages.Edit_Ticket;
    }

    public String doEditCampaign(Inquiry inquiry) {
        inquiryProducer.prepareEditInquiry(inquiry);
        return Pages.Edit_Ticket;
    }

    public String doListUsers() {
        return  Pages.List_Users;
    }
}
