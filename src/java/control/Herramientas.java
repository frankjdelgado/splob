/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import model.TUsuario;
import org.apache.commons.lang3.RandomStringUtils;
/**
 *
 * @author marvin
 */
public class Herramientas {

    public static String Sha256(String data) {
        String out = null;
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            md.update(data.getBytes());

            byte byteData[] = md.digest();

            //convert the byte to hex format method 2
            StringBuilder hexString = new StringBuilder();
            String hex;
            for (int i = 0; i < byteData.length; i++) {
                hex = Integer.toHexString(0xff & byteData[i]);
                if (hex.length() == 1) {
                    hexString.append('0');
                } else {
                    hexString.append(hex);
                }
            }
            out = hexString.toString();
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(Herramientas.class.getName()).log(Level.SEVERE, null, ex);
        }
        return out;
    }

    public static TUsuario BuscarPorEmail(EntityManager em, String email) {
        List<TUsuario> list = em.createNamedQuery("TUsuario.findByEmail").setParameter("email", email).getResultList();

        if (list.size() <= 0) {
            return null;
        } else {
            return list.get(0);
        }
    }

    public static TUsuario BuscarPorUsername(EntityManager em, String username) {
        List<TUsuario> list = em.createNamedQuery("TUsuario.findByAlias").setParameter("alias", username).getResultList();

        if (list.size() <= 0) {
            return null;
        } else {
            return list.get(0);
        }
    }
    private static final String ALPHA_CAPS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final String ALPHA = "abcdefghijklmnopqrstuvwxyz";
    private static final String NUM = "0123456789";

    public static String generatePswd(int len) {
        return RandomStringUtils.randomAlphanumeric(len);
    }

}
