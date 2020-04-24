package CanDetect.util;

import javax.crypto.KeyGenerator;
import java.io.*;
import java.security.*;
import java.security.spec.ECGenParameterSpec;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.*;

public class UtilExamples {
    private static SimpleDateFormat format = new SimpleDateFormat("HH-mm-ss");
    private static Calendar calendar = Calendar.getInstance();

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
        MessageDigest.getInstance(algorithm);
        MessageDigest.getInstance(algorithm, providerStr);
    }

    public void hashData2(String algorithm, String providerStr, Provider provider) throws Exception {
        MessageDigest.getInstance(algorithm);
        MessageDigest.getInstance(algorithm, providerStr);
    }

    public Connection getConnection() throws SQLException {
        Connection conn = null;
        conn = DriverManager.getConnection("jdbc:mysql://localhost/test?" +
                "user=steve&password=blue"); // Sensitive
        String uname = "steve";
        String password = "steve";
        conn = DriverManager.getConnection("jdbc:mysql://localhost/test?" +
                "user=" + uname + "&password=" + password); // Sensitive
        return conn;
    }

    public void readFile(String fileName) {
        BufferedReader buffReader = null;
        try {
            buffReader = new BufferedReader(new FileReader(fileName));
            while (buffReader.readLine() != null) {

            }
        } catch (IOException e) {
            System.out.println(e);
        }
    }

    private void readProperties() throws Exception {
        String file = System.getenv("myfile.txt");
        OutputStream stream = null;
        List<String> propertyList = new ArrayList<>();
        try {
            for (String property : propertyList) {
                stream = new FileOutputStream(file);
            }
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            stream.close();  // Multiple streams were opened. Only the last is closed.
        }
    }

    private Map<String, String> getMap() {
        Map<String, String> testMap = new HashMap<>();
        testMap.put("a", "Apple");
        testMap.put("a", "Orange");
        return testMap;
    }

}
