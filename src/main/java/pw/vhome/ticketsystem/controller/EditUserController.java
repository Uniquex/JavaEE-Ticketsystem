package pw.vhome.ticketsystem.controller;

import pw.vhome.ticketsystem.data.InquiryListProducer;
import pw.vhome.ticketsystem.data.InquiryProducer;
import pw.vhome.ticketsystem.data.UserProducer;
import pw.vhome.ticketsystem.model.User;

import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;


/**
 * Created by vitz on 14.06.17.
 */

@SessionScoped
@Named
public class EditUserController implements Serializable {
    private static final long serialVersionUID = 2835989L;

    @Inject
    private InquiryListProducer inquiryListProducer;

    @Inject
    private UserProducer userProducer;

    public String doSave(){
        if(userProducer.isAddMode()) {
            inquiryListProducer.onInquiryAdded() .get(0).setAgent(userProducer.getSelectedUser());
        }
        return Pages.LIST_INQUIRIES;
    }

    public String doCancel() {
        return Pages.LIST_INQUIRIES;
    }

}
