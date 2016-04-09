--------------------------------------------------------
--  File created - Saturday-April-09-2016   
--------------------------------------------------------
--------------------------------------------------------
--  DDL for Sequence PRODUCT_SEQ
--------------------------------------------------------

   CREATE SEQUENCE  "PRODUCT_SEQ"  MINVALUE 1 MAXVALUE 9999999999999999999999999999 INCREMENT BY 1 START WITH 7 CACHE 2 NOORDER  NOCYCLE
--------------------------------------------------------
--  DDL for Sequence PRODUCT_TYPE_SEQ
--------------------------------------------------------

   CREATE SEQUENCE  "PRODUCT_TYPE_SEQ"  MINVALUE 1 MAXVALUE 9999999999999999999999999999 INCREMENT BY 1 START WITH 5 CACHE 2 NOORDER  NOCYCLE
--------------------------------------------------------
--  DDL for Table CUSTOMERS
--------------------------------------------------------

  CREATE TABLE "CUSTOMERS" ("ID" NUMBER, "NAME" VARCHAR2(50), "PID" VARCHAR2(20), "DATE_OF_BIRTH" DATE, "ADDRESS" VARCHAR2(100), "STATUS" VARCHAR2(20))
--------------------------------------------------------
--  DDL for Table ORDERS
--------------------------------------------------------

  CREATE TABLE "ORDERS" ("ID" NUMBER, "OVERALL_PRICE" NUMBER, "CUSTOMER" NUMBER, "PURCHASE_DATE" DATE, "STATUS" VARCHAR2(20))
--------------------------------------------------------
--  DDL for Table PRODUCTS
--------------------------------------------------------

  CREATE TABLE "PRODUCTS" ("ID" NUMBER, "NAME" VARCHAR2(20), "TYPE" NUMBER, "PRICE" NUMBER DEFAULT 0, "QUANTITY" NUMBER DEFAULT 1, "STATUS" VARCHAR2(20))
--------------------------------------------------------
--  DDL for Table PRODUCT_LIST
--------------------------------------------------------

  CREATE TABLE "PRODUCT_LIST" ("ID" VARCHAR2(20), "ORDER_ID" NUMBER, "PRODUCT_ID" NUMBER, "QUANTITY" NUMBER)
--------------------------------------------------------
--  DDL for Table PRODUCT_TYPE
--------------------------------------------------------

  CREATE TABLE "PRODUCT_TYPE" ("ID" NUMBER, "NAME" VARCHAR2(50))
--------------------------------------------------------
--  DDL for Table ROLES
--------------------------------------------------------

  CREATE TABLE "ROLES" ("ID" NUMBER, "ROLE" VARCHAR2(50))
--------------------------------------------------------
--  DDL for Table USERS
--------------------------------------------------------

  CREATE TABLE "USERS" ("ID" NUMBER, "USERNAME" VARCHAR2(20), "PASSWORD" VARCHAR2(100), "STATUS" VARCHAR2(20))
--------------------------------------------------------
--  DDL for Table USER_CUSTOMERS
--------------------------------------------------------

  CREATE TABLE "USER_CUSTOMERS" ("USER_ID" NUMBER, "CUSTOMER_ID" NUMBER)
--------------------------------------------------------
--  DDL for Table USER_ROLES
--------------------------------------------------------

  CREATE TABLE "USER_ROLES" ("USER_ID" NUMBER, "ROLE_ID" NUMBER)
