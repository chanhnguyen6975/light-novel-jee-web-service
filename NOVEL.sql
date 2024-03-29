USE [master]
GO
/****** Object:  Database [NOVEL]    Script Date: 4/30/2022 8:47:36 AM ******/
CREATE DATABASE [NOVEL]
GO
USE [NOVEL]
GO
/****** Object:  Table [dbo].[category]    Script Date: 4/30/2022 8:47:36 AM ******/
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
/****** Object:  Table [dbo].[category_group]    Script Date: 4/30/2022 8:47:36 AM ******/
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
	[modifiedby] [int] NULL,
 CONSTRAINT [PK_category_group] PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[chapter]    Script Date: 4/30/2022 8:47:36 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[chapter](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[title] [nvarchar](150) NULL,
	[content] [ntext] NULL,
	[novel_id] [int] NULL,
 CONSTRAINT [PK_chapter] PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]

GO
/****** Object:  Table [dbo].[comment]    Script Date: 4/30/2022 8:47:36 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[comment](
	[id] [bigint] IDENTITY(1,1) NOT NULL,
	[content] [text] NOT NULL,
	[novel_id] [int] NOT NULL,
	[createddate] [datetime] NULL,
	[modifieddate] [datetime] NULL,
	[createdby] [int] NULL,
	[modifiedby] [int] NULL,
 CONSTRAINT [PK__comment__3213E83F45A8B2A3] PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]

GO
/****** Object:  Table [dbo].[novel]    Script Date: 4/30/2022 8:47:36 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[novel](
	[id] [int] IDENTITY(1,1) NOT NULL,
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
/****** Object:  Table [dbo].[roles]    Script Date: 4/30/2022 8:47:36 AM ******/
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
/****** Object:  Table [dbo].[status]    Script Date: 4/30/2022 8:47:36 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[status](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[name] [nvarchar](50) NULL,
 CONSTRAINT [PK_status] PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[users]    Script Date: 4/30/2022 8:47:36 AM ******/
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
ALTER TABLE [dbo].[category]  WITH CHECK ADD  CONSTRAINT [FK_category_category_group] FOREIGN KEY([group_id])
REFERENCES [dbo].[category_group] ([id])
GO
ALTER TABLE [dbo].[category] CHECK CONSTRAINT [FK_category_category_group]
GO
ALTER TABLE [dbo].[category]  WITH CHECK ADD  CONSTRAINT [FK_category_users] FOREIGN KEY([createdby])
REFERENCES [dbo].[users] ([id])
GO
ALTER TABLE [dbo].[category] CHECK CONSTRAINT [FK_category_users]
GO
ALTER TABLE [dbo].[category]  WITH CHECK ADD  CONSTRAINT [FK_category_users1] FOREIGN KEY([modifiedby])
REFERENCES [dbo].[users] ([id])
GO
ALTER TABLE [dbo].[category] CHECK CONSTRAINT [FK_category_users1]
GO
ALTER TABLE [dbo].[category_group]  WITH CHECK ADD  CONSTRAINT [FK_category_group_users] FOREIGN KEY([createdby])
REFERENCES [dbo].[users] ([id])
GO
ALTER TABLE [dbo].[category_group] CHECK CONSTRAINT [FK_category_group_users]
GO
ALTER TABLE [dbo].[category_group]  WITH CHECK ADD  CONSTRAINT [FK_category_group_users1] FOREIGN KEY([modifiedby])
REFERENCES [dbo].[users] ([id])
GO
ALTER TABLE [dbo].[category_group] CHECK CONSTRAINT [FK_category_group_users1]
GO
ALTER TABLE [dbo].[chapter]  WITH CHECK ADD  CONSTRAINT [FK_chapter_novel] FOREIGN KEY([novel_id])
REFERENCES [dbo].[novel] ([id])
GO
ALTER TABLE [dbo].[chapter] CHECK CONSTRAINT [FK_chapter_novel]
GO
ALTER TABLE [dbo].[comment]  WITH CHECK ADD  CONSTRAINT [FK_comment_novel] FOREIGN KEY([novel_id])
REFERENCES [dbo].[novel] ([id])
GO
ALTER TABLE [dbo].[comment] CHECK CONSTRAINT [FK_comment_novel]
GO
ALTER TABLE [dbo].[comment]  WITH CHECK ADD  CONSTRAINT [FK_comment_users] FOREIGN KEY([createdby])
REFERENCES [dbo].[users] ([id])
GO
ALTER TABLE [dbo].[comment] CHECK CONSTRAINT [FK_comment_users]
GO
ALTER TABLE [dbo].[comment]  WITH CHECK ADD  CONSTRAINT [FK_comment_users1] FOREIGN KEY([modifiedby])
REFERENCES [dbo].[users] ([id])
GO
ALTER TABLE [dbo].[comment] CHECK CONSTRAINT [FK_comment_users1]
GO
ALTER TABLE [dbo].[novel]  WITH CHECK ADD  CONSTRAINT [FK_novel_category] FOREIGN KEY([category_id])
REFERENCES [dbo].[category] ([id])
GO
ALTER TABLE [dbo].[novel] CHECK CONSTRAINT [FK_novel_category]
GO
ALTER TABLE [dbo].[novel]  WITH CHECK ADD  CONSTRAINT [FK_novel_status] FOREIGN KEY([status_id])
REFERENCES [dbo].[status] ([id])
GO
ALTER TABLE [dbo].[novel] CHECK CONSTRAINT [FK_novel_status]
GO
ALTER TABLE [dbo].[novel]  WITH CHECK ADD  CONSTRAINT [FK_novel_users] FOREIGN KEY([createdby])
REFERENCES [dbo].[users] ([id])
GO
ALTER TABLE [dbo].[novel] CHECK CONSTRAINT [FK_novel_users]
GO
ALTER TABLE [dbo].[novel]  WITH CHECK ADD  CONSTRAINT [FK_novel_users1] FOREIGN KEY([modifiedby])
REFERENCES [dbo].[users] ([id])
GO
ALTER TABLE [dbo].[novel] CHECK CONSTRAINT [FK_novel_users1]
GO
ALTER TABLE [dbo].[roles]  WITH CHECK ADD  CONSTRAINT [FK_roles_users] FOREIGN KEY([createdby])
REFERENCES [dbo].[users] ([id])
GO
ALTER TABLE [dbo].[roles] CHECK CONSTRAINT [FK_roles_users]
GO
ALTER TABLE [dbo].[roles]  WITH CHECK ADD  CONSTRAINT [FK_roles_users1] FOREIGN KEY([modifiedby])
REFERENCES [dbo].[users] ([id])
GO
ALTER TABLE [dbo].[roles] CHECK CONSTRAINT [FK_roles_users1]
GO
ALTER TABLE [dbo].[users]  WITH CHECK ADD  CONSTRAINT [FK_users_roles] FOREIGN KEY([roleid])
REFERENCES [dbo].[roles] ([id])
GO
ALTER TABLE [dbo].[users] CHECK CONSTRAINT [FK_users_roles]
GO
USE [master]
GO
ALTER DATABASE [NOVEL] SET  READ_WRITE 
GO
