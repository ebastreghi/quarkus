package tech.ebastreghi.course;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.UUID;

@Path("/hello")
public class GreetingResource {

    public static final String TOKEN = "dev";

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String hello() {
        return "hello" + UUID.randomUUID().toString();
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public String addHello(@HeaderParam("token") String hName, @QueryParam("token") String aName){
        String token = (hName != null) ? hName : aName;
        if(!TOKEN.equals(token)){
            throw new RuntimeException("Unauthorized");
        }
        return "{\"key\": \"" + aName + "\"}";
    }

}
