package com.practice.diplom.service.implementation;

import com.practice.diplom.dto.TabRequestDto;
import com.practice.diplom.entity.Tab;
import com.practice.diplom.exception.NotFoundException;
import com.practice.diplom.mapper.TabMapper;
import com.practice.diplom.repository.TabRepository;
import com.practice.diplom.service.TabService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TabServiceImpl implements TabService {

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
    public void deleteTabById(Long id) {
        tabRepository.delete(getTabById(id));
    }
}
