package org.keycloak.adapters.saml.jetty;

import org.eclipse.jetty.server.Authentication;
import org.eclipse.jetty.server.HttpChannel;
import org.eclipse.jetty.server.Request;
import org.eclipse.jetty.server.UserIdentity;
import org.keycloak.adapters.spi.AdapterSessionStore;
import org.keycloak.adapters.saml.SamlDeployment;

import javax.servlet.ServletRequest;

/**
 * @author <a href="mailto:bill@burkecentral.com">Bill Burke</a>
 * @version $Revision: 1 $
 */
public class KeycloakSamlAuthenticator extends AbstractSamlAuthenticator {

    public KeycloakSamlAuthenticator() {
        super();
    }


   @Override
    protected Request resolveRequest(ServletRequest req) {
        return (req instanceof Request) ? (Request)req : HttpChannel.getCurrentHttpChannel().getRequest();
    }

    @Override
    public Authentication createAuthentication(UserIdentity userIdentity) {
        return new KeycloakAuthentication(getAuthMethod(), userIdentity) {
            @Override
            public void logout() {
                logoutCurrent(HttpChannel.getCurrentHttpChannel().getRequest());
            }
        };
    }

    @Override
    public AdapterSessionStore createSessionTokenStore(Request request, SamlDeployment resolvedDeployment) {
        return new JettyAdapterSessionStore(request);
    }
}