REM INSERTING into CUSTOMERS
SET DEFINE OFF;
Insert into CUSTOMERS (ID,NAME,PID,DATE_OF_BIRTH,ADDRESS,STATUS) values (1,'Customer Name','0123CN',to_date('01-NOV-87','DD-MON-RR'),'City,1 "Street" Str.','Active');
Insert into CUSTOMERS (ID,NAME,PID,DATE_OF_BIRTH,ADDRESS,STATUS) values (2,'Other Customer Name','0123ON',to_date('01-NOV-87','DD-MON-RR'),'City,1 "Street" Str.','Inactive');
REM INSERTING into ORDERS
SET DEFINE OFF;
Insert into ORDERS (ID,OVERALL_PRICE,CUSTOMER,PURCHASE_DATE,STATUS) values (1,1000,1,to_date('02-APR-16','DD-MON-RR'),'Active');
REM INSERTING into PRODUCTS
SET DEFINE OFF;
Insert into PRODUCTS (ID,NAME,TYPE,PRICE,QUANTITY,STATUS) values (1,'model01',1,1000,5,'Active');
Insert into PRODUCTS (ID,NAME,TYPE,PRICE,QUANTITY,STATUS) values (2,'model02',1,900.23,2,'Inactive');
Insert into PRODUCTS (ID,NAME,TYPE,PRICE,QUANTITY,STATUS) values (3,'model01',2,1234.56,10,'Active');
Insert into PRODUCTS (ID,NAME,TYPE,PRICE,QUANTITY,STATUS) values (4,'new_product',3,9.99,20,'Inactive');
Insert into PRODUCTS (ID,NAME,TYPE,PRICE,QUANTITY,STATUS) values (5,'new_product 02',3,51009.99,1,'Active');
Insert into PRODUCTS (ID,NAME,TYPE,PRICE,QUANTITY,STATUS) values (6,'new_product 03',4,9.99,1,'Active');
REM INSERTING into PRODUCT_LIST
SET DEFINE OFF;
Insert into PRODUCT_LIST (ID,ORDER_ID,PRODUCT_ID,QUANTITY) values ('1',1,1,2);
Insert into PRODUCT_LIST (ID,ORDER_ID,PRODUCT_ID,QUANTITY) values ('2',1,2,2);
REM INSERTING into PRODUCT_TYPE
SET DEFINE OFF;
Insert into PRODUCT_TYPE (ID,NAME) values (1,'computer');
Insert into PRODUCT_TYPE (ID,NAME) values (2,'phone');
Insert into PRODUCT_TYPE (ID,NAME) values (3,'drink');
Insert into PRODUCT_TYPE (ID,NAME) values (4,'drink2');
REM INSERTING into ROLES
SET DEFINE OFF;
Insert into ROLES (ID,ROLE) values (1,'ROLE_ADMIN');
Insert into ROLES (ID,ROLE) values (2,'ROLE_USER');
REM INSERTING into USERS
SET DEFINE OFF;
Insert into USERS (ID,USERNAME,PASSWORD,STATUS) values (1,'admin','c4ca4238a0b923820dcc509a6f75849b','Active');
Insert into USERS (ID,USERNAME,PASSWORD,STATUS) values (2,'user01','c20ad4d76fe97759aa27a0c99bff6710','Active');
Insert into USERS (ID,USERNAME,PASSWORD,STATUS) values (3,'user02','c20ad4d76fe97759aa27a0c99bff6710','Inactive');
REM INSERTING into USER_CUSTOMERS
SET DEFINE OFF;
Insert into USER_CUSTOMERS (USER_ID,CUSTOMER_ID) values (2,1);
REM INSERTING into USER_ROLES
SET DEFINE OFF;
Insert into USER_ROLES (USER_ID,ROLE_ID) values (1,1);
Insert into USER_ROLES (USER_ID,ROLE_ID) values (2,2);
Insert into USER_ROLES (USER_ID,ROLE_ID) values (1,2);
--------------------------------------------------------
--  DDL for Index CUSTOMERS_PK
--------------------------------------------------------

  CREATE UNIQUE INDEX "CUSTOMERS_PK" ON "CUSTOMERS" ("ID")
--------------------------------------------------------
--  DDL for Index ORDERS_PK
--------------------------------------------------------

  CREATE UNIQUE INDEX "ORDERS_PK" ON "ORDERS" ("ID")
--------------------------------------------------------
--  DDL for Index TABLE1_PK
--------------------------------------------------------

  CREATE UNIQUE INDEX "TABLE1_PK" ON "PRODUCTS" ("ID")
--------------------------------------------------------
--  DDL for Index PRODUCT_LIST_PK
--------------------------------------------------------

  CREATE UNIQUE INDEX "PRODUCT_LIST_PK" ON "PRODUCT_LIST" ("ID")
--------------------------------------------------------
--  DDL for Index PRODUCT_TYPE_PK
--------------------------------------------------------

  CREATE UNIQUE INDEX "PRODUCT_TYPE_PK" ON "PRODUCT_TYPE" ("ID")
--------------------------------------------------------
--  DDL for Index PRODUCT_TYPE_NAME_UNIQUE
--------------------------------------------------------

  CREATE UNIQUE INDEX "PRODUCT_TYPE_NAME_UNIQUE" ON "PRODUCT_TYPE" ("NAME")
--------------------------------------------------------
--  DDL for Index ROLES_PK
--------------------------------------------------------

  CREATE UNIQUE INDEX "ROLES_PK" ON "ROLES" ("ID")
--------------------------------------------------------
--  DDL for Index USERS_PK
--------------------------------------------------------

  CREATE UNIQUE INDEX "USERS_PK" ON "USERS" ("ID")
--------------------------------------------------------
--  Constraints for Table CUSTOMERS
--------------------------------------------------------

  ALTER TABLE "CUSTOMERS" ADD CONSTRAINT "CUSTOMERS_PK" PRIMARY KEY ("ID") ENABLE
  ALTER TABLE "CUSTOMERS" MODIFY ("PID" NOT NULL ENABLE)
  ALTER TABLE "CUSTOMERS" MODIFY ("ID" NOT NULL ENABLE)
--------------------------------------------------------
--  Constraints for Table ORDERS
--------------------------------------------------------

  ALTER TABLE "ORDERS" ADD CONSTRAINT "ORDERS_PK" PRIMARY KEY ("ID") ENABLE
  ALTER TABLE "ORDERS" MODIFY ("ID" NOT NULL ENABLE)
