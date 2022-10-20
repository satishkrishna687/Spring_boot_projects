package com.controller.impl;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.Writer;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;

import com.routingtopology.value.PacketVO;




public class SimplePathUtilImpl  {

	private static final String TRIPLE_DES_CONSTANT = "DESede";
	private static final String SEQUENCE_NO1 = "1";
	private static final String SEQUENCE_NO2 = "2";
	private static final String SEQUENCE_NO3 = "3";
	private static final String SEQUENCE_NO4 = "4";

	public boolean checkNeigbourContainDestination(List<Integer> neigbours,
			int destinationNode) {

		boolean status = false;
		int indexNeigbour = 0;
		indexNeigbour = neigbours.size();
		for (int i = 0; i < indexNeigbour; i++) {
			int destListValue = neigbours.get(i);
			if (destListValue == destinationNode) {
				status = true;
				break;
			}
		}
		return status;
	}

	public int pickMinHopNeigbour(List<Integer> neigbours) {
		return neigbours.get((neigbours.size() - 1));
	}

	public int pickNeigbour(List<Integer> neigbours) {
		int index;
		int neigbourValue;
		Random randomInt = new Random();
		index = randomInt.nextInt(neigbours.size());
		neigbourValue = neigbours.get(index);
		return neigbourValue;
	}

	public List<Integer> returnNIRList(List<Integer> neigbourList,
			List<Integer> nirRouting) {
		List<Integer> similar = new ArrayList<Integer>(neigbourList);
		List<Integer> different = new ArrayList<Integer>();
		different.addAll(neigbourList);
		different.addAll(nirRouting);
		similar.retainAll(nirRouting);
		different.removeAll(similar);
		neigbourList.retainAll(different);
		return neigbourList;
	}

	public List<Integer> getLastHopNeigbourList(List<Integer> neigbbourList,
			List<Integer> lhnl) {
		List<Integer> similar = new ArrayList<Integer>();
		similar = new ArrayList<Integer>(neigbbourList);
		List<Integer> different = new ArrayList<Integer>();
		different.addAll(neigbbourList);
		different.addAll(lhnl);
		similar.retainAll(lhnl);
		different.removeAll(similar);
		neigbbourList.retainAll(different);
		return neigbbourList;
	}

	public int getPreviousNode(String routeUptilNow) {
	
		int previousNode=0;
		/*
		System.out.println("Route Uptil Now is"+routeUptilNow);
		int previousNode = 0;
		char routeUptilNowChar[];
		routeUptilNowChar = routeUptilNow.split("->").toString().toCharArray();
		System.out.println("After Spliting my route contains"+routeUptilNow);
		if (routeUptilNowChar.length == 1) {
			previousNode = Integer.parseInt(routeUptilNow);
			previousNode=0;
			
		} else {
			int index = routeUptilNowChar.length;
			char previousNodeChar = routeUptilNowChar[index - 1];
			String previousCharStr = Character.toString(previousNodeChar);
			System.out.println("character is"+previousCharStr);
			previousNode = Integer.parseInt(previousCharStr);
			System.out.println("Previous Node From Util"+previousNode);
		}*/
		String[] r2=routeUptilNow.split("-->");
		
		for(String r:r2)
		{
			System.out.println("Node Uptil Now Are:"+r);
		}
		int v1=r2.length;
		int v2=v1-2;
		if(v2<0)
		{
			previousNode=0;
		}
		if(v2>=0)
		{
			previousNode=Integer.parseInt(r2[v2]);
		}
		return previousNode;
	}
	
	
	

	/*
	 * This is the formula
	 * 
	 * C1=CLmax/CD+Lmax;
	 * 
	 * and
	 * 
	 * F1=D+(1/C)
	 * 
	 * 
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.multichannel.util.inter.MultiChannelUtilIF#calculateCapacity(java
	 * .lang.Integer, java.lang.Long, java.lang.Integer)
	 */

	public Double calculateCapacity(Integer dataLength, Long timeDelayTemp,
			Integer dataRate, Integer capacityBar) {

		int capacityNum = capacityBar * dataLength;
		int denom1Num = capacityBar * dataRate;
		int denom2Num = dataLength;
		Double capacityBarFor = (double) (capacityNum)
				/ (denom1Num + denom2Num);
		Double forCapacity = dataRate + (1 / capacityBarFor);
		return forCapacity;
	}

	public String decrypt(byte[] encryptionBytes, Key key, Cipher cipher) {
		String recovered =null;
		  try
		  {
		  cipher.init(Cipher.DECRYPT_MODE, key);
		  byte[] recoveredBytes =cipher.doFinal(encryptionBytes);
		  recovered =new String(recoveredBytes);
		  }
		  catch(Exception e)
		  {
			  	e.printStackTrace();
		  }
		  return recovered;
	}

	public String encripthData(String dataPayload, Key key, Cipher cipher) {
		return encrypt(dataPayload,key,cipher).toString();
	}

