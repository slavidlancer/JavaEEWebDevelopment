-- Generated by Oracle SQL Developer Data Modeler 4.1.3.901
--   at:        2016-04-09 06:24:31 EEST
--   site:      Oracle Database 11g
--   type:      Oracle Database 11g




CREATE USER WEBSTORE IDENTIFIED BY ACCOUNT UNLOCK ;

CREATE TABLE WEBSTORE.CUSTOMERS
  (
    ID            NUMBER NOT NULL ,
    NAME          VARCHAR2 (50 BYTE) ,
    PID           VARCHAR2 (20 BYTE) NOT NULL ,
    DATE_OF_BIRTH DATE ,
    ADDRESS       VARCHAR2 (100 BYTE) ,
    STATUS        VARCHAR2 (20 BYTE)
  )
  TABLESPACE APEX_4800922068347633 LOGGING ;
CREATE UNIQUE INDEX WEBSTORE.CUSTOMERS_PK ON WEBSTORE.CUSTOMERS
  (
    ID ASC
  )
  TABLESPACE APEX_4800922068347633 LOGGING ;
ALTER TABLE WEBSTORE.CUSTOMERS ADD CONSTRAINT CUSTOMERS_PK PRIMARY KEY ( ID ) USING INDEX WEBSTORE.CUSTOMERS_PK ;


CREATE TABLE WEBSTORE.CUSTOMERS_JN
 (JN_OPERATION CHAR(3) NOT NULL
 ,JN_ORACLE_USER VARCHAR2(30) NOT NULL
 ,JN_DATETIME DATE NOT NULL
 ,JN_NOTES VARCHAR2(240)
 ,JN_APPLN VARCHAR2(35)
 ,JN_SESSION NUMBER(38)
 ,ID NUMBER NOT NULL
 ,NAME VARCHAR2 (50 BYTE)
 ,PID VARCHAR2 (20 BYTE) NOT NULL
 ,DATE_OF_BIRTH DATE
 ,ADDRESS VARCHAR2 (100 BYTE)
 ,STATUS VARCHAR2 (20 BYTE)
 );

CREATE OR REPLACE TRIGGER WEBSTORE.CUSTOMERS_JNtrg
  AFTER 
  INSERT OR 
  UPDATE OR 
  DELETE ON WEBSTORE.CUSTOMERS for each row 
 Declare 
  rec WEBSTORE.CUSTOMERS_JN%ROWTYPE; 
  blank WEBSTORE.CUSTOMERS_JN%ROWTYPE; 
  BEGIN 
    rec := blank; 
    IF INSERTING OR UPDATING THEN 
      rec.ID := :NEW.ID; 
      rec.NAME := :NEW.NAME; 
      rec.PID := :NEW.PID; 
      rec.DATE_OF_BIRTH := :NEW.DATE_OF_BIRTH; 
      rec.ADDRESS := :NEW.ADDRESS; 
      rec.STATUS := :NEW.STATUS; 
      rec.JN_DATETIME := SYSDATE; 
      rec.JN_ORACLE_USER := SYS_CONTEXT ('USERENV', 'SESSION_USER'); 
      rec.JN_APPLN := SYS_CONTEXT ('USERENV', 'MODULE'); 
      rec.JN_SESSION := SYS_CONTEXT ('USERENV', 'SESSIONID'); 
      IF INSERTING THEN 
        rec.JN_OPERATION := 'INS'; 
      ELSIF UPDATING THEN 
        rec.JN_OPERATION := 'UPD'; 
      END IF; 
    ELSIF DELETING THEN 
      rec.ID := :OLD.ID; 
      rec.NAME := :OLD.NAME; 
      rec.PID := :OLD.PID; 
      rec.DATE_OF_BIRTH := :OLD.DATE_OF_BIRTH; 
      rec.ADDRESS := :OLD.ADDRESS; 
      rec.STATUS := :OLD.STATUS; 
      rec.JN_DATETIME := SYSDATE; 
      rec.JN_ORACLE_USER := SYS_CONTEXT ('USERENV', 'SESSION_USER'); 
      rec.JN_APPLN := SYS_CONTEXT ('USERENV', 'MODULE'); 
      rec.JN_SESSION := SYS_CONTEXT ('USERENV', 'SESSIONID'); 
      rec.JN_OPERATION := 'DEL'; 
    END IF; 
    INSERT into WEBSTORE.CUSTOMERS_JN VALUES rec; 
  END; 
  /
