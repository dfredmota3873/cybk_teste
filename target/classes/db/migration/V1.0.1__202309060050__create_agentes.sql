CREATE TABLE vmbears.agente (       id     uuid NOT NULL,
                                    codigo  integer  NOT NULL,
                                    data    timestamp NOT NULL ,
                                    regiao_n_id uuid NOT NULL,
                                    regiao_ne_id uuid NOT NULL,
                                    regiao_s_id uuid NOT NULL,
                                    regiao_se_id uuid NOT NULL,
                                    CONSTRAINT agente_pkey PRIMARY KEY (id));
