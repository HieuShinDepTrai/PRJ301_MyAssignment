With t as (SELECT s.SessionID, g.GroupID
FROM [dbo].[Group] as g, [dbo].[Session] as s
where s.GroupID=g.GroupID and s.SessionID=?)
Select distinct t.SessionID, stu.StudentID, stu.StudentCode, stu.SurName, stu.MidName, stu.GivenName
from [dbo].[Student] as stu, [dbo].[Enroll] as e, t
where stu.StudentID=e.StudentID and t.GroupID=e.GroupID
order by stu.StudentID asc
