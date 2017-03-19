package com.sitong.controller;

import com.sitong.domain.Girl;
import com.sitong.repository.GirlRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * Created by LiuSitong on 2017/3/19.
 */
@RestController
public class GirlController {

    @Autowired
    private GirlRepository girlRepository;




    /**
     * 查询所有女生列表
     * @return 所有女生列表
     */
    @GetMapping(value = "/girls")
    public List<Girl>  girlList(){
        return girlRepository.findAll();
    }

    /**
     * 添加一个女生
     * @param //cupSize
     * @param //age
     * @return
     */
//    @PostMapping(value = "/girls")
//    public Girl addGirls(@RequestParam("cupSize") String cupSize,
//                           @RequestParam("age") Integer age){
//        Girl girl = new Girl();
//        girl.setAge(age);
//        girl.setCupSize(cupSize);
//
//        return girlRepository.save(girl);
//
//    }


    @PostMapping(value = "/girls")
    public Girl addGirl(@Valid Girl girl , BindingResult bindingResult){

        //如果有错误就返回
        if (bindingResult.hasErrors()){
            System.out.println(bindingResult.getFieldError().getDefaultMessage());
            return null;
        }

        girl.setAge(girl.getAge());
        girl.setCupSize(girl.getCupSize());

        return girlRepository.save(girl);
    }


    //按照id查询女生
    @GetMapping(value = "/girls/id/{id}")
      public Girl findOneGirl(@PathVariable("id") Integer id){
        return girlRepository.getOne(id);
    }

    //按照年龄查找
    @GetMapping(value = "/girls/age/{age}")
    public List<Girl> findOneGirlByAge (@PathVariable("age") Integer age){
        return girlRepository.findByAge(age);
    }


    //更新
    @PutMapping(value = "/girls/{id}")
    public Girl updateGirl(@PathVariable("id") Integer id,
                           @RequestParam("cupSize") String cupSize,
                           @RequestParam("age") Integer age){
          Girl girl =new Girl();
          girl.setId(id);
          girl.setCupSize(cupSize);
          girl.setAge(age);
          return girlRepository.save(girl);
    }


    //删除
    @DeleteMapping(value = "/girls/{id}")
    public void deleteGirlById(@PathVariable("id") Integer id){
        girlRepository.delete(id);
    }
}
