--------------------------------------------------------
--  File created - Monday-March-28-2016   
--------------------------------------------------------
DROP TABLE "WEBBANK"."USERS" cascade constraints;
DROP TABLE "WEBBANK"."OPERATIONS" cascade constraints;
DROP TABLE "WEBBANK"."ACCOUNTS" cascade constraints;
DROP TABLE "WEBBANK"."DEMO_USERS" cascade constraints;
DROP SYNONYM "PUBLIC"."DBMS_OBFUSCATION_TOOLKIT";
DROP SYNONYM "PUBLIC"."UTL_RAW";
DROP SEQUENCE "WEBBANK"."DEMO_CUST_SEQ";
DROP SEQUENCE "WEBBANK"."DEMO_ORDER_ITEMS_SEQ";
DROP SEQUENCE "WEBBANK"."DEMO_ORD_SEQ";
DROP SEQUENCE "WEBBANK"."DEMO_PROD_SEQ";
DROP SEQUENCE "WEBBANK"."DEMO_USERS_SEQ";
DROP FUNCTION "WEBBANK"."CUSTOM_AUTH";
DROP FUNCTION "WEBBANK"."CUSTOM_HASH";
--------------------------------------------------------
--  DDL for Sequence DEMO_CUST_SEQ
--------------------------------------------------------

   CREATE SEQUENCE  "WEBBANK"."DEMO_CUST_SEQ"  MINVALUE 1 MAXVALUE 9999999999999999999999999999 INCREMENT BY 1 START WITH 21 CACHE 20 NOORDER  NOCYCLE ;
--------------------------------------------------------
--  DDL for Sequence DEMO_ORDER_ITEMS_SEQ
--------------------------------------------------------

   CREATE SEQUENCE  "WEBBANK"."DEMO_ORDER_ITEMS_SEQ"  MINVALUE 1 MAXVALUE 9999999999999999999999999999 INCREMENT BY 1 START WITH 61 CACHE 20 NOORDER  NOCYCLE ;
--------------------------------------------------------
--  DDL for Sequence DEMO_ORD_SEQ
--------------------------------------------------------

   CREATE SEQUENCE  "WEBBANK"."DEMO_ORD_SEQ"  MINVALUE 1 MAXVALUE 9999999999999999999999999999 INCREMENT BY 1 START WITH 11 CACHE 20 NOORDER  NOCYCLE ;
--------------------------------------------------------
--  DDL for Sequence DEMO_PROD_SEQ
--------------------------------------------------------

   CREATE SEQUENCE  "WEBBANK"."DEMO_PROD_SEQ"  MINVALUE 1 MAXVALUE 9999999999999999999999999999 INCREMENT BY 1 START WITH 21 CACHE 20 NOORDER  NOCYCLE ;
--------------------------------------------------------
--  DDL for Sequence DEMO_USERS_SEQ
--------------------------------------------------------

   CREATE SEQUENCE  "WEBBANK"."DEMO_USERS_SEQ"  MINVALUE 1 MAXVALUE 9999999999999999999999999999 INCREMENT BY 1 START WITH 21 CACHE 20 NOORDER  NOCYCLE ;
--------------------------------------------------------
--  DDL for Table USERS
--------------------------------------------------------

  CREATE TABLE "WEBBANK"."USERS" 
   (	"ID" NUMBER, 
	"USERNAME" VARCHAR2(20 BYTE), 
	"PASSWORD" VARCHAR2(50 BYTE), 
	"ROLE" VARCHAR2(20 BYTE)
   ) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "APEX_4780431536990897" ;
--------------------------------------------------------
--  DDL for Table OPERATIONS
--------------------------------------------------------

  CREATE TABLE "WEBBANK"."OPERATIONS" 
   (	"ID" NUMBER, 
	"ACCOUNT_NUMBER" NUMBER, 
	"OPERATION" VARCHAR2(20 BYTE), 
	"AMOUNT" NUMBER, 
	"CURRENCY" VARCHAR2(3 BYTE), 
	"PERFORMED_BY" NUMBER
   ) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "APEX_4780431536990897" ;
