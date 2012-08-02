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

import uk.org.datalink.MDR.domain.Relationship;
import uk.org.datalink.MDR.service.RelationshipManager;

public class RelationshipListController extends AbstractCommandController {
	protected final Log logger = LogFactory.getLog(getClass());
	private RelationshipManager relationshipManager;

	public RelationshipListController(){
		setCommandClass(Relationship.class);
		setCommandName("relationshipList");
	}
	
	public void setRelationshipManager(RelationshipManager rmanager) {
		logger.info("Setting RelationshipListController rmanager ");
        this.relationshipManager = rmanager;
        logger.info("SET RelationshipListController rmanager");
    }
	
	public RelationshipManager getRelationshipManager(){
		return this.relationshipManager;
	}
	
	
	protected Object formBackingObject(HttpServletRequest request) throws ServletException {
		List<Relationship> Relationships = relationshipManager.getRelationships();

		return Relationships;
	}

	@Override
	protected ModelAndView handle(HttpServletRequest arg0,
			HttpServletResponse arg1, Object arg2, BindException arg3)
			throws Exception {
		
		logger.info("*************ArtefactListController:handle***********");
		String now = (new Date()).toString();
		List<Relationship> Relationships = relationshipManager.getRelationships();
		Map<String, Object> myModel = new HashMap<String, Object>();
        myModel.put("now", now);
        myModel.put("Relationships", Relationships);

        return new ModelAndView("relationshipList", "model", myModel);
	}

}