CREATE TABLE WEBSTORE.ORDERS
  (
    ID            NUMBER NOT NULL ,
    OVERALL_PRICE NUMBER ,
    CUSTOMER      NUMBER ,
    PURCHASE_DATE DATE ,
    STATUS        VARCHAR2 (20 BYTE)
  )
  TABLESPACE APEX_4800922068347633 LOGGING ;
CREATE UNIQUE INDEX WEBSTORE.ORDERS_PK ON WEBSTORE.ORDERS
  (
    ID ASC
  )
  TABLESPACE APEX_4800922068347633 LOGGING ;
ALTER TABLE WEBSTORE.ORDERS ADD CONSTRAINT ORDERS_PK PRIMARY KEY ( ID ) USING INDEX WEBSTORE.ORDERS_PK ;


CREATE TABLE WEBSTORE.ORDERS_JN
 (JN_OPERATION CHAR(3) NOT NULL
 ,JN_ORACLE_USER VARCHAR2(30) NOT NULL
 ,JN_DATETIME DATE NOT NULL
 ,JN_NOTES VARCHAR2(240)
 ,JN_APPLN VARCHAR2(35)
 ,JN_SESSION NUMBER(38)
 ,ID NUMBER NOT NULL
 ,OVERALL_PRICE NUMBER
 ,CUSTOMER NUMBER
 ,PURCHASE_DATE DATE
 ,STATUS VARCHAR2 (20 BYTE)
 );

CREATE OR REPLACE TRIGGER WEBSTORE.ORDERS_JNtrg
  AFTER 
  INSERT OR 
  UPDATE OR 
  DELETE ON WEBSTORE.ORDERS for each row 
 Declare 
  rec WEBSTORE.ORDERS_JN%ROWTYPE; 
  blank WEBSTORE.ORDERS_JN%ROWTYPE; 
  BEGIN 
    rec := blank; 
    IF INSERTING OR UPDATING THEN 
      rec.ID := :NEW.ID; 
      rec.OVERALL_PRICE := :NEW.OVERALL_PRICE; 
      rec.CUSTOMER := :NEW.CUSTOMER; 
      rec.PURCHASE_DATE := :NEW.PURCHASE_DATE; 
      rec.STATUS := :NEW.STATUS; 
      rec.JN_DATETIME := SYSDATE; 
      rec.JN_ORACLE_USER := SYS_CONTEXT ('USERENV', 'SESSION_USER'); 
      rec.JN_APPLN := SYS_CONTEXT ('USERENV', 'MODULE'); 
      rec.JN_SESSION := SYS_CONTEXT ('USERENV', 'SESSIONID'); 
      IF INSERTING THEN 
        rec.JN_OPERATION := 'INS'; 
      ELSIF UPDATING THEN 
        rec.JN_OPERATION := 'UPD'; 
      END IF; 
    ELSIF DELETING THEN 
      rec.ID := :OLD.ID; 
      rec.OVERALL_PRICE := :OLD.OVERALL_PRICE; 
      rec.CUSTOMER := :OLD.CUSTOMER; 
      rec.PURCHASE_DATE := :OLD.PURCHASE_DATE; 
      rec.STATUS := :OLD.STATUS; 
      rec.JN_DATETIME := SYSDATE; 
      rec.JN_ORACLE_USER := SYS_CONTEXT ('USERENV', 'SESSION_USER'); 
      rec.JN_APPLN := SYS_CONTEXT ('USERENV', 'MODULE'); 
      rec.JN_SESSION := SYS_CONTEXT ('USERENV', 'SESSIONID'); 
      rec.JN_OPERATION := 'DEL'; 
    END IF; 
    INSERT into WEBSTORE.ORDERS_JN VALUES rec; 
  END; 
  /
CREATE TABLE WEBSTORE.PRODUCTS
  (
    ID       NUMBER NOT NULL ,
    NAME     VARCHAR2 (20 BYTE) ,
    TYPE     NUMBER NOT NULL ,
    PRICE    NUMBER DEFAULT 0 NOT NULL ,
    QUANTITY NUMBER DEFAULT 1 NOT NULL ,
    STATUS   VARCHAR2 (20 BYTE)
  )
  TABLESPACE APEX_4800922068347633 LOGGING ;
