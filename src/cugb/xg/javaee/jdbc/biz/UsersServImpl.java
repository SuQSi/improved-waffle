package cugb.xg.javaee.jdbc.biz;

import cugb.xg.javaee.jdbc.dao.IUsersDAO;
import cugb.xg.javaee.jdbc.utils.DAOFactory;;

public class UsersServImpl implements IUsersService {

	@Override
	public boolean validateUser(String username, String password) {
		IUsersDAO usersdao = (IUsersDAO) DAOFactory.newInstance("IUsersDAO");
		String sql = "select * from users where username=? and password=?";
		Object[] params = {username,password};
		if(usersdao.queryUsersBy(sql, params).size() > 0 ){
			return true;
		}else{
			return false;
		}
	}

}
