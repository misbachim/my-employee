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

import com.kubro.myemployee.entity.Province;
import com.kubro.myemployee.exception.DataFormatException;
import com.kubro.myemployee.mapstruct.dto.ProvinceDto;
import com.kubro.myemployee.mapstruct.mapper.MapStructMapper;
import com.kubro.myemployee.service.ProvinceService;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(value = "/api/v1/provinces")
public class ProvinceController extends AbstractRestHandler {

    @Autowired
    private ProvinceService provinceService;

    @Autowired
    private MapStructMapper mapStructMapper;

    @RequestMapping(value = "",
            method = RequestMethod.POST,
            consumes = {"application/json", "application/xml"},
            produces = {"application/json", "application/xml"})
    @ResponseStatus(HttpStatus.CREATED)
    public void createProvince(@RequestBody Province province,
                                 HttpServletRequest request, HttpServletResponse response) {
        Province createdProvince = this.provinceService.createProvince(province);
        response.setHeader("Location", request.getRequestURL().append("/").append(createdProvince.getId()).toString());
    }

    @RequestMapping(value = "",
            method = RequestMethod.GET,
            produces = {"application/json", "application/xml"})
    @ResponseStatus(HttpStatus.OK)
    public
    @ResponseBody
    Page<ProvinceDto> getAllProvince(
                                      @RequestParam(value = "page", required = true, defaultValue = DEFAULT_PAGE_NUM) Integer page,
                                      @RequestParam(value = "size", required = true, defaultValue = DEFAULT_PAGE_SIZE) Integer size,
                                      HttpServletRequest request, HttpServletResponse response) {
        return this.provinceService.getAllProvinces(page, size).map(mapStructMapper::provinceToProvinceDto);
    }

    @RequestMapping(value = "/{id}",
            method = RequestMethod.GET,
            produces = {"application/json", "application/xml"})
    @ResponseStatus(HttpStatus.OK)
    public
    @ResponseBody
    Province getProvince(
                             @PathVariable("id") Long id,
                             HttpServletRequest request, HttpServletResponse response) throws Exception {
        Province province = this.provinceService.getProvince(id);
        checkResourceFound(province);
        return province;
    }

    @RequestMapping(value = "/{id}",
            method = RequestMethod.PUT,
            consumes = {"application/json", "application/xml"},
            produces = {"application/json", "application/xml"})
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateProvince(
                                 @PathVariable("id") Long id, @RequestBody Province province,
                                 HttpServletRequest request, HttpServletResponse response) {
        checkResourceFound(this.provinceService.getProvince(id));
        if (id != province.getId()) throw new DataFormatException("ID doesn't match!");
        this.provinceService.updateProvince(province);
    }

    @RequestMapping(value = "/{id}",
            method = RequestMethod.DELETE,
            produces = {"application/json", "application/xml"})
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteProvince(
                                 @PathVariable("id") Long id, HttpServletRequest request,
                                 HttpServletResponse response) {
        checkResourceFound(this.provinceService.getProvince(id));
        this.provinceService.deleteProvince(id);
    }
}
