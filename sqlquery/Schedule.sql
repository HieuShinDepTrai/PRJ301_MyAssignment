with t as (SELECT s.SessionID, s.GroupID, g.GroupName, g.CourseID, s.InstructorID, s.Slot, s.RoomName, s.Date
FROM [dbo].[Session] s, [dbo].[Group] g
where s.GroupId=g.GroupId)
select * from t, [dbo].[Course] as c
where t.CourseID=c.CourseID
and t.Date >= ? and t.Date <= ?
