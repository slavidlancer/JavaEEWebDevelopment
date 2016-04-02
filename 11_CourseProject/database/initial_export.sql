--------------------------------------------------------
--  File created - Saturday-April-02-2016   
--------------------------------------------------------
--------------------------------------------------------
--  DDL for Sequence DEMO_CUST_SEQ
--------------------------------------------------------

   CREATE SEQUENCE  "DEMO_CUST_SEQ"  MINVALUE 1 MAXVALUE 9999999999999999999999999999 INCREMENT BY 1 START WITH 21 CACHE 20 NOORDER  NOCYCLE
--------------------------------------------------------
--  DDL for Sequence DEMO_ORDER_ITEMS_SEQ
--------------------------------------------------------

   CREATE SEQUENCE  "DEMO_ORDER_ITEMS_SEQ"  MINVALUE 1 MAXVALUE 9999999999999999999999999999 INCREMENT BY 1 START WITH 61 CACHE 20 NOORDER  NOCYCLE
--------------------------------------------------------
--  DDL for Sequence DEMO_ORD_SEQ
--------------------------------------------------------

   CREATE SEQUENCE  "DEMO_ORD_SEQ"  MINVALUE 1 MAXVALUE 9999999999999999999999999999 INCREMENT BY 1 START WITH 11 CACHE 20 NOORDER  NOCYCLE
--------------------------------------------------------
--  DDL for Sequence DEMO_PROD_SEQ
--------------------------------------------------------

   CREATE SEQUENCE  "DEMO_PROD_SEQ"  MINVALUE 1 MAXVALUE 9999999999999999999999999999 INCREMENT BY 1 START WITH 21 CACHE 20 NOORDER  NOCYCLE
--------------------------------------------------------
--  DDL for Sequence DEMO_USERS_SEQ
--------------------------------------------------------

   CREATE SEQUENCE  "DEMO_USERS_SEQ"  MINVALUE 1 MAXVALUE 9999999999999999999999999999 INCREMENT BY 1 START WITH 21 CACHE 20 NOORDER  NOCYCLE
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
REM INSERTING into PRODUCT_LIST
SET DEFINE OFF;
Insert into PRODUCT_LIST (ID,ORDER_ID,PRODUCT_ID,QUANTITY) values ('1',1,1,2);
Insert into PRODUCT_LIST (ID,ORDER_ID,PRODUCT_ID,QUANTITY) values ('2',1,2,2);
REM INSERTING into PRODUCT_TYPE
SET DEFINE OFF;
Insert into PRODUCT_TYPE (ID,NAME) values (1,'computer');
Insert into PRODUCT_TYPE (ID,NAME) values (2,'phone');
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

  ALTER TABLE "PRODUCTS" ADD CONSTRAINT "TABLE1_PK" PRIMARY KEY ("ID") ENABLE
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

  ALTER TABLE "PRODUCT_TYPE" ADD CONSTRAINT "PRODUCT_TYPE_PK" PRIMARY KEY ("ID") ENABLE
  ALTER TABLE "PRODUCT_TYPE" MODIFY ("ID" NOT NULL ENABLE)
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
