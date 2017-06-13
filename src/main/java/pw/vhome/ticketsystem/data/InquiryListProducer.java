package pw.vhome.ticketsystem.data;

import pw.vhome.ticketsystem.model.Inquiry;
import pw.vhome.ticketsystem.model.User;

import javax.enterprise.context.SessionScoped;
import javax.enterprise.inject.Produces;
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

    @Produces
    public List<Inquiry> getInquiries()
    {
        return inquiries;
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

        User administrator = new User();
        administrator.setFirstName("Luki");
        administrator.setLastName("Luiui");
        administrator.setEmail("luki@fam.com");
        administrator.setBirthday(new Date(875750400000l));
        administrator.setId(2);
        administrator.setLevel(User.Level.Customer);

        Inquiry inquiry1 = new Inquiry();
        inquiry1.setTicket(Inquiry.Ticket.Incident);
        inquiry1.setCustomer(customer1);
        inquiry1.setStatus(Inquiry.Status.Open);
        inquiry1.setTimeIssued(new Date(System.currentTimeMillis()));

        Inquiry inquiry2 = new Inquiry();
        inquiry2.setTicket(Inquiry.Ticket.ServiceRequest);
        inquiry2.setCustomer(customer1);
        inquiry2.setAgent(administrator);
        inquiry2.setStatus(Inquiry.Status.Pending);
        inquiry2.setTimeIssued(new Date(System.currentTimeMillis()-100000));

        List<Inquiry> inquiries = new LinkedList<>();
        inquiries.add(inquiry1);


        return inquiries;
    }
}
