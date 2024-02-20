package my.gov.ns.ptgns.doc_utils.utils;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.security.*;
import java.util.Arrays;
import java.util.Base64;
import java.util.Random;

import static java.nio.charset.StandardCharsets.UTF_8;

public class AES {

    public static String encrypt(String plaintext, String passphrase) throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, InvalidAlgorithmParameterException, IllegalBlockSizeException, BadPaddingException {
        final int keySize = 256;
        final int ivSize = 128;

        // Create empty key and iv
        byte[] key = new byte[keySize / 8];
        byte[] iv = new byte[ivSize / 8];

        // Create random salt
        byte[] saltBytes = generateSalt(8);

        // Derive key and iv from passphrase and salt
        EvpKDF(passphrase.getBytes(UTF_8), keySize, ivSize, saltBytes, key, iv);

        // Actual encrypt
        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
        cipher.init(Cipher.ENCRYPT_MODE, new SecretKeySpec(key, "AES"), new IvParameterSpec(iv));
        byte[] cipherBytes = cipher.doFinal(plaintext.getBytes(UTF_8));

        /**
         * Create CryptoJS-like encrypted string from encrypted data This is how
         * CryptoJS do: 1. Create new byte array to hold ecrypted string (b) 2.
         * Concatenate 8 bytes to b 3. Concatenate salt to b 4. Concatenate
         * encrypted data to b 5. Encode b using Base64
         */
        byte[] sBytes = "Salted__".getBytes(UTF_8);
        byte[] b = new byte[sBytes.length + saltBytes.length + cipherBytes.length];
        System.arraycopy(sBytes, 0, b, 0, sBytes.length);
        System.arraycopy(saltBytes, 0, b, sBytes.length, saltBytes.length);
        System.arraycopy(cipherBytes, 0, b, sBytes.length + saltBytes.length, cipherBytes.length);

        //byte[] base64b = Base64.encode(b, Base64.DEFAULT);
        byte[] base64b = Base64.getEncoder().encode(b);

        return new String(base64b);
    }

    public static String decrypt(String ciphertext, String passphrase) throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, InvalidAlgorithmParameterException, IllegalBlockSizeException, BadPaddingException {
        final int keySize = 256;
        final int ivSize = 128;

        // Decode from base64 text
        //byte[] ctBytes = Base64.decode(ciphertext.getBytes("UTF-8"), Base64.DEFAULT);
        byte[] ctBytes = Base64.getDecoder().decode(ciphertext);

        // Get salt
        byte[] saltBytes = Arrays.copyOfRange(ctBytes, 8, 16);

        // Get ciphertext
        byte[] ciphertextBytes = Arrays.copyOfRange(ctBytes, 16, ctBytes.length);

        // Get key and iv from passphrase and salt
        byte[] key = new byte[keySize / 8];
        byte[] iv = new byte[ivSize / 8];
        EvpKDF(passphrase.getBytes(UTF_8), keySize, ivSize, saltBytes, key, iv);

        // Actual decrypt
        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
        cipher.init(Cipher.DECRYPT_MODE, new SecretKeySpec(key, "AES"), new IvParameterSpec(iv));
        byte[] recoveredPlaintextBytes = cipher.doFinal(ciphertextBytes);

        return new String(recoveredPlaintextBytes);
    }

