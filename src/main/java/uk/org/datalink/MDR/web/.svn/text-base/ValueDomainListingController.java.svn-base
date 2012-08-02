package uk.org.datalink.MDR.web;

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

import uk.org.datalink.MDR.domain.ValueDomain;
import uk.org.datalink.MDR.service.ValueDomainManager;


@Controller
@RequestMapping(value="/valuedomain/browse")
public class ValueDomainListingController  {
	protected final Log logger = LogFactory.getLog(getClass());
	private ValueDomainManager valueDomainManager;
	
	@Autowired
	public void setValueDomainManager(ValueDomainManager datamanager) {
        this.valueDomainManager = datamanager;
    }
	
	public ValueDomainManager getDataElementDataManager(){
		return this.valueDomainManager;
	}
	

	protected Object formBackingObject(HttpServletRequest request) throws ServletException {
		List<ValueDomain> DEList = valueDomainManager.getValueDomains();

		return DEList;
	}

	@RequestMapping(method=RequestMethod.GET)
	protected ModelAndView viewDataElements()
			throws Exception {
		
		logger.info("*************ValueDomainListingController***********");
		List<ValueDomain> VDList = valueDomainManager.getValueDomains();
		Map<String, Object> myModel = new HashMap<String, Object>();
        myModel.put("VDList", VDList);

        return new ModelAndView("/valuedomain/valuedomainList", "model", myModel);
	}


}
