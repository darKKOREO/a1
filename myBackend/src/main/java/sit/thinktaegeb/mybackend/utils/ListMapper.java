package sit.thinktaegeb.mybackend.utils;

import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import sit.thinktaegeb.mybackend.dtos.PageDTO;

import java.util.List;
import java.util.stream.Collectors;
public class ListMapper {
    private static final ListMapper listMapper = new ListMapper();

    private ListMapper() {
    }
    public static ListMapper getInstance() {
        return listMapper;
    }
    public <S, T> List<T> mapList(List<S> source, Class<T> targetClass, ModelMapper modelMapper) {
        return source.stream().map(entity -> modelMapper.map(entity, targetClass)).collect(Collectors.toList());
    }
    public <S, T> PageDTO<T> toPageDTO(Page<S> source, Class<T> targetClass, ModelMapper modelMapper) {
        PageDTO<T> page = modelMapper.map(source, PageDTO.class);
        page.setContent(mapList(source.getContent(), targetClass, modelMapper));
        return page;
    }

}
