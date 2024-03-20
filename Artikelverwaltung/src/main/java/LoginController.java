import jakarta.faces.application.FacesMessage;
import jakarta.faces.application.NavigationHandler;
import jakarta.faces.component.UIComponent;
import jakarta.faces.component.UIInput;
import jakarta.faces.context.FacesContext;
import jakarta.faces.event.ComponentSystemEvent;
import jakarta.faces.validator.ValidatorException;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;

import java.io.Serializable;

@Named
@ViewScoped
public class LoginController implements Serializable {

    @Inject
    Shop shop;

    @Inject
    CurrentUser currentUser;

    // those are text-field values
    String user, password;
    // this setting comes earlier
    String tempUsername;
    // this is used for the next display
    String failureMessage = "";

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFailureMessage() {
        return failureMessage;
    }

    public void setFailureMessage(String failureMessage) {
        this.failureMessage = failureMessage;
    }

    // this method should be called early to avoid providing information if the user is not logged in
    public void checkLogin() {
        if(!currentUser.isValid()) {
            failureMessage = "Bitte loggen Sie sich ein.";
            FacesContext fc = FacesContext.getCurrentInstance();
            NavigationHandler nh = fc.getApplication().getNavigationHandler();
            nh.handleNavigation(fc, null, "login.xhtml?faces-redirect=true");
        }

    }

    public String logout() {
        currentUser.reset();
        return "login.xhtml?faces-redirect=true";
    }

    public void postValidateUser(ComponentSystemEvent ev) {
        UIInput temp = (UIInput) ev.getComponent();
        this.tempUsername = (String) temp.getValue();
    }

    public void validateLogin(FacesContext context, UIComponent component, Object value) throws ValidatorException {
        String password = (String) value;
        shop.validateUsernameAndPassword(currentUser, tempUsername, password);
        if (!currentUser.isValid())
            throw new ValidatorException(new FacesMessage("Login falsch!"));
    }

    public String login() {
        if (currentUser.isAdmin()) {
            this.failureMessage = "";
            return "backoffice.xhtml?faces-redirect=true";
        } else if (currentUser.isClient()) {
            this.failureMessage = "";
            return "shopclient.xhtml?faces-redirect=true";
        } else {
            this.failureMessage = "Passwort und Benutzername nicht erkannt.";
            return "";
        }
    }
}