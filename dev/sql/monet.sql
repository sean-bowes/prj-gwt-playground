drop table IF EXISTS user;

CREATE TABLE user (
userId INT NOT NULL AUTO_INCREMENT,
login VARCHAR(80) NOT NULL,
password CHAR(40) NOT NULL,
email VARCHAR(80) NOT NULL,
displayName VARCHAR(50) NOT NULL,
role char(1) NULL,
firstName VARCHAR(25) NULL,
lastName VARCHAR(25) NULL,
address VARCHAR(80) NULL,
city VARCHAR(30) NULL,
state CHAR(2) NULL,
postcode CHAR(10) NULL,
loginSid VARCHAR(100) NULL,
loginLast timestamp NULL,
enabled char(1) NULL,
PRIMARY KEY (userId),
UNIQUE INDEX (login),
UNIQUE INDEX (email)
) ENGINE=INNODB;

insert into user 
(login,password,email,displayName,firstName,lastName,enabled)
values
('admin','admin','admin@stoutstransportation.com','Admin','Admin','Admin','Y');

insert into user 
(login,password,email,displayName,enabled)
values
('vivian','vivian','vivian@stoutstransportation.com','Vivian','Y');

insert into user 
(login,password,email,displayName,enabled)
values
('harry','harry','harry@stoutstransportation.com','Harry','Y');

insert into user 
(login,password,email,displayName,enabled)
values
('sales','sales','sales@stoutstransportation.com','Sales','Y');

insert into user 
(login,password,email,displayName,enabled)
values
('manager','manager','manager@stoutstransportation.com','Manager','Y');

insert into user 
(login,password,email,displayName,enabled)
values
('user1','user1','user1@stoutstransportation.com','User1','Y');

insert into user 
(login,password,email,displayName,enabled)
values
('user2','user2','user2@stoutstransportation.com','User2','Y');

insert into user 
(login,password,email,displayName,enabled)
values
('user3','user3','user3@stoutstransportation.com','User3','Y');

insert into user 
(login,password,email,displayName,enabled)
values
('user4','user4','user4@stoutstransportation.com','User4','Y');

insert into user 
(login,password,email,displayName,enabled)
values
('user5','user5','user5@stoutstransportation.com','User5','Y');

select * from user;

drop table IF EXISTS customer;
CREATE TABLE customer (
CustomerId INT NOT NULL AUTO_INCREMENT,
ActiveStatus VARCHAR(10) NULL,
CustomerName VARCHAR(40) NULL,
Company VARCHAR(40) NULL,
Salutation VARCHAR(10) NULL,
FirstName VARCHAR(40) NULL,
MiddleName VARCHAR(40) NULL,
LastName VARCHAR(40) NULL,
Title VARCHAR(40) NULL,
CustomerType VARCHAR(40) NULL,
CustomerNotesId INT NULL,
AccountId INT NULL,
PRIMARY KEY (CustomerId),
INDEX (CustomerName),
INDEX (FirstName),
INDEX (LastName)
) ENGINE=INNODB;

drop table IF EXISTS address;
CREATE TABLE address (
AddressId INT NOT NULL AUTO_INCREMENT,
CustomerId INT NOT NULL,
ActiveStatus VARCHAR(10) NULL,
AddressType VARCHAR(20) NULL,
Street VARCHAR(200) NULL,
City VARCHAR(200) NULL,
State VARCHAR(2) NULL,
Zipcode VARCHAR(10) NULL,
AddressNotesId INT NULL,
PRIMARY KEY (AddressId),
INDEX (CustomerId)
) ENGINE=INNODB;

drop table IF EXISTS customerPatron;
CREATE TABLE customerPatron (
CustomerPatronId INT NOT NULL AUTO_INCREMENT,
ParentCustomerId INT NOT NULL,
ChildCustomerId INT NOT NULL,
ActiveStatus VARCHAR(10) NULL,
PRIMARY KEY (customerPatronId),
INDEX (ParentCustomerId),
INDEX (ChildCustomerId)
) ENGINE=INNODB;

