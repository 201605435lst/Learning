package com.linebead.controller;

import com.linebead.pojo.Schedule;
import com.linebead.service.ScheduleService;
import com.linebead.utils.R;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * @author liushengtao
 * @description 描述
 * @date 2024年12月06日15:05
 */
@CrossOrigin
@RestController
@RequestMapping("schedule")
@Slf4j
public class ScheduleController {

    @Autowired
    private ScheduleService scheduleService;

    /*获取分页信息*/
    @GetMapping("getSchedule/{pageSize}/{currentPage}")
    public R getSchedule(@PathVariable("pageSize") Integer pageSize, @PathVariable("currentPage") Integer currentPage) {


        log.info("pageSize:{},currentPage:{}", pageSize, currentPage);

        R r = scheduleService.getSchedule(pageSize, currentPage);

        log.info("数据信息{}", r);

        return r;

    }

    @DeleteMapping("deleteById/{id}")
    public R deleteById(@PathVariable Integer id) {
        R r = scheduleService.deleteById(id);
        return r;
    }

    @PostMapping
    public R save(@Validated @RequestBody Schedule schedule, BindingResult result) {

        if(result.hasErrors()){
            return R.fail(result.getFieldError().getDefaultMessage());
        }
        R r = scheduleService.save(schedule);
        return r;
    }

    @PutMapping
    public R update(@Validated @RequestBody Schedule schedule, BindingResult result) {

        if(result.hasErrors()){
            return R.fail(result.getFieldError().getDefaultMessage());
        }
        R r = scheduleService.update(schedule);
        return r;
    }


}
