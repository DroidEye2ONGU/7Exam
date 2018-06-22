package Action;

import DAO.UserDAO;
import Moudle.User;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class RegistThenLoginAction extends ActionSupport {
    private User user;
    private UserDAO userDAO;
    private int age;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String execute() throws Exception {
        userDAO = UserDAO.getUserDAOInstance();
        user.setAge(Integer.toString(getAge()));
        if (userDAO.addNewUser(user)) {
            ActionContext.getContext().getSession().put("user", user);
            return SUCCESS;
        } else {
            addFieldError("AddNewUserWrong", getText("regist.AddWrong"));
            return INPUT;
        }
    }
}
