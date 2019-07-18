package cn.skr.ilovectrl.repository;

import cn.skr.ilovectrl.pojo.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User,Integer> {



    public List<User> findByNameAndPassword(String name,String password);
}
