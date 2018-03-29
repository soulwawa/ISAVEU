package org.Isaveu.domain;

import java.io.Serializable;
import java.sql.Timestamp;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@Getter
@Setter
public class TbFireExVO implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private int fire_ex_id;
	private int location_id;
	private String fire_ex_name;
	private String fire_ex_mac;
	private String fire_ex_status;
	private Timestamp fire_ex_make;
	private Timestamp next_check;
	private Timestamp check_date;
	 

}
