package com.linebead.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.linebead.mapper.ScheduleMapper;
import com.linebead.pojo.Schedule;
import com.linebead.utils.PageBean;
import com.linebead.utils.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author liushengtao
 * @description 描述
 * @date 2024年12月06日15:06
 */
@Service
public class ScheduleServiceImpl implements ScheduleService {

    @Autowired
    private ScheduleMapper scheduleMapper;

    @Override
    public R getSchedule(Integer pageSize, Integer currentPage) {

        PageHelper.startPage(currentPage, pageSize);
        List<Schedule> list=scheduleMapper.selectAll();

        PageInfo<Schedule> pageInfo = new PageInfo<>(list);
        PageBean<Schedule> pageBean = new PageBean<>(currentPage, pageSize, pageInfo.getTotal(), pageInfo.getList());
        return R.ok(pageBean);
    }

    @Override
    public R deleteById(Integer id) {
       int i =scheduleMapper.delete(id);

       if(i>0){
           return R.ok(null);
       }

        return R.fail(null);
    }

    @Override
    public R save(Schedule schedule) {

       int i = scheduleMapper.save(schedule);
        if(i>0){
            return R.ok(null);
        }

        return R.fail(null);
    }

    @Override
    public R update(Schedule schedule) {
        int i = scheduleMapper.update(schedule);
        if(i>0){
            return R.ok(null);
        }

        return R.fail(null);
    }
}
