SELECT COUNT ([AttendanceStatus])
FROM [Assignment].[dbo].[Attendance] as a, [Assignment].[dbo].[Session] as s
where a.StudentID=? and s.SessionID=a.SessionID and s.GroupID=? and AttendanceStatus='Attended'
