package controllers;

import model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import play.data.Form;
import play.mvc.Controller;
import play.mvc.Result;
import utils.DBHelper;
import views.html.login;

import static play.data.Form.form;

/**
 * Created by tserj on 07.09.2015.
 */
public class Login extends Controller {
    public String userLogin;
    public String password;

    private static final Logger LOG = LoggerFactory.getLogger(Login.class);

    public Result login() {
        return ok(login.render("Login to admin panel", form(Login.class)));
    }

    public Result logout() {
        session().clear();
        flash("success", "You've been logged out");
        return redirect(routes.Login.login());
    }

    public User validate(String login, String pass) {
        User user = DBHelper.getUser(login, pass);
        if (user == null || user.getId() == null || user.getId() <= 0L) {
            return null;
        }
        return user;
    }

    public Result authenticate()  {
        Form<Login> loginForm = form(Login.class).bindFromRequest();
        if (loginForm.hasErrors()) {
            return badRequest(login.render("Login to admin panel - Bad request", loginForm));
        } else {
            User user = validate(loginForm.get().userLogin, loginForm.get().password);
            if (user != null && user.getId() > 0) {
                session().clear();
                session("id", user.getId().toString());
                session("fullName", user.getFullname());
                return redirect(routes.Application.index());
            }
            LOG.error("Invalid user or password for login [{}]", loginForm.get().userLogin);
            return badRequest(login.render("Login to admin panel - Invalid user or password", loginForm));
        }
    }
}
