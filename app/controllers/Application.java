package controllers;

import model.User;
import play.libs.Json;
import play.mvc.*;

import utils.DBHelper;
import views.html.*;

/**
 * Created by tserj on 08.09.2015.
 */
public class Application extends Controller {


    @Security.Authenticated(Secured.class)
    public Result index() {
        User res = DBHelper.getUser(request().username());
        return ok(index.render("Admin panel", res));
    }

    public Result help() {
        return ok(help.render("Play help page"));
    }

    public Result cover() {
        return ok(cover.render("Sample index page"));
    }

}
