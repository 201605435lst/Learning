package com.linebead.mapper;


import com.linebead.pojo.Schedule;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author liushengtao
 * @description 描述
 * @date 2024年12月06日15:05
 */
@Repository
public interface ScheduleMapper {

    List<Schedule> selectAll();

    int delete(Integer id);

    /*save*/
    int save(Schedule schedule);
    int update(Schedule schedule);

}
