--------------------------------------------------------
--  File created - Monday-March-28-2016   
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
--  DDL for Sequence DEMO_CUST_SEQ
--------------------------------------------------------

   CREATE SEQUENCE  "UNIVERSITY"."DEMO_CUST_SEQ"  MINVALUE 1 MAXVALUE 9999999999999999999999999999 INCREMENT BY 1 START WITH 21 CACHE 20 NOORDER  NOCYCLE ;
--------------------------------------------------------
--  DDL for Sequence DEMO_ORDER_ITEMS_SEQ
--------------------------------------------------------

   CREATE SEQUENCE  "UNIVERSITY"."DEMO_ORDER_ITEMS_SEQ"  MINVALUE 1 MAXVALUE 9999999999999999999999999999 INCREMENT BY 1 START WITH 61 CACHE 20 NOORDER  NOCYCLE ;
--------------------------------------------------------
--  DDL for Sequence DEMO_ORD_SEQ
--------------------------------------------------------

   CREATE SEQUENCE  "UNIVERSITY"."DEMO_ORD_SEQ"  MINVALUE 1 MAXVALUE 9999999999999999999999999999 INCREMENT BY 1 START WITH 11 CACHE 20 NOORDER  NOCYCLE ;
--------------------------------------------------------
--  DDL for Sequence DEMO_PROD_SEQ
--------------------------------------------------------

   CREATE SEQUENCE  "UNIVERSITY"."DEMO_PROD_SEQ"  MINVALUE 1 MAXVALUE 9999999999999999999999999999 INCREMENT BY 1 START WITH 21 CACHE 20 NOORDER  NOCYCLE ;
--------------------------------------------------------
--  DDL for Sequence DEMO_USERS_SEQ
--------------------------------------------------------

   CREATE SEQUENCE  "UNIVERSITY"."DEMO_USERS_SEQ"  MINVALUE 1 MAXVALUE 9999999999999999999999999999 INCREMENT BY 1 START WITH 21 CACHE 20 NOORDER  NOCYCLE ;
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
Insert into UNIVERSITY.STUDENTS (ID,FACULTY_NUMBER,NAME) values (4,'1029','New Name 02');
Insert into UNIVERSITY.STUDENTS (ID,FACULTY_NUMBER,NAME) values (1,'a1s2','User Name');
Insert into UNIVERSITY.STUDENTS (ID,FACULTY_NUMBER,NAME) values (3,'0987','User Name 02');
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
--------------------------------------------------------
--  DDL for Function CUSTOM_AUTH
--------------------------------------------------------

  CREATE OR REPLACE FUNCTION "UNIVERSITY"."CUSTOM_AUTH" (p_username in VARCHAR2, p_password in VARCHAR2)
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

  CREATE OR REPLACE FUNCTION "UNIVERSITY"."CUSTOM_HASH" (p_username in varchar2, p_password in varchar2)
return varchar2
is
  l_password varchar2(4000);
  l_salt varchar2(4000) := 'SA9OL6FPBEXSNGG7MFZPVLHV82F6AD';
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
