package net.spring.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import net.spring.entity.Metadata;

@Repository
public interface Repo extends JpaRepository<Metadata,Long>{

    @Query("select d from Metadata d where d.fileName like %:keyword% or d.userId like %:keyword%")
    List<Metadata> findByFileNameOrUserId(@Param("keyword") String keyword);

    List<Metadata> findByFileNameIgnoreCaseContaining(String keyword);
}
