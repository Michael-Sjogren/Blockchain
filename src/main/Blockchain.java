package main;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Blockchain {
	
	private List<Block> chain;
	
	public Blockchain() {
		chain = new ArrayList<>();
		chain.add(generateGenesisBlock());
	}

	private Block generateGenesisBlock() {
		
		final Block genBlock = new Block("0x200", new Date(),"<transactions>");
		genBlock.setPreviousHash(null);
		genBlock.ComputeHash();
		return genBlock;
	}
	
	public void addBlock(Block b) {
		Block newBlock = b;
		if(newBlock == null) {
			throw new NullPointerException("Block was null");
		}
		newBlock.setPreviousHash(chain.get(chain.size() -1).getHash());
		newBlock.ComputeHash();
		this.chain.add(newBlock);
	}
	
	public void PrintChain() {
		
		for (Block block : chain) {
			System.out.println("Block ID" + block.getId());
			System.out.println("Block Version " +block.getVersion());
			System.out.println("Prev Hash: " + block.getPreviousHash());
			System.out.println("Hash: " + block.getHash());
			System.out.println("timestamp: " + block.getTimestamp().getTime());
			System.out.println("______________________________________________");
		}
	}
	
	public Block getLatestBlock() {
		if(chain.isEmpty())
		{
			return null;
		}
		return chain.get(chain.size()-1);
	}
	
	public boolean IsBlockchainValid() {
		
		for (int i = chain.size()-1; i > 0; i--) {
			Block block = chain.get(i);
			Block prevBlock = chain.get(i-1);
			
			// checks if the computed hash is NOT the same as the existing hash
			if( !block.getHash().equals(block.ComputeHash()) ) {
				return false;
			}
			
			// if the previous hash does not match up with the computed previous hash returns false
			if(!block.getPreviousHash().equals(prevBlock.ComputeHash())) {
				return false;
			}
		}
		System.out.println("Chain is valid!");
		return true;
	}
}
