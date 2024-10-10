
CREATE TABLE sch_commun.commun_paiement
(
    id integer NOT NULL DEFAULT nextval('sch_commun.commun_paiement_id_seq'::regclass),
    code_action character varying(255) COLLATE pg_catalog."default" NOT NULL,
    num_facture character varying(255) COLLATE pg_catalog."default",
    num_tranche character varying(255) COLLATE pg_catalog."default",
    num_memoire character varying(255) COLLATE pg_catalog."default",
    num_cheque character varying(255) COLLATE pg_catalog."default",
    rip character varying(255) COLLATE pg_catalog."default",
    code_client character varying(255) COLLATE pg_catalog."default" NOT NULL,
    unite_facture character varying(255) COLLATE pg_catalog."default" NOT NULL,
    unite_encaissement character varying(255) COLLATE pg_catalog."default" NOT NULL,
    is_repris boolean DEFAULT false,
    type_energie character varying(255) COLLATE pg_catalog."default",
    date_system timestamp without time zone NOT NULL DEFAULT clock_timestamp(),
    date_operation timestamp without time zone NOT NULL,
    date_integration timestamp without time zone,
    date_ecriture timestamp without time zone NOT NULL DEFAULT now(),
    date_lecture timestamp without time zone,
    mode_paiement character varying(255) COLLATE pg_catalog."default",
    acteur character varying(255) COLLATE pg_catalog."default",
    synchroniser_traiter boolean NOT NULL DEFAULT false,
    CONSTRAINT paiement_primary_key PRIMARY KEY (id)
)
CREATE TABLE sch_ctc.ctc_automate_synchronisation
(
    id integer NOT NULL DEFAULT nextval('sch_ctc.ctc_automate_synchronisation_id_seq'::regclass),
    mode_paiement character varying(50) COLLATE pg_catalog."default" NOT NULL,
    code_action character varying(30) COLLATE pg_catalog."default" NOT NULL,
    etat_parent_ctc character varying(30) COLLATE pg_catalog."default",
    etat_parent_hors_ctc character varying(30) COLLATE pg_catalog."default",
    acteur character varying(20) COLLATE pg_catalog."default",
    message text COLLATE pg_catalog."default",
    CONSTRAINT automate_synchronisation_pkey PRIMARY KEY (id)
)