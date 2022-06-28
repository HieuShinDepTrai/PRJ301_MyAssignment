UPDATE [dbo].[Attendance]
SET AttendanceStatus = ? ,RecordTime = ? ,Message = ?
WHERE StudentID=? and SessionID=?