CREATE UNIQUE INDEX WEBSTORE.TABLE1_PK ON WEBSTORE.PRODUCTS
  (
    ID ASC
  )
  TABLESPACE APEX_4800922068347633 LOGGING ;
ALTER TABLE WEBSTORE.PRODUCTS ADD CONSTRAINT PRODUCTS_PK PRIMARY KEY ( ID ) USING INDEX WEBSTORE.TABLE1_PK ;


CREATE TABLE WEBSTORE.PRODUCTS_JN
 (JN_OPERATION CHAR(3) NOT NULL
 ,JN_ORACLE_USER VARCHAR2(30) NOT NULL
 ,JN_DATETIME DATE NOT NULL
 ,JN_NOTES VARCHAR2(240)
 ,JN_APPLN VARCHAR2(35)
 ,JN_SESSION NUMBER(38)
 ,ID NUMBER NOT NULL
 ,NAME VARCHAR2 (20 BYTE)
 ,TYPE NUMBER NOT NULL
 ,PRICE NUMBER NOT NULL
 ,QUANTITY NUMBER NOT NULL
 ,STATUS VARCHAR2 (20 BYTE)
 );

CREATE OR REPLACE TRIGGER WEBSTORE.PRODUCTS_JNtrg
  AFTER 
  INSERT OR 
  UPDATE OR 
  DELETE ON WEBSTORE.PRODUCTS for each row 
 Declare 
  rec WEBSTORE.PRODUCTS_JN%ROWTYPE; 
  blank WEBSTORE.PRODUCTS_JN%ROWTYPE; 
  BEGIN 
    rec := blank; 
    IF INSERTING OR UPDATING THEN 
      rec.ID := :NEW.ID; 
      rec.NAME := :NEW.NAME; 
      rec.TYPE := :NEW.TYPE; 
      rec.PRICE := :NEW.PRICE; 
      rec.QUANTITY := :NEW.QUANTITY; 
      rec.STATUS := :NEW.STATUS; 
      rec.JN_DATETIME := SYSDATE; 
      rec.JN_ORACLE_USER := SYS_CONTEXT ('USERENV', 'SESSION_USER'); 
      rec.JN_APPLN := SYS_CONTEXT ('USERENV', 'MODULE'); 
      rec.JN_SESSION := SYS_CONTEXT ('USERENV', 'SESSIONID'); 
      IF INSERTING THEN 
        rec.JN_OPERATION := 'INS'; 
      ELSIF UPDATING THEN 
        rec.JN_OPERATION := 'UPD'; 
      END IF; 
    ELSIF DELETING THEN 
      rec.ID := :OLD.ID; 
      rec.NAME := :OLD.NAME; 
      rec.TYPE := :OLD.TYPE; 
      rec.PRICE := :OLD.PRICE; 
      rec.QUANTITY := :OLD.QUANTITY; 
      rec.STATUS := :OLD.STATUS; 
      rec.JN_DATETIME := SYSDATE; 
      rec.JN_ORACLE_USER := SYS_CONTEXT ('USERENV', 'SESSION_USER'); 
      rec.JN_APPLN := SYS_CONTEXT ('USERENV', 'MODULE'); 
      rec.JN_SESSION := SYS_CONTEXT ('USERENV', 'SESSIONID'); 
      rec.JN_OPERATION := 'DEL'; 
    END IF; 
    INSERT into WEBSTORE.PRODUCTS_JN VALUES rec; 
  END; 
  /
CREATE TABLE WEBSTORE.PRODUCT_LIST
  (
    ID         VARCHAR2 (20 BYTE) NOT NULL ,
    ORDER_ID   NUMBER ,
    PRODUCT_ID NUMBER ,
    QUANTITY   NUMBER
  )
  TABLESPACE APEX_4800922068347633 LOGGING ;
CREATE UNIQUE INDEX WEBSTORE.PRODUCT_LIST_PK ON WEBSTORE.PRODUCT_LIST
  (
    ID ASC
  )
  TABLESPACE APEX_4800922068347633 LOGGING ;
ALTER TABLE WEBSTORE.PRODUCT_LIST ADD CONSTRAINT PRODUCT_LIST_PK PRIMARY KEY ( ID ) USING INDEX WEBSTORE.PRODUCT_LIST_PK ;


