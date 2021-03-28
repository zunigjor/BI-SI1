#!/bin/bash
#
# This is a shell script which installs the database for the TattooPro project.
# The script requiries root priviledges!
# The requirements for TattooPro are mysql-server-5.7 and Java to be installed!
###############################################################################
# Now follow used functions in this script.
#
# Check for root prviledges
check_root(){
	if [ "$EUID" -ne 0 ] 
	then
		echo "Please run as root." ;
		exit ;
	fi
}
# Check if mysql-server-5.7 is installed
check_mysql(){
	echo "Checking for mysql-server-5.7 ..." ;
	MYSQL_INSTALLED=$( dpkg-query -W -f='${Status}\n' mysql-server-5.7 | grep -o "installed" ) ; 
	if [ "$MYSQL_INSTALLED" = "installed" ] 
	then 
		echo "OK, MySQL is installed!" ;
	else 
		echo "MySQL is not installed, please install." ;
		echo "TIP: Try \"sudo apt-get install mysql-server-5.7\"" ;
		exit ;
	fi
}
# Check if java is isnalled.
check_java(){
	echo "Checking for Java ... " ;
	if [ -n `which java` ] 
	then
		echo "OK, Java installed!" ;
	else
		echo "Java not installed, please install." ;
		exit ;
	fi
}
# MYSQL database setup
mysql_setup(){
	echo "Setting up database ... " ;
	mysql -e "
		create database TattooPro ;
		create user 'springuser'@'%' identified by 'ThePassword' ;
		grant all on TattooPro.* to 'springuser'@'%' ;
	";
	if [ $? -ne 0 ] 
	then 
		echo "Error while setting up the database! Aborting..." ;
		exit;
	fi
	echo "OK, Database set up!" ;
	exit;
}
###############################################################################
# Now follows the main body of this script.
check_root
check_mysql
check_java
mysql_setup

