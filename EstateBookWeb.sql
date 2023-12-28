create database [EstateBookWeb]
go

create database [EstateBookWeb]
go

use [EstateBookWeb]
go

 
 
 

 CREATE TABLE [dbo].[User]
(
    [ID_User] int not null identity(1,1),
    [Name] varchar(50) not null,
    [Surname] varchar(50) not null,
    [Middle_Name] varchar(50) null,
    [Login] varchar(50) not null,
    [Password] varchar(255) not null,
    [Avatar] varchar(max) null,
    [Phone] varchar(20) null,
    [Location] varchar(300) null,
    [Description] varchar(max) null,
    [Average_Mark] float null,
    [Registration_Date] datetime not null,
    Constraint [PK_User] Primary Key([ID_User])
);
go
 


--INSERT INTO [dbo].[User] (
--    [Login],
--    [Password]
--)
--VALUES (
--    'anna',
--    '������123'
--),
--(
--    'peter',
--    '������456'
--),
--(
--    'test',
--    '$2y$10$NmrOO8LQW2FF6TUu.wj0H.wigt3NYRZs9BWq1WYxWckH5n5pS9r.W'
--)
--go

SELECT * FROM [dbo].[Estate] WHERE Ad_Name LIKE '1'	
go
 
SELECT * FROM [dbo].[estate_users]
go

SELECT * FROM [dbo].[Estate]
go
SELECT * FROM [dbo].[role]
go
 SELECT * FROM [dbo].[Tag]
go
	
create  table [dbo].[Estate]
(
[ID_Estate] int not null identity(1,1),
[Ad_Name] varchar(100) not null,
[Location] varchar(300) not null,
[Price] int not null,
[Price_For_Month] int not null,
[Mortgage_Price] int not null,
[Area] int not null,
[House_Area] int not null,
[Metro_Station] varchar(70) null,
[Train_Station] varchar(1000) not null,
[Description] varchar(1000) not null,
 [Ad_Date] datetime not null,
 [Building_Date] date not null,	
[Status] varchar(70) not null,
[Estate_Rating] int  null, 
 
[User_ID] int not null,
Constraint [PK_Estate] Primary Key([ID_Estate]),
 
constraint [FK_Estate_User] foreign key ([User_ID])  
references [dbo].[User] ([ID_User]),
)
go
 BACKUP DATABASE [ ] TO DISK='{@"C:\Users\Honor\source\repos\Admin_Estate_Book\Backups\MyDatabaseBackup.bak"}'

--INSERT INTO [dbo].[Estate] (
--    [Ad_Name],
--    [Location],
--    [Price],
--    [Price_For_Month],
--    [Mortgage_Price],
--    [Area],
--    [House_Area],
--    [Metro_Station],
--    [Train_Station],
--    [Description],
--    --[Ad_Date],
--    --[Building_Date],
--    [Status],
--    [Estate_Rating],
--    [Estate_Images_ID]
--)
--VALUES (
--    N'������ �������� � ����',
--    N'������, ����������� �����',
--    2500000,
--    50000,  -- Corrected the data type to int
--    1200000,
--    100,
--    70,
--    N'������� ����� "�����������"',
--    N'��������� ������� ������ "�����������"',
--    N'���������� � ������� �������� � ����� �� ����.',
--    '2023-09-04 08:11:11',
--    '2020-01-01',
--    N'�������',
--    5,
--    1
--),
--(
--    N'��� � �����',
--    N'�����-���������, ������������ �����',
--    3500000,
--    60000,  -- Corrected the data type to int
--    2000000,
--    200,
--    150,
--    N'��������� ������� ����� "������������"',
--    N'��������� ������� ������ "������������"',
--    N'������ ��� � ������� ����� � �������.',
--    '2023-09-05',
--    '2019-02-01',
--    N'�������',
--    4,
--    2
--),
--(
--    N'����� ������� �������� �������� ����� ������ ��� �� ��� ����� ����� �������� ������������',
--    N'�����-���������, ������������ �����',
--    3500000,
--    60000,  -- Corrected the data type to int
--    2000000,
--    200,
--    150,
--    N'��������� ������� ����� "������������"',
--    N'��������� ������� ������ "������������"',
--    N'������ ��� � ������� ����� � �������.',
--    '2023-09-05',
--    '2019-02-01',
--    N'�������',
--    4,
--    2
--)
--go


