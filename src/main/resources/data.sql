insert into accounts ( account_number, account_name, account_type, balance_date, currency, opening_available_balance, user_id) values
('585309209','SGSavings726','Savings','2018-11-08', 'SGD', '84327.51','1');

insert into accounts ( account_number, account_name, account_type, balance_date, currency, opening_available_balance, user_id) values
('791066619','AUSavings933','Savings','2018-11-08', 'AUD', '88005.93','1');

insert into accounts ( account_number, account_name, account_type, balance_date, currency, opening_available_balance, user_id) values
('321143048','AUCurrent433','Current','2018-11-08', 'AUD', '38010.62','1');

insert into accounts ( account_number, account_name, account_type, balance_date, currency, opening_available_balance, user_id) values
('347786244','SGCurrent166','Current','2018-11-08', 'SGD', '50664.65','1');

insert into transactions ( account_number, account_name, currency, credit_amount, debit_amount, transaction_date, transaction_narrative, transaction_type) values
('585309209', 'SGSavings726', 'SGD', '9520.88',  null, '2018-11-08', 'Salary Credit', 'Credit');

insert into transactions ( account_number, account_name, currency, credit_amount, debit_amount, transaction_date, transaction_narrative, transaction_type) values
('585309209', 'SGSavings726', 'SGD', null,  '660', '2018-11-08', 'Rent Debit', 'Debit');

insert into transactions ( account_number, account_name, currency, credit_amount, debit_amount, transaction_date, transaction_narrative, transaction_type) values
('791066619', 'AUSavings933', 'AUD', '6600',  null, '2018-11-08', 'Salary Credit', 'Credit');

insert into transactions ( account_number, account_name, currency, credit_amount, debit_amount, transaction_date, transaction_narrative, transaction_type) values
('791066619', 'AUSavings933', 'AUD', null, '500', '2018-11-09', 'Rent Debit', 'Debit');
