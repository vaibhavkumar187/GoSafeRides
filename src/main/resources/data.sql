--user table seed data
INSERT INTO gsr_user (email, name, password)
VALUES
('user1@example.com', 'User 1', 'password1'),
('user2@example.com', 'User 2', 'password2'),
('user3@example.com', 'User 3', 'password3'),
('user4@example.com', 'User 4', 'password4'),
('user5@example.com', 'User 5', 'password5'),
('user6@example.com', 'User 6', 'password6'),
('user7@example.com', 'User 7', 'password7'),
('user8@example.com', 'User 8', 'password8'),
('user9@example.com', 'User 9', 'password9'),
('user10@example.com', 'User 10', 'password10'),
('user11@example.com', 'User 11', 'password11'),
('user12@example.com', 'User 12', 'password12'),
('user13@example.com', 'User 13', 'password13'),
('user14@example.com', 'User 14', 'password14'),
('user15@example.com', 'User 15', 'password15'),
('user16@example.com', 'User 16', 'password16'),
('user17@example.com', 'User 17', 'password17'),
('user18@example.com', 'User 18', 'password18'),
('user19@example.com', 'User 19', 'password19'),
('user20@example.com', 'User 20', 'password20'),
('user21@example.com', 'User 21', 'password21'),
('user22@example.com', 'User 22', 'password22'),
('user23@example.com', 'User 23', 'password23'),
('user24@example.com', 'User 24', 'password24'),
('user25@example.com', 'User 25', 'password25'),
('user26@example.com', 'User 26', 'password26'),
('user27@example.com', 'User 27', 'password27'),
('user28@example.com', 'User 28', 'password28'),
('user29@example.com', 'User 29', 'password29'),
('user30@example.com', 'User 30', 'password30'),
('user31@example.com', 'User 31', 'password31'),
('user32@example.com', 'User 32', 'password32'),
('user33@example.com', 'User 33', 'password33'),
('user34@example.com', 'User 34', 'password34'),
('user35@example.com', 'User 35', 'password35'),
('user36@example.com', 'User 36', 'password36'),
('user37@example.com', 'User 37', 'password37'),
('user38@example.com', 'User 38', 'password38'),
('user39@example.com', 'User 39', 'password39'),
('user40@example.com', 'User 40', 'password40'),
('user41@example.com', 'User 41', 'password41'),
('user42@example.com', 'User 42', 'password42'),
('user43@example.com', 'User 43', 'password43'),
('user44@example.com', 'User 44', 'password44'),
('user45@example.com', 'User 45', 'password45'),
('user46@example.com', 'User 46', 'password46'),
('user47@example.com', 'User 47', 'password47'),
('user48@example.com', 'User 48', 'password48'),
('user49@example.com', 'User 49', 'password49'),
('user50@example.com', 'User 50', 'password50');

-- user roles
INSERT INTO user_roles (user_id, roles)
VALUES
(1, 'RIDER'),
(2, 'RIDER'),
(2, 'DRIVER'),
(3, 'RIDER'),
(3, 'DRIVER'),
(4, 'RIDER'),
(4, 'DRIVER'),
(5, 'RIDER'),
(5, 'DRIVER'),
(6, 'RIDER'),
(6, 'DRIVER'),
(7, 'RIDER'),
(7, 'DRIVER'),
(8, 'RIDER'),
(8, 'DRIVER'),
(9, 'RIDER'),
(9, 'DRIVER'),
(10, 'RIDER'),
(10, 'DRIVER'),
(11, 'RIDER'),
(11, 'DRIVER'),
(12, 'RIDER'),
(12, 'DRIVER'),
(13, 'RIDER'),
(13, 'DRIVER'),
(14, 'RIDER'),
(14, 'DRIVER'),
(15, 'RIDER'),
(15, 'DRIVER'),
(16, 'RIDER'),
(16, 'DRIVER'),
(17, 'RIDER'),
(17, 'DRIVER'),
(18, 'RIDER'),
(18, 'DRIVER'),
(19, 'RIDER'),
(19, 'DRIVER'),
(20, 'RIDER'),
(20, 'DRIVER'),
(21, 'RIDER'),
(21, 'DRIVER'),
(22, 'RIDER'),
(22, 'DRIVER'),
(23, 'RIDER'),
(23, 'DRIVER'),
(24, 'RIDER'),
(24, 'DRIVER'),
(25, 'RIDER'),
(25, 'DRIVER'),
(26, 'RIDER'),
(26, 'DRIVER'),
(27, 'RIDER'),
(27, 'DRIVER'),
(28, 'RIDER'),
(28, 'DRIVER'),
(29, 'RIDER'),
(29, 'DRIVER'),
(30, 'RIDER'),
(30, 'DRIVER'),
(31, 'RIDER'),
(31, 'DRIVER'),
(32, 'RIDER'),
(32, 'DRIVER'),
(33, 'RIDER'),
(33, 'DRIVER'),
(34, 'RIDER'),
(34, 'DRIVER'),
(35, 'RIDER'),
(35, 'DRIVER'),
(36, 'RIDER'),
(36, 'DRIVER'),
(37, 'RIDER'),
(37, 'DRIVER'),
(38, 'RIDER'),
(38, 'DRIVER'),
(39, 'RIDER'),
(39, 'DRIVER'),
(40, 'RIDER'),
(40, 'DRIVER'),
(41, 'RIDER'),
(42, 'RIDER'),
(43, 'RIDER'),
(44, 'RIDER'),
(45, 'RIDER'),
(46, 'RIDER'),
(47, 'RIDER'),
(48, 'RIDER'),
(49, 'RIDER'),
(50, 'RIDER');

