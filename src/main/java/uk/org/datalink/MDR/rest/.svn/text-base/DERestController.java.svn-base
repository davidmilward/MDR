package uk.org.datalink.MDR.rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import uk.org.datalink.MDR.domain.DataElement;
import uk.org.datalink.MDR.service.DataElementManager;
import uk.org.datalink.MDR.service.PersonManager;
import uk.org.datalink.MDR.web.ResourceNotFoundException;



@Controller
@RequestMapping(value="/rest")
public class DERestController {
	 
	protected final Log logger = LogFactory.getLog(getClass());
	private static final String DE_VIEW_KEY = "dataelement/view";
	private DataElementManager dataManager;
	private PersonManager peopleManager;
	@Autowired
	public void setDataManager(DataElementManager datamanager) {
		logger.info("setDataManager" );
        this.dataManager = datamanager;
    }
	
	public DataElementManager getDataManager(){
		return this.dataManager;
	}
	@Autowired
	public void setPeopleManager(PersonManager pm) {
        this.peopleManager = pm;
    }
	
	public PersonManager getPeopleManager(){
		return this.peopleManager;
	}
	
	@RequestMapping(method=RequestMethod.GET, value="/{id}/dataelement")
	public ModelAndView getDataElement(@PathVariable("id") Integer id){
		
		logger.info("getting data element:" + id);
		if(dataManager!=null){
			logger.info("dataManager exists");
		}else{
			logger.info("dataManager DOES NOT EXIST");
		}
		DataElement dataElement = this.dataManager.getDataElement(id.intValue());
	    //ModelAndView mv = new ModelAndView(CUSTOMER_VIEW_KEY);
	    //ModelAndView mav = new ModelAndView("mdrXmlView", BindingResult.MODEL_KEY_PREFIX + "dataElement", dataElement);
		//mv.addObject("dataElement", dataElement);

		if (dataElement == null) {
			throw new ResourceNotFoundException(id);
		}
		ModelAndView mv = new ModelAndView(DE_VIEW_KEY);
		mv.addObject("dataElement", dataElement);
		logger.info("got data element:" + id);
		return mv;
	}
	


	
}