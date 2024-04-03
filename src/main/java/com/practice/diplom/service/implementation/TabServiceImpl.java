package com.practice.diplom.service.implementation;

import com.practice.diplom.dto.TabRequestDto;
import com.practice.diplom.dto.TabResponseDto;
import com.practice.diplom.dto.UrlRequest;
import com.practice.diplom.entity.Tab;
import com.practice.diplom.exception.NotFoundException;
import com.practice.diplom.mapper.TabMapper;
import com.practice.diplom.repository.TabRepository;
import com.practice.diplom.service.TabService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TabServiceImpl implements TabService {

    private final String URL = "http://localhost:5001/generate-tabs";

    @Autowired
    private TabRepository tabRepository;
    @Autowired
    private TabMapper tabMapper;


    @Override
    public List<Tab> getAllTabsBySongId(Long id) {
        return tabRepository.findAllBySongId(id);
    }

    @Override
    @Transactional
    public Tab createTab(TabRequestDto tabRequestDto) {
        Tab tab = tabMapper.toEntity(tabRequestDto);
        return tabRepository.save(tab);
    }

    @Override
    public Tab getTabById(Long id) {
        return tabRepository.findById(id).orElseThrow(
                () -> new NotFoundException(String.format("Табулатуры с таким id = %d не существует", id)));
    }

    @Override
    @Transactional
    public List<TabRequestDto> generateTabs(UrlRequest url) {
        RestTemplate restTemplate = new RestTemplate();
        List<TabRequestDto> tabRequestDtos =  restTemplate.postForObject(URL,url,List.class);
        return tabRequestDtos;
    }

    @Override
    @Transactional
    public void deleteTabById(Long id) {
        tabRepository.delete(getTabById(id));
    }
}
