package controllers;

import com.google.common.collect.Lists;
import models.CredentialsEntity;
import models.LoginData;
import notes.Routes;
import play.data.Form;
import play.data.FormFactory;
import play.mvc.Controller;
import play.mvc.Http;
import play.mvc.Result;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;

public class LoginController  extends Controller {
    private final Form<LoginData> form;

    private List<CredentialsEntity> credentials;

    @Inject
    public LoginController(FormFactory formFactory) {
        form = formFactory.form(LoginData.class);
        credentials = Lists.newArrayList(
                new CredentialsEntity("nghia", "123")
                , new CredentialsEntity("john", "123")
                , new CredentialsEntity("admin", "admin")
        );

    }

    public Result index(Http.Request request) {
        return ok(views.html.login_index.render(form,request));
    }

    public Result login(Http.Request request) {
        Form<LoginData> loginDataForm = form.bindFromRequest(request);
        if (loginDataForm.hasErrors()) {
            return badRequest(views.html.login_index.render(form,request));
        } else {
            LoginData loginData = loginDataForm.get();

            if (credentials.stream().anyMatch(credentialsEntity -> credentialsEntity.getUsername().equals(loginData.getUsername())
                    && credentialsEntity.getPassword().equals(loginData.getPassword()))) {
                return redirect(routes.HomeController.index());
            } else {
                return redirect(routes.LoginController.index()).flashing("noti", "Username or password not correct");

            }

//            credentials.add(new CredentialsEntity(loginData.getUsername(), loginData.getPassword()));


        }
    }

}
