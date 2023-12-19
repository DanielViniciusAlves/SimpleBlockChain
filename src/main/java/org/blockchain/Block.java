package org.blockchain;

import org.blockchain.utils.StringUtil;

import java.util.Date;

public class Block {
    public String previousHash;
    public String hash;
    private String data;
    private long timestamp;
    private int nonce;

    public Block(String data, String previousHash){
       this.previousHash = previousHash;
       this.hash = hash;
       this.data = data;
       this.timestamp = new Date().getTime();

       this.hash = generateHash();
    }

    public String generateHash(){
        String newHash = StringUtil.addSha256(
                this.hash + this.data + Long.toString(this.timestamp)
        );

        return newHash;
    }

    public String calculateHash(){
        String hash = previousHash + Long.toString(timestamp) + Integer.toString(nonce) + data;
        return StringUtil.addSha256(hash);
    }

    public void mineBlock(int difficulty){
        // Creating string with 0 with size equals to difficulty
        String difficultyString = new String(new char[difficulty]).replace('\0', '0');

        while(!hash.substring(0, difficulty).equals(difficultyString)){
            nonce++;
            hash =  calculateHash();
        }
        System.out.println("Block mined.");
    }

}
