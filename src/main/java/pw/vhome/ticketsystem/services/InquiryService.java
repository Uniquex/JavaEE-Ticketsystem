package pw.vhome.ticketsystem.services;

import pw.vhome.ticketsystem.model.Inquiry;

import javax.inject.Inject;
import java.util.List;

/**
 * Created by wvitz on 19.06.2017.
 */
public interface InquiryService {
    List<Inquiry> getAllInquiries();
}
