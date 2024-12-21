package Service;

import Model.Account;
import DAO.AccountDAO;

public class AccountService {
    private AccountDAO accountDAO;

    public AccountService(){
        accountDAO = new AccountDAO();
    }

    public AccountService(AccountDAO accountDAO) {
        this.accountDAO = accountDAO;
    }

    public Account createAccount(Account account){
        if(account.getUsername() != "" && account.getUsername() != null && account.getPassword().length() >= 4) {
            return accountDAO.createAccount(account);
        } else {
            return null;
        }
    }

    public Account verifyLogin(Account account) {
        if(accountDAO.verifyLogin(account) != null) {
            return accountDAO.verifyLogin(account);
        } else {
            return null;
        }
    }
    
}
