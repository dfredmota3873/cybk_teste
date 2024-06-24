CREATE TABLE cbyk.conta (           id                 uuid NOT NULL,
                                    data_vencimento    timestamp NOT NULL ,
                                    data_pagamento     timestamp NULL,
                                    valor              numeric(19,2) NOT NULL,
                                    descricao          varchar(240) NOT NULL,
                                    situacao           varchar(1) NOT NULL,
                                    CONSTRAINT conta_pkey PRIMARY KEY (id));
