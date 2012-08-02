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

import uk.org.datalink.MDR.domain.Model;
import uk.org.datalink.MDR.service.ModelManager;

public class ModelListController extends AbstractCommandController {
	protected final Log logger = LogFactory.getLog(getClass());
	private ModelManager modelManager;

	public ModelListController(){
		setCommandClass(Model.class);
		setCommandName("ModelList");
	}
	
	public void setModelManager(ModelManager mmanager) {
		logger.info("Setting ModelListController  ");
        this.modelManager= mmanager;
        logger.info("SET ModelListController ");
    }
	
	public ModelManager getModelManager(){
		return this.modelManager;
	}
	
	
	protected Object formBackingObject(HttpServletRequest request) throws ServletException {
		List<Model> Models= modelManager.getModelDetails();

		return Models;
	}

	@Override
	protected ModelAndView handle(HttpServletRequest arg0,
			HttpServletResponse arg1, Object arg2, BindException arg3)
			throws Exception {
		
		logger.info("*************ModelListController:handle***********");
		String now = (new Date()).toString();
		List<Model> modelList = modelManager.getModelDetails();
		Map<String, Object> myModel = new HashMap<String, Object>();
        myModel.put("now", now);
        myModel.put("modelList", modelList);

        return new ModelAndView("modelList", "model", myModel);
	}

}
