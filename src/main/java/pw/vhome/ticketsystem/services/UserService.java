package pw.vhome.ticketsystem.services;

import pw.vhome.ticketsystem.model.Inquiry;
import pw.vhome.ticketsystem.model.User;

import javax.inject.Inject;
import java.util.List;

/**
 * Created by wvitz on 19.06.2017.
 */
public interface UserService {
    List<User> getAllUsers();

    void addUser(User user);
    void deleteUser(User user);
    void updateUser(User user);
}
