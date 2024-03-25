INSERT INTO public."users"
(id,name,email,password,role_type) VALUES
(1,'Igor','igor.work@mail.ru','test','USER'),
(2,'Danila','danya.strushko@mail.ru','myPassword','ADMIN');

INSERT INTO public."songs"
(id,author,name) VALUES
(1,'Green Day','Holiday'),
(2,'Blink-182','Adams Song');

INSERT INTO public."tabs"
(id,instrument_name,url,song_id) VALUES
(1,'Distortion Guitar lead','url1',1),
(2,'Electric Bass','url2',1),
(3,'Distortion Guitar rhythm','url3',1),
(4,'Electric Bass','url4',2),
(5,'Electric Guitar clean','url5',2),
(6,'Distortion Guitar rhythm','url6',2);

INSERT INTO public."user_songs"
(id,user_id,song_id) VALUES
(1,1,2),
(2,2,1);