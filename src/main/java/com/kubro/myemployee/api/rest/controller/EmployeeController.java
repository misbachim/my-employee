package com.kubro.myemployee.api.rest.controller;

import java.util.Base64;
import java.util.UUID;

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

import com.kubro.myemployee.entity.Employee;
import com.kubro.myemployee.exception.DataFormatException;
import com.kubro.myemployee.mapstruct.dto.EmployeeDto;
import com.kubro.myemployee.mapstruct.mapper.MapStructMapper;
import com.kubro.myemployee.service.EmployeeService;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(value = "/api/v1/employees")
public class EmployeeController extends AbstractRestHandler {

    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private MapStructMapper mapStructMapper;
    
    @RequestMapping(value = "",
            method = RequestMethod.POST,
            consumes = {"application/json", "application/xml"},
            produces = {"application/json", "application/xml"})
    @ResponseStatus(HttpStatus.CREATED)
    public void createEmployee(@RequestBody Employee employee,
                                 HttpServletRequest request, HttpServletResponse response) {
        Employee createdEmployee = this.employeeService.createEmployee(employee);
        response.setHeader("Location", request.getRequestURL().append("/").append(createdEmployee.getId()).toString());
    }

    @RequestMapping(value = "",
            method = RequestMethod.GET,
            produces = {"application/json", "application/xml"})
    @ResponseStatus(HttpStatus.OK)
    public
    @ResponseBody
    Page<EmployeeDto> getAllEmployee(
                                      @RequestParam(value = "page", required = true, defaultValue = DEFAULT_PAGE_NUM) Integer page,
                                      @RequestParam(value = "size", required = true, defaultValue = DEFAULT_PAGE_SIZE) Integer size,
                                      @RequestParam(value = "name", required = false) String name,
                                      @RequestParam(value = "positionId", required = false) Long positionId,
                                      HttpServletRequest request, HttpServletResponse response) {
        if (name != null && !name.isEmpty()) {
                if (positionId != null) {
                        return this.employeeService.getByNameAndPositionId(name, positionId, page, size).map(mapStructMapper::employeeToEmployeeDto);
                }
                return this.employeeService.getByName(name, page, size).map(mapStructMapper::employeeToEmployeeDto);
        }
        if (positionId != null) {
                return this.employeeService.getByPositionId(positionId, page, size).map(mapStructMapper::employeeToEmployeeDto);
        }
        return this.employeeService.getAllEmployees(page, size).map(mapStructMapper::employeeToEmployeeDto);
    }

    @RequestMapping(value = "/{id}",
            method = RequestMethod.GET,
            produces = {"application/json", "application/xml"})
    @ResponseStatus(HttpStatus.OK)
    public
    @ResponseBody
    EmployeeDto getEmployee(
                             @PathVariable("id") UUID id,
                             HttpServletRequest request, HttpServletResponse response) throws Exception {
        Employee employee = this.employeeService.getEmployee(id);
        checkResourceFound(employee);
        return mapStructMapper.employeeToEmployeeDto(employee);
    }

    @RequestMapping(value = "/{id}/ktp",
            method = RequestMethod.GET,
            produces = {"application/json", "application/xml"})
    @ResponseStatus(HttpStatus.OK)
    public
    @ResponseBody
    byte[] getEmployeeKtp(
                             @PathVariable("id") UUID id,
                             HttpServletRequest request, HttpServletResponse response) throws Exception {
        Employee employee = this.employeeService.getEmployee(id);
        checkResourceFound(employee);
        return Base64.getEncoder().encode(employee.getKtpFile());
    }

    @RequestMapping(value = "/{id}",
            method = RequestMethod.PUT,
            consumes = {"application/json", "application/xml"},
            produces = {"application/json", "application/xml"})
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateEmployee(
                                 @PathVariable("id") UUID id, @RequestBody Employee employee,
                                 HttpServletRequest request, HttpServletResponse response) {
        checkResourceFound(this.employeeService.getEmployee(id));
        if (!id.toString().equals(employee.getId().toString())) throw new DataFormatException("ID doesn't match!");
        this.employeeService.updateEmployee(employee);
    }

    @RequestMapping(value = "/{id}",
            method = RequestMethod.DELETE,
            produces = {"application/json", "application/xml"})
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteEmployee(
                                 @PathVariable("id") UUID id, HttpServletRequest request,
                                 HttpServletResponse response) {
        checkResourceFound(this.employeeService.getEmployee(id));
        this.employeeService.deleteEmployee(id);
    }
}
