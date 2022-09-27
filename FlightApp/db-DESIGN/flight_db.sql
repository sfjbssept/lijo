CREATE TABLE `tb_user` (
  `id` int PRIMARY KEY AUTO_INCREMENT,
  `username` varchar(255),
  `password` password,
  `role` varchar(255),
  `status` varchar(255)
);

CREATE TABLE `tb_passenger` (
  `id` int PRIMARY KEY AUTO_INCREMENT,
  `user_id` int,
  `name` varchar(255),
  `address` varchar(255),
  `passport` varchar(255),
  `id_card_no` varchar(255),
  `id_card_type` varchar(255),
  `gender` gender,
  `age` age,
  `dob` dob,
  `phone` phone
);

CREATE TABLE `tb_airline` (
  `id` int PRIMARY KEY AUTO_INCREMENT,
  `airline_name` varchar(255),
  `no_of_flights` int,
  `status` varchar(255),
  `contact` varchar(255),
  `website` varchar(255),
  `international_service` varchar(255),
  `domestice_service` varchar(255)
);

CREATE TABLE `tb_flight` (
  `flight_id` int PRIMARY KEY AUTO_INCREMENT,
  `flight_name` varchar(255),
  `no_of_rows` int,
  `busines_class_seats` int,
  `economy_class_sats` int,
  `airline_id` int,
  `instrument` varchar(255),
  `start_date` timestamp,
  `scheduled_days` varchar(255),
  `status` varchar(255)
);

CREATE TABLE `tb_flight_detail` (
  `id` int PRIMARY KEY AUTO_INCREMENT,
  `flight_id` int,
  `from` varchar(255),
  `to` varchar(255),
  `start_time` timestamp,
  `end_time` timestamp,
  `duration` int,
  `busines_class_Cost` int,
  `econmoy_cost` int
);

CREATE TABLE `tb_ticket_detail` (
  `id` int PRIMARY KEY AUTO_INCREMENT,
  `ticket_no` int,
  `flight_id` int,
  `flight_type` varchar(255),
  `ticket_cost` int,
  `meal_type` varchar(255),
  `passenger_id` int
);

ALTER TABLE `tb_passenger` ADD FOREIGN KEY (`user_id`) REFERENCES `tb_user` (`id`);

ALTER TABLE `tb_flight` ADD FOREIGN KEY (`airline_id`) REFERENCES `tb_airline` (`id`);

ALTER TABLE `tb_flight_detail` ADD FOREIGN KEY (`flight_id`) REFERENCES `tb_flight` (`flight_id`);

ALTER TABLE `tb_ticket_detail` ADD FOREIGN KEY (`flight_id`) REFERENCES `tb_flight` (`flight_id`);

ALTER TABLE `tb_ticket_detail` ADD FOREIGN KEY (`passenger_id`) REFERENCES `tb_passenger` (`id`);
