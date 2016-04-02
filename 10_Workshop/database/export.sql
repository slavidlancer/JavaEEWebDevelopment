--------------------------------------------------------
--  File created - Saturday-April-02-2016   
--------------------------------------------------------
--------------------------------------------------------
--  DDL for Table AUTO_USER
--------------------------------------------------------

  CREATE TABLE "AUTO_USER" ("ID" NUMBER, "USERNAME" VARCHAR2(20), "PASSWORD" VARCHAR2(100), "CREATED_BY" NUMBER, "STATUS" VARCHAR2(20))
--------------------------------------------------------
--  DDL for Table HIST_USER_AUTHORITY
--------------------------------------------------------

  CREATE TABLE "HIST_USER_AUTHORITY" ("ID" NUMBER, "USER_ID" NUMBER, "AUTHORITY_ID" NUMBER, "MODIFIED_DATE" DATE, "MODIFIED_BY" NUMBER, "OPERATION" VARCHAR2(20))
--------------------------------------------------------
--  DDL for Table NM_AUTHORITY
--------------------------------------------------------

  CREATE TABLE "NM_AUTHORITY" ("ID" NUMBER, "AUTHORITY" VARCHAR2(50))
--------------------------------------------------------
--  DDL for Table USER_AUTHORITY
--------------------------------------------------------

  CREATE TABLE "USER_AUTHORITY" ("USER_ID" NUMBER, "AUTHORITY_ID" NUMBER)
REM INSERTING into AUTO_USER
SET DEFINE OFF;
Insert into AUTO_USER (ID,USERNAME,PASSWORD,CREATED_BY,STATUS) values (1,'admin','e10adc3949ba59abbe56e057f20f883e',1,'Active');
Insert into AUTO_USER (ID,USERNAME,PASSWORD,CREATED_BY,STATUS) values (2,'regular','e10adc3949ba59abbe56e057f20f883e',1,'Inactive');
REM INSERTING into HIST_USER_AUTHORITY
SET DEFINE OFF;
REM INSERTING into NM_AUTHORITY
SET DEFINE OFF;
Insert into NM_AUTHORITY (ID,AUTHORITY) values (1,'ROLE_ADMIN');
Insert into NM_AUTHORITY (ID,AUTHORITY) values (2,'ROLE_USER');
REM INSERTING into USER_AUTHORITY
SET DEFINE OFF;
Insert into USER_AUTHORITY (USER_ID,AUTHORITY_ID) values (1,1);
Insert into USER_AUTHORITY (USER_ID,AUTHORITY_ID) values (1,2);
--------------------------------------------------------
--  DDL for Index SYS_C007269
--------------------------------------------------------

  CREATE UNIQUE INDEX "SYS_C007269" ON "AUTO_USER" ("ID")
--------------------------------------------------------
--  DDL for Index SYS_C007270
--------------------------------------------------------

  CREATE UNIQUE INDEX "SYS_C007270" ON "HIST_USER_AUTHORITY" ("ID")
--------------------------------------------------------
--  DDL for Index SYS_C007271
--------------------------------------------------------

  CREATE UNIQUE INDEX "SYS_C007271" ON "NM_AUTHORITY" ("ID")
--------------------------------------------------------
--  Constraints for Table AUTO_USER
--------------------------------------------------------

  ALTER TABLE "AUTO_USER" ADD PRIMARY KEY ("ID") ENABLE
--------------------------------------------------------
--  Constraints for Table HIST_USER_AUTHORITY
--------------------------------------------------------

  ALTER TABLE "HIST_USER_AUTHORITY" ADD PRIMARY KEY ("ID") ENABLE
--------------------------------------------------------
--  Constraints for Table NM_AUTHORITY
--------------------------------------------------------

  ALTER TABLE "NM_AUTHORITY" ADD PRIMARY KEY ("ID") ENABLE
--------------------------------------------------------
--  Ref Constraints for Table USER_AUTHORITY
--------------------------------------------------------

  ALTER TABLE "USER_AUTHORITY" ADD CONSTRAINT "USER_AUTH_AUTH_FK" FOREIGN KEY ("AUTHORITY_ID") REFERENCES "NM_AUTHORITY" ("ID") ENABLE
  ALTER TABLE "USER_AUTHORITY" ADD CONSTRAINT "USER_AUTH_USER_FK" FOREIGN KEY ("USER_ID") REFERENCES "AUTO_USER" ("ID") ENABLE
