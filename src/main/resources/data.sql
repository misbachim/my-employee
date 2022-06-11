INSERT INTO provinces
(id, "name")
VALUES(1, 'East Java');
INSERT INTO provinces
(id, "name")
VALUES(2, 'Central Java');
INSERT INTO provinces
(id, "name")
VALUES(3, 'Bali');
INSERT INTO provinces
(id, "name")
VALUES(4, 'Jakarta');
INSERT INTO provinces
(id, "name")
VALUES(5, 'West Sumatra');

INSERT INTO cities
(id, "name", province_id)
VALUES(1, 'Kota Denpasar', 3);

INSERT INTO cities
(id, "name", province_id)
VALUES(2, 'Kota Magelang', 2);
INSERT INTO cities
(id, "name", province_id)
VALUES(3, 'Kota Pekalongan', 2);
INSERT INTO cities
(id, "name", province_id)
VALUES(4, 'Kota Semarang', 2);
INSERT INTO cities
(id, "name", province_id)
VALUES(5, 'Kota Tegal', 2);

INSERT INTO cities
(id, "name", province_id)
VALUES(6, 'Kota Bukittinggi', 5);
INSERT INTO cities
(id, "name", province_id)
VALUES(7, 'Kota Padang', 5);
INSERT INTO cities
(id, "name", province_id)
VALUES(8, 'Kota Pariaman', 5);
INSERT INTO cities
(id, "name", province_id)
VALUES(9, 'Kota Padang Panjang', 5);

INSERT INTO cities
(id, "name", province_id)
VALUES(10, 'Kota Batu', 1);
INSERT INTO cities
(id, "name", province_id)
VALUES(11, 'Kota Kediri', 1);
INSERT INTO cities
(id, "name", province_id)
VALUES(12, 'Kota Madiun', 1);
INSERT INTO cities
(id, "name", province_id)
VALUES(13, 'Kota Malang', 1);
INSERT INTO cities
(id, "name", province_id)
VALUES(14, 'Kota Mojokerto', 1);

INSERT INTO cities
(id, "name", province_id)
VALUES(15, 'Kota Jakarta Barat', 4);
INSERT INTO cities
(id, "name", province_id)
VALUES(16, 'Kota Jakarta Timur', 4);
INSERT INTO cities
(id, "name", province_id)
VALUES(17, 'Kota Jakarta Utara', 4);
INSERT INTO cities
(id, "name", province_id)
VALUES(18, 'Kota Jakarta Selatan', 4);
INSERT INTO cities
(id, "name", province_id)
VALUES(19, 'Kota Jakarta Pusat', 4);

INSERT INTO bank_accounts
(id, "name")
VALUES(1, 'BANK BUMI ARTA');
INSERT INTO bank_accounts
(id, "name")
VALUES(2, 'BANK CENTRAL ASIA');
INSERT INTO bank_accounts
(id, "name")
VALUES(3, 'BANK MANDIRI');
INSERT INTO bank_accounts
(id, "name")
VALUES(4, 'BANK MEGA');
INSERT INTO bank_accounts
(id, "name")
VALUES(5, 'BANK OCBC NISP');
INSERT INTO bank_accounts
(id, "name")
VALUES(6, 'BANK RAKYAT INDONESIA');

INSERT INTO positions
(id, "name")
VALUES(1, '.NET Developer');
INSERT INTO positions
(id, "name")
VALUES(2, 'Android Programmer');
INSERT INTO positions
(id, "name")
VALUES(3, 'CEO');
INSERT INTO positions
(id, "name")
VALUES(4, 'Cleaning Service');
INSERT INTO positions
(id, "name")
VALUES(5, 'Golang Developer');
INSERT INTO positions
(id, "name")
VALUES(6, 'Junior Java Developer');
INSERT INTO positions
(id, "name")
VALUES(7, 'Manager Finance');
INSERT INTO positions
(id, "name")
VALUES(8, 'Manager HR');
INSERT INTO positions
(id, "name")
VALUES(9, 'Manager IT');
INSERT INTO positions
(id, "name")
VALUES(10, 'Market Research Specialist');
INSERT INTO positions
(id, "name")
VALUES(11, 'React Developer');
INSERT INTO positions
(id, "name")
VALUES(12, 'Senior Java Developer');
INSERT INTO positions
(id, "name")
VALUES(13, 'Staff IT');
INSERT INTO positions
(id, "name")
VALUES(14, 'Supervisor Finance');
INSERT INTO positions
(id, "name")
VALUES(15, 'Supervisor IT');

