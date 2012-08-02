package uk.org.datalink.MDR.web;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import uk.org.datalink.MDR.domain.DataElement;
import uk.org.datalink.MDR.service.DataElementManager;


@Controller
@RequestMapping(value="/dataelement/browse")
public class DataElementListingController  {
	protected final Log logger = LogFactory.getLog(getClass());
	private DataElementManager dataElementManager;
	
	@Autowired
	public void setDataElementManager(DataElementManager datamanager) {
        this.dataElementManager = datamanager;
    }
	
	public DataElementManager getDataElementDataManager(){
		return this.dataElementManager;
	}
	

	protected Object formBackingObject(HttpServletRequest request) throws ServletException {
		List<DataElement> DEList = dataElementManager.getDataElements();

		return DEList;
	}

	@RequestMapping(method=RequestMethod.GET)
	protected ModelAndView viewDataElements()
			throws Exception {
		
		logger.info("*************DataElementListingController***********");
		String now = (new Date()).toString();
		List<DataElement> DEList = dataElementManager.getDataElements();
		Map<String, Object> myModel = new HashMap<String, Object>();
        myModel.put("now", now);
        myModel.put("DEList", DEList);

        return new ModelAndView("/dataelement/dataElementList", "model", myModel);
	}
	
	

}
