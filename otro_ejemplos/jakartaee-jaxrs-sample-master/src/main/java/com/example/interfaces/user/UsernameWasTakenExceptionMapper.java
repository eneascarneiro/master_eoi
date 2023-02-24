/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.interfaces.user;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

/**
 *
 * @author hantsy
 */
@Provider
public class UsernameWasTakenExceptionMapper implements ExceptionMapper<UsernameWasTakenException> {

    @Override
    public Response toResponse(UsernameWasTakenException exception) {
        return Response.status(Response.Status.CONFLICT)
            .entity(exception.getMessage())
            .build();
    }

}