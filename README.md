# JAVA SPRING  SOLID-project
# Bank app
## Instruction

1) Open terminal. 

2) Enter "java -jar SolidBankApp.jar"

## Project Structure
    configs
        (c) MyConfig                                                / with beans /

    kz.jusan.solidbankapp
        +- account
            +- cli             
                (c) AccountBasicCLI
                (i) CreateAccountOperationUI
            +- creationservice                                      / creation service /
                (i) AccountCreationService
                (c) AccountCreationServiceImpl
            +- database                                             / all accounts /
                (i) AccountDAO
                (c) MemoryAccountDAO
            +- listingservice                                       / listing service /
                (i) AccountListingService
                (c) AccountListingServiceImpl
            +- types                                                / account types /
                (c) AccountDeposit  <- (c) FixedAccount
                (c) AccountWithdraw <- (c) CheckingAccount
                                    <- (c) SavingAccount
            (c) Account
            (c) AccountType
        
        +- bank                                                     / bank /
            (c) BankCore
        
        +- cli                                                      / read to entering /
            (i) CLIUI
            (c) MyCLI
        
        +- transaction
            +- cli
                (c) TransactionDepositCLI
                (c) TransactionWithdrawCLI
                (i) WithdrawDepositOperationCLIIU
            +- database                                             / all transactions /
                (i) TreansactionDAO
                (c) MemoryTransactionDAO
            +- deposit                                              / deposit operation /
                +- depositservice
                    (i) AccountDepositService
                    (c) AccountDepositServiceImpl
                (c) TransactionDeposit
            +- withdraw                                             / withdraw operation /
                +- withdrawservice
                    (i) AccountWithdrawService
                    (c) AccountWithdrawServiceImpl
                (c) TransactionWithdraw

        (c) SOLIDBankApp                                            / run here / 
            
                
    
    

## Operations
   
    "1 - show accounts"
   
    "2 - create account"
   
    "3 - deposit"
   
    "4 - withdraw"
   
    "5 - transactions"
   
    "6 - this message"
   
    "7 - exit"

## Example 
    Welcome to CLI Bank service
    Please enter operation number:
    1 - show accounts
    2 - create account
    3 - deposit
    4 - withdraw
    5 - transactions
    6 - this message
    7 - exit
    1
    next operation ...
    2
    Choose account type
    [CHECKING, SAVING, FIXED]
    SAVING
    Bank account created
    next operation ...
    2
    Choose account type
    [CHECKING, SAVING, FIXED]
    Fixed
    Not correct enter
    Choose account type
    [CHECKING, SAVING, FIXED]
    dsf
    Not correct enter
    Choose account type
    [CHECKING, SAVING, FIXED]
    FIXED
    Bank account created
    next operation ...
    2
    Choose account type
    [CHECKING, SAVING, FIXED]
    CHECKING
    Bank account created
    next operation ...
    1
    Account{SAVING, id = 001000001, clientID = 1, balance = 0.00}
    Account{FIXED, id = 001000002, clientID = 1, balance = 0.00}
    Account{CHECKING, id = 001000003, clientID = 1, balance = 0.00}
    next operation ...
    6
    1 - show accounts
    2 - create account
    3 - deposit
    4 - withdraw
    5 - transactions
    6 - this message
    7 - exit
    
    next operation ...
    3
    Type account ID
    001000001
    Type Amount of money
    10000
    10000.00$ transferred to 001000001 account
    next operation ...
    3
    Type account ID
    00100001
    Not found account
    next operation ...
    3
    Type account ID
    001000002
    Type Amount of money
    10000
    10000.00$ transferred to 001000002 account
    next operation ...
    3
    Type account ID
    001000003
    Type Amount of money
    sdf
    java.lang.NumberFormatException: For input string: "sdf"
    at java.base/jdk.internal.math.FloatingDecimal.readJavaFormatString(FloatingDecimal.java:2054)
    at java.base/jdk.internal.math.FloatingDecimal.parseDouble(FloatingDecimal.java:110)
    at java.base/java.lang.Double.parseDouble(Double.java:651)
    at kz.jusan.solidbankapp.cli.MyCLI.requestClientAmount(MyCLI.java:31)
    at kz.jusan.solidbankapp.transaction.cli.TransactionDepositCLI.depositMoney(TransactionDepositCLI.java:31)
    at SOLIDBankApp.main(SOLIDBankApp.java:47)
    illegal amount value
    next operation ...
    4
    Type account ID
    001000001
    Type Amount of money for withdraw
    100
    100.00$ transferred to 001000001 account
    next operation ...
    1
    Account{SAVING, id = 001000001, clientID = 1, balance = 9900.00}
    Account{FIXED, id = 001000002, clientID = 1, balance = 10000.00}
    Account{CHECKING, id = 001000003, clientID = 1, balance = 0.00}
    next operation ...
    4
    Type account ID
    001000002
    Not found account or withdraw not allowed with this account
    next operation ...
    4
    Type account ID
    001000003
    Type Amount of money for withdraw
    100
    java.lang.IllegalArgumentException
    at kz.jusan.solidbankapp.account.database.MemoryAccountDAO.updateAccount(MemoryAccountDAO.java:56)
    at kz.jusan.solidbankapp.transaction.withdraw.withdrawservice.AccountWithdrawServiceImpl.withdraw(AccountWithdrawServiceImpl.java:15)
    at kz.jusan.solidbankapp.transaction.withdraw.TransactionWithdraw.execute(TransactionWithdraw.java:24)
    at kz.jusan.solidbankapp.transaction.cli.TransactionWithdrawCLI.withdrawMoney(TransactionWithdrawCLI.java:38)
    at SOLIDBankApp.main(SOLIDBankApp.java:49)
    operation failed, please try again
    next operation ...
    5
    10000.00$ | from out to 001000001 | at 2022/05/12 13:43:40 | isTransferred = true
    10000.00$ | from out to 001000002 | at 2022/05/12 13:44:11 | isTransferred = true
    100.00$ | from out to 001000001 | at 2022/05/12 13:44:44 | isTransferred = true
    100.00$ | from out to 001000003 | at 2022/05/12 13:45:40 | isTransferred = false
    next operation ...
    7
    Application closed
    
    Process finished with exit code 0

    