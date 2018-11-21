package main;

import java.util.Date;

public class Main {

	public static void main(String[] args) {
		Blockchain tcpCoin = new Blockchain();
		String version = "0x200";
		Block a = new Block(version, new Date(), "<transactions>");
		Block b = new Block(version, new Date(), "<transactions>");
		Block c = new Block(version, new Date(), "<transactions>");
		
		tcpCoin.addBlock(a);
		tcpCoin.addBlock(b);
		tcpCoin.addBlock(c);
		
		if(!tcpCoin.IsBlockchainValid()) {
			System.out.println("Blockchain is invalid");
		}
		
		tcpCoin.getLatestBlock().setHash("avasdsafasgfa");
		tcpCoin.PrintChain();
	}

}