--------------------------------------------------------
--  DDL for Table ACCOUNTS
--------------------------------------------------------

  CREATE TABLE "WEBBANK"."ACCOUNTS" 
   (	"ID" NUMBER, 
	"ACCOUNT_NUMBER" VARCHAR2(20 BYTE), 
	"USERNAME" NUMBER, 
	"AMOUNT" NUMBER, 
	"CURRENCY" VARCHAR2(3 BYTE), 
	"CREATED_BY" NUMBER
   ) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "APEX_4780431536990897" ;
--------------------------------------------------------
--  DDL for Table DEMO_USERS
--------------------------------------------------------

  CREATE TABLE "WEBBANK"."DEMO_USERS" 
   (	"USER_ID" NUMBER, 
	"USER_NAME" VARCHAR2(100 BYTE), 
	"PASSWORD" VARCHAR2(4000 BYTE), 
	"CREATED_ON" DATE, 
	"QUOTA" NUMBER, 
	"PRODUCTS" CHAR(1 BYTE), 
	"EXPIRES_ON" DATE, 
	"ADMIN_USER" CHAR(1 BYTE)
   ) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "APEX_4780431536990897" ;
REM INSERTING into WEBBANK.USERS
SET DEFINE OFF;
Insert into WEBBANK.USERS (ID,USERNAME,PASSWORD,ROLE) values (1,'admin','c4ca4238a0b923820dcc509a6f75849b','ROLE_BANK_EMPLOYEE');
Insert into WEBBANK.USERS (ID,USERNAME,PASSWORD,ROLE) values (2,'user','c20ad4d76fe97759aa27a0c99bff6710','ROLE_USER');
Insert into WEBBANK.USERS (ID,USERNAME,PASSWORD,ROLE) values (3,'user02','c20ad4d76fe97759aa27a0c99bff6710','ROLE_USER');
REM INSERTING into WEBBANK.OPERATIONS
SET DEFINE OFF;
Insert into WEBBANK.OPERATIONS (ID,ACCOUNT_NUMBER,OPERATION,AMOUNT,CURRENCY,PERFORMED_BY) values (6,4,'withdraw',1000,'EUR',3);
Insert into WEBBANK.OPERATIONS (ID,ACCOUNT_NUMBER,OPERATION,AMOUNT,CURRENCY,PERFORMED_BY) values (8,6,'withdraw',1,'BGN',1);
Insert into WEBBANK.OPERATIONS (ID,ACCOUNT_NUMBER,OPERATION,AMOUNT,CURRENCY,PERFORMED_BY) values (10,7,'withdraw',2,'EUR',3);
Insert into WEBBANK.OPERATIONS (ID,ACCOUNT_NUMBER,OPERATION,AMOUNT,CURRENCY,PERFORMED_BY) values (7,6,'deposit',987.65,'BGN',1);
Insert into WEBBANK.OPERATIONS (ID,ACCOUNT_NUMBER,OPERATION,AMOUNT,CURRENCY,PERFORMED_BY) values (1,1,'deposit',50,'EUR',2);
Insert into WEBBANK.OPERATIONS (ID,ACCOUNT_NUMBER,OPERATION,AMOUNT,CURRENCY,PERFORMED_BY) values (2,1,'withdraw',50,'USD',2);
Insert into WEBBANK.OPERATIONS (ID,ACCOUNT_NUMBER,OPERATION,AMOUNT,CURRENCY,PERFORMED_BY) values (3,2,'deposit',10,'USD',1);
Insert into WEBBANK.OPERATIONS (ID,ACCOUNT_NUMBER,OPERATION,AMOUNT,CURRENCY,PERFORMED_BY) values (4,2,'withdraw',10,'EUR',3);
Insert into WEBBANK.OPERATIONS (ID,ACCOUNT_NUMBER,OPERATION,AMOUNT,CURRENCY,PERFORMED_BY) values (5,1,'deposit',1000000.99,'BGN',1);
Insert into WEBBANK.OPERATIONS (ID,ACCOUNT_NUMBER,OPERATION,AMOUNT,CURRENCY,PERFORMED_BY) values (9,7,'deposit',12.34,'EUR',1);
REM INSERTING into WEBBANK.ACCOUNTS
SET DEFINE OFF;
Insert into WEBBANK.ACCOUNTS (ID,ACCOUNT_NUMBER,USERNAME,AMOUNT,CURRENCY,CREATED_BY) values (5,'10aq',3,1234.56,'USD',1);
Insert into WEBBANK.ACCOUNTS (ID,ACCOUNT_NUMBER,USERNAME,AMOUNT,CURRENCY,CREATED_BY) values (6,'1029az',2,986.65,'BGN',1);
Insert into WEBBANK.ACCOUNTS (ID,ACCOUNT_NUMBER,USERNAME,AMOUNT,CURRENCY,CREATED_BY) values (7,'01acc',3,10.34,'EUR',1);
Insert into WEBBANK.ACCOUNTS (ID,ACCOUNT_NUMBER,USERNAME,AMOUNT,CURRENCY,CREATED_BY) values (4,'12',3,1431.11,'EUR',1);
Insert into WEBBANK.ACCOUNTS (ID,ACCOUNT_NUMBER,USERNAME,AMOUNT,CURRENCY,CREATED_BY) values (1,'123a',2,1000202.99,'BGN',1);
Insert into WEBBANK.ACCOUNTS (ID,ACCOUNT_NUMBER,USERNAME,AMOUNT,CURRENCY,CREATED_BY) values (2,'aw1',3,1101.02,'USD',1);
Insert into WEBBANK.ACCOUNTS (ID,ACCOUNT_NUMBER,USERNAME,AMOUNT,CURRENCY,CREATED_BY) values (3,'abc',2,1000,'BGN',1);
--------------------------------------------------------
--  DDL for Index USERS_PK
--------------------------------------------------------

  CREATE UNIQUE INDEX "WEBBANK"."USERS_PK" ON "WEBBANK"."USERS" ("ID") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "APEX_4780431536990897" ;
