package main;


import static org.junit.jupiter.api.Assertions.*;

import java.util.Date;

import org.junit.jupiter.api.Test;

class BlockchainTest {

	
	@Test
	void testAddBlock() {
		Blockchain blockchain = new Blockchain();
		Block block =  new Block("0x200" , new Date() , "<transaction>" );
		blockchain.addBlock(block);
		assert(blockchain.getLatestBlock().equals(block));
	}

	@Test
	void testGetLatestBlock() {
		Blockchain blockchain = new Blockchain();
		assertFalse(blockchain.getLatestBlock().equals(null));
		Block block =  new Block("0x200" , new Date() , "<transaction>" );
		blockchain.addBlock(block);
		assertTrue(blockchain.getLatestBlock().equals(block));
	}

	@Test
	void testIsBlockchainValid() {
		Blockchain blockchain = new Blockchain();
		Block gen = new Block("0x200", new Date(), "<transaction>");
		Block b1 = new Block("0x200", new Date(), "<transaction>");
		Block b2 = new Block("0x200", new Date(), "<transaction>");
		Block b3 = new Block("0x200", new Date(), "<transaction>");
		blockchain.addBlock(gen);
		blockchain.addBlock(b1);
		blockchain.addBlock(b2);
		blockchain.addBlock(b3);
		boolean isValid = blockchain.IsBlockchainValid();
		assertTrue(isValid);
		Block b4 = blockchain.getLatestBlock();
		b4.setHash("test");
		isValid = blockchain.IsBlockchainValid();
		assertFalse(isValid);
	}

}
