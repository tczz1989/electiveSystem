package electiveSystem.factory;

import electiveSystem.dao.IaccountDAO;
import electiveSystem.dao.proxy.AccountDAOProxy;

public class DAOFactory {

	public static IaccountDAO getIaccountDAOInstance() {
		return new AccountDAOProxy();
	}

}
