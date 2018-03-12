package com.mortgage.maps.web.swagger;

import static com.google.common.collect.Lists.newArrayList;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RequestMethod;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.builders.ResponseMessageBuilder;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {
	
	private static final String SWAGGER_API_VER = "1.0";
	private static final String LICENSE_TEXT = "Terms of Service";
	private static final String TITLE = "MAPS API";
	private static final String DESCRIPTION = "Mortgage Application Processing Systems APIs";


    @Bean
    public Docket mapsApi() {
        return new Docket(DocumentationType.SWAGGER_2)
        		.apiInfo(apiInfo())
        		.pathMapping("/maps/")
        		.select().apis(RequestHandlerSelectors.basePackage("com.mortgage.maps.web.controller"))
        		//.paths(PathSelectors.ant("/maps/api/customer/*.*"))
        		.paths(PathSelectors.any())
        		.build()
        		.enableUrlTemplating(false)
        		.useDefaultResponseMessages(false)
                .globalResponseMessage(RequestMethod.GET, newArrayList(new ResponseMessageBuilder().code(500).message("500 message").responseModel(new ModelRef("Error")).build(), new ResponseMessageBuilder().code(403).message("Forbidden!!!!!").build()));
    }

    private ApiInfo apiInfo() {
        //ApiInfo apiInfo = new ApiInfo("MAPS API", "Mortgage Application Processing Systems APIs", "API ToS", "Terms of service", new Contact("Sree Rad", "www.mortgage-maps.com", "mortgageloans@maps.com"), "License of API", "API license URL", Collections.emptyList());
        //return apiInfo;
    	
    	return new ApiInfoBuilder()
    			.title(TITLE)
    			.description(DESCRIPTION)
    			.license(LICENSE_TEXT)
    			.version(SWAGGER_API_VER)
    			.build();
    			
    }
} 