package cas.config;

import io.buji.pac4j.realm.Pac4jRealm;
import io.buji.pac4j.subject.Pac4jPrincipal;
import io.buji.pac4j.token.Pac4jToken;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.SimplePrincipalCollection;
import org.pac4j.core.profile.CommonProfile;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class CasRealm extends Pac4jRealm {
	
	Logger logger = LoggerFactory.getLogger(CasRealm.class);

	private String clientName;

	public String getClientName() {
		return clientName;
	}

	public void setClientName(String clientName) {
		this.clientName = clientName;
	}

	/**
	 * 认证
	 * 
	 * @param authenticationToken
	 * @return
	 * @throws AuthenticationException
	 */
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken)throws AuthenticationException {
		final Pac4jToken pac4jToken = (Pac4jToken) authenticationToken;
		final List<CommonProfile> commonProfileList = pac4jToken.getProfiles();
		final CommonProfile commonProfile = commonProfileList.get(0);
		logger.info("单点登录返回的信息" + commonProfile.toString());
		final Pac4jPrincipal principal = new Pac4jPrincipal(commonProfileList,getPrincipalNameAttribute());
		final PrincipalCollection principalCollection = new SimplePrincipalCollection(principal, getName());
		return new SimpleAuthenticationInfo(principalCollection,commonProfileList.hashCode());
	}

	/**
	 * 授权/验权（todo 后续有权限在此增加）
	 * 
	 * @param principals
	 * @return
	 */
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		SimpleAuthorizationInfo authInfo = new SimpleAuthorizationInfo();
		authInfo.addStringPermission("user");
		return authInfo;
	}
}
