package uk.org.datalink.MDR.web;

import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.SimpleFormController;
import org.w3c.dom.Document;

import uk.org.datalink.tools.ajax.AjaxUtils;
import uk.org.datalink.tools.flash.FlashMap.Message;
import uk.org.datalink.tools.flash.FlashMap.MessageType;
import uk.org.datalink.tools.xml.MDRXMLParser;
import uk.org.datalink.MDR.domain.ClassificationScheme;
import uk.org.datalink.MDR.service.ClassificationSchemeManager;
import uk.org.datalink.MDR.service.CreateDataElement;


@Controller
@RequestMapping("/addClassificationScheme")
public class CSController  {
	protected final Log logger = LogFactory.getLog(getClass());
	private ClassificationSchemeManager cschemeManager;

	public CSController(){
//		setCommandClass(ClassificationScheme.class);
//		setCommandName("classificationSchemeForm");
	}
	
	@Autowired
	public void setCschemeManager(ClassificationSchemeManager cmanager) {
		logger.info("Setting ClassificationSchemeManager ");
        this.cschemeManager = cmanager;
        logger.info("SET ClassificationSchemeManager");
    }
	
	public ClassificationSchemeManager getCschemeManager(){
		return this.cschemeManager;
	}
	

	@RequestMapping(method=RequestMethod.GET)
	public String getCreateForm(Model model, HttpServletRequest request, WebRequest webRequest) {
		logger.info("ClassScheme getCreateForm");
		model.addAttribute(new ClassificationScheme());
		model.addAttribute("ajaxRequest", AjaxUtils.isAjaxRequest(webRequest));

		return "classificationScheme/addClassificationScheme";
	}

	@RequestMapping(method=RequestMethod.POST)
	public String processUpload(@RequestParam("file") MultipartFile file, ClassificationScheme classificationScheme, BindingResult result, Model model) throws IOException {
		Map<String, Object> modelMap = new HashMap<String, Object>();
		String message = "File '" + file.getOriginalFilename() + "' uploaded successfully";
		MDRXMLParser parser = new MDRXMLParser();
		int ref = 0;
		try{
			Document xmlDoc = parser.parse(file.getInputStream());
			logger.info("MDRXMLParser:" + xmlDoc.getNamespaceURI());
			ref = this.cschemeManager.createFromSkos(xmlDoc);
		}catch(Exception ex){
			//Do something later
			logger.info("ERROR MDRXMLParser" + ex.getLocalizedMessage());
		}
		ClassificationScheme cs = this.cschemeManager.getClassificationScheme(ref);
		model.addAttribute("classificationScheme",cs );
		// prepare model for rendering success message in this request
		logger.info("ClassScheme processUpload:" + message);
		model.addAttribute("message", new Message(MessageType.success, message));
		return "classificationScheme/addClassificationScheme";
	}
	

}
