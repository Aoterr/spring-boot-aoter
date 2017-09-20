package com.coreplus.aps.mapper;


import com.coreplus.aps.bean.UserEntity;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface UserMapper {

    List<UserEntity> getAll();

}