package com.chak.Project.digital_banking_system.configuration;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.context.annotation.Configuration;

import java.util.Date;

@Configuration
public class JWTUtil {

private final String SECRET = "OpenApIKapurrabakosalaviamirtadijaanpebanekalatilmukhdetejachdajaanbadejadohasdenajarrakiyo";
    public String generateToken(String email)
    {
        return Jwts.builder().setSubject(email).setIssuedAt(new Date()).setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60)).signWith(SignatureAlgorithm.HS256, SECRET).compact();
    }
}

