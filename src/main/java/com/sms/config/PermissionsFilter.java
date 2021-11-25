package com.sms.config;

import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.filter.authz.PermissionsAuthorizationFilter;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import java.io.IOException;

public class PermissionsFilter extends PermissionsAuthorizationFilter {
    @Override
    public boolean isAccessAllowed(ServletRequest request, ServletResponse response, Object mappedValue) throws IOException {
        Subject subject = this.getSubject(request, response);
        String[] perms = (String[])mappedValue;
        boolean isPermitted = false;

        if (perms != null && perms.length > 0) {
            for (String perm : perms) {
                if (subject.isPermitted(perm)) {
                    return true;
                }
            }
        }

        return isPermitted;
    }
}
