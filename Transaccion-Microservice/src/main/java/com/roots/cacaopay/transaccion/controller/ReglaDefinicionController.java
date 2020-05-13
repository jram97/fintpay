package com.roots.cacaopay.transaccion.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.roots.cacaopay.commons.controllers.CommonController;
import com.roots.cacaopay.transaccion.entity.ReglaDefinicion;
import com.roots.cacaopay.transaccion.service.ReglaDefinicionService;

@RestController
@RequestMapping("/regla-cuenta")
public class ReglaDefinicionController extends CommonController<ReglaDefinicion, ReglaDefinicionService> {

}
