This is a prototype which implements an hierarchy of actions classes

Terminology:
Macro - group of actions executed together
Action - action executed individually or as part of a macro set of actions (retweet a tweet, adding a comment, etc.)

There are 2 types of action classes:
1. JPA Entities classes:  MacroEntity and ActionEntity, used to store/retrieve data from the database
2. Actions executors: Macro and Action, with Facebook/Twitter specialisations 

Please run MacroTest.java to study "EngageActionPrototype" functionality
 
Technical details:
1. Install steps:
- run mvn clean install
- run mvn eclipse:eclipse
- import project into eclipse
- run MacroTest.java as Junit


2. EngageActionPrototype uses a database connection configured in persistence.xml file.
To create your own database on Azure SQL Server, the following table generation instructions can be used.

SET ANSI_NULLS ON;
GO
SET QUOTED_IDENTIFIER ON;
GO

/****** Object: Table [dbo].[action]   Script Date: 5/28/2014 12:08:55 PM ******/
CREATE TABLE [dbo].[action] (
[id] int IDENTITY(1, 1) NOT NULL,
[operation] varchar(45) NULL,
[params] varchar(200) NULL);
GO


/****** Object: Table [dbo].[macro]   Script Date: 5/28/2014 12:09:21 PM ******/
CREATE TABLE [dbo].[macro] (
[id] int IDENTITY(1, 1) NOT NULL,
[name] varchar(45) NULL);
GO


/****** Object: Table [dbo].[macro_has_action]   Script Date: 5/28/2014 12:09:45 PM ******/
CREATE TABLE [dbo].[macro_has_action] (
[macro_id] int NOT NULL,
[action_id] int NOT NULL);
GO