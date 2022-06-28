SELECT a.StudentID, a.SessionID, a.AttendanceStatus, a.RecordTime, a.Message, s.StudentCode, s.SurName, s.MidName, s.GivenName
FROM [dbo].[Attendance] as a, [dbo].[Student] as s
where s.StudentID=a.StudentID and a.SessionID=?
