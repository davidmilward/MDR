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

import uk.org.datalink.MDR.domain.Relationship;
import uk.org.datalink.MDR.service.RelationshipManager;

public class RelationshipController extends SimpleFormController {
	protected final Log logger = LogFactory.getLog(getClass());
	private RelationshipManager relationshipManager;

	public RelationshipController(){
		setCommandClass(Relationship.class);
		setCommandName("relationshipForm");
	}
	public void setRelationshipManager(RelationshipManager rmanager) {
		logger.info("Setting RelationshipManager ");
        this.relationshipManager = rmanager;
        logger.info("SET RelationshipManager");
    }
	
	public RelationshipManager getRelationshipManager(){
		return this.relationshipManager;
	}
	
	public ModelAndView onSubmit(Object command)throws ServletException {

		Relationship newRL = ((uk.org.datalink.MDR.domain.Relationship) command);
		logger.info("*************RelationshipController***********" + newRL.getClassscheme_id() );
		relationshipManager.create(newRL);
		String now = (new Date()).toString();
		Map<String, Object> myModel = new HashMap<String, Object>();
        myModel.put("now", now);
        myModel.put("newRL", newRL);

        return new ModelAndView("relationshipSuccess", "model", myModel);
	}
	
	protected Object formBackingObject(HttpServletRequest request) throws ServletException {
		Relationship newRL = new Relationship();
		
		return newRL;
	}
}
