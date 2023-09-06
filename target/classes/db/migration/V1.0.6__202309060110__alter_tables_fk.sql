ALTER TABLE vmbears.regiao
    ADD CONSTRAINT regiao_geracao_fkey
        FOREIGN KEY (geracao_id) REFERENCES vmbears.geracao(id);

ALTER TABLE vmbears.regiao
    ADD CONSTRAINT regiao_compra_fkey
        FOREIGN KEY (compra_id) REFERENCES vmbears.compra(id);

ALTER TABLE vmbears.regiao
    ADD CONSTRAINT regiao_preco_medio_fkey
        FOREIGN KEY (preco_medio_id) REFERENCES vmbears.preco_medio(id);

ALTER TABLE vmbears.geracao
    ADD CONSTRAINT geracao_regiao_fkey
        FOREIGN KEY (regiao_id) REFERENCES vmbears.regiao(id);

ALTER TABLE vmbears.preco_medio
    ADD CONSTRAINT preco_medio_regiao_fkey
        FOREIGN KEY (regiao_id) REFERENCES vmbears.regiao(id);

ALTER TABLE vmbears.compra
    ADD CONSTRAINT compra_regiao_fkey
        FOREIGN KEY (regiao_id) REFERENCES vmbears.regiao(id);

ALTER TABLE vmbears.agente
    ADD CONSTRAINT agente_regiao_n_fkey
        FOREIGN KEY (regiao_n_id) REFERENCES vmbears.regiao(id);

ALTER TABLE vmbears.agente
    ADD CONSTRAINT agente_regiao_ne_fkey
        FOREIGN KEY (regiao_ne_id) REFERENCES vmbears.regiao(id);

ALTER TABLE vmbears.agente
    ADD CONSTRAINT agente_regiao_s_fkey
        FOREIGN KEY (regiao_s_id) REFERENCES vmbears.regiao(id);

ALTER TABLE vmbears.agente
    ADD CONSTRAINT agente_regiao_se_fkey
        FOREIGN KEY (regiao_se_id) REFERENCES vmbears.regiao(id);

