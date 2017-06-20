package pw.vhome.ticketsystem.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by vitz on 09.06.17.
 */

@NamedQueries({
        @NamedQuery(name = "User.findAll", query = "SELECT c FROM User c ORDER BY c.id")
})

@Entity
public class User implements Serializable{

    public static final String findAll = "User.findAll";

    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private long id;
    private Level level;
    private String firstname;
    private String lastname;
    private Date birthday;
    private String email;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Level getLevel() {
        return level;
    }

    public void setLevel(Level level) {
        this.level = level;
    }

    public String getFirstName() {
        return firstname;
    }

    public void setFirstName(String firstname) {
        this.firstname = firstname;
    }

    public String getLastName() {
        return lastname;
    }

    public void setLastName(String lastname) {
        this.lastname = lastname;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public enum Level{
        Administrator, Agent, Customer
    }
}
