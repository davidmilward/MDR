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

import uk.org.datalink.MDR.domain.RelationshipType;
import uk.org.datalink.MDR.service.RelationshipTypeManager;

public class RelationshipTypeListController extends AbstractCommandController {
	protected final Log logger = LogFactory.getLog(getClass());
	private RelationshipTypeManager relationshipTypeManager;

	public RelationshipTypeListController(){
		setCommandClass(RelationshipType.class);
		setCommandName("relationshipTypeList");
	}
	
	public void setRelationshipTypeManager(RelationshipTypeManager rmanager) {
		logger.info("Setting RelationshipTypeManager amanager ");
        this.relationshipTypeManager = rmanager;
        logger.info("SET RelationshipTypeManager amanager");
    }
	
	public RelationshipTypeManager getRelationshipTypeManager(){
		return this.relationshipTypeManager;
	}
	
	
	protected Object formBackingObject(HttpServletRequest request) throws ServletException {
		List<RelationshipType> RelationshipTypes = relationshipTypeManager.getRelationshipTypes();

		return RelationshipTypes;
	}

	@Override
	protected ModelAndView handle(HttpServletRequest arg0,
			HttpServletResponse arg1, Object arg2, BindException arg3)
			throws Exception {
		
		logger.info("*************RelationshipTypeListController:handle***********");
		String now = (new Date()).toString();
		List<RelationshipType> RelationshipTypes = relationshipTypeManager.getRelationshipTypes();
		Map<String, Object> myModel = new HashMap<String, Object>();
        myModel.put("now", now);
        myModel.put("RelationshipTypes", RelationshipTypes);

        return new ModelAndView("artefactList", "model", myModel);
	}

}
