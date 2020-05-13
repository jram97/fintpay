package com.roots.cacaopay.transaccion.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.roots.cacaopay.commons.controllers.CommonController;
import com.roots.cacaopay.transaccion.entity.ControlCuenta;
import com.roots.cacaopay.transaccion.service.ControlCuentaService;

@RestController
@RequestMapping("/control-cuenta")
public class ControlCuentaController extends CommonController<ControlCuenta, ControlCuentaService> {

}
