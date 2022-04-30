USE [master]
GO
/****** Object:  Database [NOVEL]    Script Date: 4/30/2022 8:29:27 AM ******/
CREATE DATABASE [NOVEL]
GO
/****** Object:  Table [dbo].[category]    Script Date: 4/30/2022 8:29:27 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[category](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[name] [nvarchar](255) NOT NULL,
	[group_id] [int] NULL,
	[createddate] [datetime] NULL,
	[modifieddate] [datetime] NULL,
	[createdby] [int] NULL,
	[modifiedby] [int] NULL,
 CONSTRAINT [PK__category__3213E83F50F3F5DC] PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[category_group]    Script Date: 4/30/2022 8:29:27 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[category_group](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[name] [nvarchar](50) NULL,
	[createddate] [datetime] NULL,
	[modifieddate] [datetime] NULL,
	[createdby] [int] NULL,
	[modifiedby] [int] NULL
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[chapter]    Script Date: 4/30/2022 8:29:27 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[chapter](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[title] [nvarchar](150) NULL,
	[content] [ntext] NULL,
	[novel_id] [int] NULL
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]

GO
/****** Object:  Table [dbo].[comment]    Script Date: 4/30/2022 8:29:27 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[comment](
	[id] [bigint] IDENTITY(1,1) NOT NULL,
	[content] [text] NOT NULL,
	[novel_id] [bigint] NOT NULL,
	[createddate] [datetime] NULL,
	[modifieddate] [datetime] NULL,
	[createdby] [varchar](255) NULL,
	[modifiedby] [varchar](255) NULL,
PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[novel]    Script Date: 4/30/2022 8:29:27 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[novel](
	[id] [bigint] IDENTITY(1,1) NOT NULL,
	[title] [nvarchar](255) NULL,
	[image] [nvarchar](255) NULL,
	[short_description] [ntext] NULL,
	[reference] [nvarchar](150) NULL,
	[author] [nvarchar](100) NULL,
	[private] [bit] NULL,
	[status_id] [int] NULL,
	[category_id] [int] NULL,
	[createddate] [datetime] NULL,
	[modifieddate] [datetime] NULL,
	[createdby] [int] NULL,
	[modifiedby] [int] NULL,
 CONSTRAINT [PK__news__3213E83FA87BDA66] PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]

GO
/****** Object:  Table [dbo].[roles]    Script Date: 4/30/2022 8:29:27 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[roles](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[code] [varchar](255) NOT NULL,
	[name] [nvarchar](255) NOT NULL,
	[createddate] [datetime] NULL,
	[modifieddate] [datetime] NULL,
	[createdby] [int] NULL,
	[modifiedby] [int] NULL,
 CONSTRAINT [PK__roles__3213E83F2F63A408] PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[status]    Script Date: 4/30/2022 8:29:27 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[status](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[name] [nvarchar](50) NULL
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[users]    Script Date: 4/30/2022 8:29:27 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[users](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[username] [varchar](150) NOT NULL,
	[password] [varchar](150) NOT NULL,
	[fullname] [nvarchar](150) NULL,
	[status] [bit] NOT NULL,
	[roleid] [int] NOT NULL,
	[createddate] [datetime] NULL,
	[modifieddate] [datetime] NULL,
	[createdby] [int] NULL,
	[modifiedby] [int] NULL,
 CONSTRAINT [PK__users__3213E83FBB80EFAE] PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
SET IDENTITY_INSERT [dbo].[category] ON 

INSERT [dbo].[category] ([id], [name], [group_id], [createddate], [modifieddate], [createdby], [modifiedby]) VALUES (1, N'Kinh dị', 20, NULL, NULL, NULL, NULL)
INSERT [dbo].[category] ([id], [name], [group_id], [createddate], [modifieddate], [createdby], [modifiedby]) VALUES (3, N'Tu chân', 20, NULL, NULL, NULL, NULL)
INSERT [dbo].[category] ([id], [name], [group_id], [createddate], [modifieddate], [createdby], [modifiedby]) VALUES (4, N'Tiên hiệp', 20, NULL, NULL, NULL, NULL)
SET IDENTITY_INSERT [dbo].[category] OFF
SET IDENTITY_INSERT [dbo].[category_group] ON 

INSERT [dbo].[category_group] ([id], [name], [createddate], [modifieddate], [createdby], [modifiedby]) VALUES (19, N'Bối cảnh', NULL, NULL, NULL, NULL)
INSERT [dbo].[category_group] ([id], [name], [createddate], [modifieddate], [createdby], [modifiedby]) VALUES (20, N'Lĩnh vực', NULL, NULL, NULL, NULL)
SET IDENTITY_INSERT [dbo].[category_group] OFF
SET IDENTITY_INSERT [dbo].[chapter] ON 

INSERT [dbo].[chapter] ([id], [title], [content], [novel_id]) VALUES (1, N'Chương 1', N'123', 4)
INSERT [dbo].[chapter] ([id], [title], [content], [novel_id]) VALUES (2, N'Chương 2', N'123', 4)
SET IDENTITY_INSERT [dbo].[chapter] OFF
SET IDENTITY_INSERT [dbo].[comment] ON 

INSERT [dbo].[comment] ([id], [content], [novel_id], [createddate], [modifieddate], [createdby], [modifiedby]) VALUES (3, N'Hay quá', 4, NULL, NULL, N'1', N'1')
SET IDENTITY_INSERT [dbo].[comment] OFF
SET IDENTITY_INSERT [dbo].[novel] ON 

INSERT [dbo].[novel] ([id], [title], [image], [short_description], [reference], [author], [private], [status_id], [category_id], [createddate], [modifieddate], [createdby], [modifiedby]) VALUES (4, N'What is the son of Football Coach John Gruden, Deuce Gruden doing Now?', N'https://kenh14cdn.com/zoom/460_289/203336854389633024/2022/4/28/photo1651151572984-1651151573292577299743.gif', N'Lorem ipsum dolor sit amet consectetur adipisicing elit. Distinctio placeat exercitationem magni voluptates dolore. Tenetur fugiat voluptates quas.', N'bootstrap.com', N'Chánh Nguyễn', 0, 1, 1, CAST(N'2000-01-01 00:00:00.000' AS DateTime), NULL, 1, 1)
INSERT [dbo].[novel] ([id], [title], [image], [short_description], [reference], [author], [private], [status_id], [category_id], [createddate], [modifieddate], [createdby], [modifiedby]) VALUES (5, N'ABC', N'https://kenh14cdn.com/zoom/460_289/203336854389633024/2022/4/28/photo1651151572984-1651151573292577299743.gif', N'Lorem ipsum dolor sit amet consectetur adipisicing elit. Distinctio placeat exercitationem magni voluptates dolore. Tenetur fugiat voluptates quas.', N'bootstrap.com', N'Nguyễn Chánh', 0, 1, 1, CAST(N'2000-01-01 00:00:00.000' AS DateTime), NULL, 1, 2)
INSERT [dbo].[novel] ([id], [title], [image], [short_description], [reference], [author], [private], [status_id], [category_id], [createddate], [modifieddate], [createdby], [modifiedby]) VALUES (6, N'What is the son of Football Coach John Gruden, Deuce Gruden doing Now?', N'https://kenh14cdn.com/zoom/460_289/203336854389633024/2022/4/28/photo1651151572984-1651151573292577299743.gif', N'Lorem ipsum dolor sit amet consectetur adipisicing elit. Distinctio placeat exercitationem magni voluptates dolore. Tenetur fugiat voluptates quas.', N'bootstrap.com', N'Nguyễn Chánh', 0, 1, 1, CAST(N'2000-01-01 00:00:00.000' AS DateTime), NULL, 1, 1)
INSERT [dbo].[novel] ([id], [title], [image], [short_description], [reference], [author], [private], [status_id], [category_id], [createddate], [modifieddate], [createdby], [modifiedby]) VALUES (7, N'What is the son of Football Coach John Gruden, Deuce Gruden doing Now?', N'https://kenh14cdn.com/zoom/460_289/203336854389633024/2022/4/28/photo1651151572984-1651151573292577299743.gif', N'Lorem ipsum dolor sit amet consectetur adipisicing elit. Distinctio placeat exercitationem magni voluptates dolore. Tenetur fugiat voluptates quas.', N'bootstrap.com', N'Chánh Nguyễn', 0, 1, 1, CAST(N'2000-01-01 00:00:00.000' AS DateTime), NULL, 1, 1)
INSERT [dbo].[novel] ([id], [title], [image], [short_description], [reference], [author], [private], [status_id], [category_id], [createddate], [modifieddate], [createdby], [modifiedby]) VALUES (8, N'What is the son of Football Coach John Gruden, Deuce Gruden doing Now?', N'https://kenh14cdn.com/zoom/460_289/203336854389633024/2022/4/28/photo1651151572984-1651151573292577299743.gif', N'Lorem ipsum dolor sit amet consectetur adipisicing elit. Distinctio placeat exercitationem magni voluptates dolore. Tenetur fugiat voluptates quas.', N'bootstrap.com', N'Nguyễn Chánh', 0, 1, 1, CAST(N'2000-01-01 00:00:00.000' AS DateTime), NULL, 1, 1)
INSERT [dbo].[novel] ([id], [title], [image], [short_description], [reference], [author], [private], [status_id], [category_id], [createddate], [modifieddate], [createdby], [modifiedby]) VALUES (9, N'What is the son of Football Coach John Gruden, Deuce Gruden doing Now?', N'https://kenh14cdn.com/zoom/460_289/203336854389633024/2022/4/28/photo1651151572984-1651151573292577299743.gif', N'Lorem ipsum dolor sit amet consectetur adipisicing elit. Distinctio placeat exercitationem magni voluptates dolore. Tenetur fugiat voluptates quas.', N'bootstrap.com', N'Nguyễn Chánh', 0, 1, 1, CAST(N'2000-01-01 00:00:00.000' AS DateTime), NULL, 1, 1)
INSERT [dbo].[novel] ([id], [title], [image], [short_description], [reference], [author], [private], [status_id], [category_id], [createddate], [modifieddate], [createdby], [modifiedby]) VALUES (10, N'What is the son of Football Coach John Gruden, Deuce Gruden doing Now?', N'https://kenh14cdn.com/zoom/460_289/203336854389633024/2022/4/28/photo1651151572984-1651151573292577299743.gif', N'Lorem ipsum dolor sit amet consectetur adipisicing elit. Distinctio placeat exercitationem magni voluptates dolore. Tenetur fugiat voluptates quas.', N'bootstrap.com', N'Chánh Nguyễn', 0, 1, 1, CAST(N'2000-01-01 00:00:00.000' AS DateTime), NULL, 2, 1)
INSERT [dbo].[novel] ([id], [title], [image], [short_description], [reference], [author], [private], [status_id], [category_id], [createddate], [modifieddate], [createdby], [modifiedby]) VALUES (11, N'What is the son of Football Coach John Gruden, Deuce Gruden doing Now?', N'https://kenh14cdn.com/zoom/460_289/203336854389633024/2022/4/28/photo1651151572984-1651151573292577299743.gif', N'Lorem ipsum dolor sit amet consectetur adipisicing elit. Distinctio placeat exercitationem magni voluptates dolore. Tenetur fugiat voluptates quas.', N'bootstrap.com', N'Nguyễn Chánh', 0, 1, 1, CAST(N'2000-01-01 00:00:00.000' AS DateTime), NULL, 2, 1)
INSERT [dbo].[novel] ([id], [title], [image], [short_description], [reference], [author], [private], [status_id], [category_id], [createddate], [modifieddate], [createdby], [modifiedby]) VALUES (12, N'What is the son of Football Coach John Gruden, Deuce Gruden doing Now?', N'https://kenh14cdn.com/zoom/460_289/203336854389633024/2022/4/28/photo1651151572984-1651151573292577299743.gif', N'Lorem ipsum dolor sit amet consectetur adipisicing elit. Distinctio placeat exercitationem magni voluptates dolore. Tenetur fugiat voluptates quas.', N'bootstrap.com', N'Nguyễn Chánh', 0, 1, 1, CAST(N'2000-01-01 00:00:00.000' AS DateTime), NULL, 2, 1)
INSERT [dbo].[novel] ([id], [title], [image], [short_description], [reference], [author], [private], [status_id], [category_id], [createddate], [modifieddate], [createdby], [modifiedby]) VALUES (13, N'What is the son of Football Coach John Gruden, Deuce Gruden doing Now?', N'https://kenh14cdn.com/zoom/460_289/203336854389633024/2022/4/28/photo1651151572984-1651151573292577299743.gif', N'Lorem ipsum dolor sit amet consectetur adipisicing elit. Distinctio placeat exercitationem magni voluptates dolore. Tenetur fugiat voluptates quas.', N'bootstrap.com', N'Chánh Nguyễn', 0, 1, 1, CAST(N'2000-01-01 00:00:00.000' AS DateTime), NULL, 2, 1)
INSERT [dbo].[novel] ([id], [title], [image], [short_description], [reference], [author], [private], [status_id], [category_id], [createddate], [modifieddate], [createdby], [modifiedby]) VALUES (14, N'What is the son of Football Coach John Gruden, Deuce Gruden doing Now?', N'https://kenh14cdn.com/zoom/460_289/203336854389633024/2022/4/28/photo1651151572984-1651151573292577299743.gif', N'Lorem ipsum dolor sit amet consectetur adipisicing elit. Distinctio placeat exercitationem magni voluptates dolore. Tenetur fugiat voluptates quas.', N'bootstrap.com', N'Nguyễn Chánh', 0, 1, 1, CAST(N'2000-01-01 00:00:00.000' AS DateTime), NULL, 2, 1)
INSERT [dbo].[novel] ([id], [title], [image], [short_description], [reference], [author], [private], [status_id], [category_id], [createddate], [modifieddate], [createdby], [modifiedby]) VALUES (15, N'What is the son of Football Coach John Gruden, Deuce Gruden doing Now?', N'https://kenh14cdn.com/zoom/460_289/203336854389633024/2022/4/28/photo1651151572984-1651151573292577299743.gif', N'Lorem ipsum dolor sit amet consectetur adipisicing elit. Distinctio placeat exercitationem magni voluptates dolore. Tenetur fugiat voluptates quas.', N'bootstrap.com', N'Nguyễn Chánh', 0, 1, 1, CAST(N'2000-01-01 00:00:00.000' AS DateTime), NULL, 2, 1)
INSERT [dbo].[novel] ([id], [title], [image], [short_description], [reference], [author], [private], [status_id], [category_id], [createddate], [modifieddate], [createdby], [modifiedby]) VALUES (16, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, CAST(N'2000-01-01 00:00:00.000' AS DateTime), NULL, 2, 1)
INSERT [dbo].[novel] ([id], [title], [image], [short_description], [reference], [author], [private], [status_id], [category_id], [createddate], [modifieddate], [createdby], [modifiedby]) VALUES (17, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 1)
SET IDENTITY_INSERT [dbo].[novel] OFF
SET IDENTITY_INSERT [dbo].[roles] ON 

INSERT [dbo].[roles] ([id], [code], [name], [createddate], [modifieddate], [createdby], [modifiedby]) VALUES (1, N'admin', N'Admin', NULL, NULL, NULL, NULL)
INSERT [dbo].[roles] ([id], [code], [name], [createddate], [modifieddate], [createdby], [modifiedby]) VALUES (2, N'user', N'User', NULL, NULL, NULL, NULL)
SET IDENTITY_INSERT [dbo].[roles] OFF
SET IDENTITY_INSERT [dbo].[status] ON 

INSERT [dbo].[status] ([id], [name]) VALUES (1, N'Hoàn thành')
INSERT [dbo].[status] ([id], [name]) VALUES (2, N'Chưa hoàn thành')
SET IDENTITY_INSERT [dbo].[status] OFF
SET IDENTITY_INSERT [dbo].[users] ON 

INSERT [dbo].[users] ([id], [username], [password], [fullname], [status], [roleid], [createddate], [modifieddate], [createdby], [modifiedby]) VALUES (1, N'chanh', N'123', N'Nguyễn Trung Chánh', 0, 1, NULL, NULL, NULL, NULL)
INSERT [dbo].[users] ([id], [username], [password], [fullname], [status], [roleid], [createddate], [modifieddate], [createdby], [modifiedby]) VALUES (2, N'nguyen', N'123', N'Nguyễn Chánh', 0, 2, NULL, NULL, NULL, NULL)
SET IDENTITY_INSERT [dbo].[users] OFF
USE [master]
GO
ALTER DATABASE [NOVEL] SET  READ_WRITE 
GO
