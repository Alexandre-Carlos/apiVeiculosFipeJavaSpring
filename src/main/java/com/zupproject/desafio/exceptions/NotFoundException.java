package com.zupproject.desafio.exceptions;

import com.zupproject.desafio.util.MessageUtil;

public class NotFoundException extends RuntimeException {
        public NotFoundException(){
            super(MessageUtil.REGISTRO_NAO_ENCONTRADO);
        }
}
