insert into tb_event values (null,1,now(),0,0,0,0,0);

show tables;
select* from tb_action order by action_id DESC;
select* from tb_event order by event_id DESC;
select* from tb_fire_ex;
select* from tb_hr;
select* from tb_location;
SELECT * FROM tb_module;

select* from tb_event event
inner join tb_module module on event.module_id = module.module_id
inner join tb_location location on module.location_id = location.location_id
order by event_id desc limit 11;


select * from tb_hr where id = '0000000000';


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
	*
FROM tb_location location, tb_module module, tb_event event
WHERE location.location_id = module.location_id and module.location_id = event.module_id
and event.time > DATE_ADD(NOW(), INTERVAL -20 hour_second)
order by issue limit 14;

SELECT distinct
	event.issue , event.time, location.location
FROM tb_location location, tb_module module, tb_event event
WHERE location.location_id = module.location_id and module.location_id = event.module_id
GROUP BY location.location;

SELECT 
	event.issue, location.location, event.time
FROM tb_event event, tb_location location, tb_module module
where location.location_id = module.location_id and module.location_id = event.module_id and time = now();



SELECT 
	event.issue, location.location, event.time
FROM tb_event event, tb_location location, tb_module module
GROUP BY location order by time desc;

SELECT count(*) FROM tb_location WHERE location LIKE '6%';

SELECT
	count(*)
FROM tb_module module, tb_location location
where module.location_id = location.location_id
and module.type = 'arduino' and location LIKE '6%';

select* from tb_action order by action_id DESC;
select* from tb_event order by event_id DESC;
select* from tb_fire_ex;
select* from tb_hr;
select* from tb_location;
SELECT * FROM tb_module;
SELECT * FROM tb_board;

select* from tb_event WHERE module_id="0" limit 12;

SELECT * FROM tb_event WHERE module_id ="0" ORDER BY event_id DESC LIMIT 121;

SELECT * FROM tb_event WHERE module_id ="0" order by time DESC limit 12; 

SELECT * FROM tb_location
INNER JOIN tb_fire_ex
ON tb_location.location_id = tb_fire_ex.location_id and fire_ex_name= 'fe-01';

SELECT * FROM tb_event WHERE module_id = "0" ORDER BY event_id	DESC LIMIT 12;

SELECT * FROM tb_fire_ex WHERE fire_ex_name = "fe-01";
UPDATE tb_fire_ex
	Inner join tb_location
	ON tb_fire_ex.location_id = tb_location.location_id0
	set fire_ex_status = 1
	WHERE location = '600';
    
    
select event.event_id, event.time, event.issue, location.location, location.dept_name
from tb_event event
inner join tb_module module on event.module_id = module.module_id
inner join tb_location location on module.location_id = location.location_id
where module.module_id = '0' order by event_id desc limit 1;

SELECT 
	event_id, module_id, time_format(time, "%T") as 'time', truncate(temp, 2) as 'temp',  truncate(smoke/20,2) as 'smoke',
	 truncate(80 - (gyro/13),2) as 'gyro',  truncate(80 - (fire/13),2) as 'fire', issue 
	FROM
	tb_event
	order by event_id DESC limit 12; 

SELECT
	action_id, action.module_id, action.time,
    replace(action.url,'C:\\Users\\user\\Documents\\ISAVEU\\spring\\ISaveU\\src\\main\\resources\\static\\eventImage\\',
    'http://192.168.0.35:99/eventImage/')
, event.issue, location.dept_name
FROM tb_action action
	inner join tb_event event on action.time = event.time
	inner join tb_module module on event.module_id = module.module_id
	inner join tb_location location on module.location_id = location.location_id
WHERE issue >= "1"
	order by event.time DESC;

select* from tb_action order by action_id DESC;

SELECT
	*
FROM tb_location
INNER JOIN tb_fire_ex
ON tb_location.location_id = tb_fire_ex.location_id;


/*tb_location.location_id, tb_location.location, tb_location.dept_name, tb_location.manager,
        tb_location.dept_tel, tb_fire.fire_ex_id, tb_fire.location_id, tb_fire.fire_ex_name, tb_fire.fire_ex_mac,
        tb_fire.fire_ex_make, tb_fire.next_chcek, tb_fire.check_date, tb_fire.fire_ex_status
        