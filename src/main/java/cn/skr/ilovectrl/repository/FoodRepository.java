package cn.skr.ilovectrl.repository;


import cn.skr.ilovectrl.pojo.Food;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FoodRepository extends JpaRepository<Food,Integer> {
}
