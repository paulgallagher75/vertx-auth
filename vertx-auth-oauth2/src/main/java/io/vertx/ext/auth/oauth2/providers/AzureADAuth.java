package io.vertx.ext.auth.oauth2.providers;

import io.vertx.codegen.annotations.VertxGen;
import io.vertx.core.Vertx;
import io.vertx.ext.auth.oauth2.OAuth2Auth;
import io.vertx.ext.auth.oauth2.OAuth2ClientOptions;
import io.vertx.ext.auth.oauth2.OAuth2FlowType;

/**
 * Simplified factory to create an {@link OAuth2Auth} for Azure AD.
 *
 * @author <a href="mailto:plopes@redhat.com">Paulo Lopes</a>
 */
@VertxGen
public interface AzureADAuth {

  /**
   * Create a OAuth2Auth provider for Microsoft Azure Active Directory
   *
   * @param clientId the client id given to you by Azure
   * @param clientSecret the client secret given to you by Azure
   * @param guid the guid of your application given to you by Azure
   */
  static OAuth2Auth create(Vertx vertx, OAuth2FlowType flow, String clientId, String clientSecret, String guid) {
    return
      OAuth2Auth.create(vertx, flow, new OAuth2ClientOptions()
        .setSite("https://login.windows.net/" + guid)
        .setTokenPath("/oauth2/token")
        .setAuthorizationPath("/oauth2/authorize")
        .setScopeSeparator(",")
        .setClientID(clientId)
        .setClientSecret(clientSecret));
  }
}
