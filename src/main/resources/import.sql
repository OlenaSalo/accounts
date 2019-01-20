INSERT INTO user_model (email, first_name, last_name, password, user_role) VALUES
('tommy.johnson@gmail.com', 'Tommy', 'Johnson', '1111', 'USER');


INSERT INTO account_model (code, name, balance, url_to_image) VALUES
('pharma-group', 'Danish Pharmaceutical group', 13250000.0, 'https://upload.wikimedia.org/wikipedia/en/thumb/1/1b/Novo_Nordisk.svg/1200px-Novo_Nordisk.svg.png'),
('samsung-electronics', 'Samsung Corporation Electronics', 3250000.0 , 'https://upload.wikimedia.org/wikipedia/commons/thumb/4/4e/Samsung_Electronics_logo_%28english%29.svg/2000px-Samsung_Electronics_logo_%28english%29.svg.png'),
('nokia-lumia',	'Nokia Lumia Department',	2500000.0, 'https://upload.wikimedia.org/wikipedia/commons/thumb/f/f1/Nokia_Lumia_logo.svg/1280px-Nokia_Lumia_logo.svg.png');

INSERT INTO user_model_accounts (user_model_email, accounts_code) VALUES
('tommy.johnson@gmail.com', 'pharma-group'),
('tommy.johnson@gmail.com', 'samsung-electronics'),
('tommy.johnson@gmail.com', 'nokia-lumia');