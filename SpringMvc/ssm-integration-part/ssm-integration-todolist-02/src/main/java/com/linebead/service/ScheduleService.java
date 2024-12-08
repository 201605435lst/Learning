package com.linebead.service;

import com.linebead.pojo.Schedule;
import com.linebead.utils.R;

/**
 * @author liushengtao
 * @description 描述
 * @date 2024年12月06日15:06
 */
public interface ScheduleService {
    R getSchedule(Integer pageSize, Integer currentPage);

    R deleteById(Integer id);

    R save(Schedule schedule);
    R update(Schedule schedule);
}
