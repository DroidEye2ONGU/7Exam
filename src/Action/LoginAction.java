package Action;

import DAO.UserDAO;
import Moudle.User;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.ServletActionContext;

public class LoginAction extends ActionSupport {
    private String ID;
    private String pass;
    private UserDAO userDAO;
    private User user;

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

//    @Override
//    public void validate() {
//        userDAO = UserDAO.getUserDAOInstance();
//        user = userDAO.queryUser(ID);
//        if (user == null || (!user.getID().equals(getID()) && !user.getPass().equals(getPass()))) {
//            addFieldError("UserWrong", getText("login.UserOrPassWrong"));
//        }
//    }

    @Override
    public String execute() throws Exception {
        userDAO = UserDAO.getUserDAOInstance();
        user = userDAO.queryUser(ID);
        if (user == null || (!user.getID().equals(getID()) && !user.getPass().equals(getPass()))) {
            addFieldError("UserWrong", getText("login.UserOrPassWrong"));
            return INPUT;
        } else {
        ActionContext.getContext().getSession().put("user", user);
//        ServletActionContext.getRequest().getSession().setAttribute("user",user);
        return SUCCESS;
        }
    }
}
