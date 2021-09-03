package ru.pink.ponies.web.mapper;

import org.mapstruct.Mapper;
import ru.pink.ponies.web.dto.Good;

import java.util.function.BiFunction;

@Mapper(componentModel = "spring")
public interface GoodPatcher extends BiFunction<Good, Good, Good> {

}
