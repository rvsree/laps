CREATE TABLE Lead
(
	customerId VARCHAR(10) PRIMARY KEY,
	firstName VARCHAR(255) NOT NULL,
	lastName VARCHAR(255) NOT NULL,
	applicationStatus VARCHAR(20) NULL,
	processingComments VARCHAR(255) NULL
);

CREATE TABLE CreditInfo
(
	creditInfoId INT PRIMARY KEY,
	customerId VARCHAR(10) NOT NULL,
	salary decimal NOT NULL,
	creditScore INT NOT NULL,
	loanAmount decimal NOT NULL
);