insert into tb_event values (null,1,now(),0,0,0,0,0);

show tables;
select* from tb_action order by action_id DESC;
select* from tb_event order by event_id DESC;
select* from tb_fire_ex;
select* from tb_hr;
select* from tb_location;


SELECT 
    *
FROM
    tb_module;
select * from tb_hr where id = '0000000000';
SELECT
* 
FROM
tb_event
ORDER BY
event_id
DESC LIMIT 12;

update tb_hr SET FCM = 'foSJVNORz8Y:APA91bEMxsYGGEEGlqnxPa3Gh3OB25evSPs5nR5yfbmxvEBbZvMn4aoo3L0Cn78bImFNVFSCEchn60Ii_-HQVjUapqkAeHeNo_roY4yUVeUgHIH2V20SaSdo3nFcQerbyrfjXPrxpImX' WHERE id = '0000000000';
update tb_hr SET profile = 'http://192.168.0.35:9999/img/HR_profile/avatar04.png' WHERE id = '2222222222';

INSERT INTO tb_action
VALUES
 (2, "C:\workspace\SaveForYou\spring\ISaveU\src\main\resources\eventImage\20180327_103420.png", now());
SELECT * FROM tb_hr;

select * FROM tb_fire_ex LEFT OUTER JOIN tb_location ON tb_fire_ex.location_id = tb_location.location_id;

select
 *
FROM tb_location
INNER JOIN
 tb_fire_ex
ON tb_location.location_id = tb_fire_ex.location_id;

select
 tb_location.location, tb_fire_ex.check_date
FROM tb_location
INNER JOIN
 tb_fire_ex
ON tb_location.location_id = tb_fire_ex.location_id;

SELECT * FROM `iot_smartbuilding`.`tb_event` ORDER BY `event_id` DESC LIMIT 12;

SELECT
	*
FROM tb_module
INNER JOIN
	tb_location
ON tb_module.location_id = tb_location.location_id
WHERE
 module_id = 2; 
 
update tb_fire_ex Inner join tb_location
ON tb_fire_ex.location_id = tb_location.location_id
set fire_ex_status = 1
WHERE location = 600;

SELECT
	*
FROM tb_module
WHERE type = "arduino";

SELECT distinct
 location.location, event.time, event.issue
FROM tb_location location, tb_module module, tb_event event
WHERE location.location_id = module.location_id and module.location_id = event.module_id
and event.time > DATE_ADD(NOW(), INTERVAL -2 hour)
limit 

SELECT count(*) FROM tb_location;
