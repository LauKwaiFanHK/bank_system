CONTENTS OF THIS FILE
---------------------
* Introduction
* Requirements
* Installation
* Authors

Introduction
------------
This project is a simple command-line bank system that offers bank functions. A standard version and a professional version were made available for users. 

Users using standard version are able to:
* login with designated name
* create one or more bank account
* deposit an amount of money to an account
* view the balance of an account
* withdraw an amount of money from an account
* transfer money from one account to another account of the same account owner
* transfer money to another account owner

Users using professional version are able to use the following additional functions:
* request for granting credit from the bank
* repay the granted credit to the bank
* view the amount of interest being deducted from the bank account

Administrator of the bank system can:
* View the total interest being deducted from all professional bank user who are granted with credit

Requirement
-----------
No modules or packages outside the project are required. 

Installation
------------
* To use this bank system, clone the project and execute the project in an IDE: https://github.com/LauKwaiFanHK/bank_system.git

* A Jenkinsfile for building a continuous integration pipeline is included. To run the pipeline and obtain the generated zip files, zip and jq are required. To download these packages, you may execute the following commands:

	apt-get install zip

	apt-get install jq


Authors
-------

Organization: 
* Technische Hochschule Brandenburg

Contributors:
* Kanstantsin Liakh
* Jan Szataniak
* Consuelo Alberca Susano
* Lau Kwai Fan
