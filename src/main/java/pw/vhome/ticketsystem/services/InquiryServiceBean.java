package pw.vhome.ticketsystem.services;

import pw.vhome.ticketsystem.model.Inquiry;

import javax.enterprise.context.RequestScoped;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by wvitz on 19.06.2017.
 */
@RequestScoped
public class InquiryServiceBean implements InquiryService{
    @Override
    public List<Inquiry> getAllInquiries() {
        return new LinkedList<Inquiry>();
    }
}
