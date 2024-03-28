package com.practice.diplom.mapper;

import com.practice.diplom.dto.TabRequestDto;
import com.practice.diplom.dto.TabResponseDto;
import com.practice.diplom.entity.Tab;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface TabMapper extends GeneralMapper<TabResponseDto, Tab, TabRequestDto>{
}
