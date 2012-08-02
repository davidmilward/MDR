package uk.org.datalink.MDR.web;

import org.springframework.web.servlet.mvc.Controller;
import org.springframework.web.servlet.mvc.SimpleFormController;
import org.springframework.web.servlet.view.RedirectView;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import java.util.Map;
import java.util.HashMap;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import java.util.Date;


import uk.org.datalink.MDR.domain.Organisation;
import uk.org.datalink.MDR.domain.Person;
import uk.org.datalink.MDR.service.OrganisationManager;
import uk.org.datalink.MDR.service.PersonManager;

public class OrganisationController extends SimpleFormController {
	protected final Log logger = LogFactory.getLog(getClass());
	private OrganisationManager organisationManager;

	public OrganisationController(){
		setCommandClass(Organisation.class);
		setCommandName("organisationForm");
	}
	public void setOrganisationManager(OrganisationManager oManager) {
		logger.info("Setting organisationManager ");
        this.organisationManager = oManager;
        logger.info("SET organisationManager");
    }
	
	public OrganisationManager getorganisationManager(){
		return this.organisationManager;
	}
	
	public ModelAndView onSubmit(Object command)throws ServletException {

		Organisation newOrg = ((uk.org.datalink.MDR.domain.Organisation) command);
		logger.info("*************organisationManager***********" + newOrg.getDescription() );
		organisationManager.create(newOrg);
		String now = (new Date()).toString();
		Map<String, Object> myModel = new HashMap<String, Object>();
        myModel.put("now", now);
        myModel.put("Organisation", newOrg);

        return new ModelAndView("organisationSuccess", "model", myModel);
	}
	
	protected Object formBackingObject(HttpServletRequest request) throws ServletException {
		Organisation newOrg = new Organisation();
		
		return newOrg;
	}

}
