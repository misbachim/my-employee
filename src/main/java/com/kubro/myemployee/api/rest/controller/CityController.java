package com.kubro.myemployee.api.rest.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.kubro.myemployee.entity.City;
import com.kubro.myemployee.exception.DataFormatException;
import com.kubro.myemployee.mapstruct.dto.CityDto;
import com.kubro.myemployee.mapstruct.mapper.MapStructMapper;
import com.kubro.myemployee.service.CityService;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(value = "/api/v1/cities")
public class CityController extends AbstractRestHandler {

        @Autowired
        private CityService cityService;

        @Autowired
        private MapStructMapper mapStructMapper;

        @RequestMapping(value = "", method = RequestMethod.POST, consumes = { "application/json",
                        "application/xml" }, produces = { "application/json", "application/xml" })
        @ResponseStatus(HttpStatus.CREATED)
        public void createCity(@RequestBody City city,
                        HttpServletRequest request, HttpServletResponse response) {
                City createdCity = this.cityService.createCity(city);
                response.setHeader("Location",
                                request.getRequestURL().append("/").append(createdCity.getId()).toString());
        }

    @RequestMapping(value = "",
            method = RequestMethod.GET,
            produces = {"application/json", "application/xml"})
    @ResponseStatus(HttpStatus.OK)
    public
    @ResponseBody
    Page<CityDto> getAllCity(
                                      @RequestParam(value = "provinceId", required = false) Long provinceId,
                                      @RequestParam(value = "page", required = true, defaultValue = DEFAULT_PAGE_NUM) Integer page,
                                      @RequestParam(value = "size", required = true, defaultValue = DEFAULT_PAGE_SIZE) Integer size,
                                      HttpServletRequest request, HttpServletResponse response) {
        
        if (provinceId != null) {
                return this.cityService.getByProvinceId(provinceId, page, size).map(mapStructMapper::cityToCityDto);
        }
        return this.cityService.getAllCitys(page, size).map(mapStructMapper::cityToCityDto);
    }

        @RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = { "application/json",
                        "application/xml" })
        @ResponseStatus(HttpStatus.OK)
        public @ResponseBody City getCity(
                        @PathVariable("id") Long id,
                        HttpServletRequest request, HttpServletResponse response) throws Exception {
                City city = this.cityService.getCity(id);
                checkResourceFound(city);
                return city;
        }

        @RequestMapping(value = "/{id}", method = RequestMethod.PUT, consumes = { "application/json",
                        "application/xml" }, produces = { "application/json", "application/xml" })
        @ResponseStatus(HttpStatus.NO_CONTENT)
        public void updateCity(
                        @PathVariable("id") Long id, @RequestBody City city,
                        HttpServletRequest request, HttpServletResponse response) {
                checkResourceFound(this.cityService.getCity(id));
                if (id != city.getId())
                        throw new DataFormatException("ID doesn't match!");
                this.cityService.updateCity(city);
        }

        @RequestMapping(value = "/{id}", method = RequestMethod.DELETE, produces = { "application/json",
                        "application/xml" })
        @ResponseStatus(HttpStatus.NO_CONTENT)
        public void deleteCity(
                        @PathVariable("id") Long id, HttpServletRequest request,
                        HttpServletResponse response) {
                checkResourceFound(this.cityService.getCity(id));
                this.cityService.deleteCity(id);
        }
}
