package com.fsboot.dao;

import com.fsboot.dto.UserDto;
import com.fsboot.entities.ResponseModel;
import com.fsboot.entities.User;
import com.fsboot.repo.UserRepo;
import com.fsboot.utils.UserConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.List;
import java.util.Optional;

@Repository
public class UserDao implements UserSqlQueries, UserConstants {
    @Autowired
    private JdbcTemplate jdbcTemplateObj;
    @Autowired
    private User user;
    @Autowired
    private ResponseModel responseModel;
    @Autowired
    private UserRepo userRepo;
    private DataSource dataSource;

    public DataSource getDataSource() {
        return dataSource;
    }

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
        this.jdbcTemplateObj = new JdbcTemplate(dataSource);
    }

    public User insData(User user) {
        return userRepo.save(user);
    }

    public Optional<User> delData(int id) {
        Optional<User> user=userRepo.findById(id);
        userRepo.deleteById(id);
        return user;
    }

    public List<UserDto> AllUsers() {
        List<UserDto> allUser = jdbcTemplateObj.query(SelQuery, (rs, row_num) -> new UserDto(rs.getInt("id"), rs.getString("name"), rs.getString("address")));
        return allUser;
    }

    public User getSingleUser(Integer id) {
        User user = userRepo.findById(id).get();
        return user;
    }

    public User updUsers(User user) {
        return userRepo.save(user);
    }
}
