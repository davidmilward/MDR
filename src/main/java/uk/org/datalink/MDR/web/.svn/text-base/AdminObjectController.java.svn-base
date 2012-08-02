package uk.org.datalink.MDR.web;

import org.springframework.web.servlet.mvc.Controller;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;
import java.util.HashMap;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import java.io.IOException;
import java.util.Date;

import uk.org.datalink.MDR.service.AdminObjectManager;


public class AdminObjectController implements Controller {
	 
	protected final Log logger = LogFactory.getLog(getClass());
	private AdminObjectManager datamanager;


	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response)
	            throws ServletException, IOException {

	        logger.info("Returning view");
	        String now = (new Date()).toString();
	        logger.info("Returning vocab view with " + now);
	        
	        Map<String, Object> myModel = new HashMap<String, Object>();
	        myModel.put("now", now);
	        myModel.put("adminObjects", this.datamanager.getAdminObjects());

	        return new ModelAndView("datepickertest", "model", myModel);
	    }
	public void setDataManager(AdminObjectManager datamanager) {
		logger.info("Setting DataManager ");
        this.datamanager = datamanager;
        logger.info("SET DataManager");
    }


	
	
}
