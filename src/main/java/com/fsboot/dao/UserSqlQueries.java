package com.fsboot.dao;

public interface UserSqlQueries {
    String InsQuery = "INSERT INTO user(name,address) VALUES(?,?)";
    String SelQuery = "SELECT * FROM user";
    String SelOneByIdQuery = "SELECT * FROM user WHERE id=?";
    String Upd_Query = "UPDATE user SET name=?,address=?" + "where id=?";
    String Del_Query = "DELETE FROM user WHERE id =?";

}
