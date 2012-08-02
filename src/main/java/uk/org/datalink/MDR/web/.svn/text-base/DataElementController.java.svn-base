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

import uk.org.datalink.MDR.domain.DataElement;
import uk.org.datalink.MDR.domain.Person;
import uk.org.datalink.MDR.domain.ValueDomain;
import uk.org.datalink.MDR.service.CreateDataElement;
import uk.org.datalink.MDR.service.DataElementManager;
import uk.org.datalink.MDR.service.DataManager;
import uk.org.datalink.MDR.service.PersonManager;



@Controller
@RequestMapping(value="/dataelement")
public class DataElementController {
 
	protected final Log logger = LogFactory.getLog(getClass());
	private static final String DE_READ_UPDATE_KEY = "dataelement/updateForm";
	private static final String DE_READ_ONLY_KEY = "dataelement/view";
	private static final String DE_SUCCESS_KEY = "dataelement/dataElementSuccess";
	private static final String DE_DELETE_KEY = "/dataelement/deDeleteConfirm";
	//private static final String DE_POST_UPDATE_KEY = "/dataelement/deDeleteConfirm";
	private static final String DE_POST_UPDATE_KEY = "/dataelement/updateForm";
	private static final String DE_CREATE_PUT_KEY = "/dataelement/dataElementSuccess";
	private static final String DE_CREATE_NEW_ELEMENT_KEY = "dataelement/createForm";
	private DataElementManager dataManager;
	private PersonManager peopleManager;
	@Autowired
	public void setDataManager(DataElementManager datamanager) {
		logger.info("DataElementController::setDataManager" );
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
	//GET CREATE FORM---GET
	@RequestMapping(method=RequestMethod.GET)
	public ModelAndView getCreateForm(Model model, HttpServletRequest request) {
		model.addAttribute(new CreateDataElement());
		setupFormData(request);
		ModelAndView mv = new ModelAndView(DE_CREATE_NEW_ELEMENT_KEY);
		return mv;
	}
	
	//READ/VIEW ---GET + ID
	@RequestMapping(method=RequestMethod.GET, value="/{id}/de")
	public ModelAndView getDataElement(@PathVariable int id, Model model, HttpServletRequest request) {
		logger.info("GET/READ, getting Data Element:" + id);
		DataElement dataElement = this.dataManager.getDataElement(id);
		setupFormData(request);
        ModelAndView mv = new ModelAndView(DE_READ_ONLY_KEY);
        //Security - if not then readonly?
        mv.addObject("dataElement", dataElement);
		logger.info("got dataElement:" + id );
		return mv;
	}
	//CREATE  ----PUT
	@RequestMapping(method=RequestMethod.PUT)
	public ModelAndView create(CreateDataElement cde, BindingResult result, Model model, HttpServletRequest request) {
		
		logger.info("PUT/CREATE:" + cde.toString());
		Map<String, Object> myModel = new HashMap<String, Object>();
        int ref = this.dataManager.createDataElement(cde);
        DataElement dataElement = this.dataManager.getDataElement(ref);
        ModelAndView mv = new ModelAndView(DE_READ_ONLY_KEY);		
		mv.addObject("dataElement", dataElement);
		setupFormData(request);
		return mv;
	}
	//UPDATE ---POST
	@RequestMapping(method=RequestMethod.POST, value="/{id}/de")
	public ModelAndView update(@PathVariable int id, DataElement oldDE, BindingResult result, Model model, HttpServletRequest request) {
		
		logger.info("POST/UPDATE--1-----, AdminID:" + oldDE.getAdminobjectid());
		//Currently the view template stuff mixes up the IDs of the Data Element and AdminObject - so this is a bit of a cludge  ***TO DO****
		//oldDE.setDataElementId(id);
		//oldDE.setId(oldDE.getAdminObjectID());
		logger.info("POST/UPDATE--2:" + oldDE.toString());
        ModelAndView mv = new ModelAndView(DE_READ_UPDATE_KEY);
        //If data element is not fully populated then assume we need to view the update form
        logger.info("POST/UPDATE--3:  GOTO UPDATE IF " + oldDE.getClassification() );
        if(oldDE.getAdministeredby()!=0){
             this.dataManager.updateDataElement(oldDE);
        }
        logger.info("POST/UPDATE--4:");
        DataElement newDE = this.dataManager.getDataElement(id);
        logger.info("POST/UPDATE--5:" + newDE.toString() );
        model.addAttribute(newDE);
        setupFormData(request);
        logger.info("POST/UPDATE--6-----:" );
		return mv;
	}
	
	//DELETE ---DELETE
	@RequestMapping(method=RequestMethod.DELETE, value="/{id}/de")
	public ModelAndView delete(DataElement ude, BindingResult result, Model model, HttpServletRequest request) {
		
		logger.info("DELETE:" + ude.toString());
		Map<String, Object> myModel = new HashMap<String, Object>();
		ModelAndView mv = new ModelAndView(DE_DELETE_KEY);		
		DataElement dataElement = this.dataManager.getDataElement(ude.getDataElementId());
		mv.addObject("dataElement", dataElement);
        //Now delete the object in the db
		this.dataManager.delete(dataElement);
        //And display the details 
		setupFormData(request);
		return mv;
	}


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
