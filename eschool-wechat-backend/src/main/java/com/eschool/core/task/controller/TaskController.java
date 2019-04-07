package com.eschool.core.task.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.eschool.core.task.dto.TaskFormDTO;
import com.eschool.core.task.dto.TaskListDTO;
import com.eschool.core.task.dto.TaskSearchDTO;
import com.eschool.core.task.dto.TaskShowDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.eschool.core.task.service.TaskService;


/**
 * 任务信息
 *
 * @author yanghanchun
 * @version 1.0
 * @date 2019-03-21 16:28:25
 */
@RestController
@RequestMapping("/api/task")
public class TaskController {
    @Autowired
    private TaskService taskService;

    /**
     * 发布任务
     * @param dto
     */
    @PostMapping("/save")
    public void save(@RequestBody TaskFormDTO dto){
        taskService.saveOrUpdateTask(dto);
    }

    /**
     * 编辑任务
     * @param dto
     */
    @PostMapping("/edit")
    public void edit(@RequestBody TaskFormDTO dto){
        taskService.saveOrUpdateTask(dto);
    }

    /**
     * 详情页
     * @param id
     * @return
     */
    @GetMapping("/show/{id}")
    public TaskShowDTO show(@PathVariable("id") Integer id){
        return taskService.getInfoById(id);
    }

    @PostMapping("/list")
    public IPage<TaskListDTO> list(@RequestBody TaskSearchDTO dto){
        IPage<TaskListDTO> page = taskService.queryForList(dto);
        return page;
    }

}
