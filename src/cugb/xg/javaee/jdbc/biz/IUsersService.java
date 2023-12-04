package cugb.xg.javaee.jdbc.biz;

public interface IUsersService {

	/***
	 * validUser
	 * @param username
	 * @param password
	 * @return
	 */
	public boolean validateUser(String username,String password);

}
