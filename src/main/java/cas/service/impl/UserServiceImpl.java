package cas.service.impl;

import cas.service.UserService;
import io.buji.pac4j.subject.Pac4jPrincipal;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.pac4j.core.profile.CommonProfile;
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
        PrincipalCollection pcs = subject.getPrincipals();
        Pac4jPrincipal p = pcs.oneByType(Pac4jPrincipal.class);
        if (p != null) {
            return p.getProfile().getId();
        }
        return null;
    }
}
