package org.sid.dao;

import org.sid.entities.Personnel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PersonnelRepository extends JpaRepository<Personnel, Long> {


    public List<Personnel> findAllByOrderByIdAsc();
    @Query("select UPPER(p) from Personnel p " )
    public List<Personnel> findBy();
}


/* Location:              C:\Users\hp\Desktop\quiz.war!\WEB-INF\classes\org\sid\dao\PersonnelRepository.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.0.7
 */