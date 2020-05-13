package com.roots.cacaopay.transaccion.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.roots.cacaopay.commons.controllers.CommonController;
import com.roots.cacaopay.transaccion.entity.Transaccion;
import com.roots.cacaopay.transaccion.service.TransaccionService;

@RestController
@RequestMapping("/transaccion")
public class TransaccionController extends CommonController<Transaccion, TransaccionService> {

}