CREATE TABLE WEBSTORE.PRODUCT_LIST_JN
 (JN_OPERATION CHAR(3) NOT NULL
 ,JN_ORACLE_USER VARCHAR2(30) NOT NULL
 ,JN_DATETIME DATE NOT NULL
 ,JN_NOTES VARCHAR2(240)
 ,JN_APPLN VARCHAR2(35)
 ,JN_SESSION NUMBER(38)
 ,ID VARCHAR2 (20 BYTE) NOT NULL
 ,ORDER_ID NUMBER
 ,PRODUCT_ID NUMBER
 ,QUANTITY NUMBER
 );

CREATE OR REPLACE TRIGGER WEBSTORE.PRODUCT_LIST_JNtrg
  AFTER 
  INSERT OR 
  UPDATE OR 
  DELETE ON WEBSTORE.PRODUCT_LIST for each row 
 Declare 
  rec WEBSTORE.PRODUCT_LIST_JN%ROWTYPE; 
  blank WEBSTORE.PRODUCT_LIST_JN%ROWTYPE; 
  BEGIN 
    rec := blank; 
    IF INSERTING OR UPDATING THEN 
      rec.ID := :NEW.ID; 
      rec.ORDER_ID := :NEW.ORDER_ID; 
      rec.PRODUCT_ID := :NEW.PRODUCT_ID; 
      rec.QUANTITY := :NEW.QUANTITY; 
      rec.JN_DATETIME := SYSDATE; 
      rec.JN_ORACLE_USER := SYS_CONTEXT ('USERENV', 'SESSION_USER'); 
      rec.JN_APPLN := SYS_CONTEXT ('USERENV', 'MODULE'); 
      rec.JN_SESSION := SYS_CONTEXT ('USERENV', 'SESSIONID'); 
      IF INSERTING THEN 
        rec.JN_OPERATION := 'INS'; 
      ELSIF UPDATING THEN 
        rec.JN_OPERATION := 'UPD'; 
      END IF; 
    ELSIF DELETING THEN 
      rec.ID := :OLD.ID; 
      rec.ORDER_ID := :OLD.ORDER_ID; 
      rec.PRODUCT_ID := :OLD.PRODUCT_ID; 
      rec.QUANTITY := :OLD.QUANTITY; 
      rec.JN_DATETIME := SYSDATE; 
      rec.JN_ORACLE_USER := SYS_CONTEXT ('USERENV', 'SESSION_USER'); 
      rec.JN_APPLN := SYS_CONTEXT ('USERENV', 'MODULE'); 
      rec.JN_SESSION := SYS_CONTEXT ('USERENV', 'SESSIONID'); 
      rec.JN_OPERATION := 'DEL'; 
    END IF; 
    INSERT into WEBSTORE.PRODUCT_LIST_JN VALUES rec; 
  END; 
  /
CREATE TABLE WEBSTORE.PRODUCT_TYPE
  (
    ID   NUMBER NOT NULL ,
    NAME VARCHAR2 (50 BYTE)
  )
  TABLESPACE APEX_4800922068347633 LOGGING ;
CREATE UNIQUE INDEX WEBSTORE.PRODUCT_TYPE_NAME_UNIQUE ON WEBSTORE.PRODUCT_TYPE
  (
    NAME ASC
  )
  TABLESPACE APEX_4800922068347633 LOGGING ;
CREATE UNIQUE INDEX WEBSTORE.PRODUCT_TYPE_PK ON WEBSTORE.PRODUCT_TYPE
  (
    ID ASC
  )
  TABLESPACE APEX_4800922068347633 LOGGING ;
ALTER TABLE WEBSTORE.PRODUCT_TYPE ADD CONSTRAINT PRODUCT_TYPE_PK PRIMARY KEY ( ID ) USING INDEX WEBSTORE.PRODUCT_TYPE_PK ;
ALTER TABLE WEBSTORE.PRODUCT_TYPE ADD CONSTRAINT PRODUCT_TYPE_NAME_UNIQUE UNIQUE ( NAME ) USING INDEX WEBSTORE.PRODUCT_TYPE_NAME_UNIQUE ;


CREATE TABLE WEBSTORE.PRODUCT_TYPE_JN
 (JN_OPERATION CHAR(3) NOT NULL
 ,JN_ORACLE_USER VARCHAR2(30) NOT NULL
 ,JN_DATETIME DATE NOT NULL
 ,JN_NOTES VARCHAR2(240)
 ,JN_APPLN VARCHAR2(35)
 ,JN_SESSION NUMBER(38)
 ,ID NUMBER NOT NULL
 ,NAME VARCHAR2 (50 BYTE)
 );

