package cn.skr.ilovectrl.controller;


import cn.skr.ilovectrl.pojo.Food;
import cn.skr.ilovectrl.repository.FoodRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


import javax.websocket.server.PathParam;
import java.util.Date;
import java.util.List;

@Controller
public class FoodController {


    @Autowired
    private FoodRepository foodRepository;


    @GetMapping("/food")
    @ResponseBody
    public List<Food> getFoods(Model model){


        List<Food> foods = foodRepository.findAll();

        for(Food food:foods){
            System.out.println("get"+food);
        }

        model.addAttribute("foods",foods);

        return foods;
    }


    @PostMapping("/food")
    public String addFood(Food food){

        food.setDate(new Date());

        System.out.println(food);
        foodRepository.save(food);

        return "redirect:/foods.html";
    }


    @PutMapping("/food")
    public String updateFood(Food food){


        food.setDate(new Date());

        System.out.println(food+">>>>");

        foodRepository.save(food);

        return "redirect:/foods.html";

    }

    @DeleteMapping("/food/{id}")
    public String deleteFood(@PathVariable(name = "id")int id){

        Food food = foodRepository.getOne(id);
        System.out.println("delete:  "+food);
        foodRepository.delete(food);
        return "redirect:/foods.html";
    }

}
