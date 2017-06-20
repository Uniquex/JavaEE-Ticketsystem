package pw.vhome.ticketsystem.test;

import pw.vhome.ticketsystem.model.User;

import java.util.Date;

/**
 * Created by wvitz on 20.06.2017.
 */
public class DataFactory {
    public static User  createTestUser() {
        User user = new User();

        user.setBirthday(new Date(System.currentTimeMillis()));
        user.setEmail("xx@microsoft.com");
        user.setFirstName("Earl");
        user.setLastName("Lemongrab");
        user.setLevel(User.Level.Administrator);

        return user;
    }

    public static User  createTestUser2() {
        User user = new User();

        user.setBirthday(new Date(System.currentTimeMillis()));
        user.setEmail("xy@nigrosoft.com");
        user.setFirstName("Digt");
        user.setLastName("Schneier");
        user.setLevel(User.Level.Customer);

        return user;
    }
}