select * from [dbo].[Estate]
GO
 
 select * from [dbo].[Estate] order by [ID_Estate] offset 0 Rows fetch next 1 rows only


--INSERT INTO [dbo].[User] (
--    [Name],
--    [Surname],
--    [Middle_Name],
--    [Login],
--    [Password],
--    [Avatar],
--    [Phone],
--    [Location],
--    [Description],
--    [Average_Mark]
--)
--VALUES (
--    N'����',
--    N'�������',
--    N'��������',
--    'anna',
--    '������123',
--    'url_�������_1',
--    '123456789',
--    N'������',
--    N'���������������� ����� �� ������������',
--    4.8
--),
--(
--    N'����',
--    N'�������',
--    N'��������',
--    'peter',
--    '������456',
--    'url_�������_2',
--    '987654321',
--    N'�����-���������',
--    N'������� �������',
--    4.5
--),
--(
--    N'����',
--    N'�������',
--    N'��������',
--    'test',
--    '$2y$10$NmrOO8LQW2FF6TUu.wj0H.wigt3NYRZs9BWq1WYxWckH5n5pS9r.W',
--    'url_�������_2',
--    '987654321',
--    N'�����-���������',
--    N'������� �������',
--    4.5
--) 
--go
	
select * from [User];
select * from [Estate];
select * from [role]
go;
create table [dbo].[Notification] (

	[ID_Notification] int not null identity(1,1),
	[Notification_Header] varchar (300) not null,
	[Notification_Text] varchar (300) not null,
	[Notification_Link] varchar(300) not null,
	[Notification_Flag] varchar(300) not null,
	--[Notification_Date] datetime not null,
	[User_ID] int null,
	 
	 constraint [PK_Notification] primary key clustered
	([ID_Notification] ASC) on [PRIMARY],
	constraint [FK_Notification_User] foreign key ([User_ID])
		references [dbo].[User] ([ID_User]),
 
)
go

--INSERT INTO [dbo].[Notification] (
--    [Notification_Header],
--    [Notification_Text],
--    [Notification_Link],
--    [Notification_Flag],
--    [Notification_Date],
--    [User_ID]
--)
--VALUES
--(
--    N'����� ���������� 1',
--    N'���������� ����� ���������� � ������� �������� � ������ ������.',
--    '/estate/1',
--    'unread',
--    '2023-09-08T08:33:33',
--    1
--),
--(
--    N'�������� ���� 1',
--    N'���� �� ��� ����� � ���������� ������� �� 10%!',
--    '/estate/3',
--    'unread',
--    '2023-09-09T08:33:33',
--    2
--),
--(
--    N'����� ���������� 2',
--    N'������ �������� � ������ ������.',
--    '/estate/4',
--    'unread',
--    '2023-09-08T08:33:33',
--   1
--),
--(
--    N'�������� ���� 2',
--    N'����������� �����������: ������ �� ��� � ������!',
--    '/estate/5',
--    'unread',
--    '2023-09-08T08:33:33',
--    1
--),
--(
--    N'����� ���������� 3',
--    N'�������� � ����� ����� ���������.',
--    '/estate/6',
--    'unread',
--    '2023-09-08T08:33:33',
--    1
--)
--go

