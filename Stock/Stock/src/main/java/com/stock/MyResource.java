package com.stock;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.dao.BseDAO;
import com.dao.CompaniesDAO;
import com.dao.NseDAO;
import com.dao.UserDAO;
import com.dto.BSE;
import com.dto.Companies;
import com.dto.NSE;
import com.dto.User;

@Path("myresource")
public class MyResource {

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String getIt() {
        return "Got it!";
    }
    
    /*@Path("regUser")
    @GET
    @Consumes(MediaType.APPLICATION_JSON)
    public String regUser() {
    	User user = new User();
    	user.setUserId(1);
    	user.setUserName("Jacob Elordi");
    	user.setEmail("jacob@gmail.com");
    	user.setPassword("jacob123");
    	UserDAO ud = new UserDAO();
    	ud.register(user);
    	return "Success";
    }*/
    
   @Path("regUser")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public String regCust(User user) {
    	UserDAO ud = new UserDAO();
		ud.register(user);
		return "Success";
	}
    
    @Path("loginUser/{email}/{password}")
	@GET
	@Consumes(MediaType.APPLICATION_JSON)
	public User loginUser(@PathParam("email") String email , @PathParam("password") String password){
    	UserDAO ud = new UserDAO();
		User cust = ud.getCustByUserPass(email,password);
		if(cust != null) {
			return cust;
		}
		else {
			return null;
		}
	}
    
    
    @Path("getCompany/{companyName}")
	@GET
	@Consumes(MediaType.APPLICATION_JSON)
	public List<Companies> getCompany(@PathParam("companyName") String companyName) {
		CompaniesDAO  comdao = new CompaniesDAO();
		List<Companies> companiesList = comdao.getStocksByCompany(companyName);
		return companiesList;
	}
    
    @Path("getCompanyStock/{companyName}/{date}")
   	@GET
   	@Produces(MediaType.APPLICATION_JSON)
   	public Companies getCompanyStock(@PathParam("companyName") String companyName,@PathParam("date") java.sql.Date date) {
   		CompaniesDAO n = new CompaniesDAO();
   		Companies c = n.getCompanyStock(companyName,date);
   		return c;
   	}
    
    
    @Path("getNSE/{date}")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public NSE getNSE(@PathParam("date") java.sql.Date date) {
		NseDAO n = new NseDAO();
		NSE nse = n.getNseByDate(date);
		return nse;
	}
    
    @Path("getBSE/{date}")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public BSE getBSE(@PathParam("date") java.sql.Date date) {
		BseDAO n = new BseDAO();
		BSE bse = n.getBseByDate(date);
		return bse;
	}
    
}
