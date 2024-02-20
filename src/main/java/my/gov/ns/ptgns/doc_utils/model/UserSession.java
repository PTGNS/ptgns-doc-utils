package my.gov.ns.ptgns.doc_utils.model;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserSession {

    //  VARIABLE
    private String userName, name, email;

    // GETTER SETTER

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
