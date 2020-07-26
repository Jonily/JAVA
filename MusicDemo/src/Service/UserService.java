package Service;

import DAO.UserDao;
import entity.User;

public class UserService {
    //登陆方法
    public User login(User loginUser){
        UserDao userDao = new UserDao();
        User user = userDao.login(loginUser);
        return user;
    }
}
