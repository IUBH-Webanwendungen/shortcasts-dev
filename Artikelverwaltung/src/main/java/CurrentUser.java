import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Named;

import java.io.Serializable;

@Named
@SessionScoped
public class CurrentUser implements Serializable {

    boolean admin, client;

    void reset() {
        admin = false; client = false;
    }

    boolean isAdmin() {
        return admin;
    }

    boolean isClient() {
        return client;
    }

    boolean isValid() {
        return isClient() || isAdmin();
    }

}
