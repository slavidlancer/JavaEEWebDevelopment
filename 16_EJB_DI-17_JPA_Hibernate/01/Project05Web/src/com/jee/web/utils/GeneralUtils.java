package com.jee.web.utils;

import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import javax.servlet.http.HttpServletRequest;

import org.bouncycastle.util.encoders.Hex;

import com.jee.entity.UserModel;

public class GeneralUtils {
    public static UserModel getLoggedUser(Object requestObject) {
        UserModel loggedUser = null;
        
        if (requestObject instanceof HttpServletRequest) {
            HttpServletRequest request = (HttpServletRequest) requestObject;
            loggedUser = (UserModel) request.getSession().getAttribute("LOGGED_USER");
        }
        
        return loggedUser;
    }
    
    public static String getRequestedPath(Object requestObject) {
        String requestedPath = "";
        
        if (requestObject instanceof HttpServletRequest) {
            HttpServletRequest request = (HttpServletRequest) requestObject;
            requestedPath = request.getRequestURI().substring(request.getContextPath().length());
        }
        
        return requestedPath;
    }
    
    public static String encodePlainTextToSha256(String plainText) {
        MessageDigest messageDigest = null;
        
        try {
            messageDigest = MessageDigest.getInstance("SHA-256");
            byte[] hash = messageDigest.digest(plainText.getBytes("UTF-8"));
            
            return new String(Hex.encode(hash));
        } catch (NoSuchAlgorithmException nsae) {
            throw new RuntimeException("no encoding algorithm found", nsae);
        } catch (UnsupportedEncodingException uee) {
            throw new RuntimeException("no encoding support", uee);
        }
    }
    
    public static String encodePlainTextToMd5(String plainText) {
        MessageDigest messageDigest = null;
        
        try {
            messageDigest = MessageDigest.getInstance("MD5");
            messageDigest.update(plainText.getBytes("UTF-8"), 0, plainText.length());
            
            return new BigInteger(1, messageDigest.digest()).toString(16);
        } catch (NoSuchAlgorithmException nsae) {
            throw new RuntimeException("no encoding algorithm found", nsae);
        } catch (UnsupportedEncodingException uee) {
            throw new RuntimeException("no encoding support", uee);
        }
    }
    
    public static String convertDateToString(Date date, String pattern) {
        DateFormat dateFormat = new SimpleDateFormat(pattern);
        
        return dateFormat.format(date);
    }
}
