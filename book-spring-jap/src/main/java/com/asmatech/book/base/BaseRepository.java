package com.asmatech.book.base;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

@NoRepositoryBean
public interface BaseRepository<T extends BaseEntity , ID extends Number> extends JpaRepository<T, ID>{

	@Transactional
	@Modifying
	@Query("update #{#entityName} t set t.statusCode=:statusCode where t.id=:id")
	void updateEntity(@Param("id") ID id, @Param("statusCode") String statusCode);
}
