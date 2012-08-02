package uk.org.datalink.MDR.web;


import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;  


import uk.org.datalink.MDR.domain.ValueDomain;
import uk.org.datalink.MDR.domain.Person;
import uk.org.datalink.MDR.service.CreateValueDomain;
import uk.org.datalink.MDR.service.PersonManager;
import uk.org.datalink.MDR.service.ValueDomainManager;


@Controller
@RequestMapping(value="/valuedomain")
public class ValueDomainController {
 
	protected final Log logger = LogFactory.getLog(getClass());
	private static final String VD_READ_UPDATE_KEY = "valuedomain/updateForm";
	private static final String DE_READ_ONLY_KEY = "dataelement/view";
	private static final String DE_SUCCESS_KEY = "dataelement/dataElementSuccess";
	private static final String DE_DELETE_KEY = "/dataelement/deDeleteConfirm";
	//private static final String DE_POST_UPDATE_KEY = "/dataelement/deDeleteConfirm";
	private static final String DE_POST_UPDATE_KEY = "/dataelement/updateForm";
	private static final String DE_CREATE_PUT_KEY = "/dataelement/dataElementSuccess";
	private static final String VD_CREATE_NEW_ELEMENT_KEY = "valuedomain/createForm";
	private static final String VD_VIEW_KEY = "valuedomain/view";
	private ValueDomainManager dataManager;
	private PersonManager peopleManager;
	@Autowired
	public void setDataManager(ValueDomainManager datamanager) {
        this.dataManager = datamanager;
    }
	
	public ValueDomainManager getDataManager(){
		return this.dataManager;
	}
	@Autowired
	public void setPeopleManager(PersonManager pm) {
        this.peopleManager = pm;
    }
	
	public PersonManager getPeopleManager(){
		return this.peopleManager;
	}
	
	//GET CREATE FORM---GET
	@RequestMapping(method=RequestMethod.GET)
	public ModelAndView getCreateForm(Model model, HttpServletRequest request) {
		model.addAttribute(new CreateValueDomain());
		setupFormData(request);
		ModelAndView mv = new ModelAndView(VD_CREATE_NEW_ELEMENT_KEY);
		return mv;
	}
	//READ/VIEW ---GET + ID
	@RequestMapping(method=RequestMethod.GET, value="/{id}/vd")
	public ModelAndView getValueDomain(@PathVariable int id, Model model, HttpServletRequest request) {
		logger.info("GET/READ, getting value domain:" + id);
		ValueDomain valueDomain = this.dataManager.getValueDomain(id);
		setupFormData(request);
        ModelAndView mv = new ModelAndView(VD_VIEW_KEY);
        //Security - if not then readonly?
        mv.addObject("valueDomain", valueDomain);
		logger.info("got valueDomain:" + id);
		return mv;
	}
	//CREATE  ----PUT
	@RequestMapping(method=RequestMethod.PUT)
	public ModelAndView create(CreateValueDomain cvd, BindingResult result, Model model, HttpServletRequest request) {
		
		logger.info("PUT/CREATE:" + cvd.getComments());
		Map<String, Object> myModel = new HashMap<String, Object>();
		int ref = this.dataManager.createValueDomain(cvd);
	    ValueDomain valueDomain = this.dataManager.getValueDomain(ref);
        ModelAndView mv = new ModelAndView(VD_VIEW_KEY);		
		mv.addObject("valueDomain", valueDomain);
		setupFormData(request);
		return mv;
	}
	
	//UPDATE ---POST
	@RequestMapping(method=RequestMethod.POST, value="/{id}/vd")
	public ModelAndView update(@PathVariable int id, ValueDomain valueDomain, BindingResult result, Model model, HttpServletRequest request) {
		
		logger.info("POST/UPDATE--1-----, AdminID:" + valueDomain.getAdminobjectid());
		logger.info("POST/UPDATE--2:" + valueDomain.toString());
        ModelAndView mv = new ModelAndView(VD_READ_UPDATE_KEY);
        //If data element is not fully populated then assume we need to view the update form
        logger.info("POST/UPDATE--3:  GOTO UPDATE IF " + valueDomain.getClassification() );
        if(valueDomain.getAdministeredby()!=0){
             this.dataManager.updateValueDomain(valueDomain);
        }
        logger.info("POST/UPDATE--4:");
        ValueDomain newVD = this.dataManager.getValueDomain(id);
        logger.info("POST/UPDATE--5:" + newVD.toString() );
        model.addAttribute(newVD);
        setupFormData(request);
        logger.info("POST/UPDATE--6-----:" );
		return mv;
	}
		
	//DELETE ---DELETE
	@RequestMapping(method=RequestMethod.DELETE, value="/{id}/de")
	public ModelAndView delete(ValueDomain valueDomain, BindingResult result, Model model, HttpServletRequest request) {
		
		logger.info("DELETE:" + valueDomain.toString());
		Map<String, Object> myModel = new HashMap<String, Object>();
		ModelAndView mv = new ModelAndView(DE_DELETE_KEY);		
		//ValueDomain valueDomain = this.dataManager.getValueDomain(valueDomain.getValuedomainid());
		mv.addObject("valueDomain", valueDomain);
        //Now delete the object in the db
		this.dataManager.delete(valueDomain.getValuedomainid());
        //And display the details 
		setupFormData(request);
		return mv;
	}
	
	
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	protected Map referenceData(HttpServletRequest request)throws Exception{
		if(request==null){
		    logger.info("NO REQUEST OBJECT");
		}
		Map topMap = new HashMap();
		List<String> registrationStatusList = getAllRegistrationStatus();
		List<Person> personList = getAllPeople();
		topMap.put("registrationStatusList", registrationStatusList);
		topMap.put("personList", personList);
		return topMap;
	}
	
	protected void setupFormData(HttpServletRequest request){
		List<String> registrationStatusList = getAllRegistrationStatus();
		request.setAttribute("registrationStatusList", registrationStatusList);
		List<Person> personList = getAllPeople();
		request.setAttribute("personList", personList);
	}

	protected List<String> getAllRegistrationStatus(){	
		List<String> regList = Arrays.asList("Candidate","Historical","Incomplete","Standard","Superceded");
		return regList;	
	}
	protected List<Person> getAllPeople(){	
		List<Person> peopleList = this.peopleManager.getPersons();
		return peopleList;	
	}
	
}
