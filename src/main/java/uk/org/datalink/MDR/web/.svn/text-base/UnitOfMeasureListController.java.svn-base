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

import uk.org.datalink.MDR.domain.UnitsOfMeasure;
import uk.org.datalink.MDR.service.UnitsOfMeasureManager;

public class UnitOfMeasureListController extends AbstractCommandController {
	protected final Log logger = LogFactory.getLog(getClass());
	private UnitsOfMeasureManager unitsOfMeasureManager;

	public UnitOfMeasureListController(){
		setCommandClass(UnitsOfMeasure.class);
		setCommandName("UnitsOfMeasureList");
	}
	
	public void setUnitsOfMeasureManager(UnitsOfMeasureManager umanager) {
		logger.info("Setting ArtefactListController amanager ");
        this.unitsOfMeasureManager = umanager;
        logger.info("SET ArtefactListController amanager");
    }
	
	public UnitsOfMeasureManager getUnitsOfMeasureManager(){
		return this.unitsOfMeasureManager;
	}
	
	
	protected Object formBackingObject(HttpServletRequest request) throws ServletException {
		List<UnitsOfMeasure> UnitsOfMeasure = unitsOfMeasureManager.getUnitsOfMeasures();

		return UnitsOfMeasure;
	}

	@Override
	protected ModelAndView handle(HttpServletRequest arg0,
			HttpServletResponse arg1, Object arg2, BindException arg3)
			throws Exception {
		
		logger.info("*************UnitsofMeasureListController:handle***********");
		String now = (new Date()).toString();
		List<UnitsOfMeasure> UnitsOfMeasure = unitsOfMeasureManager.getUnitsOfMeasures();
		Map<String, Object> myModel = new HashMap<String, Object>();
        myModel.put("now", now);
        myModel.put("UnitsOfMeasure", UnitsOfMeasure);

        return new ModelAndView("unitsOfMeasureList", "model", myModel);
	}

}
