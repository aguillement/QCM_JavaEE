DECLARE @dbname nvarchar(128)
SET @dbname = N'QCM_DB'

IF (EXISTS (SELECT name FROM master.dbo.sysdatabases WHERE ('[' + name + ']' = @dbname OR name = @dbname)))
BEGIN
	DROP DATABASE QCM_DB
	CREATE DATABASE QCM_DB
END
ELSE
BEGIN
	CREATE DATABASE QCM_DB
END

USE [QCM_DB]
GO

SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[EXAM](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[startDate] [datetime] NOT NULL,
	[endDate] [datetime] NOT NULL,
	[timeSpent] [int] NULL,
	[state] [char](2) NOT NULL,
	[score] [char](3) NULL,
	[level] [char](3) NULL,
	[idTest] [int] NOT NULL,
	[idUsers] [int] NOT NULL,
 CONSTRAINT [EXAM_PK] PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO

SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[PROFILE](
	[id] [int] NOT NULL,
	[label] [varchar](100) NOT NULL,
 CONSTRAINT [PROFILe_PK] PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO

SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[PROMOTION](
	[id] [char](8) NOT NULL,
	[label] [varchar](200) NOT NULL,
 CONSTRAINT [PROMOTION_PK] PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO

SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[PROPOSITION](
	[id] [int] NOT NULL,
	[statement] [varchar](500) NOT NULL,
	[isTrue] [bit] NOT NULL,
	[idQuestion] [int] NOT NULL,
 CONSTRAINT [PROPOSITION_PK] PRIMARY KEY CLUSTERED 
(
	[id] ASC,
	[idQuestion] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO

SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[QUESTION](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[statement] [varchar](500) NOT NULL,
	[media] [int] NULL,
	[points] [int] NOT NULL,
	[idTheme] [int] NOT NULL,
 CONSTRAINT [QUESTION_PK] PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO

SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[DRAW_QUESTION](
	[isMarked] [bit] NOT NULL,
	[idQuestion] [int] NOT NULL,
	[orderNumber] [int] NOT NULL,
	[idExam] [int] NOT NULL,
 CONSTRAINT [DRAW_QUESTION_PK] PRIMARY KEY CLUSTERED 
(
	[idQuestion] ASC,
	[idExam] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO

SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[DRAW_ANSWER](
	[idProposition] [int] NOT NULL,
	[idQuestion] [int] NOT NULL,
	[idExam] [int] NOT NULL,
 CONSTRAINT [DRAW_ANSWER_PK] PRIMARY KEY CLUSTERED 
(
	[idQuestion] ASC,
	[idExam] ASC,
	[idProposition] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[SECTION_TEST]    Script Date: 08/10/2018 16:28:33 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[TEST_SECTION](
	[nbQuestionToDraw] [int] NOT NULL,
	[idTest] [int] NOT NULL,
	[idTheme] [int] NOT NULL,
 CONSTRAINT [TEST_SECTION_PK] PRIMARY KEY CLUSTERED 
(
	[idTest] ASC,
	[idTheme] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO

SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[TEST](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[label] [varchar](100) NOT NULL,
	[statement] [varchar](200) NOT NULL,
	[duration] [int] NOT NULL,
	[high_level] [int] NOT NULL,
	[low_level] [int] NOT NULL,
 CONSTRAINT [TEST_PK] PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO

SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[THEME](
	[id] [int]  IDENTITY(1,1) NOT NULL,
	[label] [varchar](200) NOT NULL,
 CONSTRAINT [THEME_PK] PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO

SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[USERS](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[lastname] [varchar](250) NOT NULL,
	[firstname] [varchar](250) NOT NULL,
	[email] [varchar](250) NOT NULL,
	[password] [varchar](100) NOT NULL,
	[idProfile] [int] NOT NULL,
	[idPromotion] [char](8) NULL,
 CONSTRAINT [USERS_PK] PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
SET IDENTITY_INSERT [dbo].[EXAM] ON 

INSERT [dbo].[EXAM] ([id], [startDate], [endDate], [timeSpent], [state], [score], [level], [idTest], [idUsers]) VALUES (3, CAST(N'2018-10-04 10:00:00.000' AS DateTime), CAST(N'2018-10-04 16:00:00.000' AS DateTime), 50, N'T', 16, N'A', 1, 3),
																													  (6, CAST(N'2018-10-04 10:00:00.000' AS DateTime), CAST(N'2018-10-04 16:00:00.000' AS DateTime), 60, N'T', 7, N'NA', 1, 5)
SET IDENTITY_INSERT [dbo].[EXAM] OFF
INSERT [dbo].[PROFILE] ([id], [label]) VALUES (10, N'libre'), (20, N'stagiaire'), (30, N'formateur'), (40, N'admin')
INSERT [dbo].[PROMOTION] ([id], [label]) VALUES (N'1', N'promo01'), (N'2', N'promo02'), (N'3', N'promo03'), (N'4', N'promo04'), (N'5', N'promo05'), (N'6', N'promo06')
INSERT [dbo].[PROPOSITION] ([id], [statement], [isTrue], [idQuestion]) VALUES (1, N'MariaDB', 1, 1), (2, N'MySQL', 1, 1), (3, N'Oracle', 1, 1), (4, N'Create Read Update Delete', 1, 2), (5, N'Create Read Upgrade Delete', 0, 2), (6, N'Create Remove Upgrade Delete', 0, 2), (7, N'Create Remove Update Delete', 0, 2), (8, N'class NomClass', 1, 3), (9, N'class nomClass', 0, 3), (10, N'new class NomClass', 0, 3), (11, N'new class nomClass', 0, 3)
SET IDENTITY_INSERT [dbo].[QUESTION] ON 

INSERT [dbo].[QUESTION] ([id], [statement], [media], [points], [idTheme]) VALUES (1, N'Donner un SGBD', NULL, 3, 1), (2, N'Que signifie CRUD ?', NULL, 1, 1), (3, N'Comment déclarer une classe ?', NULL, 10, 2)
SET IDENTITY_INSERT [dbo].[QUESTION] OFF
INSERT [dbo].[DRAW_QUESTION] ([isMarked], [idQuestion], [orderNumber], [idExam]) VALUES (0, 1, 1, 3), (1, 2, 2, 6)
INSERT [dbo].[DRAW_ANSWER] ([idProposition], [idQuestion], [idExam]) VALUES (1, 1, 3)
INSERT [dbo].[TEST_SECTION] ([nbQuestionToDraw], [idTest], [idTheme]) VALUES (4, 1, 1), (4, 1, 2), (6, 1, 4)
SET IDENTITY_INSERT [dbo].[TEST] ON 

INSERT [dbo].[TEST] ([id], [label], [statement], [duration], [high_level], [low_level]) VALUES (1, N'Test SQL', N'Test sur le SQL', 120, 16, 10), (2, N'Test JAVA', N'Test sur le JAVA', 30, 16, 10), (3, N'Test PHP', N'Test sur le PHP', 240, 14, 8)

SET IDENTITY_INSERT [dbo].[TEST] OFF
INSERT [dbo].[THEME] ([label]) VALUES (N'SQL'), (N'PHP'), (N'JAVA'), (N'POO')
SET IDENTITY_INSERT [dbo].[USERS] ON 

INSERT [dbo].[USERS] ([id], [lastname], [firstname], [email], [password], [idProfile], [idPromotion]) VALUES (3, N'Hervé', N'Dupont', N'herve.dupont@gmail.com', N'03AC674216F3E15C761EE1A5E255F067953623C8B388B4459E13F978D7C846F4', 20, N'1       ')
INSERT [dbo].[USERS] ([id], [lastname], [firstname], [email], [password], [idProfile], [idPromotion]) VALUES (5, N'Arber', N'Drouin', N'arber.drouin@gmail.com', N'03AC674216F3E15C761EE1A5E255F067953623C8B388B4459E13F978D7C846F4', 20, N'1       ')
INSERT [dbo].[USERS] ([id], [lastname], [firstname], [email], [password], [idProfile], [idPromotion]) VALUES (6, N'Maureen', N'Leclair', N'MaureenLeclair@jourrapide.com', N'03AC674216F3E15C761EE1A5E255F067953623C8B388B4459E13F978D7C846F4', 30, NULL)
INSERT [dbo].[USERS] ([id], [lastname], [firstname], [email], [password], [idProfile], [idPromotion]) VALUES (7, N'Blanchefle', N'Auclair', N'BlanchefleAuclair@teleworm.us', N'03AC674216F3E15C761EE1A5E255F067953623C8B388B4459E13F978D7C846F4', 30, NULL)
INSERT [dbo].[USERS] ([id], [lastname], [firstname], [email], [password], [idProfile], [idPromotion]) VALUES (8, N'Catherine', N'Brian', N'
CatherineBrian@dayrep.com', N'03AC674216F3E15C761EE1A5E255F067953623C8B388B4459E13F978D7C846F4', 20, N'2       ')
INSERT [dbo].[USERS] ([id], [lastname], [firstname], [email], [password], [idProfile], [idPromotion]) VALUES (9, N'Archard', N'Godin', N'
ArchardGodin@dayrep.com', N'03AC674216F3E15C761EE1A5E255F067953623C8B388B4459E13F978D7C846F4', 40, NULL)
SET IDENTITY_INSERT [dbo].[USERS] OFF
SET ANSI_PADDING ON

GO
/****** Object:  Index [UTILISATEUR_EMAIL_UQ]    Script Date: 08/10/2018 16:28:33 ******/
ALTER TABLE [dbo].[USERS] ADD  CONSTRAINT [USERS_EMAIL_UQ] UNIQUE NONCLUSTERED 
(
	[email] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, SORT_IN_TEMPDB = OFF, IGNORE_DUP_KEY = OFF, ONLINE = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
GO
ALTER TABLE [dbo].[EXAM]  WITH CHECK ADD  CONSTRAINT [Exam_Candidat_FK] FOREIGN KEY([idUsers])
REFERENCES [dbo].[USERS] ([id])
ON DELETE CASCADE
GO
ALTER TABLE [dbo].[EXAM] CHECK CONSTRAINT [Exam_Candidat_FK]
GO
ALTER TABLE [dbo].[EXAM]  WITH CHECK ADD  CONSTRAINT [Exam_Test_FK] FOREIGN KEY([idTest])
REFERENCES [dbo].[TEST] ([id])
ON DELETE CASCADE
GO
ALTER TABLE [dbo].[EXAM] CHECK CONSTRAINT [Exam_Test_FK]
GO
ALTER TABLE [dbo].[PROPOSITION]  WITH CHECK ADD  CONSTRAINT [Proposition_Question_FK] FOREIGN KEY([idQuestion])
REFERENCES [dbo].[QUESTION] ([id])
ON DELETE CASCADE
GO
ALTER TABLE [dbo].[PROPOSITION] CHECK CONSTRAINT [Proposition_Question_FK]
GO
ALTER TABLE [dbo].[QUESTION]  WITH CHECK ADD  CONSTRAINT [Question_Theme_FK] FOREIGN KEY([idTheme])
REFERENCES [dbo].[THEME] ([id])
ON DELETE CASCADE
GO
ALTER TABLE [dbo].[QUESTION] CHECK CONSTRAINT [Question_Theme_FK]
GO
ALTER TABLE [dbo].[DRAW_QUESTION]  WITH CHECK ADD  CONSTRAINT [Draw_Exam_FK] FOREIGN KEY([idExam])
REFERENCES [dbo].[Exam] ([id])
ON DELETE CASCADE
GO
ALTER TABLE [dbo].[DRAW_QUESTION] CHECK CONSTRAINT [Draw_Exam_FK]
GO
ALTER TABLE [dbo].[DRAW_QUESTION]  WITH CHECK ADD  CONSTRAINT [Draw_Question_FK] FOREIGN KEY([idQuestion])
REFERENCES [dbo].[QUESTION] ([id])
ON DELETE CASCADE
GO
ALTER TABLE [dbo].[DRAW_QUESTION] CHECK CONSTRAINT [Draw_Question_FK]
GO
ALTER TABLE [dbo].[DRAW_ANSWER]  WITH CHECK ADD  CONSTRAINT [Answer_Proposition_FK] FOREIGN KEY([idProposition], [idQuestion])
REFERENCES [dbo].[PROPOSITION] ([id], [idQuestion])
GO
ALTER TABLE [dbo].[DRAW_ANSWER] CHECK CONSTRAINT [Answer_Proposition_FK]
GO
ALTER TABLE [dbo].[DRAW_ANSWER]  WITH CHECK ADD  CONSTRAINT [Answer_Draw_FK] FOREIGN KEY([idQuestion], [idExam])
REFERENCES [dbo].[DRAW_QUESTION] ([idQuestion], [idExam])
ON DELETE CASCADE
GO
ALTER TABLE [dbo].[DRAW_ANSWER] CHECK CONSTRAINT [Answer_Draw_FK]
GO
ALTER TABLE [dbo].[TEST_SECTION]  WITH CHECK ADD  CONSTRAINT [Section_Test_FK] FOREIGN KEY([idTest])
REFERENCES [dbo].[TEST] ([id])
ON DELETE CASCADE
GO
ALTER TABLE [dbo].[TEST_SECTION] CHECK CONSTRAINT [Section_Test_FK]
GO
ALTER TABLE [dbo].[TEST_SECTION]  WITH CHECK ADD  CONSTRAINT [Section_Theme_FK] FOREIGN KEY([idTheme])
REFERENCES [dbo].[THEME] ([id])
ON DELETE CASCADE
GO
ALTER TABLE [dbo].[TEST_SECTION] CHECK CONSTRAINT [Section_Theme_FK]
GO
ALTER TABLE [dbo].[USERS]  WITH CHECK ADD  CONSTRAINT [Candidat_Promotion_FK] FOREIGN KEY([idPromotion])
REFERENCES [dbo].[PROMOTION] ([id])
ON DELETE CASCADE
GO
ALTER TABLE [dbo].[USERS] CHECK CONSTRAINT [Candidat_Promotion_FK]
GO
ALTER TABLE [dbo].[USERS]  WITH CHECK ADD  CONSTRAINT [Utilisateur_Profil_FK] FOREIGN KEY([idProfile])
REFERENCES [dbo].[PROFILE] ([id])
ON DELETE CASCADE
GO
ALTER TABLE [dbo].[USERS] CHECK CONSTRAINT [Utilisateur_Profil_FK]
GO
ALTER TABLE [dbo].[EXAM]  WITH CHECK ADD CHECK  (([level]='NA' OR [level]='ECA' OR [level]='A'))
GO
