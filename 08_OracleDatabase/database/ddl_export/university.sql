--------------------------------------------------------
--  File created - Sunday-March-27-2016   
--------------------------------------------------------
DROP TABLE "UNIVERSITY"."STUDENTS" cascade constraints;
DROP TABLE "UNIVERSITY"."DEMO_USERS" cascade constraints;
DROP SYNONYM "PUBLIC"."DBMS_OBFUSCATION_TOOLKIT";
DROP SYNONYM "PUBLIC"."UTL_RAW";
DROP SEQUENCE "UNIVERSITY"."DEMO_CUST_SEQ";
DROP SEQUENCE "UNIVERSITY"."DEMO_ORDER_ITEMS_SEQ";
DROP SEQUENCE "UNIVERSITY"."DEMO_ORD_SEQ";
DROP SEQUENCE "UNIVERSITY"."DEMO_PROD_SEQ";
DROP SEQUENCE "UNIVERSITY"."DEMO_USERS_SEQ";
DROP FUNCTION "UNIVERSITY"."CUSTOM_AUTH";
DROP FUNCTION "UNIVERSITY"."CUSTOM_HASH";
--------------------------------------------------------
--  DDL for Table STUDENTS
--------------------------------------------------------

  CREATE TABLE "UNIVERSITY"."STUDENTS" 
   (	"ID" NUMBER, 
	"FACULTY_NUMBER" VARCHAR2(20 BYTE), 
	"NAME" VARCHAR2(40 BYTE)
   ) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "APEX_4770931237927312" ;
--------------------------------------------------------
--  DDL for Table DEMO_USERS
--------------------------------------------------------

  CREATE TABLE "UNIVERSITY"."DEMO_USERS" 
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
  TABLESPACE "APEX_4770931237927312" ;
REM INSERTING into UNIVERSITY.STUDENTS
SET DEFINE OFF;
Insert into UNIVERSITY.STUDENTS (ID,FACULTY_NUMBER,NAME) values (2,'0123','New Name');
Insert into UNIVERSITY.STUDENTS (ID,FACULTY_NUMBER,NAME) values (1,'a1s2','User Name');
--------------------------------------------------------
--  DDL for Index STUDENTS_PK
--------------------------------------------------------

  CREATE UNIQUE INDEX "UNIVERSITY"."STUDENTS_PK" ON "UNIVERSITY"."STUDENTS" ("ID") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "APEX_4770931237927312" ;
--------------------------------------------------------
--  Constraints for Table STUDENTS
--------------------------------------------------------

  ALTER TABLE "UNIVERSITY"."STUDENTS" ADD CONSTRAINT "STUDENTS_PK" PRIMARY KEY ("ID")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "APEX_4770931237927312"  ENABLE;
  ALTER TABLE "UNIVERSITY"."STUDENTS" MODIFY ("ID" NOT NULL ENABLE);
