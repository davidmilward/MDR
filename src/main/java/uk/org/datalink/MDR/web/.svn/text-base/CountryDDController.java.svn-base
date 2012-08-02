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


import uk.org.datalink.MDR.domain.Country;
import uk.org.datalink.MDR.service.CountryManager;
/*
 * This Web Controller is handling requests to add a new country
 */
public class CountryDDController extends SimpleFormController {
	protected final Log logger = LogFactory.getLog(getClass());
	private CountryManager countryManager;

	public CountryDDController(){
		setCommandClass(Country.class);
		setCommandName("countryForm");
	}
	public void setCountryManager(CountryManager cmanager) {
		logger.info("Setting countryManager ");
        this.countryManager = cmanager;
        logger.info("SET countryManager");
    }
	
	public CountryManager getCountryManager(){
		return this.countryManager;
	}
	
	public ModelAndView onSubmit(Object command)throws ServletException {

		Country newCnt = ((uk.org.datalink.MDR.domain.Country) command);
		logger.info("*************CountryDDController***********" + newCnt.getName() );
		countryManager.create(newCnt);
		String now = (new Date()).toString();
		Map<String, Object> myModel = new HashMap<String, Object>();
        myModel.put("now", now);
        myModel.put("Country", newCnt);

        return new ModelAndView("countrySuccess", "model", myModel);
		
		//return new ModelAndView(new RedirectView(getSuccessView()));
	}
	
	protected Object formBackingObject(HttpServletRequest request) throws ServletException {
		Country newCt = new Country();
		
		return newCt;
	}
}