    public static byte[] fileEncrypt(byte[] fileBytes, String passphrase) throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, InvalidAlgorithmParameterException, IllegalBlockSizeException, BadPaddingException {
        final int keySize = 256;
        final int ivSize = 128;

        // Create empty key and iv
        byte[] key = new byte[keySize / 8];
        byte[] iv = new byte[ivSize / 8];

        // Create random salt
        byte[] saltBytes = generateSalt(8);

        // Derive key and iv from passphrase and salt
        EvpKDF(passphrase.getBytes(UTF_8), keySize, ivSize, saltBytes, key, iv);

        // Actual encrypt
        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
        cipher.init(Cipher.ENCRYPT_MODE, new SecretKeySpec(key, "AES"), new IvParameterSpec(iv));
        byte[] cipherBytes = cipher.doFinal(fileBytes);

        /**
         * Create CryptoJS-like encrypted string from encrypted data This is how
         * CryptoJS do: 1. Create new byte array to hold ecrypted string (b) 2.
         * Concatenate 8 bytes to b 3. Concatenate salt to b 4. Concatenate
         * encrypted data to b 5. Encode b using Base64
         */
        byte[] sBytes = "Salted__".getBytes(UTF_8);
        byte[] b = new byte[sBytes.length + saltBytes.length + cipherBytes.length];
        System.arraycopy(sBytes, 0, b, 0, sBytes.length);
        System.arraycopy(saltBytes, 0, b, sBytes.length, saltBytes.length);
        System.arraycopy(cipherBytes, 0, b, sBytes.length + saltBytes.length, cipherBytes.length);

        //byte[] base64b = Base64.encode(b, Base64.DEFAULT);
        byte[] base64b = Base64.getEncoder().encode(b);

        return base64b;
    }

    public static byte[] fileDecrypt(byte[] fileBytes, String passphrase) throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, InvalidAlgorithmParameterException, IllegalBlockSizeException, BadPaddingException {
        final int keySize = 256;
        final int ivSize = 128;

        // Decode from base64 text
        //byte[] ctBytes = Base64.decode(ciphertext.getBytes("UTF-8"), Base64.DEFAULT);
        byte[] ctBytes = Base64.getDecoder().decode(fileBytes);

        // Get salt
        byte[] saltBytes = Arrays.copyOfRange(ctBytes, 8, 16);

        // Get ciphertext
        byte[] ciphertextBytes = Arrays.copyOfRange(ctBytes, 16, ctBytes.length);

        // Get key and iv from passphrase and salt
        byte[] key = new byte[keySize / 8];
        byte[] iv = new byte[ivSize / 8];
        EvpKDF(passphrase.getBytes(UTF_8), keySize, ivSize, saltBytes, key, iv);

        // Actual decrypt
        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
        cipher.init(Cipher.DECRYPT_MODE, new SecretKeySpec(key, "AES"), new IvParameterSpec(iv));
        byte[] recoveredPlaintextBytes = cipher.doFinal(ciphertextBytes);

        return recoveredPlaintextBytes;
    }

    private static byte[] generateSalt(int length) {
        Random r = new SecureRandom();
        byte[] salt = new byte[length];
        r.nextBytes(salt);
        return salt;
    }

    private static byte[] EvpKDF(byte[] password, int keySize, int ivSize, byte[] salt, byte[] resultKey, byte[] resultIv) throws NoSuchAlgorithmException {
        return EvpKDF(password, keySize, ivSize, salt, 1, "MD5", resultKey, resultIv);
    }

    private static byte[] EvpKDF(byte[] password, int keySize, int ivSize, byte[] salt, int iterations, String hashAlgorithm, byte[] resultKey, byte[] resultIv) throws NoSuchAlgorithmException {
        keySize = keySize / 32;
        ivSize = ivSize / 32;
        int targetKeySize = keySize + ivSize;
        byte[] derivedBytes = new byte[targetKeySize * 4];
        int numberOfDerivedWords = 0;
        byte[] block = null;
        MessageDigest hasher = MessageDigest.getInstance(hashAlgorithm);
        while (numberOfDerivedWords < targetKeySize) {
            if (block != null) {
                hasher.update(block);
            }
            hasher.update(password);
            block = hasher.digest(salt);
            hasher.reset();

            // Iterations
            for (int i = 1; i < iterations; i++) {
                block = hasher.digest(block);
                hasher.reset();
            }

            System.arraycopy(block, 0, derivedBytes, numberOfDerivedWords * 4,
                    Math.min(block.length, (targetKeySize - numberOfDerivedWords) * 4));

            numberOfDerivedWords += block.length / 4;
        }

        System.arraycopy(derivedBytes, 0, resultKey, 0, keySize * 4);
        System.arraycopy(derivedBytes, keySize * 4, resultIv, 0, ivSize * 4);

        return derivedBytes; // key + iv
    }
}
