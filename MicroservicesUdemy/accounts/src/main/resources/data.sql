-- DROP TABLE IF EXISTS "CUSTOMER";
-- DROP TABLE IF EXISTS "ACCOUNTS";


CREATE TABLE "CUSTOMER" (
    "CUSTOMER_ID" int AUTO_INCREMENT PRIMARY KEY,
    "NAME" varchar(100) NOT NULL,
    "EMAIL" varchar(100) NOT NULL,
    "MOBILE_NUMBER" varchar(20) NOT NULL,
    "CREATED_AT" date NOT NULL,
    "CREATED_BY" varchar(20) NOT NULL,
    "UPDATED_AT" date DEFAULT NULL,
    "UPDATED_BY" varchar(20) DEFAULT NULL
);

CREATE TABLE "ACCOUNTS" (
   "CUSTOMER_ID" int NOT NULL,
   "ACCOUNT_NUMBER" int AUTO_INCREMENT PRIMARY KEY,
   "ACCOUNT_TYPE" varchar(100) NOT NULL,
   "BRANCH_ADDRESS" varchar(200) NOT NULL,
   "CREATED_AT" date NOT NULL,
   "CREATED_BY" varchar(20) NOT NULL,
   "UPDATED_AT" date DEFAULT NULL,
   "UPDATED_BY" varchar(20) DEFAULT NULL
);

-- insert into CUSTOMER ("customer_id", "name","email","mobile_number") VALUES(1,'cristi','email@email.com', '12345678')
-- insert into Accounts ("customer_id", "account_number","account_type","branch_address") VALUES(1,'12345678','accounttype', 'address address')

-- insert into CUSTOMER ("CUSTOMER_ID", "NAME","EMAIL","MOBILE_NUMBER") VALUES(1,'cristi','email@email.com', '12345678')
-- insert into Accounts ("CUSTOMER_ID", "ACCOUNT_NUMBER","ACCOUNT_TYPE","BRANCH_ADDRESS") VALUES(1,'12345678','accounttype', 'address address')