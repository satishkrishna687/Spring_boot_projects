package com.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.dropsapppro.model.EncryptDecryptData;
import com.dropsapppro.model.InputModel;
import com.model.messages.Messages;

@Service
public class GammaEncryption {

	@Autowired
	private RestTemplate restTemplate;

	public String encryptUsingGamma(String strToEncrypt, String secret) {
		try {

			return encryptUsingGammaRemote(strToEncrypt, secret);
		} catch (Exception e) {
			System.out.println("Error while encrypting: " + e.toString());
		}
		return null;
	}

	public String encryptUsingGammaRemote(String strToEncrypt, String secret) {
		InputModel inputModel = new InputModel();
		inputModel.setData(strToEncrypt);
		inputModel.setSecret(secret);

		HttpEntity<InputModel> request1 = new HttpEntity<>(inputModel);
		ResponseEntity<EncryptDecryptData> response = restTemplate.exchange(
				Messages.EndPoints.GAMMA_ENCRYPTION_ENDPOINT, HttpMethod.POST, request1, EncryptDecryptData.class);

		EncryptDecryptData encryptDecryptData = response.getBody();

		String encryptedAndComparessedFilecContents = encryptDecryptData.getData();

		return encryptedAndComparessedFilecContents;
	}

}