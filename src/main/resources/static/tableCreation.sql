/* CLient Master table */
create table client_master (client_no varchar(6) not null, address1 varchar(30),
 address2 varchar(30), bal_due double precision, city varchar(15), 
 name varchar(20) not null, pincode bigint, state varchar(15), primary key (client_no)) 


/* Product master table */
create table product_master (product_no varchar(6) not null, cost_price double precision not null,
 description varchar(15) not null, profile_percent double precision not null,
  qty_no_hand bigint not null, reorder_lvl bigint not null, sell_price double precision not null,
   unit_measure varchar(10) not null, primary key (product_no)) 


/* Sale Order Table */
create table sale_order (order_no varchar(6) not null, billed_yn char(1), dely_addr varchar(25),
 dely_date date, dely_type varchar(255), order_date date, order_status integer, client_no_client_no varchar(6),
  salesman_no_salesman_no varchar(6), primary key (order_no))
alter table sale_order add constraint FK3qpjir96mwd43gply6nrdl1ro 
foreign key (salesman_no_salesman_no) references salesman_master (salesman_no)

/* Salesman master Table  */
create table salesman_master (salesman_no varchar(6) not null, address1 varchar(30) not null, 
address2 varchar(30), city varchar(20), pincode varchar(8), remarks varchar(60), 
sal_amt double precision not null, salesman_name varchar(20) not null, state varchar(20), 
tgt_to_get double precision not null, ytd_sales double precision not null, primary key (salesman_no)) 


/* sale_order_details table */
create table sale_order_details (order_no varchar(6) not null,
  product_no varchar(6) not null, product_rate double, qty_display integer, qty_ordered integer, primary key (order_no, product_no));
alter table sale_order_details add constraint foreign key (order_no) references sale_order (order_no);
alter table sale_order_details add constraint foreign key (product_no) references product_master (product_no);
