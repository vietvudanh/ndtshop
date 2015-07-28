use ndtshop;

create table if not exists users(
	id int(10) not null auto_increment primary key,
	username varchar(50) not null,
	`password` varchar(200) not null,
	address varchar(50) not null,
	create_date datetime not null,
	update_date datetime not null
);

create table if not exists categories(
	id int(10) not null auto_increment primary key,
	`name` varchar(500) not null,
	create_date datetime not null,
	update_date datetime not null
);

create table if not exists products(
	id int(10) not null auto_increment primary key,
	`name` varchar(500) not null,
	price float(20) not null,
	create_date datetime not null,
	update_date datetime not null
);

create table if not exists product_category(
	product_id int(10) not null,
	category_id int(10) not null,
	foreign key (`product_id`) 
		references `products`(`id`)
		on delete cascade,
	foreign key (`category_id`) 
		references `categories`(`id`)
		on delete cascade
);

create table if not exists orders(
	id int(10) not null auto_increment primary key,
	user_id int(10) not null,
	create_date datetime not null,
	update_date datetime not null,
	foreign key (`user_id`) 
		references `users`(`id`)
		on delete cascade
);

create table if not exists order_prodcut(
	order_id int(10) not null,
	product_id int(10) not null,
	foreign key (`order_id`) 
		references `orders`(`id`)
		on delete cascade,
	foreign key (`product_id`) 
		references `products`(`id`)
		on delete cascade
);
