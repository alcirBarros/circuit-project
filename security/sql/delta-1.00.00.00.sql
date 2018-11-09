create table rgt_registro (
   rgt_id integer not null auto_increment,
    primary key (rgt_id)
);

create table rip_registro_importacao (
   rip_id integer not null auto_increment,
    rip_cpf_responsavel varchar(255),
    rip_inconsistencia_enum integer,
    rip_nome_aluno varchar(255),
    rip_nome_responsavel varchar(255),
    rgt_id integer,
    primary key (rip_id)
);

create table upl_uploaded (
   upl_id integer not null auto_increment,
    upl_arquivo tinyblob,
    primary key (upl_id)
);

create table upr_uploaded_registro (
   upr_id integer not null auto_increment,
    rgt_id integer,
    upl_id integer,
    primary key (upr_id)
);

alter table rip_registro_importacao 
   add constraint fk_rip_rgt_id 
   foreign key (rgt_id) 
   references rgt_registro (rgt_id);

alter table tbcadastro_alunos 
   add constraint FKd4f67ds8nhxskji255eu8oeeh 
   foreign key (tbpessoas_id) 
   references tbpessoas (tbpessoas_id);

alter table tbresponsaveis 
   add constraint FKr1ro8estu1f5j60keuryv3o03 
   foreign key (tbpessoas_id) 
   references tbpessoas (tbpessoas_id);

alter table tbresponsaveis 
   add constraint FK4wg3uaheidxo2qyfjrhjj17n1 
   foreign key (tbusuarios_id) 
   references tbusuarios (tbusuarios_id);

alter table tbresponsaveis_tbcadastro_alunos 
   add constraint FKpc56as1yji9rrn2rdk89d325n 
   foreign key (tbcadastro_alunos_id) 
   references tbcadastro_alunos (tbcadastro_alunos_id);

alter table tbresponsaveis_tbcadastro_alunos 
   add constraint FK7epdsgiyte2sdtso04d83fkn3 
   foreign key (tbresponsaveis_id) 
   references tbresponsaveis (tbresponsaveis_id);

alter table upr_uploaded_registro 
   add constraint fk_upr_upr_id 
   foreign key (rgt_id) 
   references rgt_registro (rgt_id);

alter table upr_uploaded_registro 
   add constraint fk_upr_upl_id 
   foreign key (upl_id) 
   references upl_uploaded (upl_id);

ALTER TABLE rgt_registro
ADD COLUMN rgt_data_hora VARCHAR(45) NULL;

ALTER TABLE rip_registro_importacao 
DROP FOREIGN KEY fk_rip_rgt_id;
ALTER TABLE rip_registro_importacao 
CHANGE COLUMN rgt_id rgt_id INT(11) NOT NULL ;

ALTER TABLE rip_registro_importacao 
ADD CONSTRAINT fk_rip_rgt_id
  FOREIGN KEY (rgt_id)
  REFERENCES rgt_registro (rgt_id);

ALTER TABLE `rgt_registro` 
ADD COLUMN `rgt_descricao` VARCHAR(45) NULL;


