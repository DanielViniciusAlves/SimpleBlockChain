# Simple BlockChain

This is a simple implementation of a blockchain based in [this](https://medium.com/programmers-blockchain/create-simple-blockchain-java-tutorial-from-scratch-6eeed3cb03fa) article.

## Project version: Java 21 with Maeven

## How to use the program?

1. Select Difficulty
- Choose the desired difficulty level for the blockchain. Difficulty represents the number of leading zeros in the hash.
2. Enter Data (Option 1)
- Enter the data you want to include in the new block.
3. Print JSON (Option 2)
- Optionally, print the blockchain to view the stored data.
4. Result
- A JSON representation of the blockchain will be printed, showing the blocks and their respective details.
  
## How the program works?

1. Blockchain Initialization:
   - The user defines the blockchain difficulty, determining the number of leading zeros required in the hash.
   - The blockchain is initialized, creating the genesis block. This block is mined to generate a valid hash that meets the user-defined difficulty.

2. Adding Blocks:
   - Users input data they wish to add to the blockchain.
   - A new block is generated, mined, and validated. Validation checks include verifying all hashes in the blockchain against the new block and ensuring the new hash meets the defined difficulty.

### Detailed explanation:

At the start, the user will define the difficulty of the blockchain, which essentially represents the number of leading zeros at the beginning of the hash. Subsequently, the blockchain is initialized, creating the genesis block. This block is mined to generate a valid hash with the difficulty specified by the user. Following this, the user inputs the data they wish to add to the blockchain. A new block is generated, mined, and then validated. The validation process checks whether all hashes in the blockchain are valid with the inclusion of the new block and if the new hash meets the predetermined difficulty level.

## Why I made this?

Just for fun

## Is this actually useful?

No, but I learned a bit about blockchain, so that's a win, right?
