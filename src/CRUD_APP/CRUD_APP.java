
package CRUD_APP;

import Model.DB;
import view.LoginPage;

public class CRUD_APP {

    /**
     *
     * @param args
     */
    @SuppressWarnings("deprecation")
    public static void main(String[] args) {
       
        LoginPage loginObj= new LoginPage();
        loginObj.show();
        DB.loadConnection();//calling load method in main class

    }
    
}