create table [dbo].[User_Review](
[ID_User_Review] int not null identity(1,1),
[Review_Mark] int not null,
[Review_Text] varchar(300),
[Agency_Reciever_ID] int null,
[User_Reviewer_ID] int null,
[User_Reciever_ID] int null,
 constraint [PK_User_Review] primary key clustered
	([ID_User_Review] ASC) on [PRIMARY],
	constraint [FK_User_Reciever] foreign key ([User_Reciever_ID])
		references [dbo].[User] ([ID_User]),
	constraint [FK_User_Reviewer] foreign key ([User_Reviewer_ID])
		references [dbo].[User] ([ID_User]),	 

)
go

 

--INSERT INTO [dbo].[User_Review] (
--    [Review_Mark],
--    [Review_Text],
--    [Agency_Reciever_ID],
--    [User_Reviewer_ID],
--    [User_Reciever_ID]
--)
--VALUES
--(
--    5,
--    N'�������� �����, ������ �������� ����� ������ ��������.',
--    NULL,
--    2,
--    1
--),
--(
--    4,
--    N'������ ������ ������, �� ������� �����.',
--    NULL,
--    1,
--    2
--),
--(
--    5,
--    N'���������������� �������, ����������!',
--    NULL,
--    1,
--    1
--),
--(
--    4,
--    N'��� ������, �� ���� ����� �� ���� ����.',
--    NULL,
--    1,
--    1
--),
--(
--    5,
--    N'�������� ������������, ���������� ������!',
--    NULL,
--   1 ,
--    1
--);
--go


create table [dbo].[Chat] (
	[ID_Chat] int not null identity(1,1),
	[Message] varchar (300) not null,
	[Agency_ID] int not null,
	[User_ID] int not null,
	 [User2_ID] int not null,
	 constraint [PK_Chat] primary key clustered
	([ID_Chat] ASC) on [PRIMARY],
	constraint [FK_Chat_User1] foreign key ([User_ID])
		references [dbo].[User] ([ID_User]),
		constraint [FK_Chat_User2] foreign key ([User2_ID])
		references [dbo].[User] ([ID_User]),
		 
)
go
--INSERT INTO [dbo].[Chat] (
--    [Message],
--    [Agency_ID],
--    [User_ID],
--    [User2_ID]
--)
--VALUES
--(
--    N'������������! ���� ������ ������ � �������� 1.',
--    1,
--    1,
--    2
--),
--(
--    N'������ ����! ����� ���� �������� � ����� ������?',
--    1,
--    1,
--    1
--),
--(
--    N'������������! ���������� � ���� � ������.',
--    1,
--    1,
--   1
--),
--(
--    N'������ ����! ���� �� �������� � �������?',
--    1,
--    1,
--    1
--),
--(
--    N'������������! ���������� ��� �������� � ����� ���������.',
--    1,
--    1,
--    1
--);

create table [dbo].[Declined_Ad] (

	[ID_Declined_Ad] int not null identity(1,1),
	[Reason] varchar (300) not null,
	[Estate_ID] int not null,
	[Moderator_ID] int not null,
	   constraint [PK_Declined_Ad] primary key clustered
	([ID_Declined_Ad] ASC) on [PRIMARY],
	constraint [FK_Declined_Ad_Estate] foreign key ([Estate_ID])
		references [dbo].[Estate] ([ID_Estate]),  
)
go

--INSERT INTO [dbo].[Declined_Ad] (
--    [Reason],
--    [Estate_ID],
--    [Moderator_ID]
--)
--VALUES
--(
--    N'������������� ���������� � ���������� 1.',
--    1,
--    1
--),
--(
--    N'��������� ������ ���������� ���������� 1.',
--    1,
--    2
--),
--(
--    N'������������� ���������� � ���������� 2.',
--    1,
--    1
--),
--(
--    N'��������� ������ ���������� ���������� 2.',
--    1,
--    1
--),
--(
--    N'������������� ���������� � ���������� 3.',
--    1,
--    1
--);

