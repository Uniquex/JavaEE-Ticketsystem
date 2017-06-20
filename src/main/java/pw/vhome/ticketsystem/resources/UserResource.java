package pw.vhome.ticketsystem.resources;

import pw.vhome.ticketsystem.model.User;
import pw.vhome.ticketsystem.services.InquiryService;
import pw.vhome.ticketsystem.services.UserService;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;


/**
 * Created by wvitz on 20.06.2017.
 */

@Path("/organizer/user")
public class UserResource {
    @Inject
    UserService userService;

    @GET
    @Path("/list")
    @Produces(MediaType.APPLICATION_JSON)
    public List<User> getAllUsers() {
        List<User> allUsers = userService.getAllUsers();

        return allUsers;
    }


}
