package com.asmatech.book.repository;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import com.asmatech.book.base.BaseRepository;
import com.asmatech.book.entity.Auther;

@Repository
public interface AutherRepository extends BaseRepository<Auther, Long>, JpaSpecificationExecutor<Auther>{

}