create table [dbo].[Watch_Later_Estates]
(
[ID_Watch_Later_Estates] int not null identity(1,1),
	[Estate_ID] int not null,
	[User_ID] int not null,
	constraint [PK_Watch_Later_Estates] primary key clustered
	([ID_Watch_Later_Estates] ASC) on [PRIMARY],
	constraint [FK_Watch_Later_Estates_Estate] foreign key ([Estate_ID])
		references [dbo].[Estate] ([ID_Estate]),
		constraint [FK_Watch_Later_Estates_User] foreign key ([User_ID])
		references [dbo].[User] ([ID_User]),
)
go

--INSERT INTO [dbo].[Watch_Later_Estates] (
--    [Estate_ID],
--    [User_ID]
--)
--VALUES
--(
--    1,
--    1
--),
--(
--    1,
--    1
--),
--(
--    1,
--    1
--),
--(
--    1,
--    1
--),
--(
--    1,
--    1
--);

create table [dbo].[Favourite_Estates]
(
[ID_Favourite_Estates] int not null identity(1,1),
	[Estate_ID] int not null,
	[User_ID] int not null,
	constraint [PK_Favourite_Estates] primary key clustered
	([ID_Favourite_Estates] ASC) on [PRIMARY],
	constraint [FK_Favourite_Estates_Estate] foreign key ([Estate_ID])
		references [dbo].[Estate] ([ID_Estate]),
		constraint [FK_Favourite_Estates_User] foreign key ([User_ID])
		references [dbo].[User] ([ID_User]),
)
go

--INSERT INTO [dbo].[Favourite_Estates] (
--    [Estate_ID],
--    [User_ID]
--)
--VALUES
--(
--    1,
--    1
--),
--(
--    1,
--    1
--),
--(
--    1,
--    2
--),
--(
--    1,
--    1
--),
--(
--   1,
--    1
--);

create table [dbo].[Tag]
(
[ID_Tag] int not null identity(1,1),
	[Tag_Name] varchar(300) not null,
	constraint [PK_Tag] primary key clustered
	([ID_Tag] ASC) on [PRIMARY]
)
go

INSERT INTO [dbo].[Tag] (
    [Tag_Name]
)
VALUES
(
    N'������ � �����'
),
(
    N'� ��������'
),
(
    N'� ����� �� ����'
),
(
    N'������� �������'
),
(
    N'������ ��������'
)
go

create table [dbo].[Tag_And_Estate]
(
[ID_Tag_And_Estate] int not null identity(1,1),
	[Estate_ID] int not null,
	[Tag_ID] int not null,
	constraint [PK_Tag_And_Estate] primary key clustered
	([ID_Tag_And_Estate] ASC) on [PRIMARY],
	constraint [FK_Tag_And_Estate_Estate] foreign key ([Estate_ID])
		references [dbo].[Estate] ([ID_Estate]),
		constraint [FK_Tag_And_Estate_Tag] foreign key ([Tag_ID])
		references [dbo].[Tag] ([ID_Tag]),
)
go

--INSERT INTO [dbo].[Tag_And_Estate] (
--    [Estate_ID],
--    [Tag_ID]
--)
--VALUES
--(
--    1,
--    1
--),
--(
--    1,
--    2
--),
--(
--    1,
--    1
--),
--(
--    1,
--    1
--),
--(
--    1,
--    1
--);

create table [dbo].[User_History_Watched] (

	[ID_User_History_Watched] int not null identity(1,1),
	 
	[Estate_ID] int not null,
	[User_ID] int not null,
	 
	   constraint [PK_User_History_Watched] primary key clustered
	([ID_User_History_Watched] ASC) on [PRIMARY],
	constraint [FK_User_History_Watched_Estate] foreign key ([Estate_ID])	
		references [dbo].[Estate] ([ID_Estate]), 
		constraint [FK_User_History_Watched_User] foreign key ([User_ID])
		references [dbo].[User] ([ID_User]), 
	 
)
go



create procedure Add_To_User_History (
	@User_ID int,
	@Name VARCHAR(255) 

)
as 
begin 
	insert into [dbo].[User_History_Watched]([Estate_ID],[User_ID])
	values (@User_ID, @Name);
