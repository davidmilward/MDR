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

import uk.org.datalink.MDR.domain.UnitsOfMeasure;
import uk.org.datalink.MDR.service.UnitsOfMeasureManager;

public class UnitOfMeasureController extends SimpleFormController {
	protected final Log logger = LogFactory.getLog(getClass());
	private UnitsOfMeasureManager unitsOfMeasureManager;

	public UnitOfMeasureController(){
		setCommandClass(UnitsOfMeasure.class);
		setCommandName("unitsofmeasureForm");
	}
	public void setUnitsOfMeasureManager(UnitsOfMeasureManager umanager) {
		logger.info("Setting UnitsOfMeasureManager ");
        this.unitsOfMeasureManager = umanager;
        logger.info("SET UnitsOfMeasureManager");
    }
	
	public UnitsOfMeasureManager getUnitsOfMeasureManager(){
		return this.unitsOfMeasureManager;
	}
	
	public ModelAndView onSubmit(Object command)throws ServletException {

		UnitsOfMeasure newUOM = ((uk.org.datalink.MDR.domain.UnitsOfMeasure) command);
		logger.info("*************UnitsOfMeasureController***********" + newUOM.getDescription() );
		unitsOfMeasureManager.create(newUOM);
		String now = (new Date()).toString();
		Map<String, Object> myModel = new HashMap<String, Object>();
        myModel.put("now", now);
        myModel.put("newUOM", newUOM);

        return new ModelAndView("unitsofmeasureSuccess", "model", myModel);
	}
	
	protected Object formBackingObject(HttpServletRequest request) throws ServletException {
		UnitsOfMeasure newUOM = new UnitsOfMeasure();
		
		return newUOM;
	}

}