drop table IF EXISTS salesRep;
CREATE TABLE salesRep (
SalesRepId INT NOT NULL AUTO_INCREMENT,
CustomerId INT NOT NULL,
ActiveStatus VARCHAR(10) NULL,
Salutation VARCHAR(10) NULL,
FirstName VARCHAR(40) NULL,
MiddleName VARCHAR(40) NULL,
LastName VARCHAR(40) NULL,
Title VARCHAR(40) NULL,
SalesRepType VARCHAR(40) NULL,
SalesRepNotesId INT NULL,
PRIMARY KEY (SalesRepId),
INDEX (CustomerId)
) ENGINE=INNODB;

drop table IF EXISTS notes;
CREATE TABLE notes (
notesId INT NOT NULL AUTO_INCREMENT,
NoteText TEXT,
PRIMARY KEY (notesId)
) ENGINE=INNODB;

drop table IF EXISTS customerBillable;
CREATE TABLE customerBillable (
customerBillableId INT NOT NULL AUTO_INCREMENT,
ParentCustomerId INT NOT NULL,
ChildCustomerId INT NOT NULL,
ActiveStatus VARCHAR(10) NULL,
PRIMARY KEY (customerBillableId),
INDEX (ParentCustomerId),
INDEX (ChildCustomerId)
) ENGINE=INNODB;

drop table IF EXISTS customerBookingAgent;
CREATE TABLE customerBookingAgent (
customerBookingAgentId INT NOT NULL AUTO_INCREMENT,
ParentCustomerId INT NOT NULL,
ChildCustomerId INT NOT NULL,
ActiveStatus VARCHAR(10) NULL,
PRIMARY KEY (customerBookingAgentId),
INDEX (ParentCustomerId),
INDEX (ChildCustomerId)
) ENGINE=INNODB;

drop table IF EXISTS zipCode;
CREATE TABLE zipCode (
ZipCodeId INT NOT NULL AUTO_INCREMENT,
ZipCode char(5),
PrimaryRecord char(1),
Population int,
HouseholdsPerZipcode int,
WhitePopulation int,
BlackPopulation int,
HispanicPopulation int,
AsianPopulation int,
HawaiianPopulation int,
IndianPopulation int,
OtherPopulation int,
MalePopulation int,
FemalePopulation int,
PersonsPerHousehold decimal(4, 2),
AverageHouseValue int,
IncomePerHousehold int,
Latitude decimal(12, 6),
Longitude decimal(12, 6),
Elevation int,
State char(2),
StateFullName varchar(35),
CityType char(1),
CityAliasAbbreviation varchar(13),
AreaCode varchar(55),
City varchar(35),
CityAliasName varchar(35),
County varchar(45),
CountyFIPS char(5),
StateFIPS char(2),
TimeZone char(2),
DayLightSaving char(1),
MSA varchar(35),
PMSA char(4),
CSA char(3),
CBSA char(5),
CBSA_DIV char(5),
CBSA_Type char(5),
CBSA_Name varchar(150),
MSA_Name varchar(150),
PMSA_Name varchar(150),
Region varchar(10),
Division varchar(20),
MailingName char(1),
PreferredLastLineKey varchar(10),
ClassificationCode char(1),
MultiCounty char(1),
CSAName varchar(255),
CBSA_Div_Name varchar(255),
CityStateKey char(6),
CityAliasCode varchar(5),
CityMixedCase varchar(35),
CityAliasMixedCase varchar(35),
StateANSI varchar(2),
CountyANSI varchar(3),
FacilityCode varchar(1),
CityDeliveryIndicator varchar(1),
CarrierRouteRateSortation varchar(1),
FinanceNumber varchar(6),
UniqueZIPName varchar(1),
PRIMARY KEY (ZipCodeId),
INDEX (ZipCode),
INDEX (PrimaryRecord),
INDEX (City),
INDEX (State)
) ENGINE=INNODB;




