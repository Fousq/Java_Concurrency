package kz.zhanbolat.concurrency.repository;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLGenerator;
import com.fasterxml.jackson.dataformat.yaml.YAMLMapper;

public enum ObjectMapperFactory {
    INSTANCE;

    public ObjectMapper createYmlObjectMapper() {
        YAMLMapper mapper = new YAMLMapper().disable(YAMLGenerator.Feature.WRITE_DOC_START_MARKER);
        mapper.findAndRegisterModules();
        return mapper;
    }
}
