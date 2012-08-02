package uk.org.datalink.MDR.web;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.SimpleFormController;

import uk.org.datalink.MDR.domain.RelationshipType;
import uk.org.datalink.MDR.service.RelationshipTypeManager;

public class RelationshipTypeController extends SimpleFormController {
	protected final Log logger = LogFactory.getLog(getClass());
	private RelationshipTypeManager relationshipTypeManager;

	public RelationshipTypeController(){
		setCommandClass(RelationshipType.class);
		setCommandName("relationshiptypeForm");
	}
	public void setRelationshipTypeManager(RelationshipTypeManager rtmanager) {
		logger.info("Setting relationshipTypeManager ");
        this.relationshipTypeManager = rtmanager;
        logger.info("SET relationshipTypeManager");
    }
	
	public RelationshipTypeManager getRelationshipTypeManager(){
		return this.relationshipTypeManager;
	}
	
	public ModelAndView onSubmit(Object command)throws ServletException {

		RelationshipType newRT = ((uk.org.datalink.MDR.domain.RelationshipType) command);
		logger.info("*************ClassificationSchemeController***********" + newRT.getDescription() );
		relationshipTypeManager.create(newRT);
		String now = (new Date()).toString();
		Map<String, Object> myModel = new HashMap<String, Object>();
        myModel.put("now", now);
        myModel.put("newRT", newRT);

        return new ModelAndView("classificationSchemeSuccess", "model", myModel);
	}
	
	protected Object formBackingObject(HttpServletRequest request) throws ServletException {
		RelationshipType newCs = new RelationshipType();
		
		return newCs;
	}

}
