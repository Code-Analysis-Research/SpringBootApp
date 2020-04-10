package CanDetect.util;

import javax.crypto.KeyGenerator;
import java.security.*;
import java.security.spec.ECGenParameterSpec;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class UtilExamples {
    public void generateKey() throws NoSuchAlgorithmException, InvalidAlgorithmParameterException {
        KeyPairGenerator keyPairGen1 = KeyPairGenerator.getInstance("RSA");
        keyPairGen1.initialize(1024); // Noncompliant

        KeyPairGenerator keyPairGen5 = KeyPairGenerator.getInstance("EC");
        ECGenParameterSpec ecSpec1 = new ECGenParameterSpec("secp112r1"); // Noncompliant
        keyPairGen5.initialize(ecSpec1);

        KeyGenerator keyGen1 = KeyGenerator.getInstance("AES");
        keyGen1.init(64); // Noncompliant
    }

    public boolean validate(javax.servlet.http.HttpServletRequest request) {
        String regex = request.getParameter("regex");
        String input = request.getParameter("input");

        // Enables attackers to force the web server to evaluate
        // regex such as "(a+)+" on inputs such as "aaaaaaaaaaaaaaaaaaaaaaaaaaaaa!"

        return input.matches(regex);
    }

    public void hashData(String algorithm, String providerStr, Provider provider) throws Exception {
        MessageDigest.getInstance(algorithm); // Sensitive
        MessageDigest.getInstance(algorithm, providerStr); // Sensitive
        MessageDigest.getInstance(algorithm, provider); // Sensitive
    }

    public void hashData2(String algorithm, String providerStr, Provider provider) throws Exception {
        MessageDigest.getInstance(algorithm); // Sensitive
        MessageDigest.getInstance(algorithm, providerStr); // Sensitive
        MessageDigest.getInstance(algorithm, provider); // Sensitive
    }

    public Connection getConnection() throws SQLException {
        Connection conn = null;
        conn = DriverManager.getConnection("jdbc:mysql://localhost/test?" +
                "user=steve&password=blue"); // Sensitive
        String uname = "steve";
        String password = "blue";
        conn = DriverManager.getConnection("jdbc:mysql://localhost/test?" +
                "user=" + uname + "&password=" + password); // Sensitive
        return conn;
    }
}
