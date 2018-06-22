package Action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class LogoffAction extends ActionSupport {
    @Override
    public String execute() throws Exception {
        ActionContext.getContext().getSession().clear();
        return SUCCESS;
    }
}