--------------------------------------------------------
--  DDL for Index OPERATIONS_PK
--------------------------------------------------------

  CREATE UNIQUE INDEX "WEBBANK"."OPERATIONS_PK" ON "WEBBANK"."OPERATIONS" ("ID") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "APEX_4780431536990897" ;
--------------------------------------------------------
--  DDL for Index ACCOUNTS_PK
--------------------------------------------------------

  CREATE UNIQUE INDEX "WEBBANK"."ACCOUNTS_PK" ON "WEBBANK"."ACCOUNTS" ("ID") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "APEX_4780431536990897" ;
--------------------------------------------------------
--  Constraints for Table USERS
--------------------------------------------------------

  ALTER TABLE "WEBBANK"."USERS" ADD CONSTRAINT "USERS_PK" PRIMARY KEY ("ID")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "APEX_4780431536990897"  ENABLE;
  ALTER TABLE "WEBBANK"."USERS" MODIFY ("ID" NOT NULL ENABLE);
--------------------------------------------------------
--  Constraints for Table OPERATIONS
--------------------------------------------------------

  ALTER TABLE "WEBBANK"."OPERATIONS" ADD CONSTRAINT "OPERATIONS_PK" PRIMARY KEY ("ID")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "APEX_4780431536990897"  ENABLE;
  ALTER TABLE "WEBBANK"."OPERATIONS" MODIFY ("ID" NOT NULL ENABLE);
--------------------------------------------------------
--  Constraints for Table ACCOUNTS
--------------------------------------------------------

  ALTER TABLE "WEBBANK"."ACCOUNTS" ADD CONSTRAINT "ACCOUNTS_PK" PRIMARY KEY ("ID")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "APEX_4780431536990897"  ENABLE;
  ALTER TABLE "WEBBANK"."ACCOUNTS" MODIFY ("ID" NOT NULL ENABLE);
