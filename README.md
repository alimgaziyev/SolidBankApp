# JAVA SPRING  SOLID-project
# Bank app
## Instruction

1) Open terminal. 

2) Enter "java -jar SolidBankApp.jar"

## Project Structure
    kz.jusan.solidbankapp
        +- account
            +- cli
                (c) AccountBasicCLI
                (i) CreateAccountOperationUI
            +- creationservice
                (i) AccountCreationService
                (c) AccountCreationServiceImpl
            +- database
                (i) AccountDAO
                (c) MemoryAccountDAO
            +- listingservice
                (i) AccountListingService
                (c) AccountListingServiceImpl
            +- types
                (c) AccountDeposit  <- (c) FixedAccount
                (c) AccountWithdraw <- (c) CheckingAccount
                                    <- (c) SavingAccount
            (c) Account
            (c) AccountType
        
        +- bank
            (c) BankCore
        
        +- cli
            (i) CLIUI
            (c) MyCLI
        
        +- transaction
            +- cli
                Tra
            +- database
                (i) TreansactionDAO
                (c) MemoryTransactionDAO
            
                
    
    

## Operations
   
    "1 - show accounts"
   
    "2 - create account"
   
    "3 - deposit"
   
    "4 - withdraw"
   
    "5 - transfer"
   
    "6 - this message"
   
    "7 - exit"