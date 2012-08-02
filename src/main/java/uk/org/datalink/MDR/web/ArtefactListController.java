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

import uk.org.datalink.MDR.domain.Artefact;
import uk.org.datalink.MDR.service.ArtefactManager;

public class ArtefactListController extends AbstractCommandController {
	protected final Log logger = LogFactory.getLog(getClass());
	private ArtefactManager artefactManager;

	public ArtefactListController(){
		setCommandClass(Artefact.class);
		setCommandName("artefactList");
	}
	
	public void setArtefactManager(ArtefactManager amanager) {
		logger.info("Setting ArtefactListController amanager ");
        this.artefactManager = amanager;
        logger.info("SET ArtefactListController amanager");
    }
	
	public ArtefactManager getArtefactManager(){
		return this.artefactManager;
	}
	
	
	protected Object formBackingObject(HttpServletRequest request) throws ServletException {
		List<Artefact> Artefacts = artefactManager.getArtefactDetails();

		return Artefacts;
	}

	@Override
	protected ModelAndView handle(HttpServletRequest arg0,
			HttpServletResponse arg1, Object arg2, BindException arg3)
			throws Exception {
		
		logger.info("*************ArtefactListController:handle***********");
		String now = (new Date()).toString();
		List<Artefact> Artefacts = artefactManager.getArtefactDetails();
		Map<String, Object> myModel = new HashMap<String, Object>();
        myModel.put("now", now);
        myModel.put("Artefacts", Artefacts);

        return new ModelAndView("artefactList", "model", myModel);
	}
}
