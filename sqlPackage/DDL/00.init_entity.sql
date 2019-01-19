DROP TABLE IF EXISTS public.career_visions;

CREATE TABLE public.career_visions
(
    user_id integer NOT NULL,
    first_essential text,
    second_essential text,
    third_essential text,
    freetext text,
    oneyear_vision text,
    threeyears_vision text,
    fiveyears_vision text,
    registered_at DATE,
    updated_at DATE,
    registered_by character varying(50),
    updated_by character varying(50),
    version integer NOT NULL default 0 ,
    CONSTRAINT career_visions_pkey PRIMARY KEY (user_id,version)
);

DROP TABLE IF EXISTS public.department;

CREATE TABLE public.department
(
    department_id bigint NOT NULL,
    department_name character varying(50) NOT NULL,
    registered_at DATE,
    updated_at DATE,
    registered_by character varying(50),
    updated_by character varying(50),
    version integer NOT NULL default 0 ,
    CONSTRAINT department_pkey PRIMARY KEY (department_id)
);

DROP TABLE IF EXISTS public.engineer_levels;

CREATE TABLE public.engineer_levels
(
    id serial NOT NULL,
    engineer_level character varying(50),
    satisfy_weight decimal NOT NULL,
    commitment_weight decimal NOT NULL,
    proposal_weight decimal NOT NULL,
    internal_communication_weight decimal NOT NULL,
    development_weight decimal NOT NULL,
    it_skills_weight decimal NOT NULL,
    understand_weight decimal NOT NULL,
    communication_weight decimal NOT NULL,
    leadership_weight decimal NOT NULL,
    resolve_weight decimal NOT NULL,
    professional_weight decimal NOT NULL,
    field_sales_weight decimal NOT NULL,
    thanks_weight decimal NOT NULL,
    engine_weight decimal NOT NULL,
    all_weight decimal NOT NULL,
    masterpiece_weight decimal NOT NULL,
    stock_weight decimal NOT NULL,
    seattle_brand_weight decimal NOT NULL,
    registered_at DATE,
    updated_at DATE,
    registered_by character varying(50),
    updated_by character varying(50),
    version integer NOT NULL default 0 ,
    CONSTRAINT engineer_levels_pkey PRIMARY KEY (id)
);

DROP TABLE IF EXISTS public.management_visions;

CREATE TABLE public.management_visions
(
    user_id bigint NOT NULL,
    management_id smallint NOT NULL,
    registered_at DATE,
    updated_at DATE,
    registered_by character varying(50),
    updated_by character varying(50),
    version integer NOT NULL default 0 ,
    CONSTRAINT management_visions_pkey PRIMARY KEY (user_id,management_id,version)
);

DROP TABLE IF EXISTS public.master_management_visions;

CREATE TABLE public.master_management_visions
(
    management_id serial NOT NULL,
    management_name character varying(50),
    registered_at DATE,
    updated_at DATE,
    registered_by character varying(50),
    updated_by character varying(50),
    version integer NOT NULL default 0 ,
    CONSTRAINT master_management_visions_pkey PRIMARY KEY (management_id)
);

DROP TABLE IF EXISTS public.master_sector_visions;

CREATE TABLE public.master_sector_visions
(
    sector_id serial NOT NULL,
    sector_name character varying(50),
    registered_at DATE,
    updated_at DATE,
    registered_by character varying(50),
    updated_by character varying(50),
    version integer NOT NULL default 0 ,
    CONSTRAINT master_sector_visions_pkey PRIMARY KEY (sector_id)
);

DROP TABLE IF EXISTS public.master_specialist_visions;

CREATE TABLE public.master_specialist_visions
(
    specialist_id serial NOT NULL,
    specialist_name character varying(50),
    registered_at DATE,
    updated_at DATE,
    registered_by character varying(50),
    updated_by character varying(50),
    version integer NOT NULL default 0 ,
    CONSTRAINT master_specialist_visions_pkey PRIMARY KEY (specialist_id,version)
);

DROP TABLE IF EXISTS public.middledepartment;

CREATE TABLE public.middledepartment
(
    id serial NOT NULL,
    user_id bigint NOT NULL,
    department_id bigint,
    delete_flag smallint NOT NULL default 0,
    registered_at DATE,
    updated_at DATE,
    registered_by character varying(50),
    updated_by character varying(50),
    version integer NOT NULL default 0 ,
    CONSTRAINT middledepartment_pkey PRIMARY KEY (id)
);

DROP TABLE IF EXISTS public.middleproject;

CREATE TABLE public.middleproject
(
    id serial NOT NULL,
    user_id bigint NOT NULL,
    project_id bigint,
    delete_flag smallint NOT NULL default 0,
    registered_at DATE,
    updated_at DATE,
    registered_by character varying(50),
    updated_by character varying(50),
    version integer NOT NULL default 0 ,
    CONSTRAINT middleproject_pkey PRIMARY KEY (id,user_id,project_id)
);

