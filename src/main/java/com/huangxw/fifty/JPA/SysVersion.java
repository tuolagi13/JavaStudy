package com.huangxw.fifty.JPA;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;

@Data
@AllArgsConstructor
@Table("sys_version")
public class SysVersion {
    private Integer version_id;
    private String version_no;
    private Date create_time;
    private String version_change;
}
