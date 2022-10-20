package com.dropsapppro.services;

import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.KeyGenerator;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;

import com.model.EncDataVO;

public class DESEncryptionService {

	public static EncDataVO encypt(String data) {
		
		EncDataVO encDataVO = new EncDataVO();

		String encypttedData = "";
		try {

			KeyGenerator keygenerator = KeyGenerator.getInstance("DES");
			SecretKey myDesKey = keygenerator.generateKey();

			Cipher desCipher;

			// Create the cipher
			desCipher = Cipher.getInstance("DES/ECB/PKCS5Padding");

			// Initialize the cipher for encryption
			desCipher.init(Cipher.ENCRYPT_MODE, myDesKey);

			// sensitive information
			byte[] text = data.getBytes();
			
			encDataVO.setSecretKey(text.toString());

			// Encrypt the text
			byte[] textEncrypted = desCipher.doFinal(text);

			encypttedData = textEncrypted.toString();

			
			encDataVO.setEncrypt(encypttedData);

		
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		} catch (NoSuchPaddingException e) {
			e.printStackTrace();
		} catch (InvalidKeyException e) {
			e.printStackTrace();
		} catch (IllegalBlockSizeException e) {
			e.printStackTrace();
		} catch (BadPaddingException e) {
			e.printStackTrace();
		}

		return encDataVO;

	}

	public static String decyption(String encEncrypt) {

		String descryptData = "";
		try {

			KeyGenerator keygenerator = KeyGenerator.getInstance("DES");
			SecretKey myDesKey = keygenerator.generateKey();

			Cipher desCipher;

			// Create the cipher
			desCipher = Cipher.getInstance("DES/ECB/PKCS5Padding");

			// Initialize the same cipher for decryption
			desCipher.init(Cipher.DECRYPT_MODE, myDesKey);

			// Decrypt the text
			byte[] textDecrypted = desCipher.doFinal(encEncrypt.getBytes());

			descryptData = textDecrypted.toString();

		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		} catch (NoSuchPaddingException e) {
			e.printStackTrace();
		} catch (InvalidKeyException e) {
			e.printStackTrace();
		} catch (IllegalBlockSizeException e) {
			e.printStackTrace();
		} catch (BadPaddingException e) {
			e.printStackTrace();
		}

		return descryptData;

	}

}