-- rider table seed data
INSERT INTO rider (rating, user_id)
VALUES
(4.5, 1),
(4.0, 2),
(4.8, 3),
(4.2, 4),
(4.7, 5),
(4.1, 6),
(4.9, 7),
(4.4, 8),
(4.3, 9),
(4.6, 10),
(4.8, 11),
(4.0, 12),
(4.5, 13),
(4.1, 14),
(4.7, 15),
(4.6, 16),
(4.4, 17),
(4.3, 18),
(4.8, 19),
(4.2, 20),
(4.1, 21),
(4.6, 22),
(4.0, 23),
(4.7, 24),
(4.5, 25),
(4.3, 26),
(4.8, 27),
(4.2, 28),
(4.1, 29),
(4.6, 30),
(4.0, 31),
(4.7, 32),
(4.5, 33),
(4.3, 34),
(4.8, 35),
(4.1, 36),
(4.4, 37),
(4.0, 38),
(4.2, 39),
(4.7, 40),
(4.5, 41),
(4.6, 42),
(4.8, 43),
(4.1, 44),
(4.4, 45),
(4.9, 46),
(4.2, 47),
(4.3, 48),
(4.7, 49),
(4.5, 50);


-- driver table seed data
INSERT INTO driver (available, rating, user_id, vehicle_id, current_location)
VALUES
(true, 4.2, 2, 'DL2XYZ456', ST_GeomFromText('POINT(77.3910 28.5355)', 4326)), -- Noida
(true, 4.8, 3, 'DL3PQR789', ST_GeomFromText('POINT(77.0266 28.4595)', 4326)), -- Gurgaon
(false, 4.1, 4, 'DL4MNO111', ST_GeomFromText('POINT(77.2090 28.6139)', 4326)), -- Central Delhi
(true, 3.9, 5, 'DL5XYZ123', ST_GeomFromText('POINT(77.3178 28.4089)', 4326)), -- Faridabad
(true, 4.6, 6, 'DL6ABC456', ST_GeomFromText('POINT(76.9845 28.4080)', 4326)), -- Manesar
(false, 4.0, 7, 'DL7PQR111', ST_GeomFromText('POINT(77.2500 28.4089)', 4326)), -- South Delhi
(true, 4.3, 8, 'DL8DEF789', ST_GeomFromText('POINT(77.3192 28.7041)', 4326)), -- East Delhi
(true, 4.7, 9, 'DL9GHI123', ST_GeomFromText('POINT(77.2135 28.6036)', 4326)), -- Karol Bagh
(true, 4.9, 10, 'DL10JKL456', ST_GeomFromText('POINT(77.2400 28.6166)', 4326)), -- Lajpat Nagar
(false, 3.8, 11, 'DL11MNO789', ST_GeomFromText('POINT(77.2021 28.5721)', 4326)), -- Saket
(true, 4.4, 12, 'DL12PQR111', ST_GeomFromText('POINT(77.2370 28.6465)', 4326)), -- Connaught Place
(true, 4.2, 13, 'DL13XYZ222', ST_GeomFromText('POINT(77.1245 28.7012)', 4326)), -- Model Town
(true, 3.6, 14, 'DL14DEF333', ST_GeomFromText('POINT(77.2019 28.7215)', 4326)), -- Rohini
(true, 4.1, 15, 'DL15GHI444', ST_GeomFromText('POINT(77.0892 28.5101)', 4326)), -- Dwarka
(true, 3.8, 16, 'DL16JKL555', ST_GeomFromText('POINT(77.0707 28.4547)', 4326)), -- Najafgarh
(true, 4.3, 17, 'DL17MNO666', ST_GeomFromText('POINT(77.2290 28.6892)', 4326)), -- Kamla Nagar
(true, 4.2, 18, 'DL18XYZ777', ST_GeomFromText('POINT(77.1950 28.5816)', 4326)), -- Malviya Nagar
(true, 3.9, 19, 'DL19DEF888', ST_GeomFromText('POINT(77.1515 28.6834)', 4326)), -- Punjabi Bagh
(false, 4.6, 20, 'DL20GHI999', ST_GeomFromText('POINT(77.1151 28.7311)', 4326)), -- Pitampura
(true, 4.5, 21, 'DL21JKL101', ST_GeomFromText('POINT(77.0584 28.5049)', 4326)), -- Palam Vihar
(true, 4.8, 22, 'DL22MNO202', ST_GeomFromText('POINT(77.2002 28.6469)', 4326)), -- Civil Lines
(true, 4.3, 23, 'DL23XYZ303', ST_GeomFromText('POINT(77.1612 28.5898)', 4326)), -- Hauz Khas
(true, 4.4, 24, 'DL24DEF404', ST_GeomFromText('POINT(77.2345 28.7412)', 4326)), -- North Campus
(true, 4.1, 25, 'DL25GHI505', ST_GeomFromText('POINT(77.0631 28.4902)', 4326)), -- Vasant Kunj
(false, 4.0, 26, 'DL26JKL606', ST_GeomFromText('POINT(77.0810 28.6204)', 4326)), -- Safdarjung
(true, 4.2, 27, 'DL27MNO707', ST_GeomFromText('POINT(77.1732 28.5887)', 4326)), -- Green Park
(true, 3.7, 28, 'DL28XYZ808', ST_GeomFromText('POINT(77.2224 28.6386)', 4326)), -- Kashmiri Gate
(true, 4.6, 29, 'DL29DEF909', ST_GeomFromText('POINT(77.1717 28.6781)', 4326)), -- Ashok Vihar
(true, 4.0, 30, 'DL30GHI010', ST_GeomFromText('POINT(77.2157 28.7041)', 4326)), -- Shadipur
(true, 4.2, 31, 'DL31JKL011', ST_GeomFromText('POINT(77.3245 28.5678)', 4326)), -- Shahdara
(true, 3.9, 32, 'DL32MNO012', ST_GeomFromText('POINT(77.2707 28.6139)', 4326)), -- West Delhi
(true, 4.5, 33, 'DL33XYZ013', ST_GeomFromText('POINT(77.2745 28.5478)', 4326)), -- New Friends Colony
(true, 4.8, 34, 'DL34DEF014', ST_GeomFromText('POINT(77.3390 28.5766)', 4326)), -- Mayur Vihar
(false, 4.7, 35, 'DL35GHI015', ST_GeomFromText('POINT(77.3100 28.6050)', 4326)), -- Anand Vihar
(true, 4.1, 36, 'DL36JKL016', ST_GeomFromText('POINT(77.3858 28.5646)', 4326)), -- Karkardooma
(true, 4.2, 37, 'DL37MNO017', ST_GeomFromText('POINT(77.3333 28.6421)', 4326)), -- Vivek Vihar
(true, 3.5, 38, 'DL38XYZ018', ST_GeomFromText('POINT(77.2956 28.5456)', 4326)), -- Preet Vihar
(true, 4.3, 39, 'DL39DEF019', ST_GeomFromText('POINT(77.2210 28.6351)', 4326)), -- Chandni Chowk
(true, 4.7, 40, 'DL40GHI020', ST_GeomFromText('POINT(77.1093 28.7050)', 4326)); -- Adarsh Nagar


INSERT INTO wallet(user_id, wallet_balance)
VALUES
(1, 300),
(2, 500);

