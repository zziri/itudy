package polymorphism.web.userinfo;

import polymorphism.userinfo.UserInfo;
import polymorphism.userinfo.dao.UserInfoDao;
import polymorphism.userinfo.dao.mysql.UserInfoMySqlDao;
import polymorphism.userinfo.dao.oracle.UserInfoOracleDao;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class UserInfoClient {
    public static void main(String[] args) throws IOException {
        FileInputStream fis = new FileInputStream("db.properties");
        Properties properties = new Properties();
        properties.load(fis);

        String dbType = properties.getProperty("DBTYPE");
        UserInfo userInfo = new UserInfo();
        userInfo.setUserId("12345");
        userInfo.setPasswd("!@#$%");
        userInfo.setUserName("이순신");

        UserInfoDao userInfoDao = null;
        if (dbType.equals("ORACLE")) {
            userInfoDao = new UserInfoOracleDao();
        } else if (dbType.equals("MYSQL")) {
            userInfoDao = new UserInfoMySqlDao();
        } else {
            System.out.println("db error");
            return;
        }

        userInfoDao.insertUserInfo(userInfo);
        userInfoDao.deleteUserInf(userInfo);
        userInfoDao.updateUserInfo(userInfo);

    }
}
