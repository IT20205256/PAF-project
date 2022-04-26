/*****************PAYMENT SERVICE***********/
/*DROP TABLE IF EXISTS*/
DROP TABLE IF EXISTS payments;
/*CREATE TABLE FOR PAYMENTS*/
CREATE TABLE payments (
ID integer auto_increment primary key,
account varchar(10),
bill_no varchar(200),
name varchar(100),
amount_required decimal(10,2),
amount_paying decimal(10,2),
amount_due decimal(10,2),
date TIMESTAMP DEFAULT now()
);
/*INSERT INTO TABLE PAYMENTS*/
insert into payments values (0, '20228450', '200009', 'P.M. Mendis', 2500.00, 2000.00, 500.00, now());
insert into payments values (0, '20228451', '2000010','R.A. Perera', '1500.00', '1500.00', '0.00', now());
insert into payments values (0, '20228452', '2000011','N.M. Silva', '3000.00', '2800.00', '200.00', now());
insert into payments values (0, '20228453', '2000012','H.S. Costa', '3500.00', '3000.00', '500.00', now());

/*****************PAYMENT METHOD SERVICE*********/
/*DROP TABLE IF EXISTS*/
DROP TABLE IF EXISTS paymentMethod;
/*CREATE TABLE FOR PAYMENTS METHODS*/
CREATE TABLE paymentMethod (
ID integer auto_increment primary key,
EaccontNo varchar(10),
cardHolderName varchar(200),
paymentType varchar(100),
nameOnCard varchar(45),
cardNumber varchar(16),
expDate varchar(45),
cvv varchar(45)
);
/*INSERT INTO TABLE PAYMENT METHOD TABLE*/
insert into payment.paymentMethod values (0, '20228450', 'P.M. Mendis', 'Credit Card', 'BOC', '4562789547852365', '05/24', '123');
insert into payment.paymentMethod values (0, '20228451', 'R.A. Perera', 'Debit Card', 'Commercial', '4562788654852365', '06/23', '456');
insert into payment.paymentMethod values (0, '20228452', 'N.M. Silva', 'Credit Card', 'NSB', '4562789541452365', '07/25', '789');
insert into payment.paymentMethod values (0, '20228453', 'H.S. Costa', 'Debit Card', 'HNB', '4562789789542365', '08/23', '159');


--
-- Table structure for table `consumer_details`
--

/*DROP TABLE IF EXISTS*/
DROP TABLE IF EXISTS consumer_details;

/*CREATE TABLE FOR consumer_details*/
CREATE TABLE consumer_details (
  account_no int NOT NULL AUTO_INCREMENT,
  name varchar(45) DEFAULT NULL,
  address varchar(45) DEFAULT NULL,
  phone varchar(10) DEFAULT NULL,
  email varchar(45) DEFAULT NULL,
  username varchar(45) DEFAULT NULL,
  password varchar(45) DEFAULT NULL,
  PRIMARY KEY (account_no)
)AUTO_INCREMENT=20228539;

/*INSERT INTO `consumer_details` TABLE */
insert into consumer_details  values (0,'R.M.Rajapaksha','Battaramulla','0754862591','nethma@gmail.com','IT0310','Nethma@99');
insert into consumer_details  values (0,'N.S.Senarathne','Koswatta','0786745345','navodya@gmail.com','DS0309','Navodya@94');
insert into consumer_details  values (0,'W.D.Withanage','Kadhana','0767890246','udeshi@gmail.com','SE0405','Udeshi@96');
insert into consumer_details  values (0,'P.W.Perera','Battaramulla','0754862591','saduni@gmail.com','IT1012','Saduni@20');


--
-- Table structure for table `login`
--

/*DROP TABLE IF EXISTS*/
DROP TABLE IF EXISTS login;

/*CREATE TABLE FOR login*/
CREATE TABLE login (
  account_no int NOT NULL,
  username varchar(45) DEFAULT NULL,
  password varchar(45) DEFAULT NULL,
  email varchar(45) DEFAULT NULL,
  PRIMARY KEY (account_no)
);

/*INSERT INTO login TABLE*/
INSERT INTO login VALUES (20228540,'IT0310','Nethma@99','nethma@gmail.com');
INSERT INTO login VALUES (20228541,'DS0309','Navodya@94','navodya@gmail.com');
INSERT INTO login VALUES (20228542,'SE0405','Udeshi@96','udeshi@gmail.com');
INSERT INTO login VALUES (20228543,'IT1012','Saduni@20','saduni@gmail.com');

