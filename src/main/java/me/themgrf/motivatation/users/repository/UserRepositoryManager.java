package me.themgrf.motivatation.users.repository;

import me.themgrf.motivatation.database.UserInfoMapper;
import org.springframework.lang.Nullable;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class UserRepositoryManager {

    /*@Autowired
    private JdbcTemplate db;

    @Autowired
    private DefualtUserService userDetailsService;

    public UserDetails findByUsername(String username) {
        String sql = "SELECT username, password from users where username = ?";

        Object[] params = new Object[]{username};
        UserInfoMapper mapper = new UserInfoMapper();

        try {
            LoginDetails loginDetails = db.queryForObject(sql, params, mapper);
            return userDetailsService.loadUserByUsername(loginDetails.getUsername());
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }*/

    @Nullable
    @Deprecated
    public UserDetails findByEmail(String email) {
        String sql = "SELECT email, password from users where email = ?";

        Object[] params = new Object[]{email};
        UserInfoMapper mapper = new UserInfoMapper();

        /*try {
            LoginDetails loginDetails = db.queryForObject(sql, params, mapper);
            return userDetailsService.loadUserByUsername(loginDetails.getUsername());
        } catch (EmptyResultDataAccessException e) {
            return null;
        }*/
        return null;
    }
}
