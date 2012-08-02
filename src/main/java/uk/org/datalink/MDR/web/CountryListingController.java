package uk.org.datalink.MDR.web;

import org.springframework.validation.BindException;
import org.springframework.web.servlet.mvc.AbstractCommandController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Map;
import java.util.HashMap;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import java.util.Date;

import uk.org.datalink.MDR.domain.Country;
import uk.org.datalink.MDR.service.CountryManager;

@SuppressWarnings("deprecation")
public class CountryListingController extends AbstractCommandController {
	protected final Log logger = LogFactory.getLog(getClass());
	private CountryManager countryManager;

	public CountryListingController(){
		setCommandClass(Country.class);
		setCommandName("countryList");
	}
	
	public void setCountryManager(CountryManager cmanager) {
		logger.info("Setting CountryListingController countryManager ");
        this.countryManager = cmanager;
        logger.info("SET CountryListingController countryManager");
    }
	
	public CountryManager getCountryManager(){
		return this.countryManager;
	}
	
	
	protected Object formBackingObject(HttpServletRequest request) throws ServletException {
		List<Country> Countries = countryManager.getCountries();

		return Countries;
	}

	@Override
	protected ModelAndView handle(HttpServletRequest arg0,
			HttpServletResponse arg1, Object arg2, BindException arg3)
			throws Exception {
		
		logger.info("*************CountryListingController:handle***********");
		String now = (new Date()).toString();
		List<Country> Countries = countryManager.getCountries();
		Map<String, Object> myModel = new HashMap<String, Object>();
        myModel.put("now", now);
        myModel.put("Countries", Countries);

        return new ModelAndView("countryList", "model", myModel);
	}
}

