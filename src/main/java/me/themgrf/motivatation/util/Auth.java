package me.themgrf.motivatation.util;

import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;

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

}