END;

select * from EstateView;
select * from [dbo].[User];


-- Create a view for Estate table
CREATE OR ALTER VIEW EstateView
AS
SELECT
    e.*,
    u.[Login] AS [User_Login],
    u.[Registration_Date] AS [User_Registration_Date]
FROM
    [dbo].[Estate] e
JOIN
    [dbo].[User] u ON e.[User_ID] = u.[ID_User];
GO
 
CREATE VIEW UserView
AS
SELECT [Login], [Password], [Avatar], [Registration_Date]
FROM [dbo].[User];
GO


select * from EstateView
go
select * from [dbo].[User]
go
-- Create a view for User table
CREATE VIEW UserView
AS
SELECT *
FROM [dbo].[User];
GO
 
-- Create a view for Notification table
CREATE VIEW NotificationView
AS
SELECT *
FROM [dbo].[Notification];
GO
-- Create a view for User_Review table
CREATE VIEW UserReviewView
AS
SELECT *
FROM [dbo].[User_Review];
GO
-- Create a view for Chat table
CREATE VIEW ChatView
AS
SELECT *
FROM [dbo].[Chat];
GO
-- Create a view for Declined_Ad table
CREATE VIEW DeclinedAdView
AS
SELECT *
FROM [dbo].[Declined_Ad];
GO
-- Create a view for Watch_Later_Estates table
CREATE VIEW WatchLaterEstatesView
AS
SELECT *
FROM [dbo].[Watch_Later_Estates];
GO
-- Create a view for Favourite_Estates table
CREATE VIEW FavouriteEstatesView
AS
SELECT *
FROM [dbo].[Favourite_Estates];
GO
-- Create a view for Tag table
CREATE VIEW TagView
AS
SELECT *
FROM [dbo].[Tag];
GO
-- Create a view for Tag_And_Estate table
CREATE VIEW TagAndEstateView
AS
SELECT *
FROM [dbo].[Tag_And_Estate];
GO
-- Create a view for User_History_Watched table
CREATE VIEW UserHistoryWatchedView
AS
SELECT *
FROM [dbo].[User_History_Watched];
GO

select * from [dbo].[User]
go
 
 select * from [dbo].[notification]
go
--c������� ������� � ��������
CREATE LOGIN [Admin_Estate] WITH PASSWORD = 'password';
CREATE LOGIN [User_Estate] WITH PASSWORD = 'password2';
--c������� �������������
CREATE USER [Admin_Estate] FOR LOGIN [Admin_Estate];
CREATE USER [User_Estate] FOR LOGIN [User_Estate];
--������ ���� �� ������ ������������
GRANT SELECT ON [dbo].[UserReviewView] TO [User_Estate];
GRANT SELECT ON [dbo].[ChatView] TO [User_Estate];
GRANT SELECT ON [dbo].[DeclinedAdView] TO [User_Estate];
GRANT SELECT ON [dbo].[WatchLaterEstatesView] TO [User_Estate];
GRANT SELECT ON [dbo].[FavouriteEstatesView] TO [User_Estate];
GRANT SELECT ON [dbo].[TagView] TO [User_Estate];
GRANT SELECT ON [dbo].[TagAndEstateView] TO [User_Estate];
GRANT SELECT ON [dbo].[UserHistoryWatchedView] TO [User_Estate];
--������ ���� �� SELECT, INSERT, UPDATE, DELETE ������
GRANT SELECT ON [dbo].[User] TO [Admin_Estate];
 
GRANT SELECT, INSERT, UPDATE, DELETE ON [dbo].[User] TO [Admin_Estate];
GRANT SELECT, INSERT, UPDATE, DELETE ON [dbo].[Estate] TO [Admin_Estate];
--�������� ���� �� ������� user � ������������
DENY INSERT, UPDATE, DELETE ON [dbo].[User] TO [User_Estate];