CREATE OR REPLACE TRIGGER WEBSTORE.PRODUCT_TYPE_JNtrg
  AFTER 
  INSERT OR 
  UPDATE OR 
  DELETE ON WEBSTORE.PRODUCT_TYPE for each row 
 Declare 
  rec WEBSTORE.PRODUCT_TYPE_JN%ROWTYPE; 
  blank WEBSTORE.PRODUCT_TYPE_JN%ROWTYPE; 
  BEGIN 
    rec := blank; 
    IF INSERTING OR UPDATING THEN 
      rec.ID := :NEW.ID; 
      rec.NAME := :NEW.NAME; 
      rec.JN_DATETIME := SYSDATE; 
      rec.JN_ORACLE_USER := SYS_CONTEXT ('USERENV', 'SESSION_USER'); 
      rec.JN_APPLN := SYS_CONTEXT ('USERENV', 'MODULE'); 
      rec.JN_SESSION := SYS_CONTEXT ('USERENV', 'SESSIONID'); 
      IF INSERTING THEN 
        rec.JN_OPERATION := 'INS'; 
      ELSIF UPDATING THEN 
        rec.JN_OPERATION := 'UPD'; 
      END IF; 
    ELSIF DELETING THEN 
      rec.ID := :OLD.ID; 
      rec.NAME := :OLD.NAME; 
      rec.JN_DATETIME := SYSDATE; 
      rec.JN_ORACLE_USER := SYS_CONTEXT ('USERENV', 'SESSION_USER'); 
      rec.JN_APPLN := SYS_CONTEXT ('USERENV', 'MODULE'); 
      rec.JN_SESSION := SYS_CONTEXT ('USERENV', 'SESSIONID'); 
      rec.JN_OPERATION := 'DEL'; 
    END IF; 
    INSERT into WEBSTORE.PRODUCT_TYPE_JN VALUES rec; 
  END; 
  /
CREATE TABLE WEBSTORE.ROLES
  (
    ID   NUMBER NOT NULL ,
    ROLE VARCHAR2 (50 BYTE)
  )
  TABLESPACE APEX_4800922068347633 LOGGING ;
CREATE UNIQUE INDEX WEBSTORE.ROLES_PK ON WEBSTORE.ROLES
  (
    ID ASC
  )
  TABLESPACE APEX_4800922068347633 LOGGING ;
ALTER TABLE WEBSTORE.ROLES ADD CONSTRAINT ROLES_PK PRIMARY KEY ( ID ) USING INDEX WEBSTORE.ROLES_PK ;


CREATE TABLE WEBSTORE.ROLES_JN
 (JN_OPERATION CHAR(3) NOT NULL
 ,JN_ORACLE_USER VARCHAR2(30) NOT NULL
 ,JN_DATETIME DATE NOT NULL
 ,JN_NOTES VARCHAR2(240)
 ,JN_APPLN VARCHAR2(35)
 ,JN_SESSION NUMBER(38)
 ,ID NUMBER NOT NULL
 ,ROLE VARCHAR2 (50 BYTE)
 );

CREATE OR REPLACE TRIGGER WEBSTORE.ROLES_JNtrg
  AFTER 
  INSERT OR 
  UPDATE OR 
  DELETE ON WEBSTORE.ROLES for each row 
 Declare 
  rec WEBSTORE.ROLES_JN%ROWTYPE; 
  blank WEBSTORE.ROLES_JN%ROWTYPE; 
  BEGIN 
    rec := blank; 
    IF INSERTING OR UPDATING THEN 
      rec.ID := :NEW.ID; 
      rec.ROLE := :NEW.ROLE; 
      rec.JN_DATETIME := SYSDATE; 
      rec.JN_ORACLE_USER := SYS_CONTEXT ('USERENV', 'SESSION_USER'); 
      rec.JN_APPLN := SYS_CONTEXT ('USERENV', 'MODULE'); 
      rec.JN_SESSION := SYS_CONTEXT ('USERENV', 'SESSIONID'); 
      IF INSERTING THEN 
        rec.JN_OPERATION := 'INS'; 
      ELSIF UPDATING THEN 
        rec.JN_OPERATION := 'UPD'; 
      END IF; 
    ELSIF DELETING THEN 
      rec.ID := :OLD.ID; 
      rec.ROLE := :OLD.ROLE; 
      rec.JN_DATETIME := SYSDATE; 
      rec.JN_ORACLE_USER := SYS_CONTEXT ('USERENV', 'SESSION_USER'); 
      rec.JN_APPLN := SYS_CONTEXT ('USERENV', 'MODULE'); 
      rec.JN_SESSION := SYS_CONTEXT ('USERENV', 'SESSIONID'); 
      rec.JN_OPERATION := 'DEL'; 
    END IF; 
    INSERT into WEBSTORE.ROLES_JN VALUES rec; 
  END; 
  /
