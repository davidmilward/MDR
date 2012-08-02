package uk.org.datalink.MDR.web;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.support.SessionStatus;

import uk.org.datalink.MDR.domain.Artefact;
import uk.org.datalink.MDR.service.ArtefactManager;

@Controller
@RequestMapping("/artefact/artefactForm")
public class ArtefactController  {
	protected final Log logger = LogFactory.getLog(getClass());
	private ArtefactManager artefactManager;
	@Autowired
	public ArtefactController(ArtefactManager artefactMan){
		this.artefactManager = artefactMan;
	}

	@RequestMapping(method = RequestMethod.POST)
	public String processSubmit(
		@ModelAttribute("artefact") Artefact newArt,
		BindingResult result, SessionStatus status) {
 
		//clear the command object from the session
		status.setComplete(); 
 
		//return form success view
		return "artefactSuccess";
 
	}

	 @RequestMapping(method = RequestMethod.GET)
		public String initForm(ModelMap model){
		    Artefact newCt = new Artefact();
			//command object
			model.addAttribute("artefact", newCt);
			//return form view
			return "CustomerForm";
		}

}
