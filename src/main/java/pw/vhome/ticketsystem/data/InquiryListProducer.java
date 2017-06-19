package pw.vhome.ticketsystem.data;

import pw.vhome.ticketsystem.model.Inquiry;
import pw.vhome.ticketsystem.services.InquiryService;
import pw.vhome.ticketsystem.util.Events;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.enterprise.event.Observes;
import javax.enterprise.inject.Produces;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;


@SessionScoped
public class InquiryListProducer implements Serializable
{
    private static final long serialVersionUID = -182866064791747156L;
    private List<Inquiry> inquiries;


    @Inject
    private InquiryService inquiryService;

    @PostConstruct
    public void init() {
        inquiries = inquiryService.getAllInquiries();
    }

    @Produces
    @Named
    public List<Inquiry> getInquiries() {
        return inquiries;
    }


    public void onInquiryAdded(@Observes @Events.Added Inquiry inquiry) {
        getInquiries().add(inquiry);
    }

    public void onInquiryDeleted(@Observes @Events.Deleted Inquiry inquiry) {
        getInquiries().remove(inquiry);
    }

//    public void onAktionUpdated(@Observes @Updated Inquiry inquiry) {
//        inquiryService.updateInquiry(inquiry);
//        init();
//    }
}