CREATE TABLE WEBSTORE.USERS
  (
    ID       NUMBER NOT NULL ,
    USERNAME VARCHAR2 (20 BYTE) ,
    PASSWORD VARCHAR2 (100 BYTE) ,
    STATUS   VARCHAR2 (20 BYTE)
  )
  TABLESPACE APEX_4800922068347633 LOGGING ;
CREATE UNIQUE INDEX WEBSTORE.USERS_PK ON WEBSTORE.USERS
  (
    ID ASC
  )
  TABLESPACE APEX_4800922068347633 LOGGING ;
ALTER TABLE WEBSTORE.USERS ADD CONSTRAINT USERS_PK PRIMARY KEY ( ID ) USING INDEX WEBSTORE.USERS_PK ;


CREATE TABLE WEBSTORE.USERS_JN
 (JN_OPERATION CHAR(3) NOT NULL
 ,JN_ORACLE_USER VARCHAR2(30) NOT NULL
 ,JN_DATETIME DATE NOT NULL
 ,JN_NOTES VARCHAR2(240)
 ,JN_APPLN VARCHAR2(35)
 ,JN_SESSION NUMBER(38)
 ,ID NUMBER NOT NULL
 ,USERNAME VARCHAR2 (20 BYTE)
 ,PASSWORD VARCHAR2 (100 BYTE)
 ,STATUS VARCHAR2 (20 BYTE)
 );

CREATE OR REPLACE TRIGGER WEBSTORE.USERS_JNtrg
  AFTER 
  INSERT OR 
  UPDATE OR 
  DELETE ON WEBSTORE.USERS for each row 
 Declare 
  rec WEBSTORE.USERS_JN%ROWTYPE; 
  blank WEBSTORE.USERS_JN%ROWTYPE; 
  BEGIN 
    rec := blank; 
    IF INSERTING OR UPDATING THEN 
      rec.ID := :NEW.ID; 
      rec.USERNAME := :NEW.USERNAME; 
      rec.PASSWORD := :NEW.PASSWORD; 
      rec.STATUS := :NEW.STATUS; 
      rec.JN_DATETIME := SYSDATE; 
      rec.JN_ORACLE_USER := SYS_CONTEXT ('USERENV', 'SESSION_USER'); 
      rec.JN_APPLN := SYS_CONTEXT ('USERENV', 'MODULE'); 
      rec.JN_SESSION := SYS_CONTEXT ('USERENV', 'SESSIONID'); 
      IF INSERTING THEN 
        rec.JN_OPERATION := 'INS'; 
      ELSIF UPDATING THEN 
        rec.JN_OPERATION := 'UPD'; 
      END IF; 
    ELSIF DELETING THEN 
      rec.ID := :OLD.ID; 
      rec.USERNAME := :OLD.USERNAME; 
      rec.PASSWORD := :OLD.PASSWORD; 
      rec.STATUS := :OLD.STATUS; 
      rec.JN_DATETIME := SYSDATE; 
      rec.JN_ORACLE_USER := SYS_CONTEXT ('USERENV', 'SESSION_USER'); 
      rec.JN_APPLN := SYS_CONTEXT ('USERENV', 'MODULE'); 
      rec.JN_SESSION := SYS_CONTEXT ('USERENV', 'SESSIONID'); 
      rec.JN_OPERATION := 'DEL'; 
    END IF; 
    INSERT into WEBSTORE.USERS_JN VALUES rec; 
  END; 
  /
CREATE TABLE WEBSTORE.USER_CUSTOMERS
  (
    USER_ID     NUMBER ,
    CUSTOMER_ID NUMBER
  )
  TABLESPACE APEX_4800922068347633 LOGGING ;


