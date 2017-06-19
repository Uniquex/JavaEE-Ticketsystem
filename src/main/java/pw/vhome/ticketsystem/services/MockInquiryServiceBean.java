package pw.vhome.ticketsystem.services;

import pw.vhome.ticketsystem.model.Inquiry;
import pw.vhome.ticketsystem.model.User;

import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Alternative;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by wvitz on 19.06.2017.
 */
@RequestScoped
@Alternative
public class MockInquiryServiceBean implements InquiryService {

    public List<Inquiry> getAllInquiries() {

        User customer1 = new User();
        customer1.setFirstName("Glord");
        customer1.setLastName("Maier");
        customer1.setEmail("geier@tsn.at");
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
        administrator.setLevel(User.Level.Administrator);

        User moderator = new User();
        moderator.setFirstName("Earl");
        moderator.setLastName("Lemongrab");
        moderator.setEmail("lemon@grab.com");
        moderator.setBirthday(new Date(875250400000l));
        moderator.setId(2);
        moderator.setLevel(User.Level.Agent);

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
        inquiry2.setAgent(moderator);
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
