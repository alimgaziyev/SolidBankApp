CREATE TABLE Account
(
    account_id INTEGER  NOT NULL,
    bank_id INTEGER  NOT NULL,
    client_id INTEGER  NOT NULL,
    balance DOUBLE  NOT NULL,
    withdraw_allowed BOOLEAN NOT NULL
);

CREATE TABLE Transaction
(
    transaction_id INTEGER  NOT NULL,
    from_id NVARCHAR(40) NOT NULL,
    to_id NVARCHAR(40) NOT NULL,
    amount DOUBLE NOT NULL,
    transaction_date NVARCHAR(40)  NOT NULL,
    is_done BOOLEAN NOT NULL
);