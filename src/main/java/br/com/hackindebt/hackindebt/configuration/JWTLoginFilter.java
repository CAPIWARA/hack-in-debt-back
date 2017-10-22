package br.com.hackindebt.hackindebt.configuration;

import org.json.JSONObject;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;

public class JWTLoginFilter extends AbstractAuthenticationProcessingFilter {

    public JWTLoginFilter(String url, AuthenticationManager authManager) {
        super(new AntPathRequestMatcher(url));
        setAuthenticationManager(authManager);
    }

    @Override
    public Authentication attemptAuthentication(HttpServletRequest req, HttpServletResponse res)
            throws AuthenticationException, IOException, ServletException {
        try {
            BufferedReader in = new BufferedReader(
                    new InputStreamReader(
                            req.getInputStream()));
            String line;
            StringBuilder sb = new StringBuilder();
            String email;
            String password;
            while ((line = in.readLine()) != null) {
                sb.append(line);
            }
            if (sb.toString().equals(null) || sb.toString().equals("")) {
                System.out.println("CHAMOU " + sb.toString());
                email = "";
                password = "";
            } else {
                JSONObject json = new JSONObject(sb.toString());
                email = json.get("email").toString();
                password = json.get("password").toString();
            }
            System.out.println("email da persona: " + email);
            System.out.println("senha da persona: " + password);


            return getAuthenticationManager().authenticate(
                    new UsernamePasswordAuthenticationToken(
                            email,
                            password,
                            Collections.emptyList()
                    )
            );
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Login não é valido:" + e.getMessage());
            return null;
        }
    }

    @Override
    protected void successfulAuthentication(
            HttpServletRequest req,
            HttpServletResponse res, FilterChain chain,
            Authentication auth) throws IOException, ServletException {
        TokenAuthenticationService
                .addAuthentication(res, auth.getName());
    }
}