--------------------------------------------------------
--  Ref Constraints for Table OPERATIONS
--------------------------------------------------------

  ALTER TABLE "WEBBANK"."OPERATIONS" ADD CONSTRAINT "ACCOUNT_NUMBER_FK" FOREIGN KEY ("ACCOUNT_NUMBER")
	  REFERENCES "WEBBANK"."ACCOUNTS" ("ID") ENABLE;
  ALTER TABLE "WEBBANK"."OPERATIONS" ADD CONSTRAINT "PERFORMED_BY_FK" FOREIGN KEY ("PERFORMED_BY")
	  REFERENCES "WEBBANK"."USERS" ("ID") ENABLE;
--------------------------------------------------------
--  Ref Constraints for Table ACCOUNTS
--------------------------------------------------------

  ALTER TABLE "WEBBANK"."ACCOUNTS" ADD CONSTRAINT "CREATED_BY_FK" FOREIGN KEY ("CREATED_BY")
	  REFERENCES "WEBBANK"."USERS" ("ID") ENABLE;
  ALTER TABLE "WEBBANK"."ACCOUNTS" ADD CONSTRAINT "USERNAME_FK" FOREIGN KEY ("USERNAME")
	  REFERENCES "WEBBANK"."USERS" ("ID") ENABLE;
--------------------------------------------------------
--  DDL for Function CUSTOM_AUTH
--------------------------------------------------------

  CREATE OR REPLACE FUNCTION "WEBBANK"."CUSTOM_AUTH" (p_username in VARCHAR2, p_password in VARCHAR2)
return BOOLEAN
is
  l_password varchar2(4000);
  l_stored_password varchar2(4000);
  l_expires_on date;
  l_count number;
begin
-- First, check to see if the user is in the user table
select count(*) into l_count from demo_users where user_name = p_username;
if l_count > 0 then
  -- First, we fetch the stored hashed password & expire date
  select password, expires_on into l_stored_password, l_expires_on
   from demo_users where user_name = p_username;

  -- Next, we check to see if the user's account is expired
  -- If it is, return FALSE
  if l_expires_on > sysdate or l_expires_on is null then

    -- If the account is not expired, we have to apply the custom hash
    -- function to the password
    l_password := custom_hash(p_username, p_password);

    -- Finally, we compare them to see if they are the same and return
    -- either TRUE or FALSE
    if l_password = l_stored_password then
      return true;
    else
      return false;
    end if;
  else
    return false;
  end if;
else
  -- The username provided is not in the DEMO_USERS table
  return false;
end if;
end;

/
--------------------------------------------------------
--  DDL for Function CUSTOM_HASH
--------------------------------------------------------

  CREATE OR REPLACE FUNCTION "WEBBANK"."CUSTOM_HASH" (p_username in varchar2, p_password in varchar2)
return varchar2
is
  l_password varchar2(4000);
  l_salt varchar2(4000) := 'PEU64YXKCBWSI35QRTZP6F8XOVNGUB';
begin

-- This function should be wrapped, as the hash algorhythm is exposed here.
-- You can change the value of l_salt or the method of which to call the
-- DBMS_OBFUSCATOIN toolkit, but you much reset all of your passwords
-- if you choose to do this.

l_password := utl_raw.cast_to_raw(dbms_obfuscation_toolkit.md5
  (input_string => p_password || substr(l_salt,10,13) || p_username ||
    substr(l_salt, 4,10)));
return l_password;
end;

/
--------------------------------------------------------
--  DDL for Synonymn DBMS_OBFUSCATION_TOOLKIT
--------------------------------------------------------

  CREATE OR REPLACE PUBLIC SYNONYM "DBMS_OBFUSCATION_TOOLKIT" FOR "SYS"."DBMS_OBFUSCATION_TOOLKIT";
--------------------------------------------------------
--  DDL for Synonymn UTL_RAW
--------------------------------------------------------

  CREATE OR REPLACE PUBLIC SYNONYM "UTL_RAW" FOR "SYS"."UTL_RAW";