DROP TABLE IF EXISTS public.motivation;

CREATE TABLE public.motivation
(
    id serial NOT NULL,
    user_id bigint NOT NULL,
    company_motivation character varying(20),
    job_motivation character varying(20),
    retire_risk boolean default false,
    interview_date DATE,
    comment character varying(600),
    date DATE,
    registered_at DATE,
    updated_at DATE,
    registered_by character varying(50),
    updated_by character varying(50),
    version integer,
    CONSTRAINT motivation_pkey PRIMARY KEY (id)
);

DROP TABLE IF EXISTS public.users;

CREATE TABLE public.users
(
    user_id serial NOT NULL,
    user_name character varying(50) NOT NULL,
    email character varying(256) NOT NULL,
    password character varying(255) NOT NULL,
    employee_number integer,
    engineer_level character varying(10),
    delete_flag smallint NOT NULL default 0,
    birth_date DATE,
    gender integer NOT NULL default 0 ,
    enter_date DATE,
    leave_date DATE,
    registered_at DATE,
    updated_at DATE,
    registered_by character varying(50),
    updated_by character varying(50),
    version integer NOT NULL default 0 ,
    CONSTRAINT users_pkey PRIMARY KEY (user_id)
);

DROP TABLE IF EXISTS public.premises;

CREATE TABLE public.premises
(
    id serial NOT NULL,
    user_id integer NOT NULL,
    year integer NOT NULL,
    term boolean,
    attend boolean NOT NULL default true,
    attitude boolean NOT NULL default true,
    security_accident boolean NOT NULL default true,
    registered_at DATE,
    updated_at DATE,
    registered_by character varying(50),
    updated_by character varying(50),
    version integer NOT NULL default 0 ,
    CONSTRAINT premises_pkey PRIMARY KEY (id)
);

DROP TABLE IF EXISTS public.project;

CREATE TABLE public.project
(
    project_id bigint NOT NULL,
    project_name character varying(50),
    registered_at DATE,
    updated_at DATE,
    registered_by character varying(50),
    updated_by character varying(50),
    version integer NOT NULL default 0 ,
    CONSTRAINT project_pkey PRIMARY KEY (project_id)
);

DROP TABLE IF EXISTS public.evaluation_results;

CREATE TABLE public.evaluation_results
(
    id serial NOT NULL,
    user_id bigint NOT NULL,
    engineer_level character varying(50),
    team_id bigint NOT NULL,
    satisfy_score decimal NOT NULL,
    commitment_score decimal NOT NULL,
    proposal_score decimal NOT NULL,
    internal_communication_score decimal NOT NULL,
    development_score decimal NOT NULL,
    it_skills_score decimal NOT NULL,
    understand_score decimal NOT NULL,
    leadership_score decimal NOT NULL,
    resolve_score decimal NOT NULL,
    communication_score decimal NOT NULL,
    professional_score decimal NOT NULL,
    field_sales_score decimal NOT NULL,
    thanks_score decimal NOT NULL,
    engine_score decimal NOT NULL,
    all_score decimal NOT NULL,
    masterpiece_score decimal NOT NULL,
    stock_score decimal NOT NULL,
    seattle_brand_score decimal NOT NULL,
    remark character varying(200) NOT NULL,
    total_score decimal NOT NULL,
    year integer NOT NULL,
    term boolean NOT NULL default false,
    delete_flag smallint NOT NULL default 0,
    registered_at DATE,
    updated_at DATE,
    registered_by character varying(50),
    updated_by character varying(50),
    version integer NOT NULL default 0 ,
    CONSTRAINT evaluation_results_pkey PRIMARY KEY (id)
);

DROP TABLE IF EXISTS public.sector_visions;

CREATE TABLE public.sector_visions
(
    user_id bigint NOT NULL,
    sector_id smallint NOT NULL,
    registered_at DATE,
    updated_at DATE,
    registered_by character varying(50),
    updated_by character varying(50),
    version integer NOT NULL default 0 ,
    CONSTRAINT sector_visions_pkey PRIMARY KEY (user_id,sector_id,version)
);

DROP TABLE IF EXISTS public.specialist_visions;

CREATE TABLE public.specialist_visions
(
    user_id integer NOT NULL,
    specialist_id integer NOT NULL,
    registered_at DATE,
    updated_at DATE,
    registered_by character varying(50),
    updated_by character varying(50),
    version integer NOT NULL default 0 ,
    CONSTRAINT specialist_visions_pkey PRIMARY KEY (user_id,specialist_id)
);

DROP TABLE IF EXISTS public.teams;

CREATE TABLE public.teams
(
    team_id serial NOT NULL,
    year integer NOT NULL,
    term boolean,
    group_ character varying(50),
    team character varying(50),
    registered_at DATE,
    updated_at DATE,
    registered_by character varying(50),
    updated_by character varying(50),
    version integer NOT NULL default 0 ,
    CONSTRAINT teams_pkey PRIMARY KEY (team_id)
);