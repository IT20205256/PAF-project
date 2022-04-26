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
