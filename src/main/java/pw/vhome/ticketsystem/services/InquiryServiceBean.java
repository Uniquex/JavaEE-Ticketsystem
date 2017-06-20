package pw.vhome.ticketsystem.services;

import pw.vhome.ticketsystem.model.Inquiry;

import javax.ejb.Stateless;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Produces;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by wvitz on 19.06.2017.
 */
@Stateless
public class InquiryServiceBean implements InquiryService{

    @Inject
    EntityManager entityManager;

    @Override
    public List<Inquiry> getAllInquiries() {
        TypedQuery<Inquiry> query =
                entityManager.createNamedQuery(Inquiry.findAll, Inquiry.class);
        List<Inquiry> inquiries = query.getResultList();
        return inquiries;
    }

    @Override
    public void addInquiry(Inquiry inquiry) {
        entityManager.persist(inquiry);
    }

    @Override
    public void deleteInquiry(Inquiry inquiry) {
        Inquiry managedInquiry = entityManager.find(Inquiry.class, inquiry.getId());
        entityManager.remove(managedInquiry);
    }

    @Override
    public void updateInquiry(Inquiry inquiry) {
        entityManager.merge(inquiry);
    }


}
