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

import uk.org.datalink.MDR.domain.ClassificationScheme;
import uk.org.datalink.MDR.service.ClassificationSchemeManager;

public class CSListController extends AbstractCommandController {
	protected final Log logger = LogFactory.getLog(getClass());
	private ClassificationSchemeManager csManager;

	public CSListController(){
		setCommandClass(ClassificationScheme.class);
		setCommandName("countryList");
	}
	
	public void setCsManager(ClassificationSchemeManager cmanager) {
		logger.info("Setting ClassificationSchemeManager countryManager ");
        this.csManager = cmanager;
        logger.info("SET ClassificationSchemeController countryManager");
    }
	
	public ClassificationSchemeManager getCsManager(){
		return this.csManager;
	}
	
	
	protected Object formBackingObject(HttpServletRequest request) throws ServletException {
		List<ClassificationScheme> Schemes = csManager.getClassificationSchemeDetails();

		return Schemes;
	}

	@Override
	protected ModelAndView handle(HttpServletRequest arg0,
			HttpServletResponse arg1, Object arg2, BindException arg3)
			throws Exception {
		
		logger.info("*************ClassificationSchemeListingController:handle***********");
		String now = (new Date()).toString();
		List<ClassificationScheme> Schemes = csManager.getClassificationSchemeDetails();
		Map<String, Object> myModel = new HashMap<String, Object>();
        myModel.put("now", now);
        myModel.put("Schemes", Schemes);

        return new ModelAndView("classificationSchemeList", "model", myModel);
	}

}
