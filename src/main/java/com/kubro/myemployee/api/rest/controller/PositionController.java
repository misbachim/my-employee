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

import com.kubro.myemployee.entity.Position;
import com.kubro.myemployee.exception.DataFormatException;
import com.kubro.myemployee.service.PositionService;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(value = "/api/v1/positions")
public class PositionController extends AbstractRestHandler {

    @Autowired
    private PositionService positionService;

    @RequestMapping(value = "",
            method = RequestMethod.POST,
            consumes = {"application/json", "application/xml"},
            produces = {"application/json", "application/xml"})
    @ResponseStatus(HttpStatus.CREATED)
    public void createPosition(@RequestBody Position position,
                                 HttpServletRequest request, HttpServletResponse response) {
        Position createdPosition = this.positionService.createPosition(position);
        response.setHeader("Location", request.getRequestURL().append("/").append(createdPosition.getId()).toString());
    }

    @RequestMapping(value = "",
            method = RequestMethod.GET,
            produces = {"application/json", "application/xml"})
    @ResponseStatus(HttpStatus.OK)
    public
    @ResponseBody
    Page<Position> getAllPosition(
                                      @RequestParam(value = "page", required = true, defaultValue = DEFAULT_PAGE_NUM) Integer page,
                                      @RequestParam(value = "size", required = true, defaultValue = DEFAULT_PAGE_SIZE) Integer size,
                                      HttpServletRequest request, HttpServletResponse response) {
        return this.positionService.getAllPositions(page, size);
    }

    @RequestMapping(value = "/{id}",
            method = RequestMethod.GET,
            produces = {"application/json", "application/xml"})
    @ResponseStatus(HttpStatus.OK)
    public
    @ResponseBody
    Position getPosition(
                             @PathVariable("id") Long id,
                             HttpServletRequest request, HttpServletResponse response) throws Exception {
        Position position = this.positionService.getPosition(id);
        checkResourceFound(position);
        return position;
    }

    @RequestMapping(value = "/{id}",
            method = RequestMethod.PUT,
            consumes = {"application/json", "application/xml"},
            produces = {"application/json", "application/xml"})
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updatePosition(
                                 @PathVariable("id") Long id, @RequestBody Position position,
                                 HttpServletRequest request, HttpServletResponse response) {
        checkResourceFound(this.positionService.getPosition(id));
        if (id != position.getId()) throw new DataFormatException("ID doesn't match!");
        this.positionService.updatePosition(position);
    }

    @RequestMapping(value = "/{id}",
            method = RequestMethod.DELETE,
            produces = {"application/json", "application/xml"})
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletePosition(
                                 @PathVariable("id") Long id, HttpServletRequest request,
                                 HttpServletResponse response) {
        checkResourceFound(this.positionService.getPosition(id));
        this.positionService.deletePosition(id);
    }
}
