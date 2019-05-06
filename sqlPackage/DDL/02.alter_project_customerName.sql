ALTER TABLE public.project add column customer_name  character varying(200);
COMMENT ON COLUMN project.customer_name IS 'お客様名'
;

ALTER TABLE public.project add column expansion_possibilities bigint;
COMMENT ON COLUMN project.expansion_possibilities IS '拡大可能性	0:無、1:小、2:中、3:大、4:極大、5:緊急、6:縮小';
ALTER TABLE public.project add column increase_number bigint;
COMMENT ON COLUMN project.expansion_possibilities IS '次月増減員人数予定';
ALTER TABLE public.project add column sales_representative bigint;
COMMENT ON COLUMN project.expansion_possibilities IS '担当営業ID';