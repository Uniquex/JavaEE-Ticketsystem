package pw.vhome.ticketsystem.services;

import pw.vhome.ticketsystem.model.User;

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
public class UserServiceBean implements UserService{

    @Inject
    EntityManager entityManager;

    @Override
    public List<User> getAllUsers() {
        TypedQuery<User> query =
                entityManager.createNamedQuery(User.findAll, User.class);
        List<User> users = query.getResultList();
        return users;
    }

    @Override
    public void addUser(User user) {
        entityManager.persist(user);
    }

    @Override
    public void deleteUser(User user) {
        User managedUser = entityManager.find(User.class, user.getId());
        entityManager.remove(managedUser);
    }

    @Override
    public void updateUser(User user) {
        entityManager.merge(user);
    }
}
