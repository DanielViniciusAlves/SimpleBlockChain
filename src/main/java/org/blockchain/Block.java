package org.blockchain;

import org.blockchain.utils.StringUtil;

import java.security.SecureRandom;
import java.util.Date;

public class Block {
    private int nonce;
    private String hash;
    private final String previousHash;
    private final String data;
    private final long timestamp;

    public Block(String data, String previousHash){
       this.previousHash = previousHash;
       this.data = data;
       this.timestamp = new Date().getTime();
       this.hash = calculateHash();
    }

    public String calculateHash(){
        return StringUtil.addSha256( previousHash + timestamp + nonce + data );
    }

    public void generateNonce(){
        SecureRandom rand = new SecureRandom();
        nonce = Math.abs(rand.nextInt());
    }

    public String getHash() {
        return hash;
    }

    public void setHash(String hash) {
        this.hash = hash;
    }

    public String getPreviousHash() {
        return previousHash;
    }
}
