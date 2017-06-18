package pw.vhome.ticketsystem.data;

import pw.vhome.ticketsystem.model.Inquiry;
import pw.vhome.ticketsystem.model.User;
import pw.vhome.ticketsystem.util.Events;

import javax.enterprise.context.SessionScoped;
import javax.enterprise.event.Observes;
import javax.inject.Named;
import java.io.Serializable;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;


@SessionScoped
@Named
public class InquiryListProducer implements Serializable
{
    private static final long serialVersionUID = -182866064791747156L;
    private List<Inquiry> inquiries;

    public InquiryListProducer()
    {
        inquiries = createMockInquiries();
    }

    //@Produces
    public List<Inquiry> getInquiries()
    {
        return inquiries;
    }

    public void onCampaignAdded(@Observes @Events.Added Inquiry inquiry) {
        getInquiries().add(inquiry);
    }

    public List<Inquiry> createMockInquiries()
    {

        User customer1 = new User();
        customer1.setFirstName("Benedikt");
        customer1.setLastName("Maier");
        customer1.setEmail("beier@tsn.at");
        customer1.setBirthday(new Date(852336000000l));
        customer1.setId(2);
        customer1.setLevel(User.Level.Customer);

        User customer2 = new User();
        customer2.setFirstName("Dikt");
        customer2.setLastName("Schneier");
        customer2.setEmail("beier@tsn.at");
        customer2.setBirthday(new Date(852336000000l));
        customer2.setId(3);
        customer2.setLevel(User.Level.Customer);

        User administrator = new User();
        administrator.setFirstName("Bruce");
        administrator.setLastName("Wayne");
        administrator.setEmail("luki@fam.com");
        administrator.setBirthday(new Date(875750400000l));
        administrator.setId(2);
        administrator.setLevel(User.Level.Customer);

        Inquiry inquiry1 = new Inquiry();
        inquiry1.setId(1);
        inquiry1.setTicket(Inquiry.Kind.Incident);
        inquiry1.setCustomer(customer1);
        inquiry1.setAgent(administrator);
        inquiry1.setStatus(Inquiry.Status.Open);
        inquiry1.setTimeIssued(new Date(System.currentTimeMillis()));
        inquiry1.setPriority(Inquiry.Priority.low);
        inquiry1.setMessage("Pc nix gehen keine Arbeit machen ich kann");


        Inquiry inquiry2 = new Inquiry();
        inquiry2.setId(2);
        inquiry2.setTicket(Inquiry.Kind.ServiceRequest);
        inquiry2.setCustomer(customer2);
        inquiry2.setAgent(administrator);
        inquiry2.setStatus(Inquiry.Status.Pending);
        inquiry2.setTimeIssued(new Date(System.currentTimeMillis()-100000));
        inquiry2.setPriority(Inquiry.Priority.critical);
        inquiry2.setMessage("Ich nix wissen was machen JavaEE");

        List<Inquiry> inquiries = new LinkedList<>();
        inquiries.add(inquiry1);
        inquiries.add(inquiry2);


        return inquiries;
    }
}
