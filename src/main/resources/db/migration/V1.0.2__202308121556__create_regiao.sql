CREATE TABLE vmbears.regiao (      id     uuid NOT NULL,
                                   sigla  text  NOT NULL,
                                   geracao_id    uuid NOT NULL ,
                                   compra_id    uuid NOT NULL ,
                                   preco_medio_id    uuid NOT NULL ,
                                   CONSTRAINT regiao_pkey PRIMARY KEY (id));