	public byte[] encrypt(String input, Key key, Cipher cipher) {
		byte[] encriptedBytes=null;
		byte[] inputBytes=null;
		 try
		 {
			 cipher.init(Cipher.ENCRYPT_MODE, key);
			 inputBytes = input.getBytes();
			 encriptedBytes=cipher.doFinal(inputBytes);
		} 
		 catch (Exception e)
		{
			e.printStackTrace();
		}
		 return encriptedBytes;
	}

	
	public List<String> getDecriptedDataPayloads(
			List<String> dataPacketsWithEncription) {
		List<String> decriptedDataPackets=new ArrayList<String>();
		for(int i=0;i<dataPacketsWithEncription.size();i++)
		{
			decriptedDataPackets.add(decrypt(dataPacketsWithEncription.get(i).getBytes(), setUpKey(TRIPLE_DES_CONSTANT),setUpCipher(TRIPLE_DES_CONSTANT)));
		}
		return decriptedDataPackets;	
	}

	
	public List<String> getEncriptedDataPayloads(
			List<String> dataPacketsWithoutEncription) {
		List<String> encriptedDataPackets=new ArrayList<String>();
		for(int i=0;i<dataPacketsWithoutEncription.size();i++)
		{
			encriptedDataPackets.add(encripthData(dataPacketsWithoutEncription.get(i), setUpKey(TRIPLE_DES_CONSTANT),setUpCipher(TRIPLE_DES_CONSTANT)));
		}
		return encriptedDataPackets;
	}

	public List<String> getPacketDataPayLoad(String totalDataPayload) {
		List<String> listPackets = new ArrayList<String>();
		/* getting the sizes of individual string s to form total string */
		int sizeDataPayload = totalDataPayload.length();
		int size1 = 0;
		int size2 = sizeDataPayload / 4;
		int size3 = sizeDataPayload / 3;
		int size4 = sizeDataPayload / 2;
		int size5 = sizeDataPayload;
		/* converting the String into an array to divide the data */
		char totalData[] = totalDataPayload.toCharArray();
		/* process for packet1 data extraction */
		String packet1 = "";
		for (int i = size1; i <= size2 - 1; i++) {
			packet1 = packet1 + totalData[i];
		}
		listPackets.add(packet1);
		/* process for packet2 data extraction */
		String packet2 = "";
		for (int i = size2; i <= size3 - 1; i++) {
			packet2 = packet2 + totalData[i];
		}
		listPackets.add(packet2);
		/* process for packet3 data extraction */
		String packet3 = "";
		for (int i = size3; i <= size4 - 1; i++) {
			packet3 = packet3 + totalData[i];
		}
		listPackets.add(packet3);
		/* process for packet4 data extraction */
		String packet4 = "";
		for (int i = size4; i < size5; i++) {
			packet4 = packet4 + totalData[i];
		}
		listPackets.add(packet4);
		return listPackets;
	}

	public List<String> packetFormation(String sourceId, String destinationId,
			String dataPayLoad, String sequenceNo) {
		// TODO Auto-generated method stub
		return null;
	}

	public Cipher setUpCipher(String algorithm) {
		Cipher cipher=null;
		 try {
			 cipher= Cipher.getInstance(algorithm);
		} catch (Exception e) {
			System.out.println("This is the Exception:"+e);
			e.printStackTrace();
		}
		return cipher;
	}

	public Key setUpKey(String algorithm) {
		Key key=null;
		 try {
			key= KeyGenerator.getInstance(algorithm).generateKey();
		} catch (NoSuchAlgorithmException e) {
			System.out.println("NoSuchException"+e);
			e.printStackTrace();
		}
		return key;
	}

	public List<String> getPacketData(String sourceId, String destinationId,
			String packetData, String sequenceNumber) {
		List<String> packet =new ArrayList<String>();
		packet.add(sourceId);
		packet.add(destinationId);
		packet.add(packetData);
		packet.add(sequenceNumber);
		return packet;
	}

	public boolean writePacketData(List packetData,String path) {
		
		boolean writingPacket=false;
		
		try
    	{
      		Writer output = null;
       		String frame="";
    		for(int i=0;i<packetData.size();i++)
    		{
    			frame=frame+packetData.get(i);
    		}
    		File file = new File(path);
    		output = new BufferedWriter(new FileWriter(file));
    		output.write(frame);
    		output.close();
    		writingPacket=true;
       	}
    	catch(Exception e)
    	{
    		writingPacket=false;
    		e.printStackTrace();
    	}
    	
    	return writingPacket;
	}

	public List<String> frameFormation(String sourceId, String destinationId,
			String dataPayLoad) {
	
		List<String> frame=new ArrayList<String>();
		frame.add(sourceId);
		frame.add(dataPayLoad);
		frame.add(destinationId);
		return frame;
		
	}
	

