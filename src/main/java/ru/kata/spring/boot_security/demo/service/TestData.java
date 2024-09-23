package ru.kata.spring.boot_security.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import ru.kata.spring.boot_security.demo.model.Role;
import ru.kata.spring.boot_security.demo.model.User;

import java.util.HashSet;
import java.util.Set;

@Component
public class TestData implements CommandLineRunner {
    @Autowired
    private ServiceUser serviceUser;

//    public TestData() {
//        makeTestData();
//    }

    //    public void makeTestData() {
    @Override
    public void run(String... args) throws Exception {
        User user1 = new User("Ivan", "Petrov", (byte) 32);
        user1.setUserName("user");
        user1.setPassword("user");
        Set<Role> set1 = new HashSet<>();
        set1.add(Role.USER);
        user1.setRoles(set1);
        User user2 = new User("Petr", "Sidorov", (byte) 27);
        user2.setUserName("admin");
        user2.setPassword("admin");
        Set<Role> set2 = new HashSet<>();
        set2.add(Role.ADMIN);
        user2.setRoles(set2);

        serviceUser.updateUser(user1);
        serviceUser.updateUser(user2);
    }


}
