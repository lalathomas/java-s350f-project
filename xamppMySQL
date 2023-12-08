-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- 主機： 127.0.0.1
-- 產生時間： 2023-12-08 00:41:41
-- 伺服器版本： 10.4.22-MariaDB
-- PHP 版本： 8.1.2

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- 資料庫: `s350f`
--

-- --------------------------------------------------------

--
-- 資料表結構 `admin`
--

CREATE TABLE `admin` (
  `AdminID` int(11) NOT NULL,
  `UserID` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- 傾印資料表的資料 `admin`
--

INSERT INTO `admin` (`AdminID`, `UserID`) VALUES
(1, 1);

-- --------------------------------------------------------

--
-- 資料表結構 `auditlog`
--

CREATE TABLE `auditlog` (
  `LogID` int(11) NOT NULL,
  `UserID` int(11) DEFAULT NULL,
  `ActivityType` varchar(50) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `Timestamp` timestamp NOT NULL DEFAULT current_timestamp() ON UPDATE current_timestamp(),
  `Description` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- 傾印資料表的資料 `auditlog`
--

INSERT INTO `auditlog` (`LogID`, `UserID`, `ActivityType`, `Timestamp`, `Description`) VALUES
(1, 1, 'Login', '2023-12-05 17:56:42', 'Admin logged in'),
(2, 2, 'Login', '2023-12-05 17:56:42', 'Teacher logged in'),
(3, 4, 'Login', '2023-12-05 17:56:42', 'Student logged in'),
(4, 1, 'Record Update', '2023-12-05 17:56:42', 'Admin updated user information'),
(5, 3, 'Record Update', '2023-12-05 17:56:42', 'Teacher updated user information');

-- --------------------------------------------------------

--
-- 資料表結構 `course`
--

CREATE TABLE `course` (
  `CourseID` int(11) NOT NULL,
  `CourseName` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `CourseDescription` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `Credits` int(11) DEFAULT NULL,
  `InstructorID` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- 傾印資料表的資料 `course`
--

INSERT INTO `course` (`CourseID`, `CourseName`, `CourseDescription`, `Credits`, `InstructorID`) VALUES
(1, 'Software Engineering', 'Introduction to Software Engineering', 3, 1),
(2, 'Database Management', 'Fundamentals of Database Management', 4, 2),
(3, 'Digital Circuits', 'Introduction to Digital Circuits', 3, 1),
(4, 'Data Structures', 'Advanced Data Structures and Algorithms', 4, 2),
(5, 'Operating Systems', 'Principles of Operating Systems', 3, 1);

-- --------------------------------------------------------

--
-- 資料表結構 `grade`
--

CREATE TABLE `grade` (
  `GradeID` int(11) NOT NULL,
  `StudentID` int(11) DEFAULT NULL,
  `CourseID` int(11) DEFAULT NULL,
  `AssignmentName` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `Grade` varchar(2) COLLATE utf8mb4_unicode_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- 傾印資料表的資料 `grade`
--

INSERT INTO `grade` (`GradeID`, `StudentID`, `CourseID`, `AssignmentName`, `Grade`) VALUES
(1, 1, 1, 'Assignment 1', 'A'),
(2, 2, 1, 'Assignment 1', 'B+');

-- --------------------------------------------------------

--
-- 資料表結構 `program`
--

CREATE TABLE `program` (
  `ProgramID` int(11) NOT NULL,
  `ProgramName` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- 傾印資料表的資料 `program`
--

INSERT INTO `program` (`ProgramID`, `ProgramName`) VALUES
(1, 'Computer Science'),
(2, 'Electrical Engineering');

-- --------------------------------------------------------

--
-- 資料表結構 `student`
--

CREATE TABLE `student` (
  `StudentID` int(11) NOT NULL,
  `UserID` int(11) DEFAULT NULL,
  `DateOfBirth` date DEFAULT NULL,
  `Gender` varchar(10) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `ContactNumber` varchar(20) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `Address` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `EmergencyContact` varchar(20) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `ProgramID` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- 傾印資料表的資料 `student`
--

INSERT INTO `student` (`StudentID`, `UserID`, `DateOfBirth`, `Gender`, `ContactNumber`, `Address`, `EmergencyContact`, `ProgramID`) VALUES
(1, 4, '1995-05-15', 'Female', '1234567890', '123 Main St', '9876543210', 1),
(2, 5, '1998-02-28', 'Male', '9876543210', '456 Oak St', '1234567890', 1);

-- --------------------------------------------------------

--
-- 資料表結構 `teacher`
--

CREATE TABLE `teacher` (
  `TeacherID` int(11) NOT NULL,
  `UserID` int(11) DEFAULT NULL,
  `ContactNumber` varchar(20) COLLATE utf8mb4_unicode_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- 傾印資料表的資料 `teacher`
--

INSERT INTO `teacher` (`TeacherID`, `UserID`, `ContactNumber`) VALUES
(1, 2, '9998887777'),
(2, 3, '6665554444');

-- --------------------------------------------------------

--
-- 資料表結構 `webuser`
--

CREATE TABLE `webuser` (
  `UserID` int(11) NOT NULL,
  `Username` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `Password` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `Role` varchar(20) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `FirstName` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `LastName` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `Email` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- 傾印資料表的資料 `webuser`
--

INSERT INTO `webuser` (`UserID`, `Username`, `Password`, `Role`, `FirstName`, `LastName`, `Email`) VALUES
(1, 'admin', 'adminpass', 'Admin', 'Admin', 'User', 'admin@example.com'),
(2, 'teacher1', 'teacherpass', 'Teacher', 'John', 'Doe', 'john.doe@example.com'),
(3, 'teacher2', 'teacherpass', 'Teacher', 'Jane', 'Smith', 'jane.smith@example.com'),
(4, 'student1', 'studentpass', 'Student', 'Alice', 'Johnson', 'alice.johnson@example.com'),
(5, 'student2', 'studentpass', 'Student', 'Bob', 'Williams', 'bob.williams@example.com');

--
-- 已傾印資料表的索引
--

--
-- 資料表索引 `admin`
--
ALTER TABLE `admin`
  ADD PRIMARY KEY (`AdminID`),
  ADD UNIQUE KEY `UserID` (`UserID`);

--
-- 資料表索引 `auditlog`
--
ALTER TABLE `auditlog`
  ADD PRIMARY KEY (`LogID`),
  ADD KEY `UserID` (`UserID`);

--
-- 資料表索引 `course`
--
ALTER TABLE `course`
  ADD PRIMARY KEY (`CourseID`),
  ADD KEY `InstructorID` (`InstructorID`);

--
-- 資料表索引 `grade`
--
ALTER TABLE `grade`
  ADD PRIMARY KEY (`GradeID`),
  ADD KEY `StudentID` (`StudentID`),
  ADD KEY `CourseID` (`CourseID`);

--
-- 資料表索引 `program`
--
ALTER TABLE `program`
  ADD PRIMARY KEY (`ProgramID`),
  ADD UNIQUE KEY `ProgramName` (`ProgramName`);

--
-- 資料表索引 `student`
--
ALTER TABLE `student`
  ADD PRIMARY KEY (`StudentID`),
  ADD UNIQUE KEY `UserID` (`UserID`),
  ADD KEY `ProgramID` (`ProgramID`);

--
-- 資料表索引 `teacher`
--
ALTER TABLE `teacher`
  ADD PRIMARY KEY (`TeacherID`),
  ADD UNIQUE KEY `UserID` (`UserID`);

--
-- 資料表索引 `webuser`
--
ALTER TABLE `webuser`
  ADD PRIMARY KEY (`UserID`),
  ADD UNIQUE KEY `Username` (`Username`);

--
-- 已傾印資料表的限制式
--

--
-- 資料表的限制式 `admin`
--
ALTER TABLE `admin`
  ADD CONSTRAINT `admin_ibfk_1` FOREIGN KEY (`UserID`) REFERENCES `webuser` (`UserID`);

--
-- 資料表的限制式 `auditlog`
--
ALTER TABLE `auditlog`
  ADD CONSTRAINT `auditlog_ibfk_1` FOREIGN KEY (`UserID`) REFERENCES `webuser` (`UserID`);

--
-- 資料表的限制式 `course`
--
ALTER TABLE `course`
  ADD CONSTRAINT `course_ibfk_1` FOREIGN KEY (`InstructorID`) REFERENCES `teacher` (`TeacherID`);

--
-- 資料表的限制式 `grade`
--
ALTER TABLE `grade`
  ADD CONSTRAINT `grade_ibfk_1` FOREIGN KEY (`StudentID`) REFERENCES `student` (`StudentID`),
  ADD CONSTRAINT `grade_ibfk_2` FOREIGN KEY (`CourseID`) REFERENCES `course` (`CourseID`);

--
-- 資料表的限制式 `student`
--
ALTER TABLE `student`
  ADD CONSTRAINT `student_ibfk_1` FOREIGN KEY (`UserID`) REFERENCES `webuser` (`UserID`),
  ADD CONSTRAINT `student_ibfk_2` FOREIGN KEY (`ProgramID`) REFERENCES `program` (`ProgramID`);

--
-- 資料表的限制式 `teacher`
--
ALTER TABLE `teacher`
  ADD CONSTRAINT `teacher_ibfk_1` FOREIGN KEY (`UserID`) REFERENCES `webuser` (`UserID`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
