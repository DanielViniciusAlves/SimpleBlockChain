package org.blockchain;

import java.util.ArrayList;
import com.google.gson.GsonBuilder;
public class Main {
    public static ArrayList<Block> blockchain = new ArrayList<Block>();
    private static int difficulty = 5;

    public static void main(String[] args) {
        System.out.println("Starting blockchain");

        System.out.println("Starting block.");
        blockchain.add(new Block("First block", "0"));
        System.out.println("Mining");
        blockchain.get(0).mineBlock(difficulty);

        blockchain.add(new Block("Second Block",blockchain.get(blockchain.size()-1).hash));
        System.out.println("Mining");
        blockchain.get(1).mineBlock(difficulty);

        blockchain.add(new Block("Third blovk",blockchain.get(blockchain.size()-1).hash));
        System.out.println("Mining");
        blockchain.get(2).mineBlock(difficulty);

        System.out.println("\nBlockchain is Valid: " + isValid());

        String blockchainJson = new GsonBuilder().setPrettyPrinting().create().toJson(blockchain);
        System.out.println("\nThe block chain: ");
        System.out.println(blockchainJson);
    }

    public static boolean isValid(){
        Block currentBlock;
        Block previousBlock;

        String target = new String(new char[difficulty]).replace("\0", "0");
        for (int i=1; i < blockchain.size(); i++){
            currentBlock = blockchain.get(i);
            previousBlock = blockchain.get(i - 1);

            if(!currentBlock.hash.equals(currentBlock.calculateHash())){
                System.out.println("Invalid hash in current block.");
                return false;
            }

            if(!previousBlock.hash.equals(currentBlock.previousHash)){
                System.out.println("Invalid hash in previous block.");
                return false;
            }

            if(!currentBlock.hash.substring(0, difficulty).equals(target)){
                System.out.println("This block hasn't be mined.");
                return false;
            }
        }

        System.out.println("Valid hash.");
        return true;
    }
}