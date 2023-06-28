package com.platzi.platzimarket.persistencia.mapper;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import com.platzi.platzimarket.domain.Category;
import com.platzi.platzimarket.persistencia.entity.Categoria;

@Mapper(componentModel = "spring")
public interface CategoryMapper {
    @Mappings({
        @Mapping(source="idCategoria",target="categoryId"),
        @Mapping(source="descripcion",target="category"),
        @Mapping(source="estado",target="active"),
    })
    Category toCategoryMapper(Categoria categoria);
    
    @InheritInverseConfiguration
    @Mapping(target="productos",ignore=true)
    Categoria toCategoria(Category category);

}