CREATE TABLE WEBSTORE.USER_CUSTOMERS_JN
 (JN_OPERATION CHAR(3) NOT NULL
 ,JN_ORACLE_USER VARCHAR2(30) NOT NULL
 ,JN_DATETIME DATE NOT NULL
 ,JN_NOTES VARCHAR2(240)
 ,JN_APPLN VARCHAR2(35)
 ,JN_SESSION NUMBER(38)
 ,USER_ID NUMBER
 ,CUSTOMER_ID NUMBER
 );

CREATE OR REPLACE TRIGGER WEBSTORE.USER_CUSTOMERS_JNtrg
  AFTER 
  INSERT OR 
  UPDATE OR 
  DELETE ON WEBSTORE.USER_CUSTOMERS for each row 
 Declare 
  rec WEBSTORE.USER_CUSTOMERS_JN%ROWTYPE; 
  blank WEBSTORE.USER_CUSTOMERS_JN%ROWTYPE; 
  BEGIN 
    rec := blank; 
    IF INSERTING OR UPDATING THEN 
      rec.USER_ID := :NEW.USER_ID; 
      rec.CUSTOMER_ID := :NEW.CUSTOMER_ID; 
      rec.JN_DATETIME := SYSDATE; 
      rec.JN_ORACLE_USER := SYS_CONTEXT ('USERENV', 'SESSION_USER'); 
      rec.JN_APPLN := SYS_CONTEXT ('USERENV', 'MODULE'); 
      rec.JN_SESSION := SYS_CONTEXT ('USERENV', 'SESSIONID'); 
      IF INSERTING THEN 
        rec.JN_OPERATION := 'INS'; 
      ELSIF UPDATING THEN 
        rec.JN_OPERATION := 'UPD'; 
      END IF; 
    ELSIF DELETING THEN 
      rec.USER_ID := :OLD.USER_ID; 
      rec.CUSTOMER_ID := :OLD.CUSTOMER_ID; 
      rec.JN_DATETIME := SYSDATE; 
      rec.JN_ORACLE_USER := SYS_CONTEXT ('USERENV', 'SESSION_USER'); 
      rec.JN_APPLN := SYS_CONTEXT ('USERENV', 'MODULE'); 
      rec.JN_SESSION := SYS_CONTEXT ('USERENV', 'SESSIONID'); 
      rec.JN_OPERATION := 'DEL'; 
    END IF; 
    INSERT into WEBSTORE.USER_CUSTOMERS_JN VALUES rec; 
  END; 
  /
CREATE TABLE WEBSTORE.USER_ROLES
  (
    USER_ID NUMBER ,
    ROLE_ID NUMBER
  )
  TABLESPACE APEX_4800922068347633 LOGGING ;


CREATE TABLE WEBSTORE.USER_ROLES_JN
 (JN_OPERATION CHAR(3) NOT NULL
 ,JN_ORACLE_USER VARCHAR2(30) NOT NULL
 ,JN_DATETIME DATE NOT NULL
 ,JN_NOTES VARCHAR2(240)
 ,JN_APPLN VARCHAR2(35)
 ,JN_SESSION NUMBER(38)
 ,USER_ID NUMBER
 ,ROLE_ID NUMBER
 );

CREATE OR REPLACE TRIGGER WEBSTORE.USER_ROLES_JNtrg
  AFTER 
  INSERT OR 
  UPDATE OR 
  DELETE ON WEBSTORE.USER_ROLES for each row 
 Declare 
  rec WEBSTORE.USER_ROLES_JN%ROWTYPE; 
  blank WEBSTORE.USER_ROLES_JN%ROWTYPE; 
  BEGIN 
    rec := blank; 
    IF INSERTING OR UPDATING THEN 
      rec.USER_ID := :NEW.USER_ID; 
      rec.ROLE_ID := :NEW.ROLE_ID; 
      rec.JN_DATETIME := SYSDATE; 
      rec.JN_ORACLE_USER := SYS_CONTEXT ('USERENV', 'SESSION_USER'); 
      rec.JN_APPLN := SYS_CONTEXT ('USERENV', 'MODULE'); 
      rec.JN_SESSION := SYS_CONTEXT ('USERENV', 'SESSIONID'); 
      IF INSERTING THEN 
        rec.JN_OPERATION := 'INS'; 
      ELSIF UPDATING THEN 
        rec.JN_OPERATION := 'UPD'; 
      END IF; 
    ELSIF DELETING THEN 
      rec.USER_ID := :OLD.USER_ID; 
      rec.ROLE_ID := :OLD.ROLE_ID; 
      rec.JN_DATETIME := SYSDATE; 
      rec.JN_ORACLE_USER := SYS_CONTEXT ('USERENV', 'SESSION_USER'); 
      rec.JN_APPLN := SYS_CONTEXT ('USERENV', 'MODULE'); 
      rec.JN_SESSION := SYS_CONTEXT ('USERENV', 'SESSIONID'); 
      rec.JN_OPERATION := 'DEL'; 
    END IF; 
    INSERT into WEBSTORE.USER_ROLES_JN VALUES rec; 
  END; 
  /
