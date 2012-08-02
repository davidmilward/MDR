package uk.org.datalink.MDR.web;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import javax.validation.Valid;
import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;  
import uk.org.datalink.MDR.domain.Person;
import uk.org.datalink.MDR.service.PersonManager;

@Controller
@RequestMapping(value="/person")
public class PersonController {

	protected final Log logger = LogFactory.getLog(getClass());
	private PersonManager personManager;
	@Autowired
	public void setPersonManager(PersonManager pManager) {
		logger.info("Setting personManager ");
        this.personManager = pManager;
        logger.info("SET personManager");
    }
	
	public PersonManager getPersonManager(){
		return this.personManager;
	}
	
	@RequestMapping(method=RequestMethod.GET)
	public String getCreateForm(Model model) {
		model.addAttribute(new Person());
		return "person/view";
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public ModelAndView create(Person person, BindingResult result) {
		
		logger.info("Returned something:" + person.toString());
		int ref = personManager.create(person);
		Map<String, Object> myModel = new HashMap<String, Object>();
		Person newbe = personManager.getPerson(ref);
        myModel.put("Person", newbe);
        return new ModelAndView("person/personSuccess", "model", myModel);
	}
	@RequestMapping(value="/{id}", method=RequestMethod.POST)
	public ModelAndView update(@PathVariable int id, Person person, BindingResult result) {
		person.setId(id);
		Person newPerson = this.personManager.getPerson(id);
		this.personManager.updatePerson(newPerson);
		Map<String, Object> myModel = new HashMap<String, Object>();
		myModel.put("Person", person);
	    return new ModelAndView("person/personSuccess", "model", myModel);
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public String getView(@PathVariable int id, Model model) {
		Person person = this.personManager.getPerson(id);

		if (person == null) {
			throw new ResourceNotFoundException(id);
		}
		model.addAttribute(person);
		return "person/view";
	}
}