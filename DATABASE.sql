CREATE DATABASE PChecker;
USE PChecker;


CREATE TABLE Part(
PartID INT NOT NULL AUTO_INCREMENT,
Price NUMERIC(6,2),
Model VARCHAR(45) NOT NULL,
Make VARCHAR(45) NOT NULL,
PartType VARCHAR(30),

PRIMARY KEY (PartID)
);

CREATE TABLE Compatibility(
Part1 INT NOT NULL,
Part2 INT NOT NULL,
Comp BOOLEAN,
CompNumber NUMERIC(3),

PRIMARY KEY(Part1,Part2)
);

CREATE TABLE CPU(
ID INT NOT NULL,
Speed NUMERIC(4,2),
Cores INT(2),
Graphics BOOLEAN,

PRIMARY KEY (ID),
FOREIGN KEY(ID) REFERENCES Part(PartID)
);

CREATE TABLE Motherboard(
ID INT NOT NULL,
Socket VARCHAR(45) NOT NULL,
Form_Factor VARCHAR(20),
RAM_Slots INT(1),
Max_RAM int(3),

PRIMARY KEY (ID),
FOREIGN KEY(ID) REFERENCES Part(PartID)
);

CREATE TABLE RAM(
ID INT NOT NULL ,
Speed CHAR(4),
SizeGB INT(2) NOT NULL,
Sticks INT(1),


PRIMARY KEY(ID),
FOREIGN KEY(ID) REFERENCES Part(PartID)
);

CREATE TABLE Storage(
ID INT NOT NULL ,
Series VARCHAR(45),
HHD BOOLEAN NOT NULL,
Speed INT(4),
CapacityGB INT,

PRIMARY KEY(ID),
FOREIGN KEY(ID) REFERENCES Part(PartID)
);

CREATE TABLE GPU(
ID INT NOT NULL,
Series VARCHAR(45),
Chipset VARCHAR(100),
Memory INT(2),
CoreClock NUMERIC(3,2),

PRIMARY KEY(ID),
FOREIGN KEY(ID) REFERENCES Part(PartID)
);

CREATE TABLE PSU(
ID INT NOT NULL,
Wattage INT,
Modular BOOLEAN,

PRIMARY KEY(ID),
FOREIGN KEY(ID) REFERENCES Part(PartID)
);

CREATE TABLE PCCase(
ID INT NOT NULL,
Height INT(3),
Width INT(3),
Depth INT(3),
Colour VARCHAR(40),

PRIMARY KEY(ID),
FOREIGN KEY(ID) REFERENCES Part(PartID)
);

CREATE TABLE Cooler(
ID INT NOT NULL,
MinRPM INT(4),
MaxRPM INT(4) NOT NULL,

PRIMARY KEY(ID),
FOREIGN KEY(ID) REFERENCES Part(PartID)
);

CREATE TABLE Accessory(
ID INT NOT NULL,
Description VARCHAR(200),
PRIMARY KEY(ID),
FOREIGN KEY(ID) REFERENCES Part(PartID)
);

CREATE TABLE Account(
userName VARCHAR(45) NOT NULL,
Password VARCHAR(45) NOT NULL,
Fname VARCHAR(50) NOT NULL,
Sname VARCHAR(50) NOT NULL,
Email VARCHAR(60) UNIQUE NOT NULL,
MobilNum VARCHAR(11) UNIQUE NOT NULL,
DOB VARCHAR(10) NOT NULL,
accountType BOOLEAN NOT NULL,
PRIMARY KEY(userName)

);


INSERT INTO Account VALUES ('admin','admin','Admin','Admin','admin@gmail.co.uk','012345678910','10/10/1990',TRUE);
INSERT INTO Account VALUES ('user','user','User','User','user@gmail.co.uk','012367878910','01/01/1995',False);


CREATE TABLE Build(
ID INT AUTO_INCREMENT NOT NULL,
BuildName VARCHAR(45) NOT NULL,
Account VARCHAR(45) NOT NULL,
Motherboard INT NOT NULL,
CPU INT NOT NULL,
RAM INT NOT NULL,
Storage INT NOT NULL,
GPU INT,
PSU INT NOT NULL,
PCCase INT NOT NULL,
Cooler INT,
Accessory INT,
systemCompRating INT,
PRIMARY KEY (ID,Account),
FOREIGN KEY (Motherboard) REFERENCES Motherboard(ID),
FOREIGN KEY (CPU) REFERENCES CPU(ID),
FOREIGN KEY (RAM) REFERENCES RAM(ID),
FOREIGN KEY (Storage) REFERENCES Storage(ID),
FOREIGN KEY (GPU) REFERENCES GPU(ID),
FOREIGN KEY (PSU) REFERENCES PSU(ID),
FOREIGN KEY (PCCase) REFERENCES PCCase(ID),
FOREIGN KEY (Cooler) REFERENCES Cooler(ID),
FOREIGN KEY (Accessory) REFERENCES Accessory(ID)
);