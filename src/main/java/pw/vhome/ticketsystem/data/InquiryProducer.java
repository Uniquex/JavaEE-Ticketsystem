package pw.vhome.ticketsystem.data;

import pw.vhome.ticketsystem.model.Inquiry;
import sun.util.resources.cldr.en.CalendarData_en_MP;

import javax.enterprise.context.Dependent;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import javax.ws.rs.Produces;

/**
 * Created by vitz on 09.06.17.
 */
@SessionScoped
@Named
public class InquiryProducer implements java.io.Serializable {
    private static final long serialVersionUID = 1828660647917534556L;

    private enum Mode{
        EDIT, ADD
    }

    private Inquiry inquiry;
    private Mode mode;


    public void setSelectedInquiry(Inquiry inquiry) {
        this.inquiry = inquiry;
    }

    public void prepareAddInquiry(){
        this.inquiry = new Inquiry();
        this.mode = Mode.ADD;
    }

    public void prepareEditInquiry(Inquiry inquiry) {
        this.inquiry = inquiry;
        this.mode = Mode.EDIT;
    }

    @Produces
    @Named
    public Inquiry getSelectedInquiry(){
        return inquiry;
    }

    @Produces
    @Named
    public boolean isAddMode() {
        return mode == Mode.ADD;
    }

}