	public PacketVO getPacketFormationOutput(String dataPayload,
			String sourceId, String destinationId) {

		PacketVO packetVO = new PacketVO();


		// obtaning the data fragments
		List<String> dataFragments = getPacketDataPayLoad(dataPayload);

		// setting the data packets
		packetVO.setDataFragments(dataFragments);

		// obtaining the packets to be formed and storing in packetvo
		packetVO.setPacket1(getPacketData(sourceId,
				destinationId, dataFragments.get(0),
				SEQUENCE_NO1));
		packetVO.setPacket2(getPacketData(sourceId,
				destinationId, dataFragments.get(1),
				SEQUENCE_NO2));
		packetVO.setPacket3(getPacketData(sourceId,
				destinationId, dataFragments.get(2),
				SEQUENCE_NO3));
		packetVO.setPacket4(getPacketData(sourceId,
				destinationId, dataFragments.get(3),
				SEQUENCE_NO4));

		// obtaining the encripted data fragments

		Key key = setUpKey(TRIPLE_DES_CONSTANT);

		Cipher cipher = setUpCipher(TRIPLE_DES_CONSTANT);

		// doing encription of data fragment 1

		String encriptedData1 = encripthData(dataFragments
				.get(0), key, cipher);

		// doing encription of data fragment 2

		String encriptedData2 = encripthData(dataFragments
				.get(1), key, cipher);

		// doing encription of data fragment 3

		String encriptedData3 = encripthData(dataFragments
				.get(2), key, cipher);

		// doing encription of data fragment 4

		String encriptedData4 = encripthData(dataFragments
				.get(3), key, cipher);

		// adding it to list

		List<String> encriptedDataList = new ArrayList<String>();

		encriptedDataList.add(encriptedData1);

		encriptedDataList.add(encriptedData2);

		encriptedDataList.add(encriptedData3);

		encriptedDataList.add(encriptedData4);

		// storing the encrypted data list

		packetVO.setEncriptedDataFragments(encriptedDataList);

		// Forming the packets using encription

		// obtaning the data packet1
		List<String> dataPacket1 = getPacketData(sourceId, destinationId, encriptedData1,
						SEQUENCE_NO1);

		// obtaning the data packet2
		List<String> dataPacket2 = 
				getPacketData(sourceId, destinationId, encriptedData2,
						SEQUENCE_NO2);

		// obtaning the data packet1
		List<String> dataPacket3 = 
				getPacketData(sourceId, destinationId, encriptedData3,
						SEQUENCE_NO3);

		// obtaning the data packet2
		List<String> dataPacket4 = 
				getPacketData(sourceId, destinationId, encriptedData4,
						SEQUENCE_NO4);

		// storing the data packets

		packetVO.setPacket1Encripted(dataPacket1);

		packetVO.setPacket2Encripted(dataPacket2);

		packetVO.setPacket3Encripted(dataPacket3);

		packetVO.setPacket4Encripted(dataPacket4);

		// doing description of data fragment 1

		// String decripthData1 = multiChannelUtilIF.decrypt(encriptedData1
		// .getBytes(), key, cipher);

		String decripthData1 = dataFragments.get(0);
		// decryptData(dataFragments.get(0),key,cipher);

		// doing description of data fragment 2

		String decripthData2 = dataFragments.get(1);

		// multiChannelUtilIF.decrypt(encriptedData2
		// .getBytes(), key, cipher);

		// doing description of data fragment 3

		String decripthData3 = dataFragments.get(2);
		// multiChannelUtilIF.decrypt(encriptedData3

		// .getBytes(), key, cipher);

		// doing description of data fragment 4

		String decripthData4 = dataFragments.get(3);
		// multiChannelUtilIF.decrypt(encriptedData4
		// .getBytes(), key, cipher);

		// adding the decripted data fragments

		List<String> decriptedDataList = new ArrayList<String>();

		decriptedDataList.add(decripthData1);

		decriptedDataList.add(decripthData2);

		decriptedDataList.add(decripthData3);

		decriptedDataList.add(decripthData4);

		// storing the decripted data fragments

		packetVO.setDecriptedDataFragments(decriptedDataList);

		// Forming the packets using decription

		// obtaning the data packet1
		List<String> decripthPacket1 = getPacketData(
				sourceId, destinationId, encriptedData1,
				SEQUENCE_NO1);

		// obtaning the data packet2
		List<String> decripthPacket2 = getPacketData(
				sourceId, destinationId, encriptedData2,
				SEQUENCE_NO2);

		// obtaning the data packet1
		List<String> decripthPacket3 = getPacketData(
				sourceId, destinationId, encriptedData3,
				SEQUENCE_NO3);

		// obtaning the data packet2
		List<String> decripthPacket4 = getPacketData(
				sourceId, destinationId, encriptedData4,
				SEQUENCE_NO4);

		packetVO.setPacket1Decripted(decripthPacket1);

		packetVO.setPacket2Decripted(decripthPacket2);

		packetVO.setPacket3Decripted(decripthPacket3);

		packetVO.setPacket4Decripted(decripthPacket4);

		return packetVO;
	}

	
	
	

}
