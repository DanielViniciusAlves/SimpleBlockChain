package org.blockchain;

import java.util.ArrayList;
import com.google.gson.GsonBuilder;

public class Blockchain {
    private static ArrayList<Block> blockchain;
    private final int difficulty;
    private final Validate validate;

    public Blockchain(int difficulty){
        this.validate = new Validate();
        this.difficulty = difficulty;
        blockchain = new ArrayList<>();

        initializeBlockchain();
    }

    private void initializeBlockchain() {
        Block initialBlock = new Block("Initial Block", "0");
        validate.mineBlock(difficulty, initialBlock);
        blockchain.add(initialBlock);
    }

    public void addBlock(String data){
        Block block = new Block(data, blockchain.getLast().getHash());
        blockchain.add(block);

        validate.mineBlock(difficulty, block);

        boolean isValid = Validate.isValid(blockchain, difficulty);
        if(!isValid)
            blockchain.removeLast();

        System.out.println("Is block valid: " + isValid);
        display();
    }

    public void display(){
        String blockchainJson = new GsonBuilder().setPrettyPrinting().create().toJson(blockchain);
        System.out.println("\nThe block chain: ");
        System.out.println(blockchainJson);
    }

}
