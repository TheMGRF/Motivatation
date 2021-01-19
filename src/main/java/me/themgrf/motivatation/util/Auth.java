package me.themgrf.motivatation.util;

import me.themgrf.motivatation.entities.User;
import me.themgrf.motivatation.users.details.DefaultUserDetails;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;

public class Auth {

    /**
     * Check to see if the user is logged in
     *
     * @return <code>true</code> if the user is logged in, <code>false</code> otherwise
     */
    public static boolean isLoggedIn() {
        return SecurityContextHolder.getContext().getAuthentication() != null &&
                SecurityContextHolder.getContext().getAuthentication().isAuthenticated() &&
                !(SecurityContextHolder.getContext().getAuthentication()
                        instanceof AnonymousAuthenticationToken);
    }

    /**
     * Get the User object of the logged in user
     *
     * @return The User object of the logged in user
     */
    public static User getUser() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        Object principal = auth.getPrincipal();
        if (principal instanceof DefaultUserDetails) {
            return ((DefaultUserDetails) principal).getUser();
        }

        return null;
    }
}
