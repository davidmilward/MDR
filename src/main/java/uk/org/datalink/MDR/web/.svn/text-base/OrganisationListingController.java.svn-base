package uk.org.datalink.MDR.web;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.validation.BindException;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractCommandController;

import uk.org.datalink.MDR.domain.Organisation;
import uk.org.datalink.MDR.domain.Person;
import uk.org.datalink.MDR.service.OrganisationManager;
import uk.org.datalink.MDR.service.PersonManager;

public class OrganisationListingController extends AbstractCommandController {
	protected final Log logger = LogFactory.getLog(getClass());
	private OrganisationManager organisationManager;

	public OrganisationListingController(){
		setCommandClass(Organisation.class);
		setCommandName("organisationList");
	}
	
	public void setOrganisationManager(OrganisationManager oManager) {
		logger.info("Setting OrganisationListingController organisationManager ");
        this.organisationManager = oManager;
        logger.info("SET OrganisationListingController organisationManager");
    }
	
	public OrganisationManager getOrganisationManager(){
		return this.organisationManager;
	}
	
	
	protected Object formBackingObject(HttpServletRequest request) throws ServletException {
		List<Organisation> OrgList = organisationManager.getOrganisations();

		return OrgList;
	}

	@Override
	protected ModelAndView handle(HttpServletRequest arg0,
			HttpServletResponse arg1, Object arg2, BindException arg3)
			throws Exception {
		
		logger.info("*************PeopleListingController:handle***********");
		String now = (new Date()).toString();
		List<Organisation> OrgList = organisationManager.getOrganisations();
		Map<String, Object> myModel = new HashMap<String, Object>();
        myModel.put("now", now);
        myModel.put("OrgList", OrgList);

        return new ModelAndView("organisationList", "model", myModel);
	}

}
