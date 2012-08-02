package uk.org.datalink.MDR.web;

import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.SimpleFormController;
import org.springframework.ui.Model;

import uk.org.datalink.MDR.domain.DataElement;
//import uk.org.datalink.MDR.domain.Model;
import uk.org.datalink.MDR.domain.Person;
import uk.org.datalink.MDR.service.CreateDataElement;
import uk.org.datalink.MDR.service.ModelManager;
import uk.org.datalink.MDR.service.PersonManager;


@Controller
@RequestMapping(value="/model")
public class ModelController {
	protected final Log logger = LogFactory.getLog(getClass());
	private ModelManager modelManager;
	private PersonManager peopleManager;


	@Autowired
	public void setModelManager(ModelManager mdmanager) {
		logger.info("Setting ModelManager ");
        this.modelManager = mdmanager;
        logger.info("SET ModelManager");
    }
	
	public ModelManager getModelManager(){
		return this.modelManager;
	}
	@Autowired
	public void setPeopleManager(PersonManager pm) {
        this.peopleManager = pm;
    }
	
	public PersonManager getPeopleManager(){
		return this.peopleManager;
	}
	
	
	@RequestMapping(method=RequestMethod.GET)
	public String getCreateForm(Model model, HttpServletRequest request) {
		model.addAttribute(new uk.org.datalink.MDR.domain.Model());
		Map peopleMap = null;
				try {
					peopleMap = referenceData(request);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		model.addAllAttributes(peopleMap);

		return "model/createForm";
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public String create(uk.org.datalink.MDR.domain.Model mdrModel, BindingResult result, Model model) {
		
		logger.info("Returned something:" + mdrModel.toString());
		Map<String, Object> myModel = new HashMap<String, Object>();
        int ref = this.modelManager.create(mdrModel);
        uk.org.datalink.MDR.domain.Model mdModel = this.modelManager.getModel(ref);

        model.addAttribute(mdModel);
		return "model/modelSuccess";
	}
	
	@RequestMapping(value="{id}", method=RequestMethod.GET)
	public String getView(@PathVariable int id, Model model) {
		uk.org.datalink.MDR.domain.Model mdModel = this.modelManager.getModel(id);

		if (mdModel == null) {
			throw new ResourceNotFoundException(id);
		}
		model.addAttribute(mdModel);
		return "model/view";
	}

	protected Map referenceData(HttpServletRequest request)throws Exception{
		Map topMap = new HashMap();
		List<String> registrationStatusList = getAllRegistrationStatus();
		//List<String> personList = getAllPeopleStrings();//Later can be changed to registrars, admins etc by role
		List<Person> personList = getAllPeople();
		topMap.put("registrationStatusList", registrationStatusList);
		topMap.put("personList", personList);
		return topMap;
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
