package com.roots.cacaopay.transaccion.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.roots.cacaopay.commons.controllers.CommonController;
import com.roots.cacaopay.transaccion.entity.DefinicionCuenta;
import com.roots.cacaopay.transaccion.service.DefinicionCuentaService;

@RestController
@RequestMapping("/definicion-cuenta")
public class DefinicionCuentaController extends CommonController<DefinicionCuenta, DefinicionCuentaService> {

}
