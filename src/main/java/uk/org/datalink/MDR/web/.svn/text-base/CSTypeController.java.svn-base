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

import uk.org.datalink.MDR.domain.ClassificationSchemeType;
import uk.org.datalink.MDR.service.ClassificationSchemeTypeManager;

public class CSTypeController extends SimpleFormController {
	protected final Log logger = LogFactory.getLog(getClass());
	private ClassificationSchemeTypeManager cschemeTypeManager;

	public CSTypeController(){
		setCommandClass(ClassificationSchemeType.class);
		setCommandName("classificationSchemeTypeForm");
	}
	public void setCschemeTypeManager(ClassificationSchemeTypeManager cmanager) {
		logger.info("Setting ClassificationSchemeType ");
        this.cschemeTypeManager = cmanager;
        logger.info("SET ClassificationSchemeType");
    }
	
	public ClassificationSchemeTypeManager getCschemeTypeManager(){
		return this.cschemeTypeManager;
	}
	
	public ModelAndView onSubmit(Object command)throws ServletException {

		ClassificationSchemeType newCST = ((uk.org.datalink.MDR.domain.ClassificationSchemeType) command);
		logger.info("*************ClassificationSchemeController***********" + newCST.getDescription() );
		cschemeTypeManager.create(newCST);
		String now = (new Date()).toString();
		Map<String, Object> myModel = new HashMap<String, Object>();
        myModel.put("now", now);
        myModel.put("newCST", newCST);

        return new ModelAndView("classificationSchemeTypeSuccess", "model", myModel);
	}
	
	protected Object formBackingObject(HttpServletRequest request) throws ServletException {
		ClassificationSchemeType newCs = new ClassificationSchemeType();
		
		return newCs;
	}
}