INSERT INTO employees
(id, first_name, last_name, date_of_birth, ktp_number, email_address, phone_number, create_date, modify_date, province_id, city_id, position_id, bank_account_id, bank_account_number, zip_code)
VALUES('dcf2e777-6c26-4072-8f65-9de054e714c9', 'Levin', 'Kusuma', '1985-09-17', '5325235235553675', 'levin@mail.com', '6436346236', '2020-09-16 02:50:08.163', '2021-05-16 23:18:03.117', 1, 12, 5, 1, 8888444477772222, 12345);
INSERT INTO employees
(id, first_name, last_name, date_of_birth, ktp_number, email_address, phone_number, create_date, modify_date, province_id, city_id, position_id, bank_account_id, bank_account_number, zip_code)
VALUES('84e3883a-f53f-4037-9307-555c2a9da631', 'Riella ', 'Mukti', '1997-01-28', '29138012490129300123', 'riella@mail.com', '0812004930482', '2020-12-21 12:01:36.419', '2020-12-21 12:09:21.412', 2, 3, 8, 1, 8888444477772222, 12345);
INSERT INTO employees
(id, first_name, last_name, date_of_birth, ktp_number, email_address, phone_number, create_date, modify_date, province_id, city_id, position_id, bank_account_id, bank_account_number, zip_code)
VALUES('a9cb9e62-88e1-4cd3-b1d8-c7dcf0bdded5', 'Jeno', 'Lee', '2000-04-23', '3318444456668888', 'jenolee@gmail.com', '08779317438', '2021-08-13 13:04:17.285', '2021-08-13 13:14:35.070', 4, 17, 3, 1, 8888444477772222, 12345);
INSERT INTO employees
(id, first_name, last_name, date_of_birth, ktp_number, email_address, phone_number, create_date, modify_date, province_id, city_id, position_id, bank_account_id, bank_account_number, zip_code)
VALUES('4433de31-986c-44b8-9497-7d84d46d79aa', 'bolak', 'balik', '1999-01-01', '2646244623463463', 'bolakbalik@mail.com', '000000000000', '2021-09-07 07:51:14.443', '2021-09-07 16:37:29.629', 3, 1, 1, 1, 8888444477772222, 12345);
INSERT INTO employees
(id, first_name, last_name, date_of_birth, ktp_number, email_address, phone_number, create_date, modify_date, province_id, city_id, position_id, bank_account_id, bank_account_number, zip_code)
VALUES('b8281f58-bf38-4f9c-8a15-a68f62e3a168', 'Zacky', 'Aninun', '1990-09-10', '26246246624364', 'zacky-@mailptc.com', '353454463', '2020-09-16 09:49:58.740', '2021-09-10 15:26:05.277', 1, 14, 12, 3, 8888444477772222, 12345);
INSERT INTO employees
(id, first_name, last_name, date_of_birth, ktp_number, email_address, phone_number, create_date, modify_date, province_id, city_id, position_id, bank_account_id, bank_account_number, zip_code)
VALUES('73e82759-d4b6-4195-a6bb-4a70879469e8', 'Fariz Aufar', 'Sugandi', '1997-09-14', '301230102013', 'aufar.sugandi@gmail.com', '02172797223', '2021-03-10 11:10:02.366', '2021-03-10 11:17:54.944', 3, 1, 2, 5, 8888444477772222, 12345);
INSERT INTO employees
(id, first_name, last_name, date_of_birth, ktp_number, email_address, phone_number, create_date, modify_date, province_id, city_id, position_id, bank_account_id, bank_account_number, zip_code)
VALUES('d5e5fcfb-f61f-4422-8e38-7f7764bcaaa0', 'Kholil ', 'Akhmad', '2012-03-01', '1231324@#12313213123c', 'test@gmail.com', '123131', '2021-08-30 11:59:35.014', '2021-09-07 16:43:50.081', 1, 12, 3, 5, 8888444477772222, 12345);
INSERT INTO employees
(id, first_name, last_name, date_of_birth, ktp_number, email_address, phone_number, create_date, modify_date, province_id, city_id, position_id, bank_account_id, bank_account_number, zip_code)
VALUES('e32177ee-bff4-42dd-a892-871588bacc18', 'Anthony', 'Ginting', '1996-10-20', '3341555566660000', 'anthony@gmail.com', '087810094386', '2021-08-13 16:33:46.614', '2021-08-18 10:58:34.041', 2, 4, 11, 6, 8888444477772222, 12345);
INSERT INTO employees
(id, first_name, last_name, date_of_birth, ktp_number, email_address, phone_number, create_date, modify_date, province_id, city_id, position_id, bank_account_id, bank_account_number, zip_code)
VALUES('05561cf4-7255-44ca-b627-be5767773a3f', 'John ', 'Son', '2021-06-30', '893742398427', 'john.son@mail.com', '342323498234', '2021-09-03 14:28:24.892', '2021-09-07 16:48:41.730', 1, 14, 4, 1, 8888444477772222, 12345);
INSERT INTO employees
(id, first_name, last_name, date_of_birth, ktp_number, email_address, phone_number, create_date, modify_date, province_id, city_id, position_id, bank_account_id, bank_account_number, zip_code)
VALUES('df6303a5-ed07-4d7d-ad17-b0e7fd58e087', 'John', 'Doe', '1996-12-10', '1023910237130''//', 'test@test.com', '12341412313', '2021-09-03 10:18:54.955', '2021-09-09 11:41:23.067', 2, 2, 4, 6, 8888444477772222, 12345);
INSERT INTO employees
(id, first_name, last_name, date_of_birth, ktp_number, email_address, phone_number, create_date, modify_date, province_id, city_id, position_id, bank_account_id, bank_account_number, zip_code)
VALUES('fe1ff7d5-195d-493e-b0f7-375459be5eba', 'Dzaky', 'Fadhilla', '1998-03-07', '12309855', 'dzaky@gmail.com', '081282810393', '2021-04-29 16:08:52.019', '2021-04-30 09:56:06.941', 3, 1, 4, 5, 8888444477772222, 12345);
INSERT INTO employees
(id, first_name, last_name, date_of_birth, ktp_number, email_address, phone_number, create_date, modify_date, province_id, city_id, position_id, bank_account_id, bank_account_number, zip_code)
VALUES('30f18546-93fe-4615-9593-9be8447baac4', 'Misbach', 'Meitirto', '1995-08-17', '0000004', 'misbach@mail.com', '0000004', '2020-10-16 05:42:25.155', '2021-05-19 09:34:46.201', 2, 4, 12, 4, 8888444477772222, 12345);
INSERT INTO employees
(id, first_name, last_name, date_of_birth, ktp_number, email_address, phone_number, create_date, modify_date, province_id, city_id, position_id, bank_account_id, bank_account_number, zip_code)
VALUES('1ad6cb7e-211c-4165-9ae5-6308ddc42053', 'Galih', 'Home', '1998-12-17', '367637263822211', 'galihome@mail.com', '081911090909', '2021-08-18 15:07:50.789', '2021-08-18 15:11:00.331', 1, 13, 4, 3, 8888444477772222, 12345);
INSERT INTO employees
(id, first_name, last_name, date_of_birth, ktp_number, email_address, phone_number, create_date, modify_date, province_id, city_id, position_id, bank_account_id, bank_account_number, zip_code)
VALUES('f6fee554-a0ac-406a-91a7-d35ebe13dc36', 'Senior', 'Dimas', '1990-02-28', '129313', 'dimas@kw.com', '08182313', '2021-04-28 08:06:07.144', '2021-09-08 08:14:54.032', 2, 4, 8, 5, 8888444477772222, 12345);
INSERT INTO employees
(id, first_name, last_name, date_of_birth, ktp_number, email_address, phone_number, create_date, modify_date, province_id, city_id, position_id, bank_account_id, bank_account_number, zip_code)
VALUES('f2d8446b-55d4-4a2f-905e-19aa1fdc0cf5', 'gantipass', 'gantipass', '2021-05-24', '12312312321', 'akjsdkj@gmail.com', '198982891389', '2021-05-28 15:41:37.761', '2021-09-08 02:42:05.496', 1, 11, 1, 1, 8888444477772222, 12345);
INSERT INTO employees
(id, first_name, last_name, date_of_birth, ktp_number, email_address, phone_number, create_date, modify_date, province_id, city_id, position_id, bank_account_id, bank_account_number, zip_code)
VALUES('9ab795e0-9692-4e55-9026-c7506cb5d73c', 'Audi', 'Marisa', '1995-06-07', '4521673278679332', 'maudir@gmail.com', '067828736465', '2021-06-07 04:27:12.624', '2021-06-07 04:43:43.635', 2, 3, 4, 2, 8888444477772222, 12345);
INSERT INTO employees
(id, first_name, last_name, date_of_birth, ktp_number, email_address, phone_number, create_date, modify_date, province_id, city_id, position_id, bank_account_id, bank_account_number, zip_code)
VALUES('3cc2b759-6c35-478f-a998-09d57fe16f0a', 'Anggi', 'Alberto', '1998-07-02', '367402921198774', 'anggialbertos@mail.com', '081214045223', '2021-06-16 14:46:25.244', '2021-06-16 14:58:25.026', 4, 15, 12, 5, 8888444477772222, 12345);
INSERT INTO employees
(id, first_name, last_name, date_of_birth, ktp_number, email_address, phone_number, create_date, modify_date, province_id, city_id, position_id, bank_account_id, bank_account_number, zip_code)
VALUES('8bd09451-2b00-43b1-8490-50dd3afa6887', 'Agung Herculer', 'Setyo', '1993-09-17', '14124124124124', 'agungsetyo@mail.com', '05740303', '2020-08-24 08:24:14.132', '2021-07-19 16:51:37.444', 3, 1, 3, 2, 8888444477772222, 12345);
INSERT INTO employees
(id, first_name, last_name, date_of_birth, ktp_number, email_address, phone_number, create_date, modify_date, province_id, city_id, position_id, bank_account_id, bank_account_number, zip_code)
VALUES('1c82338d-b2ca-4c4f-a0ea-858850159c74', 'Benny', 'Romiko', '2021-08-10', '83472049234809', 'benny.@mail.com', '12312312312', '2021-09-03 16:39:17.567', '2021-09-06 09:06:47.250', 1, 11, 5, 5, 8888444477772222, 12345);
INSERT INTO employees
(id, first_name, last_name, date_of_birth, ktp_number, email_address, phone_number, create_date, modify_date, province_id, city_id, position_id, bank_account_id, bank_account_number, zip_code)
VALUES('0e12bac5-3ce8-4ba6-86fc-23d489bd218d', 'Kim ', 'Jong Un', '2021-07-06', '12314234131231', '31313@mail.org', '4234131', '2021-09-03 11:22:53.646', '2021-09-06 10:44:54.622', 2, 3, 13, 6, 8888444477772222, 12345);
