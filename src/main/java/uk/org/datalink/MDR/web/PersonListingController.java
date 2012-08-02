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
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindException;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractCommandController;

import uk.org.datalink.MDR.domain.Person;
import uk.org.datalink.MDR.service.PersonManager;

@Controller
@RequestMapping(value="listpeople")
public class PersonListingController  {
	protected final Log logger = LogFactory.getLog(getClass());
	private PersonManager personManager;

	public PersonListingController(){
//		setCommandClass(Person.class);
//		setCommandName("personList");
	}
	@Autowired
	public void setPersonManager(PersonManager pManager) {
		logger.info("Setting PersonListingController personManager ");
        this.personManager = pManager;
        logger.info("SET PersonListingController personManager");
    }
	
	public PersonManager getPersonManager(){
		return this.personManager;
	}
	
	
	protected Object formBackingObject(HttpServletRequest request) throws ServletException {
		List<Person> People = personManager.getPersons();

		return People;
	}

	@RequestMapping(method=RequestMethod.GET)
	protected ModelAndView viewPeople()throws Exception {
		
		logger.info("*************PeopleListingController:handle***********");
		String now = (new Date()).toString();
		List<Person> Persons = personManager.getPersons();
		Map<String, Object> myModel = new HashMap<String, Object>();
        myModel.put("now", now);
        myModel.put("Persons", Persons);

        return new ModelAndView("person/personList", "model", myModel);
	}
}
