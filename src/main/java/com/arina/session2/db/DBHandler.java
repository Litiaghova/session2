package com.arina.session2.db;

import com.arina.session2.User;

import java.sql.*;

public class DBHandler extends ConnectMySQL{

    Connection dbConnect;

    public Connection getDbConnect() throws ClassNotFoundException, SQLException
    {
     String connectionString = "jdbc:mysql://" + dbHost + ":" + dbPort + "/" + dbName;
     Class.forName("com.mysql.cj.jdbc.Driver");
     dbConnect = DriverManager.getConnection(connectionString, dbUser, dbPassword);
     return dbConnect;
    }

    public void signUpUser(User user){

    String insert = "INSERT INTO " + Constants.USERS_TABLE +"("+ Constants.USERS_NAME + "," + Constants.USERS_PASSWORD + "," + Constants.USERS_ROLE +")"
        + "VALUES(?,?,?)"; // Запрос вставки данных в БД

        try {
            PreparedStatement prSt = getDbConnect().prepareStatement(insert);
            prSt.setString(1,user.getName());
            prSt.setString(2,user.getPassword());
            prSt.setString(3,user.getRole());
            prSt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public ResultSet getUser(User user){
        ResultSet resSet = null;

        String select = "SELECT * FROM " + Constants.USERS_TABLE + " WHERE "
                + Constants.USERS_NAME + "=? AND " + Constants.USERS_PASSWORD + "=? AND " + Constants.USERS_ROLE + "=? ";

        try {
            PreparedStatement prSt = getDbConnect().prepareStatement(select); // Выполнение (Вывод) запроса select
            prSt.setString(1,user.getName());
            prSt.setString(2,user.getPassword());
            prSt.setString(3,user.getRole());

            resSet = prSt.executeQuery();

        } catch (SQLException e) {
            e.printStackTrace();

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return resSet;
    }
}
