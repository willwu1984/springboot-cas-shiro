package cas.service.impl;

import cas.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Service;

/**
 * Created by wwu on 2017/4/13.
 */
@Service("userService")
public class UserServiceImpl implements UserService {
    @Override
    public String getUsername() {
        Subject subject = SecurityUtils.getSubject();
        if (subject == null || subject.getPrincipals() == null) {
            return null;
        }
        return (String) subject.getPrincipals().getPrimaryPrincipal();
    }
}
