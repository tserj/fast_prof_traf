package controllers;

import model.User;
import play.libs.Json;
import play.mvc.Controller;
import play.mvc.Result;
import utils.DBHelper;

/**
 * Created by tserj on 11.09.2015.
 */
public class Backend extends Controller {

    public Result test() {
        String id = Long.toString(1L);
        User res = DBHelper.getUser(id);
        return ok(Json.toJson(res != null ? res : "no result"));
    }

}
