package jm.task.core.jdbc;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.service.UserServiceImpl;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        UserServiceImpl userService = new UserServiceImpl();
        userService.createUsersTable();

        userService.saveUser("aaaa", "fgh", (byte) 25);
        userService.saveUser("bbbb", "dfg", (byte) 28);
        userService.saveUser("cccc", "sdf", (byte) 32);
        userService.saveUser("dddd", "sfdfs", (byte) 22);


        List<User> users = userService.getAllUsers();
        users.forEach(user -> System.out.println(user));

        userService.cleanUsersTable();

        userService.dropUsersTable();
    }
}
