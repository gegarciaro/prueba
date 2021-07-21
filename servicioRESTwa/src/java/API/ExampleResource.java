package API;

import com.jonima.modelos.Data;
import java.util.LinkedList;
import java.util.List;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.PathParam;
import javax.ws.rs.QueryParam;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import java.util.logging.Logger;
import javax.ws.rs.core.Response;

/**
 * REST Web Service
 *
 * @author ggarcia
 */
@Path("/example/")
public class ExampleResource {

	private static Logger LOG = Logger.getLogger(ExampleResource.class.getName());

	@Context
	private UriInfo context;

	/**
	 * Creates a new instance of ExampleResource
	 */
	public ExampleResource() {
	}

	/**
	 * Retrieves representation of an instance of API.ExampleResource
	 *
	 * @return an instance of java.lang.String
	 */
	/*@GET
  @Produces(MediaType.APPLICATION_JSON)
	public String getJson(@QueryParam("t") String text) {
		System.out.println(" llego aquí ");
		return text;
		// throw new UnsupportedOperationException();
	}*/
	/**
	 * PUT method for updating or creating an instance of ExampleResource
	 *
	 * @param content representation for the resource
	 */
	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	public void putJson(String content) {
	}

	@GET
	@Produces({MediaType.APPLICATION_JSON})
	public List<Data> getData() {
		List<Data> result = new LinkedList<>();
		result.add(new Data(1, "one"));
		result.add(new Data(2, "two"));
		return result;
	}

	@GET
	@Produces({MediaType.APPLICATION_JSON})
	@Path("{id}")
	public Data getData(@PathParam("id") String id) {
		if ("1".equals(id)) {
			return new Data(1, "one");
		}
		if ("2".equals(id)) {
			return new Data(2, "two");
		}
		throw new WebApplicationException(404);
	}

	/*@POST
	@Path("/create")
	@Consumes(MediaType.APPLICATION_JSON)
	public void save(Data data) {
		try {
			System.out.println("Entro a create :" + data);
			System.out.println(data.toString() + "created");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}*/
	@POST
	@Path("/create")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response createDataInJSON(String data) {
		String result = "Data post: " + data;
		System.out.println("result: " + result);
		return Response.status(201).entity(result).build();
	}

	/*@PUT
	@Path("/{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Data update(@PathParam("id") int id, Data data) {
		System.out.println("Lllego a put");
		data.setValue(id);
		if (id == 1 || id == 2) {
			LOG.info(data.toString() + " updated");
		} else {
			LOG.info(data.toString() + " created");
		}
		return data;
	}*/
	@PUT
	@Path("/{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Data update(@PathParam("id") int id, String datos) {
		System.out.println("Lllego a put con id " + id + " y datos: " + datos);
		Data data = new Data(1, "one");
		data.setValue(id);
		if (id == 1 || id == 2) {
			LOG.info(data.toString() + " updated");
		} else {
			LOG.info(data.toString() + " created");
		}
		return data;
	}

}
