package me.themgrf.motivatation.database;

import me.themgrf.motivatation.users.LoginDetails;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserInfoMapper implements RowMapper<LoginDetails> {

    @Override
    public LoginDetails mapRow(ResultSet rs, int row) throws SQLException {

        String username = rs.getString("username");
        String password = rs.getString("password");

        return new LoginDetails(username, password);
    }
}