--------------------------------------------------------
--  Constraints for Table PRODUCTS
--------------------------------------------------------

  ALTER TABLE "PRODUCTS" ADD CONSTRAINT "PRODUCTS_PK" PRIMARY KEY ("ID") ENABLE
  ALTER TABLE "PRODUCTS" MODIFY ("QUANTITY" NOT NULL ENABLE)
  ALTER TABLE "PRODUCTS" MODIFY ("PRICE" NOT NULL ENABLE)
  ALTER TABLE "PRODUCTS" MODIFY ("TYPE" NOT NULL ENABLE)
  ALTER TABLE "PRODUCTS" MODIFY ("ID" NOT NULL ENABLE)
--------------------------------------------------------
--  Constraints for Table PRODUCT_LIST
--------------------------------------------------------

  ALTER TABLE "PRODUCT_LIST" ADD CONSTRAINT "PRODUCT_LIST_PK" PRIMARY KEY ("ID") ENABLE
  ALTER TABLE "PRODUCT_LIST" MODIFY ("ID" NOT NULL ENABLE)
--------------------------------------------------------
--  Constraints for Table PRODUCT_TYPE
--------------------------------------------------------

  ALTER TABLE "PRODUCT_TYPE" ADD CONSTRAINT "PRODUCT_TYPE_NAME_UNIQUE" UNIQUE ("NAME") ENABLE
  ALTER TABLE "PRODUCT_TYPE" ADD CONSTRAINT "PRODUCT_TYPE_PK" PRIMARY KEY ("ID") ENABLE
  ALTER TABLE "PRODUCT_TYPE" MODIFY ("ID" NOT NULL ENABLE)
--------------------------------------------------------
--  Constraints for Table ROLES
--------------------------------------------------------

  ALTER TABLE "ROLES" ADD CONSTRAINT "ROLES_PK" PRIMARY KEY ("ID") ENABLE
  ALTER TABLE "ROLES" MODIFY ("ID" NOT NULL ENABLE)
--------------------------------------------------------
--  Constraints for Table USERS
--------------------------------------------------------

  ALTER TABLE "USERS" ADD CONSTRAINT "USERS_PK" PRIMARY KEY ("ID") ENABLE
  ALTER TABLE "USERS" MODIFY ("ID" NOT NULL ENABLE)
--------------------------------------------------------
--  Ref Constraints for Table ORDERS
--------------------------------------------------------

  ALTER TABLE "ORDERS" ADD CONSTRAINT "CUSTOMER_FK" FOREIGN KEY ("CUSTOMER") REFERENCES "CUSTOMERS" ("ID") ENABLE
--------------------------------------------------------
--  Ref Constraints for Table PRODUCTS
--------------------------------------------------------

  ALTER TABLE "PRODUCTS" ADD CONSTRAINT "PRODUCT_TYPE_FK" FOREIGN KEY ("TYPE") REFERENCES "PRODUCT_TYPE" ("ID") ENABLE
--------------------------------------------------------
--  Ref Constraints for Table PRODUCT_LIST
--------------------------------------------------------

  ALTER TABLE "PRODUCT_LIST" ADD CONSTRAINT "ORDER_FK" FOREIGN KEY ("ORDER_ID") REFERENCES "ORDERS" ("ID") ENABLE
  ALTER TABLE "PRODUCT_LIST" ADD CONSTRAINT "PRODUCT_FK" FOREIGN KEY ("PRODUCT_ID") REFERENCES "PRODUCTS" ("ID") ENABLE
--------------------------------------------------------
--  Ref Constraints for Table USER_CUSTOMERS
--------------------------------------------------------

  ALTER TABLE "USER_CUSTOMERS" ADD CONSTRAINT "CUSTOMERS_FK" FOREIGN KEY ("CUSTOMER_ID") REFERENCES "CUSTOMERS" ("ID") ENABLE
  ALTER TABLE "USER_CUSTOMERS" ADD CONSTRAINT "USER_FK" FOREIGN KEY ("USER_ID") REFERENCES "USERS" ("ID") ENABLE
--------------------------------------------------------
--  Ref Constraints for Table USER_ROLES
--------------------------------------------------------

  ALTER TABLE "USER_ROLES" ADD CONSTRAINT "ROLE_FK" FOREIGN KEY ("ROLE_ID") REFERENCES "ROLES" ("ID") ENABLE
  ALTER TABLE "USER_ROLES" ADD CONSTRAINT "USER_FK2" FOREIGN KEY ("USER_ID") REFERENCES "USERS" ("ID") ENABLE
--------------------------------------------------------
--  DDL for Function CUSTOM_AUTH
--------------------------------------------------------

  CREATE OR REPLACE FUNCTION "CUSTOM_AUTH" (p_username in VARCHAR2, p_password in VARCHAR2)
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
--------------------------------------------------------
--  DDL for Function CUSTOM_HASH
--------------------------------------------------------

  CREATE OR REPLACE FUNCTION "CUSTOM_HASH" (p_username in varchar2, p_password in varchar2)
return varchar2
is
  l_password varchar2(4000);
  l_salt varchar2(4000) := 'EYOPQUGCYP3G8OB0VTJZEC4ZFBTIK2';
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
