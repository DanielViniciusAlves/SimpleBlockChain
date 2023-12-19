package org.blockchain;

import java.util.ArrayList;

public class Validate {

    public void mineBlock(int difficulty, Block block){
        // Creating string with 0 with size equals to difficulty
        String difficultyString = new String(new char[difficulty]).replace('\0', '0');

        while(!block.getHash().substring(0, difficulty).equals(difficultyString)){
            block.generateNonce();
            block.setHash(block.calculateHash());
        }
        System.out.println("Block mined.");
    }

    public static boolean isValid(ArrayList<Block> blockchain, int difficulty){
        Block currentBlock;
        Block previousBlock;

        String target = new String(new char[difficulty]).replace("\0", "0");
        for (int i=1; i < blockchain.size(); i++){
            currentBlock = blockchain.get(i);
            previousBlock = blockchain.get(i - 1);

            if(!currentBlock.getHash().equals(currentBlock.calculateHash())){
                System.out.println("Invalid hash in current block.");
                return false;
            }

            if(!previousBlock.getHash().equals(currentBlock.getPreviousHash())){
                System.out.println("Invalid hash in previous block.");
                return false;
            }

            if(!currentBlock.getHash().substring(0, difficulty).equals(target)){
                System.out.println("This block hasn't be mined.");
                return false;
            }
        }

        System.out.println("Valid hash.");
        return true;
    }

}
