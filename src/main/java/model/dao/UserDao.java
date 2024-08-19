package model.dao;

import model.beans.User;

public interface UserDao {
    public User login(String name, String password);

    public boolean registration(String name, String password, boolean isAdmin);
}