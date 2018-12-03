package com.xubh.springboot.repository;

import com.xubh.springboot.entity.Users;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * PagingAndSortingRepository接口
 */
public interface UsersRepositoryPagingAndSorting extends PagingAndSortingRepository<Users, Integer> {

}
