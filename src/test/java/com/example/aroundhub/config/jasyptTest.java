package com.example.aroundhub.config;

import org.jasypt.encryption.pbe.StandardPBEStringEncryptor;
import org.junit.jupiter.api.Test;

public class jasyptTest {

    @Test
    void encryptTest() {
        String id = "rood";
        String password = "dltmfrl66";

        System.out.println(jasyptEncoding(id));
        System.out.println(jasyptEncoding(password));
    }

    public String jasyptEncoding(String value) {
        String key = "around_hub_studio";
        StandardPBEStringEncryptor pbeEnc = new StandardPBEStringEncryptor();
        pbeEnc.setAlgorithm("PBEWithMD5AndDES");
        pbeEnc.setPassword(key);
        return pbeEnc.encrypt(value);
    }
}
