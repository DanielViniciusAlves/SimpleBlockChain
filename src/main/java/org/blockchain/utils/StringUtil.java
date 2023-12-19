package org.blockchain.utils;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
public class StringUtil {

    // This function applies a sha256 in a string and return this as a hexadecimal hash in a string
    public static String addSha256(String input){
        try{
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] hash = digest.digest(input.getBytes(StandardCharsets.UTF_8));
            StringBuilder hexString = new StringBuilder();
            for (byte b : hash) {
                String hex = Integer.toHexString(0xff & b);
                if (hex.length() == 1) hexString.append('0');
                hexString.append(hex);
            }
            return hexString.toString();
        } catch (Exception e) {
           throw new RuntimeException(e);
        }
    }

}
