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
        return accountDAO.createAccount(account);
    }

    public Account verifyLogin(Account account) {
        return accountDAO.verifyLogin(account);
    }
    
}
