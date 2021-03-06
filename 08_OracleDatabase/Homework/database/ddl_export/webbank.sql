--------------------------------------------------------
--  File created - Saturday-March-26-2016   
--------------------------------------------------------
DROP TABLE "WEBBANK"."USERS" cascade constraints;
DROP TABLE "WEBBANK"."OPERATIONS" cascade constraints;
DROP TABLE "WEBBANK"."ACCOUNTS" cascade constraints;

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
