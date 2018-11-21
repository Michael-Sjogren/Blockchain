package main;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;
import java.util.Date;
import java.util.UUID;


public class Block {

	private String version;
	private Date timestamp;
	private String hash;
	private String previousHash;
	private String data;
	private String id = UUID.randomUUID().toString();
	
	public Block(String version, Date timestamp , String data) {
		this.version = version;
		this.timestamp = timestamp;
		this.data = data;
		this.hash = ComputeHash();
	}

	public String ComputeHash() {
		StringBuilder dataToHash = new StringBuilder();
		dataToHash.append(this.version);
		dataToHash.append(this.timestamp);
		dataToHash.append(this.previousHash);
		dataToHash.append(this.data);
		MessageDigest digest;
		String encodedData = null;
		try {
			digest = MessageDigest.getInstance("SHA-256");
			byte[] hash = digest.digest(dataToHash.toString().getBytes(StandardCharsets.UTF_8));
			encodedData = Base64.getEncoder().encodeToString(hash); 
		}
		catch(NoSuchAlgorithmException e) 
		{
			e.printStackTrace();
		}
		this.hash = encodedData;
		return encodedData;
	}

	public String getVersion() {
		return version;
	}

	public Date getTimestamp() {
		return timestamp;
	}

	public String getHash() {
		return hash;
	}

	public String getPreviousHash() {
		return previousHash;
	}

	public String getData() {
		return data;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	public void setHash(String hash) {
		this.hash = hash;
	}

	public void setPreviousHash(String previousHash) {
		this.previousHash = previousHash;
	}

	public void setData(String data) {
		this.data = data;
	}

	public String getId() {
		return id;
	}
	
}
