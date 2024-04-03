package com.practice.diplom.service;

import com.practice.diplom.dto.TabRequestDto;
import com.practice.diplom.dto.UrlRequest;
import com.practice.diplom.entity.Tab;

import java.util.List;

public interface TabService {

    List<Tab> getAllTabsBySongId(Long id);

    Tab createTab(TabRequestDto tabRequestDto);

    Tab getTabById(Long id);

    List<TabRequestDto> generateTabs(UrlRequest url);

    void deleteTabById(Long id);
}
