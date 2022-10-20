package com.loginmaintain.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.loginmaintain.model.EncryptDecryptData;
import com.loginmaintain.model.InputModel;
import com.loginmaintain.utils.GammaEncryption;

@CrossOrigin
@RestController
public class EncryptionController {

	@PostMapping("/gammaEncrypt")
	public EncryptDecryptData gammaEncryption(@RequestBody InputModel inputModel) {

		EncryptDecryptData encryptionModel = new EncryptDecryptData();
		try {

			if (null == inputModel.getSecret()
					|| (inputModel.getSecret() != null && inputModel.getSecret().isEmpty())) {

				encryptionModel.setStatus(false);
				encryptionModel.setErrMessage("Secret Cannot be Empty");
				return encryptionModel;
			}

			if (null == inputModel.getData() || (inputModel.getData() != null && inputModel.getData().isEmpty())) {

				encryptionModel.setStatus(false);
				encryptionModel.setErrMessage("Data to Encrypt Cannot be Empty");
				return encryptionModel;
			}

			String encryptedData = GammaEncryption.encryptUsingGamma(inputModel.getData(), inputModel.getSecret());

			encryptionModel.setData(encryptedData);
			encryptionModel.setStatus(true);

		} catch (Exception e) {

			encryptionModel.setStatus(false);
			encryptionModel.setErrMessage(e.getMessage());

		}

		return encryptionModel;
	}

	@PostMapping("/gammaDecrypt")
	public EncryptDecryptData gammaDecryption(@RequestBody InputModel inputModel) {

		EncryptDecryptData encryptionModel = new EncryptDecryptData();
		try {

			if (null == inputModel.getSecret()
					|| (inputModel.getSecret() != null && inputModel.getSecret().isEmpty())) {

				encryptionModel.setStatus(false);
				encryptionModel.setErrMessage("Secret Cannot be Empty");
				return encryptionModel;
			}

			if (null == inputModel.getData() || (inputModel.getData() != null && inputModel.getData().isEmpty())) {

				encryptionModel.setStatus(false);
				encryptionModel.setErrMessage("Data to Decrypt Cannot be Empty");
				return encryptionModel;
			}

			String decryptData = GammaEncryption.decryptUsingGamma(inputModel.getData(), inputModel.getSecret());

			encryptionModel.setData(decryptData);
			encryptionModel.setStatus(true);
			return encryptionModel;

		} catch (Exception e) {

			encryptionModel.setStatus(false);
			encryptionModel.setErrMessage(e.getMessage());
			return encryptionModel;
		}
	}

}
