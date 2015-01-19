package org.orcid.integration.api.helper;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.core.MultivaluedMap;

import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;
import org.orcid.api.common.WebDriverHelper;
import org.orcid.integration.api.t2.T2OAuthAPIService;
import org.orcid.pojo.ajaxForm.PojoUtil;

import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.core.util.MultivaluedMapImpl;

public class OauthHelper {

    private WebDriverHelper webDriverHelper;

    private T2OAuthAPIService<ClientResponse> oauthT2Client;
    
    private List<String> items = new ArrayList<String>();
    
    {items.add("enablePersistentToken");}
    
    public void setWebDriverHelper(WebDriverHelper webDriverHelper) {
        this.webDriverHelper = webDriverHelper;
    }

    public T2OAuthAPIService<ClientResponse> getOauthT2Client() {
        return oauthT2Client;
    }

    public void setOauthT2Client(T2OAuthAPIService<ClientResponse> oauthT2Client) {
        this.oauthT2Client = oauthT2Client;
    }

    public String obtainAccessToken(String clientId, String scopes, String email, String password, String redirectUri) throws JSONException, InterruptedException {
        return obtainAccessToken(clientId, scopes, email, password, redirectUri, false);
    }
    
    public String obtainAccessToken(String clientId, String scopes, String email, String password, String redirectUri, boolean persistent) throws JSONException, InterruptedException {
        String authorizationCode = null;
        if(persistent) {
            authorizationCode = webDriverHelper.obtainAuthorizationCode(scopes, clientId, email, password, items, true);
        } else {
            authorizationCode = webDriverHelper.obtainAuthorizationCode(scopes, clientId, email, password);
        }
        assertNotNull(authorizationCode);
        assertFalse(PojoUtil.isEmpty(authorizationCode));      
        MultivaluedMap<String, String> params = new MultivaluedMapImpl();
        params.add("client_id", clientId);
        params.add("client_secret", "client-secret");
        params.add("grant_type", "authorization_code");
        params.add("scope", scopes);
        params.add("redirect_uri", redirectUri);
        params.add("code", authorizationCode);
        ClientResponse tokenResponse = oauthT2Client.obtainOauth2TokenPost("client_credentials", params);
        assertEquals(200, tokenResponse.getStatus());
        String body = tokenResponse.getEntity(String.class);
        JSONObject jsonObject = new JSONObject(body);
        String accessToken = (String) jsonObject.get("access_token");
        assertNotNull(accessToken);
        return accessToken;
    }
}