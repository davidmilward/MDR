package uk.org.datalink.MDR.web;

import org.springframework.web.servlet.mvc.SimpleFormController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import uk.org.datalink.MDR.domain.AdminObject;
import uk.org.datalink.MDR.service.ChangeAdminStatus;
import uk.org.datalink.MDR.service.DataManager;



public class ChangeAdminStatusController extends SimpleFormController{
	
	protected final Log logger = LogFactory.getLog(getClass());
	public final static int ADMINSTATUS_No_Pending_Changes = 1;
	public final static int ADMINSTATUS_Scheduled_For_Review = 2;
	public final static int ADMINSTATUS_Under_Review = 3;
	public final static int ADMINSTATUS_In_Consultation = 4;
	

    private DataManager dataManager;

    public ModelAndView onSubmit(Object command)
            throws ServletException {

        int newStatus = ((uk.org.datalink.MDR.service.ChangeAdminStatus) command).getAdminStatus();
        logger.info("changing " +  newStatus);
        

        switch(newStatus){
        
	        case 0:  dataManager.setAdminStatus(this.ADMINSTATUS_No_Pending_Changes); break;
	        case 1:  dataManager.setAdminStatus(this.ADMINSTATUS_No_Pending_Changes); break;
	        case 2:  dataManager.setAdminStatus(this.ADMINSTATUS_Scheduled_For_Review); break;
	        case 3:  dataManager.setAdminStatus(this.ADMINSTATUS_Under_Review); break;
        	
        }

        logger.info("returning new status " + getSuccessView());

        return new ModelAndView(new RedirectView(getSuccessView()));
    }

    protected Object formBackingObject(HttpServletRequest request) throws ServletException {
        ChangeAdminStatus adminStatus = new ChangeAdminStatus();
        adminStatus.setAdminStatus(5);
        logger.info("****formBackingObject - setting admin status " );
        return adminStatus;
    }

    public void setDataManager(DataManager dataManager) {
        this.dataManager = dataManager;
    }

    public DataManager getDataManager() {
        return dataManager;
    }

	
	

}
