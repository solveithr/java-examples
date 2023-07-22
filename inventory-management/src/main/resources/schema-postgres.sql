DROP DATABASE IF EXISTS "TRAINING";
CREATE DATABASE "TRAINING"
WITH
OWNER = postgres
ENCODING = 'UTF8'
LC_COLLATE = 'English_United States.1252'
LC_CTYPE = 'English_United States.1252'
TABLESPACE = pg_default
CONNECTION LIMIT = -1
IS_TEMPLATE = False;
DROP TABLE IF EXISTS public.inventory;

CREATE TABLE IF NOT EXISTS public.inventory
(
    sku_id uuid NOT NULL,
    sku_active boolean,
    sku_name character varying(255) COLLATE pg_catalog."default",
    sku_price double precision,
    CONSTRAINT inventory_pkey PRIMARY KEY (sku_id)
)

TABLESPACE pg_default;

ALTER TABLE IF EXISTS public.inventory
    OWNER to postgres;