SELECT distinct g.GroupID, g.GroupName
FROM [Assignment].[dbo].[Group] g
where g.CourseID = ?