ALTER TABLE WEBSTORE.USER_CUSTOMERS ADD CONSTRAINT CUSTOMERS_FK FOREIGN KEY ( CUSTOMER_ID ) REFERENCES WEBSTORE.CUSTOMERS ( ID ) NOT DEFERRABLE ;

ALTER TABLE WEBSTORE.ORDERS ADD CONSTRAINT CUSTOMER_FK FOREIGN KEY ( CUSTOMER ) REFERENCES WEBSTORE.CUSTOMERS ( ID ) NOT DEFERRABLE ;

ALTER TABLE WEBSTORE.PRODUCT_LIST ADD CONSTRAINT ORDER_FK FOREIGN KEY ( ORDER_ID ) REFERENCES WEBSTORE.ORDERS ( ID ) NOT DEFERRABLE ;

ALTER TABLE WEBSTORE.PRODUCT_LIST ADD CONSTRAINT PRODUCT_FK FOREIGN KEY ( PRODUCT_ID ) REFERENCES WEBSTORE.PRODUCTS ( ID ) NOT DEFERRABLE ;

ALTER TABLE WEBSTORE.PRODUCTS ADD CONSTRAINT PRODUCT_TYPE_FK FOREIGN KEY ( TYPE ) REFERENCES WEBSTORE.PRODUCT_TYPE ( ID ) NOT DEFERRABLE ;

ALTER TABLE WEBSTORE.USER_ROLES ADD CONSTRAINT ROLE_FK FOREIGN KEY ( ROLE_ID ) REFERENCES WEBSTORE.ROLES ( ID ) NOT DEFERRABLE ;

ALTER TABLE WEBSTORE.USER_CUSTOMERS ADD CONSTRAINT USER_FK FOREIGN KEY ( USER_ID ) REFERENCES WEBSTORE.USERS ( ID ) NOT DEFERRABLE ;

ALTER TABLE WEBSTORE.USER_ROLES ADD CONSTRAINT USER_FK2 FOREIGN KEY ( USER_ID ) REFERENCES WEBSTORE.USERS ( ID ) NOT DEFERRABLE ;


-- Oracle SQL Developer Data Modeler Summary Report: 
-- 
-- CREATE TABLE                             9
-- CREATE INDEX                             8
-- ALTER TABLE                             16
-- CREATE VIEW                              0
-- ALTER VIEW                               0
-- CREATE PACKAGE                           0
-- CREATE PACKAGE BODY                      0
-- CREATE PROCEDURE                         0
-- CREATE FUNCTION                          0
-- CREATE TRIGGER                           0
-- ALTER TRIGGER                            0
-- CREATE COLLECTION TYPE                   0
-- CREATE STRUCTURED TYPE                   0
-- CREATE STRUCTURED TYPE BODY              0
-- CREATE CLUSTER                           0
-- CREATE CONTEXT                           0
-- CREATE DATABASE                          0
-- CREATE DIMENSION                         0
-- CREATE DIRECTORY                         0
-- CREATE DISK GROUP                        0
-- CREATE ROLE                              0
-- CREATE ROLLBACK SEGMENT                  0
-- CREATE SEQUENCE                          0
-- CREATE MATERIALIZED VIEW                 0
-- CREATE SYNONYM                           0
-- CREATE TABLESPACE                        0
-- CREATE USER                              1
-- 
-- DROP TABLESPACE                          0
-- DROP DATABASE                            0
-- 
-- REDACTION POLICY                         0
-- 
-- ORDS DROP SCHEMA                         0
-- ORDS ENABLE SCHEMA                       0
-- ORDS ENABLE OBJECT                       0
-- 
-- ERRORS                                   0
-- WARNINGS                                 0
