package com.spb.StrangersPlayBackend.mapper;

import com.spb.StrangersPlayBackend.dto.AccountDto;
import com.spb.StrangersPlayBackend.model.AccountModel;
import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.impl.ConfigurableMapper;
import org.springframework.stereotype.Component;


@Component
public class DefaultMapper extends ConfigurableMapper {

    @Override
    protected void configure(MapperFactory factory) {
        factory.classMap(AccountModel.class, AccountDto.class)
                .byDefault()
                .register();
    }
}

