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

import uk.org.datalink.MDR.domain.ClassificationSchemeType;
import uk.org.datalink.MDR.service.ClassificationSchemeTypeManager;

public class CSTypeListController extends AbstractCommandController {
	protected final Log logger = LogFactory.getLog(getClass());
	private ClassificationSchemeTypeManager cstManager;

	public CSTypeListController(){
		setCommandClass(ClassificationSchemeType.class);
		setCommandName("classificationSchemeTypeList");
	}
	
	public void setCstManager(ClassificationSchemeTypeManager cmanager) {
		logger.info("Setting ClassificationSchemeManager countryManager ");
        this.cstManager = cmanager;
        logger.info("SET ClassificationSchemeController countryManager");
    }
	
	public ClassificationSchemeTypeManager getCstManager(){
		return this.cstManager;
	}
	
	
	protected Object formBackingObject(HttpServletRequest request) throws ServletException {
		List<ClassificationSchemeType> Schemes = cstManager.getClassificationSchemeTypeDetails();

		return Schemes;
	}

	@Override
	protected ModelAndView handle(HttpServletRequest arg0,
			HttpServletResponse arg1, Object arg2, BindException arg3)
			throws Exception {
		
		logger.info("*************ClassificationSchemeListingController:handle***********");
		String now = (new Date()).toString();
		List<ClassificationSchemeType> SchemeTypes = cstManager.getClassificationSchemeTypeDetails();
		Map<String, Object> myModel = new HashMap<String, Object>();
        myModel.put("now", now);
        myModel.put("SchemeTypes", SchemeTypes);

        return new ModelAndView("classificationSchemeTypeList", "model", myModel);
	}

}
