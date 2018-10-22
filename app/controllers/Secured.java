package controllers;

import play.mvc.*;
import play.mvc.Http.*;
import play.mvc.Security;

/**
 * Created by tserj on 11.09.2015.
 */
public class Secured extends Security.Authenticator {

    @Override
    public String getUsername(Context ctx) {
        return ctx.session().get("id");
    }

    @Override
    public Result onUnauthorized(Context ctx) {
        return redirect(routes.Login.login());
    }
}
